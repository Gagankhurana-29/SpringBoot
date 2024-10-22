package com.example.introductionToSpringBoot.department.controllers;

import com.example.introductionToSpringBoot.department.DTO.DepartmentDTO;
import com.example.introductionToSpringBoot.department.Entity.DepartmentEntity;
import com.example.introductionToSpringBoot.department.Repositories.DepartmentRepository;
import com.example.introductionToSpringBoot.department.Service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
class DepartmentController {

    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/getAllDepartments/")
    public List<DepartmentDTO> getDepartments(){
        System.out.println("Getting the departments");
        return departmentService.findAll();
    }

    @GetMapping(path = "/{departmentID}")
    public String getDepartMentByID(@PathVariable(name = "departmentID") int id){
        return "Department fetched with id " + id;
    }

    @PostMapping(path = "/addDepartments/")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO){
        //departmentEntity.setName("IT Department");
        return departmentService.save(departmentDTO);
    }

}
