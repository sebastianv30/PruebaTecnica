package com.nexos.prueba.pruebanexosjavaangular.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "mercancias")
public class Mercancia {

    @Id
    @Column (name = "id_mercancia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMercancia;

    @Column(name = "id_usuario")
    private Long idusuario;

    @Column(name = "nombre_producto", unique = true)
    private String nombreProducto;

    private Integer cantidad;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    @JsonIgnoreProperties("mercancias") // Ignora la propiedad "mercancias" en la entidad "Usuario"
    private Usuario usuario;

    @OneToMany(mappedBy = "mercancia", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("mercancia")
    private List<MercanciaLog> mercanciaLogs = new ArrayList<>();

}
