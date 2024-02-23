package com.example.demo.Service.Interfaz;

import com.example.demo.Model.Entity.Usuario;

public interface UsuarioServicios extends ServicioCrud<Usuario>{

    Usuario GetUsuarioPorCuit(String cuit);

}
