package com.medical.demo.service.impl;

import com.medical.demo.mapper.PatientMapper;
import com.medical.demo.model.Patient;
import com.medical.demo.model.PatientExample;
import com.medical.demo.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Resource
    private PatientMapper patientMapper;

    @Override
    public Patient getPatientByUserid(Integer userid) {
        PatientExample example = new PatientExample();
        example.createCriteria()
                .andUseridEqualTo(userid);
        List<Patient> patients = patientMapper.selectByExample(example);
        if(patients.size()==0){
            return null;
        }
        return patients.get(0);
    }
}
