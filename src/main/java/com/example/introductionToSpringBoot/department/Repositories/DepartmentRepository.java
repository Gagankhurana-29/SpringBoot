package com.example.introductionToSpringBoot.department.Repositories;

import com.example.introductionToSpringBoot.department.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

}
