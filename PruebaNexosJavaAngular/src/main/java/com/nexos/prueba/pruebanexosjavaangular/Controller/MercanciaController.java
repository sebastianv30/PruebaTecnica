package com.nexos.prueba.pruebanexosjavaangular.Controller;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Mercancia;
import com.nexos.prueba.pruebanexosjavaangular.Entity.MercanciaLog;
import com.nexos.prueba.pruebanexosjavaangular.Entity.Usuario;
import com.nexos.prueba.pruebanexosjavaangular.Repository.MercanciaLogRepository;
import com.nexos.prueba.pruebanexosjavaangular.Repository.MercanciaRepository;
import com.nexos.prueba.pruebanexosjavaangular.Repository.UsuarioRepository;
import com.nexos.prueba.pruebanexosjavaangular.Service.MercanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/mercancias")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class MercanciaController {
    @Autowired
    private MercanciaService mercanciaService;

    @Autowired
    private MercanciaRepository mercanciaRepository;
    @Autowired
    private MercanciaLogRepository mercanciaLogRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Mercancia>> getAll() {
        return new ResponseEntity<>(mercanciaService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/name/{name}")
    public List<Mercancia> getByNombreProducto(@PathVariable("name") String nombreProducto){
        return mercanciaService.getByNombreProducto(nombreProducto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mercancia> getMercancia (@PathVariable("id") Long idMercancia){
        return mercanciaService.getById(idMercancia).map(mercancia -> new ResponseEntity<>(mercancia,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMercancia(@RequestBody Mercancia mercancia) {
        try {
            // Verificar si ya existe una mercancía con el mismo nombre
            if (mercanciaService.existeMercanciaConNombre(mercancia.getNombreProducto())) {
                return ResponseEntity.badRequest().body("Ya existe una mercancía con el mismo nombre.");
            }
            // Si no existe, guardar la mercancía
            Mercancia nuevaMercancia = mercanciaService.saveMercancia(mercancia);

            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMercancia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la mercancía: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMercancia (@PathVariable("id") Long idMercancia){
        mercanciaService.deleteMercancia(idMercancia);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Mercancia> updateMercancia(@PathVariable Long id, @RequestBody Mercancia mercancia){
        Mercancia mercanciaUpdate = mercanciaService.findById(id);
        if (mercanciaUpdate == null){
            return ResponseEntity.notFound().build();
        }
        mercanciaUpdate.setNombreProducto(mercancia.getNombreProducto());
        mercanciaUpdate.setCantidad(mercancia.getCantidad());
        mercanciaUpdate.setFechaIngreso(mercancia.getFechaIngreso());

        Mercancia mercanciaupd = mercanciaRepository.save(mercanciaUpdate);

        MercanciaLog mercanciaLog = new MercanciaLog();
        mercanciaLog.setActualizado(new Date());
        mercanciaLog.setAccion("Actualizado");

        mercanciaLog.setMercancia(mercanciaupd);
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(mercancia.getIdusuario());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            mercanciaLog.setPersonaModifico(usuario.getNombreUsuario());
        } else {
            mercanciaLog.setPersonaModifico("");
        }
        mercanciaLogRepository.save(mercanciaLog);

        return ResponseEntity.ok().body(mercanciaupd);
    }

}
