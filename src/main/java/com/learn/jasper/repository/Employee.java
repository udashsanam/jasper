package com.learn.jasper.repository;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;

    private String name;

    private String salary;

    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee(int id, String name, String salary, String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.city = city;
    }


    public List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();

        // Adding some example employees
        employees.add(new Employee(1, "John Doe", "50000", "New York"));
        employees.add(new Employee(2, "Jane Smith", "60000", "Los Angeles"));
        employees.add(new Employee(3, "Alice Johnson", "70000", "Chicago"));
        employees.add(new Employee(4, "Bob Brown", "55000", "Houston"));

        return employees;
    }
}
