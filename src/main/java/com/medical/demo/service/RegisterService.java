package com.medical.demo.service;

import com.medical.demo.dto.RegisterDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface RegisterService {
    RegisterDTO addRegisterDTO(HttpServletRequest request, Integer id, Integer docId, Integer depId);

    void addRegister(HttpServletRequest request, Integer chiDutyId, Integer docId, Integer depId);

    List<RegisterDTO> findRegisterList(Integer sysId);

    RegisterDTO showRegisterDetail(Integer id,Integer sysId);
}
