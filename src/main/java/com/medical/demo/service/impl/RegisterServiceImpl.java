package com.medical.demo.service.impl;

import com.medical.demo.dto.DoctorDTO;
import com.medical.demo.dto.RegisterDTO;
import com.medical.demo.mapper.*;
import com.medical.demo.model.*;
import com.medical.demo.service.DoctorService;
import com.medical.demo.service.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private RegisterMapper registerMapper;
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private DutyMapper dutyMapper;
    @Resource
    private DoctorService doctorService;
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public RegisterDTO addRegisterDTO(HttpServletRequest request, Integer id, Integer docId, Integer depId) {
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setNickname(user.getNickname());
        registerDTO.setDepName(departmentMapper.selectByPrimaryKey(depId).getName());
        registerDTO.setChilDuty(dutyMapper.selectByPrimaryKey(id).getTime());
        registerDTO.setParDuty(dutyMapper.selectByPrimaryKey(dutyMapper.selectByPrimaryKey(id).getParentid()).getTime());
        registerDTO.setDoctorDTO(doctorService.getDoctorById(docId));
        return registerDTO;
    }

    @Override
    public void addRegister(HttpServletRequest request, Integer chiDutyId, Integer docId, Integer depId) {
        Register register = new Register();
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        Integer sysId = user.getId();
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria()
                .andUseridEqualTo(sysId);
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        if(patients.size()==0){
            return;
        }
        Integer patientId = patients.get(0).getId();
        register.setUserId(patientId);
        register.setDocId(docId);
        register.setDepId(depId);
        register.setDutyId(chiDutyId);
        register.setStatus(0);//未进行
        registerMapper.insert(register);
    }

    @Override
    public List<RegisterDTO> findRegisterList(Integer sysId) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria()
                .andUseridEqualTo(sysId);
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        if(patients.size()==0){
            return null;
        }
        Integer patientId = patients.get(0).getId();
        //根据病人id找到他所有的挂号表
        RegisterExample example = new RegisterExample();
        example.createCriteria()
                .andUserIdEqualTo(patientId);
        List<Register> registerList = registerMapper.selectByExample(example);
        List<RegisterDTO> registerDTOList=new ArrayList<>();

        for (Register register : registerList) {
            RegisterDTO registerDTO = new RegisterDTO();
            registerDTO.setId(register.getId());
            registerDTO.setNickname(sysUserMapper.selectByPrimaryKey(sysId).getNickname());
            registerDTO.setDepName(departmentMapper.selectByPrimaryKey(register.getDepId()).getName());
            Duty chilDuty = dutyMapper.selectByPrimaryKey(register.getDutyId());
            registerDTO.setChilDuty(chilDuty.getTime());
            Duty parDuty = dutyMapper.selectByPrimaryKey(chilDuty.getParentid());
            registerDTO.setParDuty(parDuty.getTime());
            registerDTO.setDoctorDTO(doctorService.getDoctorById(register.getDocId()));
            registerDTOList.add(registerDTO);
        }
        return registerDTOList;
    }

    @Override
    public RegisterDTO showRegisterDetail(Integer id,Integer sysId) {
        Register register = registerMapper.selectByPrimaryKey(id);
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setNickname(sysUserMapper.selectByPrimaryKey(sysId).getNickname());
        registerDTO.setDepName(departmentMapper.selectByPrimaryKey(register.getDepId()).getName());
        Duty chilDuty = dutyMapper.selectByPrimaryKey(register.getDutyId());
        registerDTO.setChilDuty(chilDuty.getTime());
        Duty parDuty = dutyMapper.selectByPrimaryKey(chilDuty.getParentid());
        registerDTO.setParDuty(parDuty.getTime());
        registerDTO.setDoctorDTO(doctorService.getDoctorById(register.getDocId()));
        return registerDTO;
    }
}