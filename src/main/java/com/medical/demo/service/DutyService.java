package com.medical.demo.service;

import com.medical.demo.dto.DutyDTO;

import java.util.List;

public interface DutyService {
    List<DutyDTO> getDutyById(Integer id);
}
