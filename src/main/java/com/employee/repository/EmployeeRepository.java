package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e FROM Employee e WHERE "+
            "e.firstName LIKE CONCAT ('%',:query,'%')"+
            "or e.lastName LIKE CONCAT ('%',:query,'%')")
    List<Employee> searchEmployee(String query);

    @Query(value = "SELECT * FROM employee e WHERE "+
            "e.first_name LIKE CONCAT ('%',:query,'%')"+
            "or e.last_name LIKE CONCAT ('%',:query,'%') ",nativeQuery = true)
    List<Employee> searchEmployeeSQL(String query);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);









}
