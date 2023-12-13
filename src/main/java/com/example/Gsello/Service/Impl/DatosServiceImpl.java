package com.example.Gsello.Service.Impl;

import com.example.Gsello.Model.Entity.Datos;
import com.example.Gsello.Repocitori.DatoRepocitory;
import com.example.Gsello.Service.Interfaz.DatoServicios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class DatosServiceImpl implements DatoServicios {

    private final DatoRepocitory datosRepocitory;

    @Override
    public Datos guardar(Datos entidad) {
        return datosRepocitory.save(entidad);
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
