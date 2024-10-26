package com.example.introductionToSpringBoot.department.Exception;

import java.util.NoSuchElementException;

public class ResourceNotFound extends NoSuchElementException {

    @Override
    public String getMessage() {
        return "Resource Not Present";
    }
}
