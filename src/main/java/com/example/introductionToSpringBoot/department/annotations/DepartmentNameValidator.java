package com.example.introductionToSpringBoot.department.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class DepartmentNameValidator implements ConstraintValidator<DepartmentNameValidation, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> departments = List.of("IT","Accounts");
        return departments.contains(s);
    }
}
