package com.priyanka.datta.springbootaop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex){
        ErroneousResponse erroneousResponse = new ErroneousResponse();
        erroneousResponse.setResponseCode(HttpStatus.NOT_FOUND.getReasonPhrase());
        erroneousResponse.setResponseMessage(ex.getMessage());
        return new ResponseEntity(erroneousResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleServerxception(Exception ex){
        ErroneousResponse erroneousResponse = new ErroneousResponse();
        erroneousResponse.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        erroneousResponse.setResponseMessage(ex.getMessage());
        return new ResponseEntity(erroneousResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
