package com.nexos.prueba.pruebanexosjavaangular.Service;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Cargo;
import com.nexos.prueba.pruebanexosjavaangular.Repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoCrudRepository;

    public List<Cargo> getAll(){
        return (List<Cargo>) cargoCrudRepository.findAll();
    }
}
