package com.HRRegistration.HRRegistration.controller;

import com.HRRegistration.HRRegistration.controller.response.DependentResponse;
import com.HRRegistration.HRRegistration.controller.response.EmployeeResponse;
import com.HRRegistration.HRRegistration.exception.EmployeeNotFoundException;
import com.HRRegistration.HRRegistration.model.Dependent;
import com.HRRegistration.HRRegistration.model.EduQualification;
import com.HRRegistration.HRRegistration.model.Employee;
import com.HRRegistration.HRRegistration.model.PreviousWorkHistory;
import com.HRRegistration.HRRegistration.repository.EmployeeRepo;
import com.HRRegistration.HRRegistration.service.AllServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@AllArgsConstructor
public class AllController {

    @Autowired
    AllServices allServices;
    EmployeeRepo employeeRepo;

    @PostMapping("/employees")
    public Employee addemp(@RequestBody Employee employee){
        return allServices.addemp(employee);
    }

    @PostMapping("/employees/{id}/dependents")
    public void adddep(@RequestBody Dependent dependent, @PathVariable("id") Long id){
        allServices.adddep(id,dependent);
    }

    @PostMapping("/employees/{id}/qualification")
    public void addquali(@RequestBody EduQualification eduQualification,@PathVariable("id")Long id){
        allServices.addquali(id,eduQualification);
    }

    @PostMapping("/employees/{id}/workhistory")
    public void addhis(@RequestBody PreviousWorkHistory previousWorkHistory,@PathVariable ("id")Long id){
        allServices.addhis(id,previousWorkHistory);
    }

    @GetMapping("/getemps/{id}")
    public Optional<EmployeeResponse> getempid(@PathVariable Long id)throws EmployeeNotFoundException{
        return allServices.getempid(id);
    }

    @GetMapping("/getdep/{id}")
    public DependentResponse getdepid(@PathVariable Long id)throws EmployeeNotFoundException {
        return allServices.getdepid(id);
    }

    @PutMapping("/updateemps/{id}")
    public Optional<Employee> updateEmp(@PathVariable Long id, @RequestBody Employee employee){
        return allServices.updateEmp(employee,id);
    }

    @DeleteMapping("/deldep/{id}")
    public Optional<String> deldep(@PathVariable Long id){
        return allServices.deldep(id);
    }

    @DeleteMapping("historydelete/{id}")
    public Optional<String> delhistory(@PathVariable Long id){
        return allServices.delhistory(id);
    }



}
