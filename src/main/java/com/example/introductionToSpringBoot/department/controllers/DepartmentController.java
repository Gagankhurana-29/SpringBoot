package com.example.introductionToSpringBoot.department.controllers;

import com.example.introductionToSpringBoot.department.DTO.DepartmentDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/departments")
class DepartmentController {

    @GetMapping(path = "/getAllDepartments/")
    public String getDepartments(){
        System.out.println("Getting the departments");
        return new String("Hii");
    }

    @GetMapping(path = "/{departmentID}")
    public String getDepartMentByID(@PathVariable(name = "departmentID") int id){
        return "Department fetched with id " + id;
    }

    @PostMapping(path = "/addDepartments/")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDto){
        departmentDto.setName("IT Department");
        return departmentDto;
    }

}
