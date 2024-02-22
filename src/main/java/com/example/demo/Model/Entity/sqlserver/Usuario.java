package com.example.demo.Model.Entity.sqlserver;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contribuyente", schema = "habilitacion")
public class Usuario {

    @Id
    @Column(name = "id_usuario", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cuit;
    private String categoria;
    private int anio;
    private boolean tem;
    private boolean cisi;

}
