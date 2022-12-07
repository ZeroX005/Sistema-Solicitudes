package DAO;

import Conexion.Conexion;
import Interfaces.IUsuarioDAO;
import Modelos.Persona;
import Modelos.Usuario;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements IUsuarioDAO<Usuario> {

    Conexion cn = new Conexion();

    @Override
    public Usuario autenticar(Object x1, Object x2) {
        String sql = "select * from loginUsuario where username_u = ? and password_u = ?";
        PreparedStatement ps;
        ResultSet rs;
        Usuario u;
        Persona p;
        try {
            ps = cn.con.prepareStatement(sql);
            ps.setString(1, x1.toString());
            ps.setString(2, x2.toString());
            rs = ps.executeQuery();
            rs.next();
            u = new Usuario();
            u.setIdUsuario(Integer.parseInt(rs.getString(1)));
            u.setUsuario(rs.getString(3));
            u.setPassword(rs.getString(4));
            p = new Persona(rs.getString(5));
            u.setPersona(p);
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
        public int consultaIdUsuario(String Password) {
        Usuario u = null;
        Conexion cn = new Conexion();
        Persona p = null;//Falta implementar en el DAO metodo para buscar persona
        try {
            String sql = "select IdUsuario from usuario where password_u=" + Password;
            PreparedStatement st = cn.con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.con.close();
            } catch (SQLException e2) {

            }
        }
        return 0;
    }

}
