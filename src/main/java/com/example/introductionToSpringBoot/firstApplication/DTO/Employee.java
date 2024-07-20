package com.example.introductionToSpringBoot.firstApplication.DTO;

public class Employee {
    private long id;
    private String name;
    private int age;
    private String Designation;
    private int Salary;

    public Employee(String name, long id, int age, int salary, String designation) {
        this.name = name;
        this.id = id;
        this.age = age;
        Salary = salary;
        Designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

}
