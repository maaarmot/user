package com.medical.demo.controller;

import com.medical.demo.base.result.PageTableRequest;
import com.medical.demo.base.result.ResponseCode;
import com.medical.demo.base.result.Results;
import com.medical.demo.dto.DoctorDTO;
import com.medical.demo.dto.DutyDTO;
import com.medical.demo.mapper.DoctorMapper;
import com.medical.demo.mapper.SysUserMapper;
import com.medical.demo.model.Doctor;
import com.medical.demo.model.SysUser;
import com.medical.demo.service.DoctorService;
import com.medical.demo.service.DutyService;
import com.medical.demo.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/doc")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DutyService dutyService;

    @GetMapping("/{id}")
    public String findDocByDep(@PathVariable(name="id")Integer id, Model model, HttpServletRequest request){
        List<DoctorDTO> dtoList = doctorService.getAllDoctorsByDep(id);
        model.addAttribute("dtoList",dtoList);
        request.getSession().setAttribute("depId", id);
        return "doc/doc-list";
    }

    @GetMapping("/detail/{id}")
    public String findDocById(@PathVariable(name="id")Integer id,Model model, HttpServletRequest request){
        DoctorDTO doctorDTO = doctorService.getDoctorById(id);
        List<DutyDTO> dutyDTOList = dutyService.getDutyById(id);
        model.addAttribute("doctorDTO",doctorDTO);
        model.addAttribute("dutyDTOList",dutyDTOList);
        request.getSession().setAttribute("docId", id);
        return "doc/doc-detail";
    }
}
