package com.HRRegistration.HRRegistration.repository;

import com.HRRegistration.HRRegistration.model.EduQualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualificationRepo extends JpaRepository<EduQualification,Long> {
}
