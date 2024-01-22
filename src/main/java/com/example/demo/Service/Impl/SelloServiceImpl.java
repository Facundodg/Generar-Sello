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

import java.util.ArrayList;
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

    try{

        if(datosDTO.getId_tramite() == 1){

            Usuario usuario = usuarioRepocitory.findAllByCuit(datosDTO.getCuit());

            if(usuario != null){

                ResponceDTO responce = tramite1(datosDTO.getId_tramite(),usuario.getCategoria(),usuario.getCuit());
                return responce;

            }else{

                ResponceDTO responce = new ResponceDTO("fail",null,"404","GenericException","No user found related to a category");
                return responce;

            }

        } else if (datosDTO.getId_tramite() == 2) {

            Usuario usuario = usuarioRepocitory.findAllByCuit(datosDTO.getCuit());

            if(usuario != null){

                ResponceDTO responce = tramite2(datosDTO.getId_tramite(),usuario.getCategoria(),usuario.getCuit());
                return responce;

            }else{

                ResponceDTO responce = new ResponceDTO("fail",null,"404","GenericException","No user found related to a category");
                return responce;

            }

        }else{

            ResponceDTO responce = new ResponceDTO("fail",null,"404","GenericException","id_tramite no encontrado");
            return responce;

        }

    } catch (Exception e) {

            e.printStackTrace();
            ResponceDTO responce = new ResponceDTO("fail",null,"404","GenericException","Algo fallo.");
            return responce;

    }

    }

    public ResponceDTO tramite1(long id_tramite,String categoria,String cuit){

        List<Object> objetosAlmacenados = new ArrayList<>();

        List<Object[]> resultados = selloRepocitory.obtenerTramite(id_tramite, categoria);

        if (resultados != null) {

            for (Object[] resultado : resultados) {
                for (Object elemento : resultado) {
                    objetosAlmacenados.add(elemento);
                }
            }

            Long cant_urbanos_inspeccion = Long.parseLong(objetosAlmacenados.get(1).toString());
            Long cant_urbanos_tasaAdministrativa = Long.parseLong(objetosAlmacenados.get(5).toString());
            Long cant_urbanos_factibilidad = Long.parseLong(objetosAlmacenados.get(9).toString());
            Long cant_urbanos_categoria = Long.parseLong(objetosAlmacenados.get(13).toString());
            double costo = (double) objetosAlmacenados.get(3);

            Concepto conceptoDTO = Concepto.builder()
                    .inspeccion(cant_urbanos_inspeccion*costo)
                    .tasaAdministrativa(cant_urbanos_tasaAdministrativa*costo)
                    .factibilidad(cant_urbanos_factibilidad*costo)
                    .categoria(cant_urbanos_categoria*costo)
                    .build();

            SelloDTO selloDTO = SelloDTO.builder()
                    .tipoCategoria(categoria)
                    .importeTotal(conceptoDTO.getCategoria() + conceptoDTO.getFactibilidad() + conceptoDTO.getTasaAdministrativa() + conceptoDTO.getInspeccion())
                    .conceptoDTO(conceptoDTO)
                    .id_tramite(id_tramite)
                    .cuit(cuit)
                    .build();

            ResponceDTO responce = new ResponceDTO("ok",selloDTO,"200 OK","","");

            return responce;

        } else {
            ResponceDTO responce = new ResponceDTO("fail",null,"404","GenericException","fail build sello");
            return responce;
        }

    }

    public ResponceDTO tramite2(long id_tramite,String categoria,String cuit){

        List<Object> objetosAlmacenados = new ArrayList<>();

        List<Object[]> resultados = selloRepocitory.obtenerTramite(id_tramite, categoria);

        if (resultados != null) {

            for (Object[] resultado : resultados) {
                for (Object elemento : resultado) {
                    objetosAlmacenados.add(elemento);
                }
            }

            Long cant_urbanos_reinspeccion = Long.parseLong(objetosAlmacenados.get(1).toString());
            String categoria_reinspeccion= objetosAlmacenados.get(6).toString();
            double costo = (double) objetosAlmacenados.get(3);

            ConceptoReinspeccion conceptoReinspeccion = ConceptoReinspeccion.builder()
                    .inspeccion(cant_urbanos_reinspeccion*costo)
                    .build();

            SelloDTO selloDTO = SelloDTO.builder()
                    .tipoCategoria(categoria)
                    .importeTotal(conceptoReinspeccion.getInspeccion())
                    .conceptoDTO(conceptoReinspeccion)
                    .id_tramite(id_tramite)
                    .cuit(cuit)
                    .build();

            ResponceDTO responce = new ResponceDTO("ok",selloDTO,"200 OK","","");

            return responce;

        } else {
            ResponceDTO responce = new ResponceDTO("fail",null,"404","GenericException","fail build sello");
            return responce;
        }

    }

}
                /*
            Object[] resultado = selloRepocitory.obtenerTramite(datosDTO.getId_tramite()).stream().findFirst().orElse(null);


                for (Object elemento : resultado) {

                    // Realizar alguna acción con cada elemento (por ejemplo, imprimirlo)
                    System.out.println(elemento);
                }

            System.out.println(objetosAlmacenados.get(12).toString());
            System.out.println(objetosAlmacenados.get(13).toString());
            System.out.println(objetosAlmacenados.get(14).toString());

            System.out.println(objetosAlmacenados.get(15).toString());
                */