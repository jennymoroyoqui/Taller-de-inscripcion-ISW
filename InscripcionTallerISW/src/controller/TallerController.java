package controller;

import java.util.ArrayList;
import java.util.List;
import model.Taller;

public class TallerController {

    private List<Taller> talleres;

    public TallerController() {
        talleres = new ArrayList<Taller>();
        cargarDatosPrueba();
    }

    // DATOS DE PRUEBA
    private void cargarDatosPrueba() {
        talleres.add(new Taller(1, "Introducción al Desarrollo Web", "Mtra. Laura Ramírez",
                "Lunes 19/10/2026", "10:00 - 12:00", "Aula 101", 30,
                "HTML, CSS y JavaScript básicos.",
                "Taller introductorio donde se construye una página web sencilla "
                + "aplicando HTML, CSS y JavaScript desde cero."));
        talleres.add(new Taller(2, "Bases de Datos Aplicadas", "Dr. Roberto Mendoza",
                "Martes 20/10/2026", "12:00 - 14:00", "Laboratorio 2", 25,
                "Modelado y consultas SQL.",
                "Taller práctico de modelado relacional y consultas SQL, "
                + "aplicado a un caso de estudio real."));
        talleres.add(new Taller(3, "Desarrollo de Aplicaciones con Java", "Ing. Fernando Castillo",
                "Miércoles 21/10/2026", "09:00 - 11:00", "Laboratorio 1", 20,
                "Programación en Java con Swing.",
                "Taller para crear aplicaciones de escritorio con Java y Swing "
                + "usando la arquitectura MVC."));

        talleres.add(new Taller(4, "Diseño de Interfaces de Usuario", "Mtra. Sofía Navarro",
                "Jueves 22/10/2026", "16:00 - 18:00", "Aula 205", 1,
                "Principios de usabilidad y prototipado.",
                "Taller sobre principios de usabilidad, diseño centrado en el usuario "
                + "y elaboración de prototipos."));
    }

    public List<Taller> obtenerTalleres() {
        return talleres;
    }

    public Taller obtenerTaller(int indice) {
        if (indice < 0 || indice >= talleres.size()) {
            throw new IllegalArgumentException("Debe seleccionar un taller de la lista.");
        }
        return talleres.get(indice);
    }
}
