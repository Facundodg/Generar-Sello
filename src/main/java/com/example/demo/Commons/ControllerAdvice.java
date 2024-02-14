package com.example.demo.Commons;

import com.example.demo.Model.DTO.ErrorDTO;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeException(RuntimeException ex){
        String exceptionType = ex.getClass().getSimpleName();
        HttpStatus httpStatus = getStatusFromException(ex);

        String exceptionMessage;
        //String exceptionType;

        if (ex instanceof ExpiredJwtException) {
            exceptionMessage = "Expired token";
            exceptionType = "JwtException.ExpiredJwtException";
        } else if (ex instanceof SignatureException) {
            exceptionMessage = "JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.";
            exceptionType = "JwtException.SignatureException";
        } else if (ex instanceof MalformedJwtException) {
            exceptionMessage = "JWT strings must contain exactly 2 period characters. Found: 1";
            exceptionType = "JwtException.MalformedJwtException";
        }else {
            exceptionMessage = "Invalid token";
            exceptionType = "JwtException";
        }

        ErrorDTO error = ErrorDTO.builder()
                .status("fail")
                .excepcion("com.dim.exception."+exceptionType)
                .code(String.valueOf(httpStatus.value()))
                .exceptionMessage(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);

    }

    private HttpStatus getStatusFromException(Exception ex) {
        ResponseStatus responseStatusAnnotation = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
        if (responseStatusAnnotation != null) {
            return responseStatusAnnotation.value();
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR; // Si no hay anotación, devolver un estado interno del servidor
        }
    }


}
