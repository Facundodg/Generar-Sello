package com.example.demo.Controller.Iterfaz;

import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.ResponceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RequestMapping("/vep")
@Tag(name = "Sello", description = "Sello API")
public interface SelloApi {

    @Operation(summary = "Genera Sello", description = "Ingresan los Datos y devuelve el Sello")
    @PostMapping(value = "",
            consumes = {"application/json", "application/xml", "application/x-www-form-urlencoded"},
            produces = {"application/json", "application/vnd.api+json"})
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ResponceDTO>generateSello(
            @NotNull
            @RequestBody @Valid final DatosDTO datos, BindingResult bi);

}
