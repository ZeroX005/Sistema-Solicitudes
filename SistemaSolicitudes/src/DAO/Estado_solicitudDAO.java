package DAO;

import Conexion.Conexion;
import Modelos.Estado_solicitud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Estado_solicitudDAO implements Interfaces.IEstado_solicitudDAO{
    
        Conexion cn = new Conexion();

    @Override
    public ArrayList consultaES() {
        String sql = "select * from estado_solicitud";
       ArrayList listadoES = new ArrayList();
       Estado_solicitud es = null;
        try {
            PreparedStatement ps = cn.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            es = new Estado_solicitud();
            es.setIdEstado_solicitud(rs.getInt(1));
            es.setNombre_es(rs.getString(2));
            listadoES.add(es);
            }
        } catch (SQLException ex) {
        } finally {
            try {
                cn.con.close();
            } catch (SQLException e2) {

            }
        }
        return listadoES;
    }
    
}
