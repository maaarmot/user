package com.medical.demo.controller;

import com.medical.demo.dto.DepartmentDTO;
import com.medical.demo.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/dep")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    public String dep(Model model){
        List<DepartmentDTO> departmentDTOList = departmentService.getAllPerDeps();
        model.addAttribute("departmentDTOList",departmentDTOList);
        return "dep/dep-list";
    }
}
