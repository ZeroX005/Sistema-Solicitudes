package Modelos;

public class Tipo_solicitud {

    private int idTipo_solicitud;
    private String nombre;

    public Tipo_solicitud() {
    }

    public Tipo_solicitud(int idTipo_solicitud) {
        this.idTipo_solicitud = idTipo_solicitud;
    }

    public Tipo_solicitud(int idTipo_solicitud, String nombre) {
        this.idTipo_solicitud = idTipo_solicitud;
        this.nombre = nombre;
    }

    public int getIdTipo_solicitud() {
        return idTipo_solicitud;
    }

    public void setIdTipo_solicitud(int idTipo_solicitud) {
        this.idTipo_solicitud = idTipo_solicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }

}
