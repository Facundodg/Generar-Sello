package com.example.demo.Repocitori;

import com.example.demo.Model.Entity.Sello;
import com.example.demo.Model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepocitory extends JpaRepository<Usuario, Long> {

    Usuario findAllByCuit(String cuit);

    // Método personalizado con la anotación @Query
    @Query( value = "SELECT * FROM Usuario WHERE cuit = :cuit AND tem = true AND cisi = true", nativeQuery = true)
    Usuario findAllByCuitAndTemIsTrueAndCisiIsTrue(String cuit);

}
