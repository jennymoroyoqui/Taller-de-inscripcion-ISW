
package model;

public class Ticket {

    private String folio;
    private String idAlumno;
    private String nombreAlumno;
    private String programaAcademico;
    private int semestre;
    private String nombreTaller;
    private String instructor;
    private String fecha;
    private String horario;
    private String lugar;
    private String estado;

    public Ticket(Inscripcion inscripcion) {
        this.folio = String.format("ISW-%04d", inscripcion.getFolio());
        this.idAlumno = inscripcion.getAlumno().getId();
        this.nombreAlumno = inscripcion.getAlumno().getNombreCompleto();
        this.programaAcademico = inscripcion.getAlumno().getProgramaAcademico();
        this.semestre = inscripcion.getAlumno().getSemestre();
        this.nombreTaller = inscripcion.getTaller().getNombre();
        this.instructor = inscripcion.getTaller().getInstructor();
        this.fecha = inscripcion.getTaller().getFecha();
        this.horario = inscripcion.getTaller().getHorario();
        this.lugar = inscripcion.getTaller().getLugar();
        this.estado = inscripcion.getEstado();
    }

    public String getFolio() {
        return folio;
    }

    public String generarTexto() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== TICKET DE INSCRIPCIÓN - SEMANA DE ISW ==========\n");
        sb.append("Folio de inscripción : ").append(folio).append("\n");
        sb.append("ID del alumno        : ").append(idAlumno).append("\n");
        sb.append("Nombre del alumno    : ").append(nombreAlumno).append("\n");
        sb.append("Programa académico   : ").append(programaAcademico).append("\n");
        sb.append("Semestre             : ").append(semestre).append("\n");
        sb.append("------------------------------------------------------------\n");
        sb.append("Taller               : ").append(nombreTaller).append("\n");
        sb.append("Instructor           : ").append(instructor).append("\n");
        sb.append("Fecha                : ").append(fecha).append("\n");
        sb.append("Horario              : ").append(horario).append("\n");
        sb.append("Lugar                : ").append(lugar).append("\n");
        sb.append("------------------------------------------------------------\n");
        sb.append("Estado de inscripción: ").append(estado).append("\n");
        sb.append("============================================================");
        return sb.toString();
    }
}
