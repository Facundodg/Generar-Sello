package com.example.Gsello.Model.Entity;


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
    private Long idDatos;
    private String tasa;
    private String subTasa;
    private String padron;
    private double mtsCuadrados;

}
