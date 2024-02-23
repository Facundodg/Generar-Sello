package com.example.demo.Service.Impl;

import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.Entity.Datos;
import com.example.demo.Repocitori.DatoRepocitory;
import com.example.demo.Service.Interfaz.DatoServicios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class DatosServiceImpl implements DatoServicios {

    private final DatoRepocitory datosRepocitory;
    private final ModelMapper modelMapper;


    public Datos getDatos(DatosDTO datosDto) {

        final Datos datos = modelMapper.map(datosDto, Datos.class);
        return datosRepocitory.save(datos);

    }

    @Override
    public Datos guardar(Datos entidad) {
        return null;
    }

    @Override
    public Datos actualizar(Long id, Datos entidad) {
        return null;
    }

    @Override
    public Datos buscarPorId(Long id) {
        return null;
    }

    @Override
    public Collection<Datos> buscarTodos() {
        return datosRepocitory.findAll();
    }

    @Override
    public Long cantidad() {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    }

}
