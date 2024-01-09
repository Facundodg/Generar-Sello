package com.example.demo.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticoCategoria;

    @OneToOne
    @JoinColumn(name = "id_categoria")
    private HabConceptoTarif habConceptoTarif;

}
