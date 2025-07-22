
package mx.edu.itspa.tics.todolistapp;

import java.time.LocalDate;

public class Tarea {
     private String descripcion;
     private LocalDate fecha;
     private  String estado;

    //Un semi constructor que solo necesita la descripcion de la tarea para crearse
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
        this.estado = "pendiente";
    }

    //A continuacion, puros set y get
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
     
}