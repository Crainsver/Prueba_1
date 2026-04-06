package com.fixnow.mapper;

import com.fixnow.dto.ClienteRequest;
import com.fixnow.model.Incidencias;

public class IncidenciaMapper {
    public static Incidencias toModel(ClienteRequest request) {
        return new Incidencias(
            request.getIdIncidencia(),
            request.getDescIncidencia(),
            request.isEstadoIncidencia(),
            request.getNivelPrioridad(),
            request.getReportante(),
            String.valueOf(request.getFechaIncidencia())
        );
    }

}
