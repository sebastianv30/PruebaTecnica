package com.nexos.prueba.pruebanexosjavaangular.Service;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Mercancia;
import com.nexos.prueba.pruebanexosjavaangular.Entity.MercanciaLog;
import com.nexos.prueba.pruebanexosjavaangular.Entity.Usuario;
import com.nexos.prueba.pruebanexosjavaangular.Repository.MercanciaLogRepository;
import com.nexos.prueba.pruebanexosjavaangular.Repository.MercanciaRepository;
import com.nexos.prueba.pruebanexosjavaangular.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MercanciaService {
    @Autowired
    private MercanciaRepository mercanciaRepository;

    @Autowired
    private MercanciaLogRepository mercanciaLogRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<Mercancia> getAll(){
        return (List<Mercancia>) mercanciaRepository.findAll();
    }
    public boolean existeMercanciaConNombre(String nombreProducto) {
        // Consultar la base de datos para verificar si existe una mercancía con el mismo nombre
        return mercanciaRepository.existsByNombreProducto(nombreProducto);
    }
    public  List<Mercancia> getByNombreProducto(String nombreProducto){
        return mercanciaRepository.findByNombreProducto(nombreProducto);
    }


    public Optional<Mercancia> getById (Long idMercancia){
        return  mercanciaRepository.findById(idMercancia);
    }
    public Mercancia findById(Long id) {
        Optional<Mercancia> optionalProducto = mercanciaRepository.findById(id);
        if (optionalProducto.isPresent()) {
            return optionalProducto.get();
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
    public Mercancia saveMercancia (Mercancia mercancia) {
        Mercancia nuevaMercancia = mercanciaRepository.save(mercancia);

        MercanciaLog mercanciaLog = new MercanciaLog();
        mercanciaLog.setActualizado(new Date());
        mercanciaLog.setAccion("Registrado");

        mercanciaLog.setMercancia(nuevaMercancia);
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(mercancia.getIdusuario());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            mercanciaLog.setPersonaModifico(usuario.getNombreUsuario());
        } else {
            mercanciaLog.setPersonaModifico("");
        }
        mercanciaLogRepository.save(mercanciaLog);
        return nuevaMercancia;
    }


    public void deleteMercancia (Long idMercancia){
        mercanciaRepository.deleteById(idMercancia);

    }
}
