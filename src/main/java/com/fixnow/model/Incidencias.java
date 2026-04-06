package com.fixnow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor

public class Incidencias {
    private int idIncidencia;
    private String descIncidencia;
    private boolean estadoIncidencia;
    private int nivelPrioridad;
    private String reportante;
    private String fechaIncidencia;
}
