package com.employee.service;

import com.employee.exception.UserNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return  employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) throws UserNotFoundException {
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if(optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        else {
            throw new UserNotFoundException("User not found with id "+id);
        }
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee=employeeRepository.findById(employee.getEmpId()).get();
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setAddress(employee.getAddress());

        Employee updatedEmployee=employeeRepository.save(existingEmployee);
        return  updatedEmployee;

    }

    @Override
    public String deleteEmployee(Long id) {
        if(employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted Successfully";
        }
        return "No such employee in the database";



    }

    @Override
    public List<Employee> searchEmployee(String query) {
        List<Employee> employee=employeeRepository.searchEmployeeSQL(query);
        return  employee;
    }

    @Override
    public List<Employee> findSalaryGreaterThan() {
        List<Employee> employee=employeeRepository.findAll();
        return  employee;
    }

    @Override
    public List<Employee> findEmployeesByFullName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName,lastName);
    }


}
