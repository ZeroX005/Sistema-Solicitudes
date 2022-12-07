package Modelos;

public class Estado_solicitud {

    private int idEstado_solicitud;
    private String nombre_es;

    public Estado_solicitud() {
    }

    public Estado_solicitud(int idEstado_solicitud) {
        this.idEstado_solicitud = idEstado_solicitud;
    }

    public Estado_solicitud(int idEstado_solicitud, String nombre_es) {
        this.idEstado_solicitud = idEstado_solicitud;
        this.nombre_es = nombre_es;
    }

    public int getIdEstado_solicitud() {
        return idEstado_solicitud;
    }

    public void setIdEstado_solicitud(int idEstado_solicitud) {
        this.idEstado_solicitud = idEstado_solicitud;
    }

    public String getNombre_es() {
        return nombre_es;
    }

    public void setNombre_es(String nombre_es) {
        this.nombre_es = nombre_es;
    }

    @Override
    public String toString() {
        return getNombre_es();
    }

}
