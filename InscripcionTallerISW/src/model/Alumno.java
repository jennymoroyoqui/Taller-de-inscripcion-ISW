package model;

public class Alumno {

    private String id;
    private String nombreCompleto;
    private int semestre;
    private String programaAcademico;

    public Alumno(String id, String nombreCompleto, int semestre, String programaAcademico) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.semestre = semestre;
        this.programaAcademico = programaAcademico;
    }

    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }
}
