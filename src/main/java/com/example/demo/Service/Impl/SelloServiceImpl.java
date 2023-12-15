package com.example.demo.Service.Impl;

import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.SelloDTO;
import com.example.demo.Model.Entity.Datos;
import com.example.demo.Model.Entity.Sello;
import com.example.demo.Repocitori.SelloRepocitory;
import com.example.demo.Service.Interfaz.DatoServicios;
import com.example.demo.Service.Interfaz.SelloServicios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class SelloServiceImpl implements SelloServicios {

    private final SelloRepocitory selloRepocitory;
    private final DatoServicios datoServicios;

    @Override
    public Sello guardar(Sello sello) {
        return selloRepocitory.save(sello);
    }

    @Override
    public Sello actualizar(Long id, Sello entidad) {
        return null;
    }

    @Override
    public Sello buscarPorId(Long id) {
        return null;
    }

    @Override
    public Collection<Sello> buscarTodos() {
        return null;
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

    @Override
    public SelloDTO generarSello(DatosDTO datosDTO) {

        Datos datos = datoServicios.getDatos(datosDTO);
        SelloDTO selloDTO = new SelloDTO();

        if (datos != null){

            selloDTO.setId_sello(1L);
            selloDTO.setImporte(2.3);

            return selloDTO;

        }

        return null;

    }
}
