package com.example.demo.Model.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelloDTO {

    @NotNull(message = "id_tramite no debe ser nulo")
    private Long id_tramite;

    @NotNull(message = "cuit no debe ser nulo")
    private String cuit;

    @NotNull(message = "TipoCategoria no debe ser nulo")
    @Min(value = 1, message = "TipoCategoria no debe ser negativo")
    private String tipoCategoria;

    @NotNull(message = "Importe no debe ser nulo")
    @Min(value = 1, message = "Importe no debe ser negativo")
    private double importeTotal;

    private Concepto conceptoDTO;


}

/*

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
