package com.medical.demo.service;


import com.medical.demo.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    List<DoctorDTO> getAllDoctorsByDep(Integer id);
    DoctorDTO getDoctorById(Integer id);
}
