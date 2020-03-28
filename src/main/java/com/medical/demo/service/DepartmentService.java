package com.medical.demo.service;

import com.medical.demo.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDTO> getAllPerDeps();
}
