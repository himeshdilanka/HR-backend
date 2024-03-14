package com.HRRegistration.HRRegistration.repository;

import com.HRRegistration.HRRegistration.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
