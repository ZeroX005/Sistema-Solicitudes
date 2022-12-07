package Modelos;

public class Prioridad {

    private int idPrioridad;
    private String nombre_p;

    public Prioridad() {
    }

    public Prioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public Prioridad(int idPrioridad, String nombre_p) {
        this.idPrioridad = idPrioridad;
        this.nombre_p = nombre_p;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public String getNombre_p() {
        return nombre_p;
    }

    public void setNombre_p(String nombre_p) {
        this.nombre_p = nombre_p;
    }
    
    @Override
    public String toString() {
        return getNombre_p();
    }

}
