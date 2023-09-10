package com.nexos.prueba.pruebanexosjavaangular.Repository;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("Select u from Usuario u where u.idUsuario= :idUsuario")
    Usuario findByIdUser(Integer idUsuario);
}
