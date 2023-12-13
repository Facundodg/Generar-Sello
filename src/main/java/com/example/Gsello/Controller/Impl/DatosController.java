package com.example.Gsello.Controller.Impl;

import com.example.Gsello.Controller.Iterfaz.DatosApi;
import com.example.Gsello.Model.Entity.Datos;
import com.example.Gsello.Service.Interfaz.DatoServicios;
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
