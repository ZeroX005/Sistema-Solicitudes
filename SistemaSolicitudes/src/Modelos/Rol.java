package Modelos;

public class Rol {
    
    private int idRol;
    private String nombre_rol;

    public Rol(int idRol) {
        this.idRol = idRol;
    }

    
    public Rol(int idRol, String nombre_rol) {
        this.idRol = idRol;
        this.nombre_rol = nombre_rol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
    
}
