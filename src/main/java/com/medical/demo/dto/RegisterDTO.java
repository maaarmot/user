package com.medical.demo.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private Integer id;
    private String nickname;
    private String depName;
    private String parDuty;
    private String chilDuty;
    private DoctorDTO doctorDTO;
}
