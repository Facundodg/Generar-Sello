package com.example.demo.Service.Interfaz;

import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.SelloDTO;
import com.example.demo.Model.Entity.Usuario;
import com.example.demo.Repocitori.UsuarioRepocitory;

public interface UsuarioServicios extends ServicioCrud<Usuario>{

    Usuario GetUsuarioPorCuit(String cuit);

}
