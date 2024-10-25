package com.example.introductionToSpringBoot.department.DTO;

import com.example.introductionToSpringBoot.department.annotations.DepartmentNameValidation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class DepartmentDTO {

    @DepartmentNameValidation(message = "Department shoud be IT/Accounts")
    private String name;

    private int id;

    @Min(value = 1, message = "Atleast one person should be there")
    private int people;

    @Min(value = 20000, message = "Minimum budget should be 20k")
    private long budget;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String name, int id, int people, long budget) {
        this.name = name;
        this.id = id;
        this.people = people;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
