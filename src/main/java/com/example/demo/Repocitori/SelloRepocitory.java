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

    String sqlQuery = "SELECT hab_tramite_tarif.id, hab_concepto_tarif.cant_urbanos, " +
            "hab_concepto_tarif.tipo_concepto, costo_urbano.costo " +
            "FROM hab_tramite_tarif " +
            "INNER JOIN hab_tramite_concepto ON hab_tramite_tarif.id = hab_tramite_concepto.id_tramite_tarif " +
            "INNER JOIN hab_concepto_tarif ON hab_tramite_concepto.id_concepto_tarif = hab_concepto_tarif.id " +
            "INNER JOIN costo_urbano ON hab_concepto_tarif.id = costo_urbano.id " +
            "WHERE hab_tramite_tarif.id = :tramiteId";

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM obtener_datos_por_id(:p_id)", nativeQuery = true)
    List<Object[]> obtenerDatosPorId(@Param("p_id") Long pId);

    @Modifying
    @Transactional
    @Query(value = "select * from obtener_tramite(:tramiteId,'')", nativeQuery = true)
    List<Object[]> obtenerTramite(@Param("tramiteId") Long pId);

    /*

        public List<Object[]> obtenerDatosTramite(Long tramiteId) {
        String sqlQuery = "SELECT hab_tramite_tarif.id, hab_concepto_tarif.cant_urbanos, " +
                          "hab_concepto_tarif.tipo_concepto, costo_urbano.costo " +
                          "FROM hab_tramite_tarif " +
                          "INNER JOIN hab_tramite_concepto ON hab_tramite_tarif.id = hab_tramite_concepto.id_tramite_tarif " +
                          "INNER JOIN hab_concepto_tarif ON hab_tramite_concepto.id_concepto_tarif = hab_concepto_tarif.id " +
                          "INNER JOIN costo_urbano ON hab_concepto_tarif.id = costo_urbano.id " +
                          "WHERE hab_tramite_tarif.id = :tramiteId";

        Query nativeQuery = entityManager.createNativeQuery(sqlQuery);
        nativeQuery.setParameter("tramiteId", tramiteId);

        List<Object[]> result = nativeQuery.getResultList();
        return result;
    }

     */


}
