package com.example.demo.Model.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelloBajaDTO {
    private Long tramite_id;
    private String descripcion;
    private Long cantidad_urbanos;
    private String tipo_categoria;
    private double costo;
}
