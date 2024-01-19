package com.example.demo.Model.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConceptoBajaDTO {

    private long id_tramite;
    private long cant_urbanos;
    private String tipo_concepto;
    private double costo;

}
