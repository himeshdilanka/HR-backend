package com.HRRegistration.HRRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Dependent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dId;
    private String dName;
    private Integer contact;

    @ManyToOne
    private Employee employee;



}
