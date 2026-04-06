package com.fixnow.service;

import com.fixnow.model.Incidencias;
import com.fixnow.repository.IncidenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service

public class IncidenciasService {
    @Autowired
    private IncidenciasRepository incidenciasRepository;

    public List<Incidencias> getIncidencias() {
        return incidenciasRepository.obtenerIncidencias();
    }

    public Incidencias saveIncidencia(Incidencias incidencia) {
        return incidenciasRepository.registrarIncidencias(incidencia);
    }

    public Incidencias getIncidenciaId(int id) {
        return incidenciasRepository.consultarIncidenciasPorId(id);
    }

    public Incidencias updateIncidencia(Incidencias incidencia) {
        return incidenciasRepository.modificarIncidencias(incidencia);
    }

    public String deleteIncidencia(int id) {
        incidenciasRepository.eliminar(id);
        return "incidencia eliminada";
    }
}

