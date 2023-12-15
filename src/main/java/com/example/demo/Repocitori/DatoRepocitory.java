package com.example.demo.Repocitori;

import com.example.demo.Model.Entity.Datos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatoRepocitory extends JpaRepository<Datos, Long> {
}
