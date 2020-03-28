package com.medical.demo.dto;

import com.medical.demo.model.Department;
import lombok.Data;
import java.util.List;

@Data
public class DepartmentDTO {
    private Integer id;
    private String name;
    private List<Department> chilDeps;
}
