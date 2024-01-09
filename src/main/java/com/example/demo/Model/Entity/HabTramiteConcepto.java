package com.example.demo.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hab_tramite_concepto")
public class HabTramiteConcepto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_tramite_tarif")
    private HabTramiteTarif tramiteTarif;

    @ManyToOne
    @JoinColumn(name = "id_concepto_tarif")
    private HabConceptoTarif conceptoTarif;
}