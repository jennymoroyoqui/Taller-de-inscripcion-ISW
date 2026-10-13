
package model;

public class Inscripcion {

    private int folio;
    private Alumno alumno;
    private Taller taller;
    private String estado;

    public Inscripcion(int folio, Alumno alumno, Taller taller) {
        this.folio = folio;
        this.alumno = alumno;
        this.taller = taller;
        this.estado = "CONFIRMADA";
    }

    public int getFolio() {
        return folio;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Taller getTaller() {
        return taller;
    }

    public String getEstado() {
        return estado;
    }
}
