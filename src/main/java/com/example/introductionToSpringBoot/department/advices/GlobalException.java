package com.example.introductionToSpringBoot.department.advices;

import com.example.introductionToSpringBoot.department.Exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse<?>> resourceNotFound(ResourceNotFound exception){
   //     ApiError error = ApiError.builder().
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, exception.getMessage());
        return buildResponseEntity(error);
    }

    public ResponseEntity<ApiResponse<?>> buildResponseEntity(ApiError error){
        return new ResponseEntity<>(new  ApiResponse<>(error), error.getStatus() );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> methodArgumentNotValid(MethodArgumentNotValidException exception){

        List<String> subErrors = exception.getBindingResult()
                .getAllErrors().
                stream()
                .map(errors -> errors.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, "Invalid Input",subErrors);

        return buildResponseEntity(error);
    }

}
