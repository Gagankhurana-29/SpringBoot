package com.example.introductionToSpringBoot.department.Service;

import com.example.introductionToSpringBoot.department.DTO.DepartmentDTO;
import com.example.introductionToSpringBoot.department.Entity.DepartmentEntity;
import com.example.introductionToSpringBoot.department.Repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
