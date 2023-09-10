package com.nexos.prueba.pruebanexosjavaangular.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Data
@Entity
@Table(name = "mercancia_log")
public class MercanciaLog {
    @Id
    @Column (name = "id_mercancia_log" , nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMercanciaLog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mercancia", referencedColumnName = "id_mercancia")
    @JsonIgnore
    private Mercancia mercancia;


    @Column(name = "persona_modifico")
    private String personaModifico;

    @Column(name = "actualizado")
    private Date actualizado;

    @Column(name = "accion")
    private String accion;

}
