package com.example.demo.Service.Interfaz;

import com.example.demo.Model.Entity.sqlserver.Usuario;

public interface UsuarioServicios extends ServicioCrud<Usuario>{

    Usuario GetUsuarioPorCuit(String cuit);

}
