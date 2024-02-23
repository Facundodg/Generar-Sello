package com.example.demo.Controller.Impl;

import com.example.demo.Controller.Iterfaz.DatosApi;
import com.example.demo.Model.Entity.Datos;
import com.example.demo.Service.Interfaz.DatoServicios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DatosController implements DatosApi {

    private final DatoServicios datoServicios;

    @Override
    public ResponseEntity<Datos> saveDatos(Datos entidad) throws Exception {
        log.info(("[DatosController - Guardar: Iniciada con Datos={}"), entidad);
        return ResponseEntity.ok(datoServicios.guardar(entidad));
    }

    @Override
    public ResponseEntity<Collection<Datos>> findAll() throws Exception {
        log.info("[DatosController - BuscarTodos]");
        return ResponseEntity.ok(datoServicios.buscarTodos());
    }
}
