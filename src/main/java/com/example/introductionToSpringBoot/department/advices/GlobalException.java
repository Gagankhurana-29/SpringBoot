package com.example.introductionToSpringBoot.department.advices;

import com.example.introductionToSpringBoot.department.Exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiError> resourceNotFound(ResourceNotFound exception){
   //     ApiError error = ApiError.builder().
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> methodArgumentNotValid(MethodArgumentNotValidException exception){

        List<String> subErrors = exception.getBindingResult()
                .getAllErrors().
                stream()
                .map(errors -> errors.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, "Invalid Input",subErrors);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
