package com.example.demo.Controller.Impl;

import com.example.demo.Controller.Iterfaz.SelloApi;
import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.SelloDTO;
import com.example.demo.Service.Interfaz.SelloServicios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SelloController implements SelloApi {

    private final SelloServicios selloServicios;
    private static final Logger logger = LoggerFactory.getLogger(DemoRest.class);

    //este es el endpoint que vamos a cambiar para que reciba y devuelva los siguientes datos


    //public ResponseEntity<SelloDTO> generateSello(DatosDTO datos) throws Exception
    @Override
    public ResponseEntity<SelloDTO> generateSello(DatosDTO datos) throws Exception {

        log.info("[SelloController - GenerarSello]");
        logger.info("Datos del CUIT: {}", datos.getCuit());
        logger.info("Datos del id_tramite: {}", datos.getId_tramite());

        var auth =  SecurityContextHolder.getContext().getAuthentication();

        logger.info("Datos del Usuario: {}", auth.getPrincipal());
        logger.info("Datos de los Roles {}", auth.getAuthorities());
        logger.info("Esta autenticado {}", auth.isAuthenticated());

        return ResponseEntity.ok(selloServicios.generarSello(datos));

        //return ResponseEntity.ok(selloServicios.generarSello(datos));
    }

}
