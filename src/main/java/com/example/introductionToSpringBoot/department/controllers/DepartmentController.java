package com.example.introductionToSpringBoot.department.controllers;

import com.example.introductionToSpringBoot.department.DTO.DepartmentDTO;
import com.example.introductionToSpringBoot.department.Entity.DepartmentEntity;
import com.example.introductionToSpringBoot.department.Repositories.DepartmentRepository;
import com.example.introductionToSpringBoot.department.Service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
class DepartmentController {

    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/getAllDepartments/")
    public ResponseEntity<List<DepartmentDTO>> getDepartments(){
        System.out.println("Getting the departments");
        List<DepartmentDTO> allDepartments =  departmentService.findAll();
        return ResponseEntity.ok(allDepartments);
    }

    @GetMapping(path = "/{departmentID}")
    public String getDepartmentByID(@PathVariable(name = "departmentID") int id){
        return "Department fetched with id " + id;
    }

    @PostMapping(path = "/addDepartments/")
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody @Valid DepartmentDTO departmentDTO){
        //departmentEntity.setName("IT Department");
        DepartmentDTO savedDepartment =  departmentService.save(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{departmentID}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody Map<String, Object> updates,
                                          @PathVariable int departmentID ){
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(departmentID,updates);
        if(updatedDepartment == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable int departmentId){
         Boolean isDeleted = departmentService.deleteDepartment(departmentId);
         if(!isDeleted) return ResponseEntity.notFound().build();
          return ResponseEntity.ok(true);
    }

}
