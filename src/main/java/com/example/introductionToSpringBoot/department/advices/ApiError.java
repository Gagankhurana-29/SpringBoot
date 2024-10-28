package com.example.introductionToSpringBoot.department.advices;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Getter
@Setter
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

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<String> subErrors) {
        this.subErrors = subErrors;
    }

    private List<String> subErrors;
}
