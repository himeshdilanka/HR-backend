package com.HRRegistration.HRRegistration.service.impl;

import com.HRRegistration.HRRegistration.controller.response.DependentResponse;
import com.HRRegistration.HRRegistration.controller.response.EmployeeResponse;
import com.HRRegistration.HRRegistration.exception.EmployeeNotFoundException;
import com.HRRegistration.HRRegistration.model.Dependent;
import com.HRRegistration.HRRegistration.model.EduQualification;
import com.HRRegistration.HRRegistration.model.Employee;
import com.HRRegistration.HRRegistration.model.PreviousWorkHistory;
import com.HRRegistration.HRRegistration.repository.DependentRepo;
import com.HRRegistration.HRRegistration.repository.EmployeeRepo;
import com.HRRegistration.HRRegistration.repository.HistoryRepo;
import com.HRRegistration.HRRegistration.repository.QualificationRepo;
import com.HRRegistration.HRRegistration.service.AllServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasicImpl implements AllServices {

    EmployeeRepo employeeRepo;
    DependentRepo dependentRepo;
    QualificationRepo qualificationRepo;
    HistoryRepo historyRepo;
    @Override
    public Employee addemp(Employee employee){
        Employee employee1= new Employee();
        employee1.setName(employee.getName());
        employee1.setAge(employee.getAge());
        return employeeRepo.save(employee1);
    }

    public void adddep (Long id,Dependent dependent){

        Optional<Employee> employeeOptional=employeeRepo.findById(id);

        if(!employeeOptional.isPresent()){
            System.out.println("No Employee ID found");
        }
        else{
            Employee employee=employeeOptional.get();
            Dependent dependent1=new Dependent();
            dependent1.setDName(dependent.getDName());
            dependent1.setContact(dependent.getContact());
            dependent1.setEmployee(employee);
            dependentRepo.save(dependent1);
        }

    }

    public void addquali (Long id, EduQualification eduQualification){
        Optional<Employee> employeeOptional=employeeRepo.findById(id);

        if(!employeeOptional.isPresent()){
            System.out.println("No Employee ID found");
        }
        else{
            Employee employee=employeeOptional.get();
            EduQualification eduQualification1=new EduQualification();
            eduQualification1.setQualification(eduQualification.getQualification());
            eduQualification1.setYear(eduQualification.getYear());
            eduQualification1.setEmployees(employee);
            qualificationRepo.save(eduQualification1);
        }

    }

    public void addhis(Long id, PreviousWorkHistory previousWorkHistory){
        Optional<Employee>employeeOptional=employeeRepo.findById(id);

        if (!employeeOptional.isPresent()){
            System.out.println("No Employee ID found");
        }
        else {
            Employee employee=employeeOptional.get();
            PreviousWorkHistory previousWorkHistory1=new PreviousWorkHistory();
            previousWorkHistory1.setJobtitle(previousWorkHistory.getJobtitle());
            previousWorkHistory1.setDate(previousWorkHistory.getDate());
            previousWorkHistory1.setEmployee(employee);
            historyRepo.save(previousWorkHistory1);
        }
    }

    @Override
    public Optional<EmployeeResponse> getempid(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional=employeeRepo.findById(id);

        if(employeeOptional.isPresent()){
            EmployeeResponse employeeResponse=new EmployeeResponse();

           Employee employee=employeeOptional.get();
           employeeResponse.setId(employee.getId());
           employeeResponse.setName(employee.getName());
           employeeResponse.setAge(employee.getAge());
           return Optional.of(employeeResponse);
        }
        else {
            throw new EmployeeNotFoundException("No employee id found");

        }
    }

    @Override
    public DependentResponse getdepid(Long id)throws EmployeeNotFoundException{
        Optional<Dependent> dependentOptional=dependentRepo.findById(id);

        if(dependentOptional.isPresent()){
            DependentResponse dependentResponse=new DependentResponse();

            Dependent dependent=dependentOptional.get();
            dependentResponse.setDid(dependent.getDId());
            dependentResponse.setDname(dependent.getDName());
            dependentResponse.setContact(dependent.getContact());

            return dependentResponse;
        }
        else {
            throw new EmployeeNotFoundException("No dependent id found");
        }

    }

    @Override
    public Optional<Employee> updateEmp(Employee employee,Long id){
        return employeeRepo.findById(id)
                .map(newEmployee ->{
                    newEmployee.setName(employee.getName());
                    newEmployee.setAge((employee.getAge()));
                    employeeRepo.save(newEmployee);
                    return null;
                }
                );
    }

    @Override
    public Optional<String> deldep(Long id){
        if(!dependentRepo.existsById(id)){
            return Optional.of("no Id found");
        }
       dependentRepo.deleteById(id);
        return Optional.of("ID "+id +" deleted");
    }

    @Override
    public Optional<String> delhistory(Long id){
        if (!historyRepo.existsById(id)){
            return Optional.of("No Id found");
        }
        historyRepo.deleteById(id);
        return Optional.of("Id "+id+" deleted");
    }

}
