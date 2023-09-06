package com.employee.controller;

import com.employee.exception.UserNotFoundException;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployee();
    }


    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) throws UserNotFoundException {
        return employeeService.getEmployeeById(id);
    }


    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody @Valid  Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employee.setEmpId(id);
        Employee updatedEmployee=employeeService.updateEmployee(employee);
        return updatedEmployee;
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {

        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/search")
    public List<Employee> SearchEmployee(@RequestParam("query") String query){
        return  employeeService.searchEmployee(query);
    }

    @GetMapping("/salaryGreaterThan5000")
    public List<Employee> getEmployeeSalaryGreaterThan5000(){
        return employeeService.findSalaryGreaterThan()
                .stream()
                .filter(employee->employee.getSalary()>5000)
                .collect(Collectors.toList());
    }

    @GetMapping("/searchByFullName")
    public ResponseEntity<List<Employee>> searchEmployeesByFullName(
            @RequestParam String firstName, @RequestParam String lastName) {
        List<Employee> employees = employeeService.findEmployeesByFullName(firstName,lastName);
        return ResponseEntity.ok(employees);
    }

}
