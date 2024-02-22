package com.example.demo.Model.Entity.postgres;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "estacion")
public class Datos {

    @Id
    @Column(name = "id_datos", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tasa;
    private String subTipoTasa;
    private String padron;
    private double mtsCuadrados;

}
