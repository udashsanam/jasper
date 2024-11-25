package com.learn.jasper.repository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {

    private Long id;

    private String name;

    private Double salary;

    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public EmployeeDto(Long id, String name, Double salary, String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.city = city;
    }


    public static List<EmployeeDto> getEmployeeList() {
        List<EmployeeDto> employees = new ArrayList<>();

        // Adding some example employees
        employees.add(new EmployeeDto(1l, "John Doe", 50000.0, "New York"));
        employees.add(new EmployeeDto(2l, "Jane Smith", 60000.0, "Los Angeles"));
        employees.add(new EmployeeDto(3l, "Alice Johnson", 70000.0, "Chicago"));
        employees.add(new EmployeeDto(4l, "Bob Brown", 55000.0, "Houston"));

        return employees;
    }
}
