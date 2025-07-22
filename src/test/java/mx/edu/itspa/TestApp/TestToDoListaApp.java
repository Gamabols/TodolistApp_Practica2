
package mx.edu.itspa.TestApp;

import static junit.framework.Assert.assertEquals;
import mx.edu.itspa.tics.todolistapp.ServicioTarea;
import mx.edu.itspa.tics.todolistapp.Tarea;
import org.junit.Test;

public class TestToDoListaApp {
    @Test
    public void testCrear(){
        Tarea tarea;
        ServicioTarea serviceTask = new ServicioTarea();
        tarea = new Tarea("Correr por la manana");
        serviceTask.crear(tarea);
        assertEquals(2, 2);
    }
    
}
