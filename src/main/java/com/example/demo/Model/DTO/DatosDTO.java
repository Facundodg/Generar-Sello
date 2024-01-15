package com.example.demo.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DatosDTO {

    @NotNull(message = "El cuit no puede ser nulo")
    @Size(min = 13, max = 13, message = "El cuit tiene que tener 13 caracteres")
    @NotBlank
    private String cuit;
    @NotNull(message = "El id_tramite no puede ser nulo")
    private Long id_tramite;
    @NotNull(message = "Los Mt2 no pueden ser nulos")
    private double mt2;
    @NotNull(message = "El padron no puede ser nulo")
    @Size(min = 6, max = 6, message = "El padron tiene que tener 6 caracteres")
    @NotBlank
    private String padron;

}
