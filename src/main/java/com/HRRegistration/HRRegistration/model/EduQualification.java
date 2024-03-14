package com.HRRegistration.HRRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class EduQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qid;
    private String qualification;
    private Integer year;

    @ManyToOne
    private Employee employees;
}
