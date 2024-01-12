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

    @NotNull(message = "El cuit no puede ser nulo")
    private String cuit;
    @NotNull(message = "El id_tramite no puede ser nulo")
    private Long id_tramite;
    @NotNull(message = "Los Mt2 no pueden ser nulos")
    private double mt2;
    @NotNull(message = "El padron no puede ser nulo")
    private Long padron;

}
