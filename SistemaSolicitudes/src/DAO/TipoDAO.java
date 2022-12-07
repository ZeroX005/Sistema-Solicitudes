package DAO;

import Conexion.Conexion;
import Modelos.Tipo_solicitud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoDAO implements Interfaces.ITipoDAO{
    
        Conexion cn = new Conexion();

    @Override
    public ArrayList consultaTipo() {
        String sql = "select * from tipo_solicitud";
       ArrayList listadoTS = new ArrayList();
       Tipo_solicitud ts = null;
        try {
            PreparedStatement ps = cn.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            ts = new Tipo_solicitud();
            ts.setIdTipo_solicitud(rs.getInt(1));
            ts.setNombre(rs.getString(2));
            listadoTS.add(ts);
            }
        } catch (SQLException ex) {
        } finally {
            try {
                cn.con.close();
            } catch (SQLException e2) {

            }
        }
        return listadoTS;
    }
    
}
