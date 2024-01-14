package com.example.demo.Controller.Impl;

import com.example.demo.Controller.Iterfaz.SelloApi;
import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.ResponceDTO;
import com.example.demo.Service.Interfaz.SelloServicios;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SelloController implements SelloApi {
    private final SelloServicios selloServicios;

    //public ResponseEntity<SelloDTO> generateSello(DatosDTO datos) throws Exception
    @Override
    public ResponseEntity<ResponceDTO> generateSello(DatosDTO datos, BindingResult bi) {

            try {

                var auth = SecurityContextHolder.getContext().getAuthentication();

                log.info("[SelloController - GenerarSello]");
                log.info("Datos del CUIT: {}", datos.getCuit());
                log.info("Datos del id_tramite: {}", datos.getId_tramite());
                log.info("Datos del Usuario: {}", auth.getPrincipal());
                log.info("Datos de los Roles {}", auth.getAuthorities());
                log.info("Esta autenticado {}", auth.isAuthenticated());

                if(bi.hasErrors()) {
                    ResponceDTO respuesta = ResponceDTO.builder()
                            .status("fail")
                            .result(null)
                            .code("403")
                            .exception(bi.getFieldError().getDefaultMessage())
                            .exceptionMessage(bi.getFieldError().getDefaultMessage())
                            .build();

                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
                }

                return ResponseEntity.ok(selloServicios.generarSello(datos));

            } catch (JwtException ex) {
                return handleJwtException(ex);
            }
    }

    private ResponseEntity<ResponceDTO> handleJwtException(JwtException ex) {
        String exceptionMessage;
        String exceptionType;

        if (ex instanceof ExpiredJwtException) {
            exceptionMessage = "Expired token";
            exceptionType = "ExpiredJwtException";
        } else if (ex instanceof SignatureException) {
            exceptionMessage = "JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.";
            exceptionType = "SignatureException";
        } else if (ex instanceof MalformedJwtException) {
            exceptionMessage = "JWT strings must contain exactly 2 period characters. Found: 1";
            exceptionType = "MalformedJwtException";
            System.out.println("entre ql");
        }else {
            exceptionMessage = "Invalid token";
            exceptionType = "JwtException";
        }
        //.MalformedJwtException

        ResponceDTO respuesta = ResponceDTO.builder()
                .status("fail")
                .result(null)
                .code("403")
                .exception(exceptionType)
                .exceptionMessage(exceptionMessage)
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta);
    }

}
