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

    @NotNull(message = "ID no debe ser nulo")
    private Long id_sello;
    @NotNull(message = "Importe no debe ser nulo")
    @Min(value = 1, message = "Importe no debe ser negativo")
    private double importe;

}
