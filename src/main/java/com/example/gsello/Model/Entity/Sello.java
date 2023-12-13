package com.example.gsello.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sello {

    @Id
    @Column(name = "id_sello", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSello;
    private double importe;

}
