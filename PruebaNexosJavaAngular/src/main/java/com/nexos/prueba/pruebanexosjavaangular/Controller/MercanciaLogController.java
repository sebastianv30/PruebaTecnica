package com.nexos.prueba.pruebanexosjavaangular.Controller;

import com.nexos.prueba.pruebanexosjavaangular.Entity.Mercancia;
import com.nexos.prueba.pruebanexosjavaangular.Entity.MercanciaLog;
import com.nexos.prueba.pruebanexosjavaangular.Repository.MercanciaLogRepository;
import com.nexos.prueba.pruebanexosjavaangular.Service.MercanciaLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class MercanciaLogController {
    @Autowired
    private MercanciaLogRepository mercanciaLogRepository;
    @Autowired
    private MercanciaLogService mercanciaLogService;

    @GetMapping
    public  ResponseEntity<List<MercanciaLog>> findAll(){
        List<MercanciaLog> mercanciaLogList = mercanciaLogRepository.findAll();
        return ResponseEntity.ok(mercanciaLogList);
    }
    @PostMapping("/savelog")
    public ResponseEntity<MercanciaLog> saveMercanciaLog (@RequestBody MercanciaLog mercanciaLog){
        System.out.println(mercanciaLog);
        mercanciaLog =mercanciaLogService.createLogMercancia(mercanciaLog);

        return ResponseEntity.ok(mercanciaLog);
    }

}
