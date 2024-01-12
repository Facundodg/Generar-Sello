package com.example.demo.Service.Impl;

import com.example.demo.Commons.FileUploadAdvice;
import com.example.demo.Commons.UsuarioNoEncontradoException;
import com.example.demo.Model.DTO.Concepto;
import com.example.demo.Model.DTO.DatosDTO;
import com.example.demo.Model.DTO.SelloBajaDTO;
import com.example.demo.Model.DTO.SelloDTO;
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

import java.nio.file.FileSystemAlreadyExistsException;
import java.util.Collection;
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
    public SelloDTO generarSello(DatosDTO datosDTO) {

        try {

        Optional<Usuario> optionalUsuario  = Optional.ofNullable(usuarioRepocitory.findAllByCuit(datosDTO.getCuit()));

        Usuario usuario = optionalUsuario.orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no empadronado"));

        log.info("[Usuario - {}]", usuario.getCategoria());

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
                Concepto conceptoDTO = new Concepto(9350.0, 9350.0, 255.0, selloBajaDTO.getCantidad_urbanos() * selloBajaDTO.getCosto());

                selloDTO.setTipoCategoria(selloBajaDTO.getTipo_categoria());
                selloDTO.setImporteTotal(selloBajaDTO.getCantidad_urbanos() * selloBajaDTO.getCosto()
                        + conceptoDTO.getFactibilidad() + conceptoDTO.getTasaAdministrativa() + conceptoDTO.getInspeccion());
                selloDTO.setConceptoDTO(conceptoDTO);

                selloDTO.setId_tramite(id_tramite);
                selloDTO.setCuit(datosDTO.getCuit());

                // Devuelve el SelloBajaDTO u otro valor según tu lógica
                return selloDTO;

            } else {
                // Manejo de caso donde la lista está vacía
                return null;
            }

        }else{

            return null;

        }

        } catch (Exception e) {
            // Manejo de la excepción
            e.printStackTrace(); // O utiliza un logger para manejar la excepción de una manera más adecuada
            return null; // O lanza otra excepción, según tus necesidades
        }

    }
}
