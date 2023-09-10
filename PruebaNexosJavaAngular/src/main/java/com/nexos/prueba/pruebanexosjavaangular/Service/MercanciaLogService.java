package com.nexos.prueba.pruebanexosjavaangular.Service;

import com.nexos.prueba.pruebanexosjavaangular.Entity.MercanciaLog;
import com.nexos.prueba.pruebanexosjavaangular.Repository.MercanciaLogRepository;
import com.nexos.prueba.pruebanexosjavaangular.Repository.MercanciaRepository;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MercanciaLogService {
    private static final Logger log = LoggerFactory.getLogger(MercanciaService.class);

    @Autowired
    private MercanciaLogRepository mercanciaLogRepository;

    @Transactional
    public MercanciaLog createLogMercancia(MercanciaLog mercanciaLog){
        log.debug("Creando nuevo Log {} ..", mercanciaLog);
        mercanciaLog.setPersonaModifico(mercanciaLog.getPersonaModifico());
        mercanciaLog.setAccion(mercanciaLog.getAccion());
        mercanciaLog.setActualizado(new Date());
        mercanciaLog.setMercancia(mercanciaLog.getMercancia());

        mercanciaLog = mercanciaLogRepository.save(mercanciaLog);
        log.debug("Guardado Log {} ", mercanciaLog);
        return mercanciaLog;
    }

}
