package com.example.demo.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hab_tramite_tarif")
public class HabTramiteTarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tipo;
    private String descripcion;
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "tramiteTarif")
    private Set<HabTramiteConcepto> tramiteConceptos = new HashSet<>();
}