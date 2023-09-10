package com.nexos.prueba.pruebanexosjavaangular.Service;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Usuario;
import com.nexos.prueba.pruebanexosjavaangular.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }
}
