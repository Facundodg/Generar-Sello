package com.example.gsello.Repocitori;

import com.example.gsello.Model.Entity.Datos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatoRepocitory extends JpaRepository<Datos, Long> {
}
