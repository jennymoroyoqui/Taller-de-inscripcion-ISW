package model;

public class Taller {

    private int id;
    private String nombre;
    private String instructor;
    private String fecha;
    private String horario;
    private String lugar;
    private int cupoDisponible;
    private String descripcionBreve;
    private String descripcion;

    public Taller(int id, String nombre, String instructor, String fecha, String horario,
            String lugar, int cupoDisponible, String descripcionBreve, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.fecha = fecha;
        this.horario = horario;
        this.lugar = lugar;
        this.cupoDisponible = cupoDisponible;
        this.descripcionBreve = descripcionBreve;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHorario() {
        return horario;
    }

    public String getLugar() {
        return lugar;
    }

    public int getCupoDisponible() {
        return cupoDisponible;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean hayCupo() {
        return cupoDisponible > 0;
    }

    public void reducirCupo() {
        if (cupoDisponible > 0) {
            cupoDisponible--;
        }
    }
}
