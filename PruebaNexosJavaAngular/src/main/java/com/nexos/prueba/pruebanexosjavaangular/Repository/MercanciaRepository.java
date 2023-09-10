package com.nexos.prueba.pruebanexosjavaangular.Repository;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Long> {
    List<Mercancia> findByNombreProducto(String nombreProducto);
    boolean existsByNombreProducto(String nombreProducto);
    @Query("Select i from Mercancia i where i.idMercancia= :id")
    Mercancia findByIdMercancia(Long id);
}
