package com.HRRegistration.HRRegistration.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PreviousWorkHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobtitle;
    private String date;

    @ManyToOne
    private Employee employee;
}
