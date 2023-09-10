package com.nexos.prueba.pruebanexosjavaangular.Controller;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Cargo;
import com.nexos.prueba.pruebanexosjavaangular.Service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;


    @GetMapping("/all")
    public ResponseEntity<List<Cargo>> getAll() {
        return new ResponseEntity<>(cargoService.getAll(), HttpStatus.OK);
    }
}