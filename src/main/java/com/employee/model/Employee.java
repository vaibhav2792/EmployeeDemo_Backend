package com.employee.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    private String firstName;
    private String lastName;
    @Email(message = "Invalid email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "Invalid Phone number entered")
    private String phone;
    private double  salary;
    private String address;

    public Employee() {
    }

    public Employee(long empId, String firstName, String lastName, String email, String phone, double salary, String address) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.address = address;
    }

    public long getEmpId() {

        return empId;
    }

    public void setEmpId(long empId) {

        this.empId = empId;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public double getSalary() {

        return salary;
    }

    public void setSalary(double salary) {

        this.salary = salary;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }
}
