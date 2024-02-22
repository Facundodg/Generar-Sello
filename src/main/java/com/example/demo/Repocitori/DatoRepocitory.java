package com.example.demo.Repocitori;

import com.example.demo.Model.Entity.postgres.Datos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatoRepocitory extends JpaRepository<Datos, Long> {
}
