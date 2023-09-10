package com.nexos.prueba.pruebanexosjavaangular.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario ;

    @Column(name = "id_cargo")
    private Integer idCargo;

    @Column(name = "nombre_usuario")
    private String nombreUsuario ;

    private Integer edad;

    @Column(name = "fecha_ingreso_compañia")
    private Date fechaIngreso;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario") // Ignora la propiedad "usuario" en la entidad "Mercancia"
    private List<Mercancia> mercancias;

    @ManyToOne
    @JoinColumn(name = "id_cargo", insertable = false, updatable = false)
    @JsonIgnoreProperties("usuarios") // Ignora la propiedad "usuarios" en la entidad "Cargo"
    private Cargo cargo;
}
