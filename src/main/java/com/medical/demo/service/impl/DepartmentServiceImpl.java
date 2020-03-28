package com.medical.demo.service.impl;

import com.medical.demo.base.result.Results;
import com.medical.demo.dto.DepartmentDTO;
import com.medical.demo.mapper.DepartmentMapper;
import com.medical.demo.model.Department;
import com.medical.demo.model.DepartmentExample;
import com.medical.demo.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentDTO> getAllPerDeps() {
        //找到所有的父级科室
        DepartmentExample example = new DepartmentExample();
        example.createCriteria()
                .andParentidEqualTo(0);
        List<Department> departments = departmentMapper.selectByExample(example);
        List<DepartmentDTO> departmentDTOList=new ArrayList<>();
        //找到父级科室对应的子科室并组装为dto
        for(Department department:departments){
            DepartmentExample departmentExample = new DepartmentExample();
            departmentExample.createCriteria()
                    .andParentidEqualTo(department.getId());
            List<Department> chilDeps = departmentMapper.selectByExample(departmentExample);

            DepartmentDTO departmentDTO=new DepartmentDTO();
            BeanUtils.copyProperties(department,departmentDTO);
            departmentDTO.setChilDeps(chilDeps);
            departmentDTOList.add(departmentDTO);
        }
        return departmentDTOList;
    }
}
