package com.medical.demo.service.impl;

import com.medical.demo.base.result.Results;
import com.medical.demo.dto.DoctorDTO;
import com.medical.demo.mapper.DepartmentMapper;
import com.medical.demo.mapper.DoctorMapper;
import com.medical.demo.mapper.SysUserMapper;
import com.medical.demo.model.Doctor;
import com.medical.demo.model.DoctorExample;
import com.medical.demo.model.SysUser;
import com.medical.demo.service.DoctorService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public List<DoctorDTO> getAllDoctorsByDep(Integer id) {
        DoctorExample example = new DoctorExample();
        example.createCriteria()
                .andDepidEqualTo(id);
        List<Doctor> doctors = doctorMapper.selectByExample(example);
        List<DoctorDTO> doctorDTOList=new ArrayList<>();
        for(Doctor doctor:doctors){
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(doctor.getUserid());
            DoctorDTO doctorDTO=new DoctorDTO();
            BeanUtils.copyProperties(doctor,doctorDTO);
            doctorDTO.setSysUser(sysUser);
            doctorDTO.setDepName(departmentMapper.selectByPrimaryKey(doctor.getDepid()).getName());
            doctorDTOList.add(doctorDTO);
        }
        return doctorDTOList;
    }

    @Override
    public DoctorDTO getDoctorById(Integer id) {
        DoctorDTO doctorDTO=new DoctorDTO();
        Doctor doctor = doctorMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(doctor,doctorDTO);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(doctor.getUserid());
        doctorDTO.setSysUser(sysUser);
        return doctorDTO;
    }
}
