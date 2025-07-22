
package mx.edu.itspa.tics.todolistapp;

import java.util.ArrayList;
import java.util.List;

public class ServicioTarea {

    private List<Tarea> listatareas = new ArrayList();
/**
 * 
 * @param tarea
 * @return Crea un espacio para la tarea y la anade a la lista
 */
    public Tarea crear(Tarea tarea) {
        listatareas.add(tarea);
        return tarea;
    }
    
    /**
     * 
     * @param descripcion
     * @return Almacena la tarea en texto para ser legible en la lista
     */
    
    public Tarea crear(String descripcion) {
        Tarea tarea = new Tarea(descripcion);
        listatareas.add(tarea);
        return tarea;
    }

    /**
     * 
     * @param tarea 
     */
    public void marcar(Tarea tarea) {
        for (Tarea _tarea : listatareas) {
            if (_tarea.getDescripcion().equalsIgnoreCase(tarea.getDescripcion())) {
                _tarea.setEstado("completado");
            }
        }
    }

    //Despliega una lista con las tareas, incluye la tarea, fecha y estado
    public void mostrartareas() {
        for (Tarea tarea : listatareas) {
            System.out.println("descricion " + tarea.getDescripcion());
            System.out.println("fecha " + tarea.getFecha());
            System.out.println("estado  " + tarea.getEstado());
        }
    }

    /**
     * 
     * @param tarea
     * @return Elimina una tarea de la lista
     */
    public boolean eliminartarea(Tarea tarea) {
        List<Tarea> _listaTareas = new ArrayList<Tarea>();
        for (Tarea _tarea : listatareas) {
            if (!_tarea.getDescripcion().equalsIgnoreCase(tarea.getDescripcion())) {
                _listaTareas.add(_tarea);
            }
        }
        listatareas = _listaTareas;
        return true;
    }

    //Despliega la lista de tareas guardadas
    public void listaTareas() {
        for (int i = 1; i <= listatareas.size(); i++) {
            System.out.println(i + ".- " + listatareas.get(i - 1).getDescripcion());
        }
    }

    //Busca una tarea especifica en la lista
    public Tarea obtener(int i) {
        return listatareas.get(i);
    }

    /**
     * 
     * @param indice
     * Cambia el estado de una tarea a completada
     */
    public void marcarCompletada(int indice) {
        listatareas.get(indice).setEstado("completado");

    }

    /**
     * 
     * @param indice 
     * Crea un indice de tareas segun la lista de tareas guardadas
     */
    public void eliminarTarea(int indice) {
        List<Tarea> _listaTareas = new ArrayList();
        for (int i = 0; i <= listatareas.size(); i++) {
            if(indice!=i){
                _listaTareas.add(listatareas.get(i));
            }
        }
        listatareas = _listaTareas; 
    }

    /**
     * 
     * @return Regresa la lista de tareas guardadas
     */
    public List<Tarea> obtenerTareas() {
        return listatareas;
    }

    /**
     * 
     * @param descripcion
     * @return Comprueba si la tarea esta marcada como completada o pediente
     */
    public boolean esTareaCompletada(String descripcion) {
        for (Tarea _tarea : listatareas) {
            if (_tarea.getDescripcion().equalsIgnoreCase(descripcion)) {
                return _tarea.getEstado().equalsIgnoreCase("completada");
            }
        }
        return false;
    }
}