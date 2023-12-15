package com.example.demo.Service.Interfaz;

import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.SelloDTO;
import com.example.demo.Model.Entity.Sello;

public interface SelloServicios extends ServicioCrud<Sello>{

    SelloDTO generarSello(DatosDTO datosDTO);

}
