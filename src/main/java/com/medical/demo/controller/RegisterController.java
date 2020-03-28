package com.medical.demo.controller;

import com.medical.demo.dto.RegisterDTO;
import com.medical.demo.model.SysUser;
import com.medical.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/reg")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/list")
    public String showRegisterList(HttpServletRequest request,Model model){
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        if(user==null){
            return "tologin";
        }
        List<RegisterDTO> registerDTOList = registerService.findRegisterList(user.getId());
        model.addAttribute("registerDTOList",registerDTOList);
        return "reg/reg-list";
    }

    @GetMapping("/submit/{id}")
    public String showRegister(@PathVariable(name="id")Integer id,
                              HttpServletRequest request,
                              Model model){
        Integer docId = (Integer) request.getSession().getAttribute("docId");
        Integer depId = (Integer) request.getSession().getAttribute("depId");
        request.getSession().setAttribute("chiDutyId", id);
        RegisterDTO registerDTO = registerService.addRegisterDTO(request,id,docId,depId);
        model.addAttribute("registerDTO",registerDTO);
        return "reg/reg-submit";
    }

    @GetMapping("/add")
    public String addRegister(HttpServletRequest request,Model model){
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        if(user==null){
            return "tologin";
        }
        Integer docId = (Integer) request.getSession().getAttribute("docId");
        Integer depId = (Integer) request.getSession().getAttribute("depId");
        Integer chiDutyId = (Integer) request.getSession().getAttribute("chiDutyId");
        registerService.addRegister(request, chiDutyId, docId, depId);

        //点了提交之后跳转到reg-list需再调用一次findRegisterList
        List<RegisterDTO> registerDTOList = registerService.findRegisterList(user.getId());
        model.addAttribute("registerDTOList",registerDTOList);
//        return "reg/reg-list";
        //要用重定向，否则路径还是/reg/add 点击又会添加新的register
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String showRegisterDetail(@PathVariable(name="id")Integer id,
                               HttpServletRequest request,
                               Model model){
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        RegisterDTO registerDTO = registerService.showRegisterDetail(id,user.getId());
        model.addAttribute("registerDTO",registerDTO);
        return "reg/reg-detail";
    }
}
