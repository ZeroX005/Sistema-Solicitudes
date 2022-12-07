package Modelos;

public class Solicitud {

    private String idSolicitud;
    private Usuario usuario;
    private UsuarioTI usuarioTI;
    private String Asunto;
    private String Descripcion;
    private String fh_creacion;
    private String fh_actualizacion;
    private String fh_cierre;
    private Tipo_solicitud ts;
    private Estado_solicitud es;
    private Prioridad pri;
    private Categoria cat;

    public Solicitud() {
    }

    public Solicitud(String idSolicitud, UsuarioTI usuarioTI, Tipo_solicitud ts, Estado_solicitud es, Prioridad pri, Categoria cat) {
        this.idSolicitud = idSolicitud;
        this.usuarioTI = usuarioTI;
        this.ts = ts;
        this.es = es;
        this.pri = pri;
        this.cat = cat;
    }

    public Solicitud(String idSolicitud, Tipo_solicitud ts, Estado_solicitud es, Prioridad pri, Categoria cat) {
        this.idSolicitud = idSolicitud;
        this.ts = ts;
        this.es = es;
        this.pri = pri;
        this.cat = cat;
    }

    public Solicitud(String idSolicitud, Usuario usuario, UsuarioTI usuarioTI, String Asunto, String Descripcion, Tipo_solicitud ts, Estado_solicitud es, Prioridad pri, Categoria cat) {
        this.idSolicitud = idSolicitud;
        this.usuario = usuario;
        this.usuarioTI = usuarioTI;
        this.Asunto = Asunto;
        this.Descripcion = Descripcion;
        this.ts = ts;
        this.es = es;
        this.pri = pri;
        this.cat = cat;
    }

    public Solicitud(String idSolicitud, Usuario usuario, UsuarioTI usuarioTI, String Asunto, String Descripcion, String fh_creacion, String fh_actualizacion, String fh_cierre, Tipo_solicitud ts, Estado_solicitud es, Prioridad pri, Categoria cat) {
        this.idSolicitud = idSolicitud;
        this.usuario = usuario;
        this.usuarioTI = usuarioTI;
        this.Asunto = Asunto;
        this.Descripcion = Descripcion;
        this.fh_creacion = fh_creacion;
        this.fh_actualizacion = fh_actualizacion;
        this.fh_cierre = fh_cierre;
        this.ts = ts;
        this.es = es;
        this.pri = pri;
        this.cat = cat;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioTI getUsuarioTI() {
        return usuarioTI;
    }

    public void setUsuarioTI(UsuarioTI usuarioTI) {
        this.usuarioTI = usuarioTI;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFh_creacion() {
        return fh_creacion;
    }

    public void setFh_creacion(String fh_creacion) {
        this.fh_creacion = fh_creacion;
    }

    public String getFh_actualizacion() {
        return fh_actualizacion;
    }

    public void setFh_actualizacion(String fh_actualizacion) {
        this.fh_actualizacion = fh_actualizacion;
    }

    public String getFh_cierre() {
        return fh_cierre;
    }

    public void setFh_cierre(String fh_cierre) {
        this.fh_cierre = fh_cierre;
    }

    public Tipo_solicitud getTs() {
        return ts;
    }

    public void setTs(Tipo_solicitud ts) {
        this.ts = ts;
    }

    public Estado_solicitud getEs() {
        return es;
    }

    public void setEs(Estado_solicitud es) {
        this.es = es;
    }

    public Prioridad getPri() {
        return pri;
    }

    public void setPri(Prioridad pri) {
        this.pri = pri;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

}
