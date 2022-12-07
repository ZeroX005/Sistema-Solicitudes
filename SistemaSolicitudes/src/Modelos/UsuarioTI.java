package Modelos;

public class UsuarioTI {

    private int idUsuarioTI;
    private Persona persona;
    private String usuario;
    private String password;
    private Rol rol;
    private Estado_conexion estado;

    public UsuarioTI() {
    }

    public UsuarioTI(String usuario, String password, Rol rol, Estado_conexion estado) {
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }

    public UsuarioTI(int idUsuarioTI) {
        this.idUsuarioTI = idUsuarioTI;
    }

    public UsuarioTI(int idUsuarioTI, Persona persona) {
        this.idUsuarioTI = idUsuarioTI;
        this.persona = persona;
    }

    
    public int getIdUsuarioTI() {
        return idUsuarioTI;
    }

    public void setIdUsuarioTI(int idUsuarioTI) {
        this.idUsuarioTI = idUsuarioTI;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Estado_conexion getEstado() {
        return estado;
    }

    public void setEstado(Estado_conexion estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return getPersona().getNombres();
    }
    
    
    
}
