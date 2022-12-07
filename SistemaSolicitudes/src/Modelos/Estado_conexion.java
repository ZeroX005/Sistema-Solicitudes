package Modelos;

public class Estado_conexion {
    
    private int idEstado_usuarioTI;
    private String nombre_ec;

    public Estado_conexion(int idEstado_usuarioTI) {
        this.idEstado_usuarioTI = idEstado_usuarioTI;
    }

    public int getIdEstado_usuarioTI() {
        return idEstado_usuarioTI;
    }

    public void setIdEstado_usuarioTI(int idEstado_usuarioTI) {
        this.idEstado_usuarioTI = idEstado_usuarioTI;
    }

    public String getNombre_ec() {
        return nombre_ec;
    }

    public void setNombre_ec(String nombre_ec) {
        this.nombre_ec = nombre_ec;
    }
    
}
