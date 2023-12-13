package com.example.gsello.Controller.Iterfaz;

import com.example.gsello.Model.Entity.Datos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/datos")
@Tag(name = "Datos", description = "Datos API")
public interface DatosApi {

    @Operation(summary = "Crea un Datos", description = "Retorna el Datos Creados")
    @PostMapping(value = "",
            consumes = {"application/json", "application/xml", "application/x-www-form-urlencoded"},
            produces = {"application/json", "application/vnd.api+json"})
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Datos> saveDatos(
            @NotNull
            @RequestBody @Valid final Datos entidad) throws Exception;

    @Operation(summary = "Busca todos los Datos", description = "Retorna todos los Datos")
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Collection<Datos>> findAll() throws Exception;
}
