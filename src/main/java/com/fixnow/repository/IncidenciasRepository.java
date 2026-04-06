package com.fixnow.repository;
import com.fixnow.model.Incidencias;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IncidenciasRepository {
    private List<Incidencias> listaIncidencias = new ArrayList<Incidencias>();

    public List<Incidencias> obtenerIncidencias() {
        return listaIncidencias;
    }

    //Consultar incidencias almacenadas
    public Incidencias consultarIncidenciasPorId(int idIncidencia){
        for (Incidencias incidencias : listaIncidencias){
            if (incidencias.getIdIncidencia() == idIncidencia){
                return incidencias;
            }

        }
    return null;
    }

    //Consultar incidencias por criterio relevante (prioridad)

    public Incidencias consultarPorPrioridad(int nivelPrioridad){
        for (Incidencias incidencias : listaIncidencias){
            if (incidencias.getNivelPrioridad() == nivelPrioridad){
                return incidencias;
            }

        }
        return null;
    }

    
    //Registro de nueva incidencia
    public Incidencias registrarIncidencias(Incidencias in){
        Incidencias incidencia = new Incidencias ();
        incidencia.setIdIncidencia(incidencia.getIdIncidencia());
        incidencia.setDescIncidencia(incidencia.getDescIncidencia());
        incidencia.setEstadoIncidencia(incidencia.isEstadoIncidencia());
        incidencia.setFechaIncidencia(incidencia.getFechaIncidencia());
        incidencia.setNivelPrioridad(incidencia.getNivelPrioridad());
        incidencia.setReportante(incidencia.getReportante());

        incidencia.setReportante(incidencia.getReportante());
        incidencia.setFechaIncidencia(incidencia.getFechaIncidencia());
        incidencia.setDescIncidencia(incidencia.getDescIncidencia());

        listaIncidencias.add(incidencia);
        return incidencia;

    }

    //Modificar/actualizar incidencias
    public Incidencias modificarIncidencias (Incidencias in){
        int idIncidencia = 0;
        int estadoIncidencia = 0;

        for (int i = 0; i <listaIncidencias.size(); i++){
            if(listaIncidencias.get(i).getIdIncidencia() == in.getIdIncidencia()){
                idIncidencia = in.getIdIncidencia();
                estadoIncidencia = i;
            }
        }
        Incidencias incidencia1 = new Incidencias();
        incidencia1.setIdIncidencia(idIncidencia);
        incidencia1.setDescIncidencia(in.getDescIncidencia());
        incidencia1.setReportante(in.getReportante());
        incidencia1.setFechaIncidencia(in.getFechaIncidencia());
        incidencia1.setEstadoIncidencia(in.isEstadoIncidencia());
        incidencia1.setNivelPrioridad(in.getNivelPrioridad());

        listaIncidencias.set(estadoIncidencia, incidencia1);
        return incidencia1;

    }
    //Eliminar incidencia por id (se que se puede de mas formas pero priorizare el avanzar en el controller y demas ya que igual esta sirve)
    public void eliminar(int id){
        Incidencias in = consultarIncidenciasPorId(id);
        if (in != null){
            listaIncidencias.remove(in);
        }
    }
}
    
    
    
    
    
    
    



   