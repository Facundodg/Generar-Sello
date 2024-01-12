package com.example.demo.Repocitori;

import com.example.demo.Model.Entity.Sello;
import com.example.demo.Model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepocitory extends JpaRepository<Usuario, Long> {

    Usuario findAllByCuit(String cuit);

}
