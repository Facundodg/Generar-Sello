package com.example.demo.Repocitori;

import com.example.demo.Model.DTO.SelloBajaDTO;
import com.example.demo.Model.Entity.Sello;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelloRepocitory extends JpaRepository<Sello, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM obtener_datos_por_id(:p_id)", nativeQuery = true)
    List<Object[]> obtenerDatosPorId(@Param("p_id") Long pId);

}
