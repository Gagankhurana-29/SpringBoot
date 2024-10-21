package com.example.introductionToSpringBoot.department.controllers;

import com.example.introductionToSpringBoot.department.DTO.DepartmentDTO;
import com.example.introductionToSpringBoot.department.Entity.DepartmentEntity;
import com.example.introductionToSpringBoot.department.Repositories.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
class DepartmentController {
    
    private final DepartmentRepository departmentRepository;

    DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping(path = "/getAllDepartments/")
    public List<DepartmentEntity> getDepartments(){
        System.out.println("Getting the departments");
        return departmentRepository.findAll();
    }

    @GetMapping(path = "/{departmentID}")
    public String getDepartMentByID(@PathVariable(name = "departmentID") int id){
        return "Department fetched with id " + id;
    }

    @PostMapping(path = "/addDepartments/")
    public DepartmentEntity addDepartment(@RequestBody DepartmentEntity departmentEntity){
        //departmentEntity.setName("IT Department");
        return departmentRepository.save(departmentEntity);
    }

}
