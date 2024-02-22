package com.example.demo.Repocitori;

import com.example.demo.Model.Entity.sqlserver.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepocitory extends JpaRepository<Usuario, Long> {

    Usuario findAllByCuit(String cuit);

    // Método personalizado con la anotación @Query
    @Query( value = "SELECT * FROM habilitacion.contribuyente WHERE cuit = :cuit", nativeQuery = true)
    Usuario findAllByCuitAndTemIsTrueAndCisiIsTrue(String cuit);
    // Método personalizado con la anotación @Query

    @Query( value = "SELECT * FROM GetCategoriaHabilitacion(:cuit)", nativeQuery = true)
    Usuario findByCuitSqlServer(String cuit);

//select * from [dbo].[GetCategoriaHabilitacion]('20321105700')

}
