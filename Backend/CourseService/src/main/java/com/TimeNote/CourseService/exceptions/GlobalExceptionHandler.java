package com.TimeNote.CourseService.exceptions;

import com.TimeNote.CourseService.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException e){
        e.printStackTrace();
        return ResponseEntity.status(e.getCode()).body(ErrorResponse.builder().message(e.getMessage()).build());
    }
}
