package com.HRRegistration.HRRegistration.service;

import com.HRRegistration.HRRegistration.controller.response.DependentResponse;
import com.HRRegistration.HRRegistration.controller.response.EmployeeResponse;
import com.HRRegistration.HRRegistration.exception.EmployeeNotFoundException;
import com.HRRegistration.HRRegistration.model.Dependent;
import com.HRRegistration.HRRegistration.model.EduQualification;
import com.HRRegistration.HRRegistration.model.Employee;
import com.HRRegistration.HRRegistration.model.PreviousWorkHistory;

import java.util.Optional;

public interface AllServices {
    Employee addemp(Employee employee);
    void adddep(Long id,Dependent dependent);
    void addquali(Long id,EduQualification eduQualification);
    void addhis(Long id, PreviousWorkHistory workHistory);
    Optional<EmployeeResponse> getempid (Long id)throws EmployeeNotFoundException;
    DependentResponse getdepid(Long id)throws EmployeeNotFoundException;
    Optional<Employee> updateEmp(Employee employee, Long id);
    Optional<String> deldep(Long id);
    Optional<String> delhistory(Long id);
}
