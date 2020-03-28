package com.medical.demo.dto;

import com.medical.demo.model.Duty;
import lombok.Data;

import java.util.List;

@Data
public class DutyDTO {
    private Integer id;
    private String time;
    private List<Duty> chilDutys;
}
