package com.example.introductionToSpringBoot.department.Service;

import com.example.introductionToSpringBoot.department.DTO.DepartmentDTO;
import com.example.introductionToSpringBoot.department.Entity.DepartmentEntity;
import com.example.introductionToSpringBoot.department.Exception.ResourceNotFound;
import com.example.introductionToSpringBoot.department.Repositories.DepartmentRepository;
import org.aspectj.util.Reflection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.module.ResolutionException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    public List<DepartmentDTO> findAll() {
        List<DepartmentEntity> allDepartments = departmentRepository.findAll();
        return allDepartments.stream().map(departments -> modelMapper.map(departments, DepartmentDTO.class)).collect(Collectors.toList());
    }

    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        DepartmentEntity toSave = modelMapper.map(departmentDTO,DepartmentEntity.class);
        DepartmentEntity savedDepartment = departmentRepository.save(toSave);
        return modelMapper.map(savedDepartment,DepartmentDTO.class);

    }

    private boolean departmentExist(int departmentID) {
        return departmentRepository.existsById(departmentID);
    }

    public DepartmentDTO updateDepartment(int departmentID, Map<String, Object> updates) {
        if(!departmentExist(departmentID)) return null;
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentID).get();
        updates.forEach((field,value) ->{
          Field fieldToUpdate =  ReflectionUtils.findField(DepartmentEntity.class,field);
          fieldToUpdate.setAccessible(true);
          ReflectionUtils.setField(fieldToUpdate,departmentEntity,value);
        });
        DepartmentEntity updatedDepartment = departmentRepository.save(departmentEntity);
        return modelMapper.map(updatedDepartment,DepartmentDTO.class);
    }

    public boolean deleteDepartment(int departmentId) {
        if(!departmentExist(departmentId)) throw new ResourceNotFound();
        departmentRepository.deleteById(departmentId);
        return true;
    }
}
