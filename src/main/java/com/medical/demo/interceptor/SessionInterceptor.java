package com.medical.demo.interceptor;

import com.medical.demo.mapper.PatientMapper;
import com.medical.demo.mapper.SysUserMapper;
import com.medical.demo.model.Patient;
import com.medical.demo.model.PatientExample;
import com.medical.demo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies=request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    PatientExample example = new PatientExample();
                    example.createCriteria()
                            .andTokenEqualTo(token);
                    List<Patient> patients = patientMapper.selectByExample(example);
                    if (patients.size() != 0) {
                        SysUser user = sysUserMapper.selectByPrimaryKey(patients.get(0).getUserid());
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
