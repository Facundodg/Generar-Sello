package com.example.demo.Service.Impl;

import com.example.demo.Model.DTO.*;
import com.example.demo.Model.Entity.Sello;
import com.example.demo.Model.Entity.Usuario;
import com.example.demo.Repocitori.SelloRepocitory;
import com.example.demo.Repocitori.UsuarioRepocitory;
import com.example.demo.Service.Interfaz.DatoServicios;
import com.example.demo.Service.Interfaz.SelloServicios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SelloServiceImpl implements SelloServicios {

    private final SelloRepocitory selloRepocitory;
    private final UsuarioRepocitory usuarioRepocitory;

    private final DatoServicios datoServicios;

    private static final Logger logger = LoggerFactory.getLogger(Usuario.class);


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
    public ResponceDTO generarSello(DatosDTO datosDTO) {
        
        try {

        //Optional<Usuario> optionalUsuario  = Optional.ofNullable(usuarioRepocitory.findAllByCuit(datosDTO.getCuit()));

        Usuario usuario = usuarioRepocitory.findAllByCuit(datosDTO.getCuit());

//

        //Usuario usuario = optionalUsuario.orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no empadronado"));

            if (usuario != null) {

            Object[] resultado = selloRepocitory.obtenerDatosPorId(datosDTO.getId_tramite()).stream().findFirst().orElse(null);

            if (resultado != null) {

                Long id_tramite = (Long) resultado[0];
                String descripcion = (String) resultado[1];
                Long cantidad_urbanos = (Long) resultado[2];
                String tipo_categoria = (String) resultado[3];
                double costo = (double) resultado[4];

                SelloBajaDTO selloBajaDTO = new SelloBajaDTO(id_tramite, descripcion, cantidad_urbanos, tipo_categoria, costo);

                SelloDTO selloDTO = new SelloDTO();

                //selloDTO.builder().

                Concepto conceptoDTO = new Concepto(9350.0, 9350.0, 255.0, selloBajaDTO.getCantidad_urbanos() * selloBajaDTO.getCosto());

                selloDTO.setTipoCategoria(selloBajaDTO.getTipo_categoria());
                selloDTO.setImporteTotal(selloBajaDTO.getCantidad_urbanos() * selloBajaDTO.getCosto()
                        + conceptoDTO.getFactibilidad() + conceptoDTO.getTasaAdministrativa() + conceptoDTO.getInspeccion());
                selloDTO.setConceptoDTO(conceptoDTO);

                selloDTO.setId_tramite(id_tramite);
                selloDTO.setCuit(datosDTO.getCuit());

                ResponceDTO responce = new ResponceDTO("ok",selloDTO,"200 OK","","");

                return responce;

            } else {
                ResponceDTO responce = new ResponceDTO("fail",null,"404","GenericException","fail build sello");
                return responce;
            }

        }else{

            ResponceDTO responce = new ResponceDTO("fail",null,"404","GenericException","No user found related to a category");
            return responce;

        }

        } catch (Exception e) {

            e.printStackTrace();
            ResponceDTO responce = new ResponceDTO("fail",null,"404","GenericException","Algo fallo.");
            return responce;

        }

    }
}
