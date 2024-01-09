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
@Table(name = "hab_concepto_tarif")
public class HabConceptoTarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_categoria;
    private Long cant_urbanos;
    private LocalDateTime fecha;

    // Opcionalmente, puedes tener una relación bidireccional con HabTramiteConcepto
    @OneToMany(mappedBy = "conceptoTarif")
    private Set<HabTramiteConcepto> tramiteConceptos = new HashSet<>();

    @OneToOne(mappedBy = "habConceptoTarif", cascade = CascadeType.ALL)
    private Categoria categoria;

}