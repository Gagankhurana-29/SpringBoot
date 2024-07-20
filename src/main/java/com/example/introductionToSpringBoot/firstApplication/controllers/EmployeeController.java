package com.example.introductionToSpringBoot.firstApplication.controllers;

import com.example.introductionToSpringBoot.firstApplication.DTO.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @GetMapping
    public String getAllEmployees(){
        return new String("All employees Data");
    }

    @GetMapping(path = "/{employeeId}/")
    public Employee getEmployeeById(@PathVariable long employeeId){
        return  new Employee("Gagan",employeeId,23,1000000,"CEO");
    }

    @GetMapping(path = "/")
    public String getEmployeeByRequestMapping(@RequestParam(required = false) Long id){
       // if(id == 0.0) return new String("All employees Data");
       // return  new Employee("Gagan",id,23,1000000,"CEO");
        if(id == null){
            return "Id not present";
        }
        return "Hi "+ id;
    }
}
