package com.nexos.prueba.pruebanexosjavaangular.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="Cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private Long idCargo;

    @Column(name = "nombre_Cargo")
    private String nombreCargo;


    @OneToMany(mappedBy = "cargo")
    @JsonIgnoreProperties("cargo") // Ignora la propiedad "cargo" en la entidad "Usuario"
    private List<Usuario> usuarios;

}
