package com.medical.demo.controller;

import com.medical.demo.model.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/inq")
public class InquiryController {

    @GetMapping("/list")
    public String inquiry(HttpServletRequest request){
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        if(user==null){
            return "tologin";
        }
        return "inq/inq-list";
    }
}
