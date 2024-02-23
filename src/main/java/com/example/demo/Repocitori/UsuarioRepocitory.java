package com.example.demo.Repocitori;

import com.example.demo.Model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepocitory extends JpaRepository<Usuario, Long> {

    Usuario findAllByCuit(String cuit);

    // Método personalizado con la anotación @Query
    //@Query( value = "SELECT * FROM habilitacion.contribuyente WHERE cuit = :cuit", nativeQuery = true)
    //Usuario findAllByCuitAndTemIsTrueAndCisiIsTrue(String cuit);
    // Método personalizado con la anotación @Query

    @Query( value = "SELECT * FROM GetCategoriaHabilitacion(:cuit)", nativeQuery = true)
    Object findByCuitSqlServer(String cuit);

//select * from [dbo].[GetCategoriaHabilitacion]('20321105700')

    /*

    			SELECT tramites.id, tarifa.id, tarifa.desc_concepto + ' ' + coalesce(cat.desc_categoria,'') as concepto
			--htt.id, htc.cant_urbanos,dbo.hab_categoria.desc_categoria
			, tarifa.cant_urbanos + coalesce(cat.cant_urbanos,0) * costo as tarifa
			FROM dbo.hab_tramite tramites
			INNER JOIN dbo.hab_tramite_concepto reltc ON tramites.id = reltc.id_tramite
			INNER JOIN dbo.hab_concepto_tarif tarifa ON reltc.id_concepto = tarifa.id
			INNER JOIN dbo.hab_costo_urbano costo ON  costo.anio = cat.anio
			--falta el inner join de la tabla costo_urbano
			LEFT JOIN dbo.hab_categoria_tarif cat ON cat.id_concepto = tarifa.id and cat.anio = tarifa.anio and cat.desc_categoria = 'C'
			Where tramites.id = 1 and tarifa.anio = YEAR(GETDATE())
			order by 1,2


     */

}
