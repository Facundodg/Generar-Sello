package com.example.demo.Model.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConceptoReinspeccion {

    @NotNull(message = "Reinspeccion no debe ser nulo")
    @Min(value = 1, message = "Reinspeccion no debe ser negativo")
    private double inspeccion;

}
