package com.example.demo.Model.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatosDTO {

    @NotNull(message = "tasa no debe ser nulo")
    private String tasa;
    @NotNull(message = "subTipoTasa no debe ser nulo")
    private String subTipoTasa;
    @NotNull(message = "padron no debe ser nulo")
    private String padron;
    @NotNull(message = "mtsCuadrados no debe ser nulo")
    @Min(value = 1, message = "mtsCuadrados no debe ser negativo")
    private double mtsCuadrados;

}
