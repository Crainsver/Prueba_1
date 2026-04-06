package com.fixnow.controller;

import com.fixnow.dto.ClienteRequest;
import com.fixnow.exception.ResourceNotFoundException;
import com.fixnow.model.Incidencias;
import com.fixnow.repository.IncidenciasRepository;
import com.fixnow.service.IncidenciasService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;


@RestController
@RequestMapping("/api/v1/fixnow/Incidencias")
public class IncidenciasController {
    @Autowired
    private IncidenciasRepository incidenciasRepository;

    @GetMapping
    public List<Incidencias> listarIncidencias() {
        return IncidenciasService.getIncidencias();
    }

    @PostMapping
    public ResponseEntity<?> registrarIncidencias(@Valid @RequestBody ClientRequest request, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> 
                errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        return ResponseEntity.ok(IncidenciasService.saveIncidencia(IncidenciasMapper.toModel(request)));
    }

    @GetMapping("{id}")
    public ResponseEntity<Incidencias> consultarIncidencia(@PathVariable int id){
        Incidencias incidencias = IncidenciasService.getIncidenciaId(id);
        
        if (incidencias == null) {
            throw new ResourceNotFoundException("Incidencia no encontrada: " + id);
        }
        
        return ResponseEntity.ok(incidencias);
    }

    
    @PutMapping("{id}")
    public Incidencias modificarIncidencias(@PathVariable int id, @RequestBody Incidencias incidencias){
        // el id lo usaremos mas adelante
        return IncidenciasService.updateIncidencias(incidencias);
    }

    @DeleteMapping("{id}")
    public String eliminarIncidencia(@PathVariable int id) {
        return IncidenciasService.deleteIncidencia(id);
    }


    @GetMapping("{id}")
    public boolean estadoIncidencia(@PathVariable int id){
        Incidencias incidencias = IncidenciasService.getIncidenciaId(id);
        
        if (incidencias == null) {
            throw new ResourceNotFoundException("Incidencia no encontrada: " + id);
        }
        
        return incidencias.isEstadoIncidencia();
    }
    
    @GetMapping("/prioridad/{nivelPrioridad}")
    public Incidencias consultarPorPrioridad(@PathVariable int nivelPrioridad){
        Incidencias incidencias = IncidenciasService.consultarPorPrioridad(nivelPrioridad);
        
        if (incidencias == null) {
            throw new ResourceNotFoundException("Incidencia no encontrada con prioridad: " + nivelPrioridad);
        }
        
        return incidencias;
    }
}
