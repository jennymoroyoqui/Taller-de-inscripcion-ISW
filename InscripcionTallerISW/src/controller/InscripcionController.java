package controller;

import java.util.ArrayList;
import java.util.List;
import model.Alumno;
import model.Inscripcion;
import model.Taller;
import model.Ticket;

public class InscripcionController {

    private List<Alumno> alumnos;
    private List<Inscripcion> inscripciones;
    private int siguienteFolio;

    public InscripcionController() {
        alumnos = new ArrayList<Alumno>();
        inscripciones = new ArrayList<Inscripcion>();
        siguienteFolio = 1;
        cargarDatosPrueba();
    }

    // DATOS DE PRUEBA
    private void cargarDatosPrueba() {
        alumnos.add(new Alumno("1001", "Juan Pérez López", 5, "Ingeniería de Software"));
        alumnos.add(new Alumno("1002", "Ana García Martínez", 5, "Ingeniería de Software"));
        alumnos.add(new Alumno("1003", "Carlos Hernández Soto", 6, "Ingeniería de Software"));
    }

    public Alumno buscarAlumno(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe capturar el ID del alumno.");
        }
        for (Alumno a : alumnos) {
            if (a.getId().equals(id.trim())) {
                return a;
            }
        }
        throw new IllegalArgumentException("No existe un alumno con el ID: " + id.trim());
    }

    public Ticket confirmarInscripcion(Alumno alumno, Taller taller) {
        if (alumno == null) {
            throw new IllegalArgumentException("Primero debe buscar un alumno válido.");
        }
        if (taller == null) {
            throw new IllegalArgumentException("Debe seleccionar un taller de la lista.");
        }
        if (!taller.hayCupo()) {
            throw new IllegalArgumentException("El taller ya no tiene cupo disponible.");
        }
        for (Inscripcion i : inscripciones) {
            if (i.getAlumno() == alumno && i.getTaller() == taller) {
                throw new IllegalArgumentException("El alumno ya está inscrito en este taller.");
            }
        }
        taller.reducirCupo();
        Inscripcion inscripcion = new Inscripcion(siguienteFolio, alumno, taller);
        siguienteFolio++;
        inscripciones.add(inscripcion);
        return new Ticket(inscripcion);
    }
}
