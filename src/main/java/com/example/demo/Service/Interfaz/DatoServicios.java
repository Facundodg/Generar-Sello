package com.example.demo.Service.Interfaz;

import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.Entity.postgres.Datos;

public interface DatoServicios  extends ServicioCrud<Datos> {
    Datos getDatos(DatosDTO datosDTO);
}
