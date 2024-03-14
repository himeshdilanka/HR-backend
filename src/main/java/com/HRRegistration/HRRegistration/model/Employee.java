package com.HRRegistration.HRRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "employee")
    private List<Dependent> dependents;

    @OneToMany(mappedBy = "employees")
    private List<EduQualification> eduQualifications;

    @OneToMany(mappedBy = "employee")
    private List<PreviousWorkHistory>previousWorkHistories;
}
