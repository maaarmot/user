package com.medical.demo.service;

import com.medical.demo.base.result.Results;
import com.medical.demo.model.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatientByUserid(Integer userid);
}
