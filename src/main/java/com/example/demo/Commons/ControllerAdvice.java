package com.example.demo.Commons;

import com.example.demo.Model.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeException(RuntimeException ex){
        String exceptionType = ex.getClass().getSimpleName();
        ErrorDTO error = ErrorDTO.builder()
                .status("fail")
                .excepcion(exceptionType)
                .code("404")
                .exceptionMessage(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);

    }

}
