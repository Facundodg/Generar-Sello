package com.example.demo.Controller.Impl;

import com.example.demo.Controller.Iterfaz.SelloApi;
import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.SelloDTO;
import com.example.demo.Service.Interfaz.SelloServicios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SelloController implements SelloApi {

    private final SelloServicios selloServicios;

    @Override
    public ResponseEntity<SelloDTO> generateSello(DatosDTO datos) throws Exception {
        log.info("[SelloController - GenerarSello]");
        return ResponseEntity.ok(selloServicios.generarSello(datos));
    }

}
