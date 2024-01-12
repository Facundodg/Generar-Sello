package com.example.demo.Model.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Concepto {

    @NotNull(message = "Importe no debe ser nulo")
    @Min(value = 1, message = "Importe no debe ser negativo")
    private double inspeccion;
    @NotNull(message = "Importe no debe ser nulo")
    @Min(value = 1, message = "Importe no debe ser negativo")
    private double tasaAdministrativa;
    @NotNull(message = "Importe no debe ser nulo")
    @Min(value = 1, message = "Importe no debe ser negativo")
    private double factibilidad;

    @NotNull(message = "Categoria no debe ser nulo")
    @Min(value = 1, message = "Categoria no debe ser negativo")
    private double categoria;

}

/*

{
    "conceptoDTO": {
        "inspeccion": 2550.0,
        "tasaAdministrativa": 255.0,
        "factibilidad": 9350.0,
        "categoria": 4845.0
    },
    "tipoCategoria": "CATEGORIA A",
    "importeTotal": 17000.0
}


{
    }

    "id_tramite":"1",
    "cuit":"20-22222222-2",
    "Categoria": "A",
    "importeTotal": 17000.0
    "conceptos:":{
        "inspeccion": 2550.0,
        "tasaAdministrativa": 255.0,
        "factibilidad": 9350.0,
        "categoria": 4845.0,
    }
}


 */