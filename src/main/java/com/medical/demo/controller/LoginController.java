package com.medical.demo.controller;

import com.medical.demo.base.result.Results;
import com.medical.demo.mapper.PatientMapper;
import com.medical.demo.model.Patient;
import com.medical.demo.model.SysUser;
import com.medical.demo.service.PatientService;
import com.medical.demo.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import javax.servlet.http.Cookie;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientMapper patientMapper;

    @PostMapping("/login")
    public Results login(@RequestParam(value="username") String username,
                         @RequestParam(value="password") String password,
                         HttpServletResponse response){
        SysUser sysUser = sysUserService.getSysUserByUsername(username);
        if(sysUser==null || !password.equals(sysUser.getPassword())){
            return Results.failure();
        }

        String token= UUID.randomUUID().toString();
        Patient patient = patientService.getPatientByUserid(sysUser.getId());
        patient.setToken(token);
        patientMapper.updateByPrimaryKeySelective(patient);
        response.addCookie(new Cookie("token",token));
        return Results.success();
    }
}
