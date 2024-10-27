package com.example.introductionToSpringBoot.department.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ApiError {
    private HttpStatus status;
    private String message;

    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
       // this.subErrors = subErrors;
    }
    public ApiError(HttpStatus status, String message, List<String> subErrors) {
        this.status = status;
        this.message = message;
         this.subErrors = subErrors;
    }

    private List<String> subErrors;
}
