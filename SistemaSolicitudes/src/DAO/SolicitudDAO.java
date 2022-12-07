package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Conexion.Conexion;
import Modelos.Solicitud;
import Modelos.Usuario;
import java.util.List;
import Interfaces.ISolicitudDAO;
import Modelos.Categoria;
import Modelos.Estado_solicitud;
import Modelos.Persona;
import Modelos.Prioridad;
import Modelos.Tipo_solicitud;
import Modelos.UsuarioTI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SolicitudDAO implements ISolicitudDAO<Solicitud> {

    private static final String SQL_LISTAR = "SELECT * FROM vista_solicitud ";
    private static final String SQL_AGREGAR = "CALL registrarSolicitud(?,?,?,?,?,?,?,?)";
    private static final String SQL_ELIMINAR = "DELETE FROM solicitud WHERE idSolicitud = ?";
    private static final String SQL_BUSCAR = "SELECT * FROM vista_solicitud where Nro_solicitud = ?";
    private static final String SQL_MODIFICARJF = "CALL actualizarSolicitudJF(?,?,?,?,?,?,?)";
    private static final String SQL_ATENDERJF = "CALL atenderSolicitudJF(?,?,?,?,?,?,?)";
    private static final String SQL_CIERREJF = "CALL cierreSolicitudJF(?,?,?,?,?,?,?)";
    private static final String SQL_MODIFICARCL = "UPDATE `solicitud` SET Asunto =?, Descripcion = ? WHERE idSolicitud= ?";
    private static final String SQL_ATENDER = "CALL atenderSolicitud(?,?,?,?,?,?)";
    private static final String SQL_CIERRE = "CALL cierreSolicitud(?,?,?,?,?,?)";
    
    Conexion cn = new Conexion();

    @Override
    public List<Solicitud> listar() {
        PreparedStatement ps;
        ResultSet rs;
        Persona p1, p2;
        Solicitud s;
        UsuarioTI uti;
        Usuario u;
        Tipo_solicitud ts;
        Estado_solicitud es;
        Prioridad pri;
        Categoria c;

        ArrayList<Solicitud> solicitud = new ArrayList();
        try {
            ps = cn.con.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Solicitud*/
                String idsolicitud = rs.getString("Nro_solicitud");
                String asunto = rs.getString("Asunto");
                String descripcion = rs.getString("Descripcion");
                String fhcreacion = rs.getString("fh_creacion");
                String fhactualizar = rs.getString("fh_actualizacion");
                String fhcierre = rs.getString("fh_cierre");

                /*Persona*/
                String nombresu = rs.getString("Usuario");
                String nombresti = rs.getString("Tecnico_asignado");

                /*Usuario*/
                int idusuario = rs.getInt("idUsuario");

                /*UsuarioTI*/
                int idusuarioti = rs.getInt("idUsuarioTI");

                /*Tipo*/
                int idtipo = rs.getInt("idTipo_solicitud");
                String tipo = rs.getString("Tipo");

                /*Estado*/
                int idestado = rs.getInt("idEstado_solicitud");
                String estado = rs.getString("Estado");

                /*Prioridad*/
                int idprioridad = rs.getInt("idPrioridad");
                String prioridad = rs.getString("Prioridad");

                /*Categoria*/
                int idcategoria = rs.getInt("idCategoria");
                String categoria = rs.getString("Categoria");

                p1 = new Persona(nombresu);
                p2 = new Persona(nombresti);
                u = new Usuario(idusuario, p1);
                uti = new UsuarioTI(idusuarioti, p2);
                ts = new Tipo_solicitud(idtipo, tipo);
                es = new Estado_solicitud(idestado, estado);
                pri = new Prioridad(idprioridad, prioridad);
                c = new Categoria(idcategoria, categoria);
                s = new Solicitud(idsolicitud, u, uti, asunto, descripcion, fhcreacion, fhactualizar, fhcierre, ts, es, pri, c);
                solicitud.add(s);
            }
            cn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return solicitud;
    }

    @Override
    public List<Solicitud> listarEst(int idEst) {
        Persona p1, p2;
        Solicitud s;
        UsuarioTI uti;
        Usuario u;
        Tipo_solicitud ts;
        Estado_solicitud es;
        Prioridad pri;
        Categoria c;

        ArrayList<Solicitud> solicitud = new ArrayList();
        try {
            PreparedStatement ps = cn.con.prepareStatement("SELECT * FROM vista_solicitud where idEstado_solicitud=" + idEst);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                /*Solicitud*/
                String idsolicitud = rs.getString("Nro_solicitud");
                String asunto = rs.getString("Asunto");
                String descripcion = rs.getString("Descripcion");
                String fhcreacion = rs.getString("fh_creacion");
                String fhactualizar = rs.getString("fh_actualizacion");
                String fhcierre = rs.getString("fh_cierre");

                /*Persona*/
                String nombresu = rs.getString("Usuario");
                String nombresti = rs.getString("Tecnico_asignado");

                /*Usuario*/
                int idusuario = rs.getInt("idUsuario");

                /*UsuarioTI*/
                int idusuarioti = rs.getInt("idUsuarioTI");

                /*Tipo*/
                int idtipo = rs.getInt("idTipo_solicitud");
                String tipo = rs.getString("Tipo");

                /*Estado*/
                int idestado = rs.getInt("idEstado_solicitud");
                String estado = rs.getString("Estado");

                /*Prioridad*/
                int idprioridad = rs.getInt("idPrioridad");
                String prioridad = rs.getString("Prioridad");

                /*Categoria*/
                int idcategoria = rs.getInt("idCategoria");
                String categoria = rs.getString("Categoria");

                p1 = new Persona(nombresu);
                p2 = new Persona(nombresti);
                u = new Usuario(idusuario, p1);
                uti = new UsuarioTI(idusuarioti, p2);
                ts = new Tipo_solicitud(idtipo, tipo);
                es = new Estado_solicitud(idestado, estado);
                pri = new Prioridad(idprioridad, prioridad);
                c = new Categoria(idcategoria, categoria);
                s = new Solicitud(idsolicitud, u, uti, asunto, descripcion, fhcreacion, fhactualizar, fhcierre, ts, es, pri, c);
                solicitud.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return solicitud;
    }

    @Override
    public List<Solicitud> filtrar(String cad) {
        List<Solicitud> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Persona p1, p2;
        Solicitud s;
        UsuarioTI uti;
        Usuario u;
        Tipo_solicitud ts;
        Estado_solicitud es;
        Prioridad pri;
        Categoria c;
        try {
            ps = cn.con.prepareStatement("SELECT * FROM vista_solicitud WHERE Nro_solicitud LIKE ? or Asunto LIKE ?");
            ps.setString(1, cad + "%");
            ps.setString(2, cad + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Solicitud*/
                String idsolicitud = rs.getString("Nro_solicitud");
                String asunto = rs.getString("Asunto");
                String descripcion = rs.getString("Descripcion");
                String fhcreacion = rs.getString("fh_creacion");
                String fhactualizar = rs.getString("fh_actualizacion");
                String fhcierre = rs.getString("fh_cierre");

                /*Persona*/
                String nombresu = rs.getString("Usuario");
                String nombresti = rs.getString("Tecnico_asignado");

                /*Usuario*/
                int idusuario = rs.getInt("idUsuario");

                /*UsuarioTI*/
                int idusuarioti = rs.getInt("idUsuarioTI");

                /*Tipo*/
                int idtipo = rs.getInt("idTipo_solicitud");
                String tipo = rs.getString("Tipo");

                /*Estado*/
                int idestado = rs.getInt("idEstado_solicitud");
                String estado = rs.getString("Estado");

                /*Prioridad*/
                int idprioridad = rs.getInt("idPrioridad");
                String prioridad = rs.getString("Prioridad");

                /*Categoria*/
                int idcategoria = rs.getInt("idCategoria");
                String categoria = rs.getString("Categoria");

                p1 = new Persona(nombresu);
                p2 = new Persona(nombresti);
                u = new Usuario(idusuario, p1);
                uti = new UsuarioTI(idusuarioti, p2);
                ts = new Tipo_solicitud(idtipo, tipo);
                es = new Estado_solicitud(idestado, estado);
                pri = new Prioridad(idprioridad, prioridad);
                c = new Categoria(idcategoria, categoria);
                s = new Solicitud(idsolicitud, u, uti, asunto, descripcion, fhcreacion, fhactualizar, fhcierre, ts, es, pri, c);
                list.add(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean crear(Solicitud obj) {
        PreparedStatement ps;

        try {
            ps = cn.con.prepareStatement(SQL_AGREGAR);
            ps.setInt(1, obj.getUsuario().getIdUsuario());
            if(obj.getUsuarioTI() == null){
            ps.setString(2, null);
            }else{
            ps.setInt(2, obj.getUsuarioTI().getIdUsuarioTI());
            }
            ps.setString(3, obj.getAsunto());
            ps.setString(4, obj.getDescripcion());
            ps.setInt(5, obj.getTs().getIdTipo_solicitud());
            ps.setInt(6, obj.getEs().getIdEstado_solicitud());
            ps.setInt(7, obj.getPri().getIdPrioridad());
            ps.setInt(8, obj.getCat().getIdCategoria());

            if (ps.executeUpdate() > 0) {
                cn.con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean eliminar(Object x) {
        PreparedStatement ps;

        try {
            ps = cn.con.prepareStatement(SQL_ELIMINAR);
            ps.setString(1, x.toString());

            if (ps.executeUpdate() > 0) {
                cn.con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean ModificarJF(Solicitud obj) {
        PreparedStatement ps;

        try {
            ps = cn.con.prepareStatement(SQL_MODIFICARJF);
            ps.setString(1, obj.getIdSolicitud());
            ps.setInt(2, obj.getUsuarioTI().getIdUsuarioTI());
            ps.setString(3, obj.getDescripcion());
            ps.setInt(4, obj.getTs().getIdTipo_solicitud());
            ps.setInt(5, obj.getEs().getIdEstado_solicitud());
            ps.setInt(6, obj.getPri().getIdPrioridad());
            ps.setInt(7, obj.getCat().getIdCategoria());

            if (ps.executeUpdate() > 0) {
                cn.con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
        @Override
    public boolean atenderSolicitudJF(Solicitud obj) {
        PreparedStatement ps;

        try {
            ps = cn.con.prepareStatement(SQL_ATENDERJF);
            ps.setString(1, obj.getIdSolicitud());
            ps.setInt(2, obj.getUsuarioTI().getIdUsuarioTI());
            ps.setString(3, obj.getDescripcion());
            ps.setInt(4, obj.getTs().getIdTipo_solicitud());
            ps.setInt(5, obj.getEs().getIdEstado_solicitud());
            ps.setInt(6, obj.getPri().getIdPrioridad());
            ps.setInt(7, obj.getCat().getIdCategoria());

            if (ps.executeUpdate() > 0) {
                cn.con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean cierreSolicitudJF(Solicitud obj) {
        PreparedStatement ps;

        try {
            ps = cn.con.prepareStatement(SQL_CIERREJF);
            ps.setString(1, obj.getIdSolicitud());
            ps.setInt(2, obj.getUsuarioTI().getIdUsuarioTI());
            ps.setString(3, obj.getDescripcion());
            ps.setInt(4, obj.getTs().getIdTipo_solicitud());
            ps.setInt(5, obj.getEs().getIdEstado_solicitud());
            ps.setInt(6, obj.getPri().getIdPrioridad());
            ps.setInt(7, obj.getCat().getIdCategoria());

            if (ps.executeUpdate() > 0) {
                cn.con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean ModificarCliente(Solicitud obj) {
        PreparedStatement ps;

        try {
            ps = cn.con.prepareStatement(SQL_MODIFICARCL);
            ps.setString(1, obj.getAsunto());
            ps.setString(2, obj.getDescripcion());
            ps.setString(3, obj.getIdSolicitud());
            if (ps.executeUpdate() > 0) {
                cn.con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean atenderSolicitud(Solicitud obj) {
        PreparedStatement ps;

        try {
            ps = cn.con.prepareStatement(SQL_ATENDER);
            ps.setString(1, obj.getIdSolicitud());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getTs().getIdTipo_solicitud());
            ps.setInt(4, obj.getEs().getIdEstado_solicitud());
            ps.setInt(5, obj.getPri().getIdPrioridad());
            ps.setInt(6, obj.getCat().getIdCategoria());

            if (ps.executeUpdate() > 0) {
                cn.con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean cierreSolicitud(Solicitud obj) {
        PreparedStatement ps;

        try {
            ps = cn.con.prepareStatement(SQL_CIERRE);
            ps.setString(1, obj.getIdSolicitud());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getTs().getIdTipo_solicitud());
            ps.setInt(4, obj.getEs().getIdEstado_solicitud());
            ps.setInt(5, obj.getPri().getIdPrioridad());
            ps.setInt(6, obj.getCat().getIdCategoria());

            if (ps.executeUpdate() > 0) {
                cn.con.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    @Override
    public Solicitud leer(Object x) {
        PreparedStatement ps;
        ResultSet rs;
        Persona p1, p2;
        Solicitud s;
        UsuarioTI uti;
        Usuario u;
        Tipo_solicitud ts;
        Estado_solicitud es;
        Prioridad pri;
        Categoria c;

        try {
            ps = cn.con.prepareStatement(SQL_BUSCAR);
            ps.setString(1, x.toString());

            rs = ps.executeQuery();
            while (rs.next()) {
                /*Solicitud*/
                String idsolicitud = rs.getString("Nro_solicitud");
                String asunto = rs.getString("Asunto");
                String descripcion = rs.getString("Descripcion");
                String fhcreacion = rs.getString("fh_creacion");
                String fhactualizar = rs.getString("fh_actualizacion");
                String fhcierre = rs.getString("fh_cierre");

                /*Persona*/
                String nombresu = rs.getString("Usuario");
                String nombresti = rs.getString("Tecnico_asignado");

                /*Usuario*/
                int idusuario = rs.getInt("idUsuario");

                /*UsuarioTI*/
                int idusuarioti = rs.getInt("idUsuarioTI");

                /*Tipo*/
                int idtipo = rs.getInt("idTipo_solicitud");
                String tipo = rs.getString("Tipo");

                /*Estado*/
                int idestado = rs.getInt("idEstado_solicitud");
                String estado = rs.getString("Estado");

                /*Prioridad*/
                int idprioridad = rs.getInt("idPrioridad");
                String prioridad = rs.getString("Prioridad");

                /*Categoria*/
                int idcategoria = rs.getInt("idCategoria");
                String categoria = rs.getString("Categoria");

                p1 = new Persona(nombresu);
                p2 = new Persona(nombresti);
                u = new Usuario(idusuario, p1);
                uti = new UsuarioTI(idusuarioti, p2);
                ts = new Tipo_solicitud(idtipo, tipo);
                es = new Estado_solicitud(idestado, estado);
                pri = new Prioridad(idprioridad, prioridad);
                c = new Categoria(idcategoria, categoria);
                s = new Solicitud(idsolicitud, u, uti, asunto, descripcion, fhcreacion, fhactualizar, fhcierre, ts, es, pri, c);

                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
