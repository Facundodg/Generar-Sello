package com.example.demo.Service.Impl;

import com.example.demo.Model.Entity.Usuario;
import com.example.demo.Repocitori.UsuarioRepocitory;
import com.example.demo.Service.Interfaz.UsuarioServicios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioImpl implements UsuarioServicios {

    private final UsuarioRepocitory usuarioRepocitory;

    @Override
    public Usuario guardar(Usuario entidad) {
        return null;
    }

    @Override
    public Usuario actualizar(Long id, Usuario entidad) {
        return null;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return null;
    }

    @Override
    public Collection<Usuario> buscarTodos() {
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
    public Usuario GetUsuarioPorCuit(String cuit) {
        log.info("[UsuarioServicio - BuscarPorCuit - {}]", cuit);
        return usuarioRepocitory.findAllByCuit(cuit);
    }
}
