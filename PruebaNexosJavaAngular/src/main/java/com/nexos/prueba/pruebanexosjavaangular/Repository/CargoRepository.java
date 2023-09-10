package com.nexos.prueba.pruebanexosjavaangular.Repository;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
