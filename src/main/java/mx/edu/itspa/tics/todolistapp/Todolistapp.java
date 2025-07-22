
package mx.edu.itspa.tics.todolistapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Todolistapp {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static ServicioTarea serviceTask = new ServicioTarea();

    public static void main(String[] args) {
        int opcionSeleccionada = 0;

        //Busqueda de posibles errores con TryCatch
        try {
            do {
                mostrarMenu();
                opcionSeleccionada = manejarOpcionSeleccionada();
            } while (opcionSeleccionada != 5);
        } catch (IOException e) {
            System.out.println("Entrada no válida");
        } finally {
            try {
                leer.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el recurso");
            }
        }
    }

    //Despliega el menu
    public static void mostrarMenu() {
        System.out.println("*********To do list*********");
        System.out.println("******** Selecciona una opcion valida ******** ");
        System.out.println("1.- Crear una tarea");
        System.out.println("2.- Mostrar tareas");
        System.out.println("3.- Completar tarea");
        System.out.println("4.- Eliminar tarea");
        System.out.println("5.- Salir");
        System.out.print("Opcion: ");
    }

    public static int manejarOpcionSeleccionada() throws IOException {
        int opcionSeleccionada = Integer.parseInt(leer.readLine());

        //Posibles opciones
        switch (opcionSeleccionada) {
            case 1: {
                System.out.println("Ingresa la tarea:");
                serviceTask.crear(leer.readLine());
                break;
            }
            case 2: {
                serviceTask.mostrartareas();
                break;
            }
            case 3: {
                serviceTask.listaTareas();
                System.out.println("Ingresa el numero de la tarea a marcar completada:");
                int indiceTarea = Integer.parseInt(leer.readLine());
                Tarea _tarea = serviceTask.obtener(indiceTarea - 1);
                serviceTask.marcar(_tarea);
                break;
            }
            case 4: {
                serviceTask.listaTareas();
                System.out.println("Ingresa el numero de la tarea a eliminar:");
                int _indiceTarea = Integer.parseInt(leer.readLine());
                Tarea _Tarea = serviceTask.obtener(_indiceTarea - 1);
                serviceTask.eliminartarea(_Tarea);
                System.out.println("Eliminada.");
                break;
            }
            case 5: {
                System.out.println("Saliendo...");
                break;
            }
            default: {
                System.out.println("Opción no válida.");
            }
        }

        return opcionSeleccionada;
        System.out.println(mostrarMenu());
    }
}