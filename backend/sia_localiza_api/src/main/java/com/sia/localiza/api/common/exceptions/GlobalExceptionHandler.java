package com.sia.localiza.api.common.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ApiError> validationException(
             ValidationException ex, 
             HttpServletRequest request){
       log.error("validation exception : "+  
                  ex.getLocalizedMessage()+
                 " for "+ 
                  request.getRequestURI() );
        
        return new ResponseEntity<>(
            ApiError.builder()
                .message("Request is not valid: "+ex.getLocalizedMessage())
                .status_code(HttpStatus.BAD_REQUEST.value())
                .request(request.getRequestURI())
                .method(request.getMethod())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ApiError> noSuchElementException(
            NoSuchElementException ex, 
            HttpServletRequest request){
        
       log.error("validation exception : "+  
                  ex.getLocalizedMessage()+
                 " for "+ 
                  request.getRequestURI() );
        
        return new ResponseEntity<>(
            ApiError.builder()
                .message("Entity not found!")
                .status_code(HttpStatus.NOT_FOUND.value())
                .request(request.getRequestURI())
                .method(request.getMethod())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> invalidJsonArgument(
        MethodArgumentNotValidException ex, 
            HttpServletRequest request){
        
       log.error("schema validation exception : "+  
                  ex.getLocalizedMessage()+
                 " for "+ 
                  request.getRequestURI() );

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        }));
       
        return new ResponseEntity<>(
            ApiError.builder()
                .message("Schema validation error!")
                .status_code(HttpStatus.NOT_FOUND.value())
                .request(request.getRequestURI())
                .method(request.getMethod())
                .errors(errors)
                .build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiError> genericException(
             Exception ex, 
             HttpServletRequest request){
        
        log.error("exception : "+ 
                 ex.getLocalizedMessage()+ 
                 " for "+ 
                 request.getRequestURI() );
        
        return new ResponseEntity<>(
            ApiError.builder()
             .message("Could not process request: "+ex.getLocalizedMessage()) 
             .status_code(HttpStatus.INTERNAL_SERVER_ERROR.value())
             .request(request.getRequestURI())
             .method(request.getMethod())
             .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}