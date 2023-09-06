package com.employee.service;

import com.employee.exception.UserNotFoundException;
import com.employee.model.Employee;

import java.util.List;


public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id) throws UserNotFoundException;

    Employee updateEmployee(Employee employee);

    String deleteEmployee(Long id);

    List<Employee> searchEmployee(String query);

    List<Employee> findSalaryGreaterThan();

    List<Employee> findEmployeesByFullName(String firstName, String lastName);







}
