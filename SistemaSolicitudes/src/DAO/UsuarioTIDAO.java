package DAO;

import Conexion.Conexion;
import Modelos.UsuarioTI;
import Modelos.Rol;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interfaces.IUsuarioTIDAO;
import Modelos.Estado_conexion;
import Modelos.Persona;
import java.util.ArrayList;

public class UsuarioTIDAO implements IUsuarioTIDAO<UsuarioTI> {

    Conexion cn = new Conexion();

    @Override
    public UsuarioTI autenticar(Object x1, Object x2) {
        String sql = "select * from loginUsuarioTI where username_ti = ? and password_ti = ?";
        PreparedStatement ps;
        ResultSet rs;
        UsuarioTI u;
        Persona p;
        Rol r;
        Estado_conexion ec;
        try {
            ps = cn.con.prepareStatement(sql);
            ps.setString(1, x1.toString());
            ps.setString(2, x2.toString());
            rs = ps.executeQuery();
            rs.next();
            u = new UsuarioTI();
            u.setUsuario(rs.getString(3));
            u.setPassword(rs.getString(4));
            r = new Rol(rs.getInt(5));
            u.setRol(r);
            ec = new Estado_conexion(rs.getInt(6));
            u.setEstado(ec);
            p = new Persona(rs.getString(7));
            u.setPersona(p);
            return u;

        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean estadoconexion(Object x, Object y) {
        String sql = "CALL econexion(?,?)";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = cn.con.prepareStatement(sql);
            ps.setString(1, x.toString());
            ps.setString(2, y.toString());
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
    public ArrayList consultaTecnico() {
        String sql = "select * from vista_tecnicos";
       ArrayList listadoTec = new ArrayList();
       UsuarioTI tec = null;
        Persona per = null;
        try {
            PreparedStatement ps = cn.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            tec = new UsuarioTI();
            tec.setIdUsuarioTI(rs.getInt(1));
            per = new Persona(rs.getString(2));
            tec.setPersona(per);
            listadoTec.add(tec);
            }
        } catch (SQLException ex) {
        } finally {
            try {
                cn.con.close();
            } catch (SQLException e2) {

            }
        }
        return listadoTec;
    }

    @Override
    public UsuarioTI tecnicoAsignado() {
        PreparedStatement ps;
        ResultSet rs;
        UsuarioTI uti;
        try{
            ps = cn.con.prepareStatement("select * from TecnicoAsignado");
            rs = ps.executeQuery();
            while (rs.next()) {
                uti = new UsuarioTI(rs.getInt("idUsuarioTI"));
                return uti;
            }
            cn.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
