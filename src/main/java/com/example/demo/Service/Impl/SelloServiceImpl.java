package com.example.demo.Service.Impl;

import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.SelloBajaDTO;
import com.example.demo.Model.DTO.SelloDTO;
import com.example.demo.Model.Entity.Datos;
import com.example.demo.Model.Entity.Sello;
import com.example.demo.Repocitori.SelloRepocitory;
import com.example.demo.Service.Interfaz.DatoServicios;
import com.example.demo.Service.Interfaz.SelloServicios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

        Object[] resultado = selloRepocitory.obtenerDatosPorId(datosDTO.getId_tramite()).stream().findFirst().orElse(null);

        if (resultado != null) {
            Long id_tramite = (Long) resultado[0];
            String descripcion = (String) resultado[1];
            Long cantidad_urbanos = (Long) resultado[2];
            String tipo_categoria = (String) resultado[3];
            double costo = (double) resultado[4];

            SelloBajaDTO selloBajaDTO = new SelloBajaDTO(id_tramite, descripcion, cantidad_urbanos, tipo_categoria, costo);

            System.out.println(selloBajaDTO.getCantidad_urbanos());

            SelloDTO selloDTO = new SelloDTO();

            System.out.println(selloBajaDTO.getCantidad_urbanos());
            System.out.println(selloBajaDTO.getCosto());

            selloDTO.setFactibilidad(200.0);
            selloDTO.setInspeccion(200.0);
            selloDTO.setTasaAdministrativa(200.0);
            selloDTO.setImporteTotal(selloBajaDTO.getCantidad_urbanos()*selloBajaDTO.getCosto()
            + selloDTO.getFactibilidad() + selloDTO.getTasaAdministrativa() + selloDTO.getInspeccion());

            // Devuelve el SelloBajaDTO u otro valor según tu lógica
            return selloDTO;
        } else {
            // Manejo de caso donde la lista está vacía
            return null;
        }

    }
}
