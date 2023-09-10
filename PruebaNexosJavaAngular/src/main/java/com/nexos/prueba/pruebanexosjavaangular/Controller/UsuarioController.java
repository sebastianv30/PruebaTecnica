package com.nexos.prueba.pruebanexosjavaangular.Controller;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Usuario;
import com.nexos.prueba.pruebanexosjavaangular.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")

    public ResponseEntity<List<Usuario>> getAll() {
        return new ResponseEntity<List<Usuario>>(usuarioService.findAll(), HttpStatus.OK);
    }
}
