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

    @NotNull(message = "TipoCategoria no debe ser nulo")
    @Min(value = 1, message = "TipoCategoria no debe ser negativo")
    private String tipoCategoria;

    @NotNull(message = "Importe no debe ser nulo")
    @Min(value = 1, message = "Importe no debe ser negativo")
    private double importeTotal;

}
