package DAO;

import Conexion.Conexion;
import Modelos.Prioridad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrioridadDAO implements Interfaces.IPrioridad {

    Conexion cn = new Conexion();

    @Override
    public ArrayList consultaPri() {
        String sql = "select * from prioridad";
       ArrayList listadoPri = new ArrayList();
       Prioridad p = null;
        try {
            PreparedStatement ps = cn.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            p = new Prioridad();
            p.setIdPrioridad(rs.getInt(1));
            p.setNombre_p(rs.getString(2));
            listadoPri.add(p);
            }
        } catch (SQLException ex) {
        } finally {
            try {
                cn.con.close();
            } catch (SQLException e2) {

            }
        }
        return listadoPri;
    }

}
