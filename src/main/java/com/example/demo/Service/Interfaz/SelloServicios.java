package com.example.demo.Service.Interfaz;

import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.ResponceDTO;
import com.example.demo.Model.Entity.Sello;

public interface SelloServicios extends ServicioCrud<Sello>{

    ResponceDTO generarSello(DatosDTO datosDTO);

}
