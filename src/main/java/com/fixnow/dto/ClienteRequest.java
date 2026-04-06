package com.fixnow.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Data;

public class ClienteRequest {
    
    @PositiveOrZero(message = "No puede ser negativo")
    private int idIncidencia;
    
    @NotBlank(message = "No puede ser vacio")
    private int nivelPrioridad;
    
    @NotBlank(message = "No puede ser vacio")
    private String descIncidencia;
    
    @NotBlank(message = "No puede ser vacio")
    private boolean estadoIncidencia;
    
    @PositiveOrZero(message = "No puede ser negativo")
    private int fechaIncidencia;

    @NotBlank(message = "No puede ser nulo")
    private String reportante;

}

