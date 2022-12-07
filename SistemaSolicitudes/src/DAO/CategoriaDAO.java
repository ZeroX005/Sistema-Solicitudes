package DAO;

import Modelos.Categoria;
import Conexion.*;
import java.sql.*;
import java.util.ArrayList;

public class CategoriaDAO implements Interfaces.ICategoria {

    Conexion cn = new Conexion();

    @Override
    public ArrayList consultaCat() {
        String sql = "select * from categoria";
       ArrayList listadoCat = new ArrayList();
       Categoria c = null;
        try {
            PreparedStatement ps = cn.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            c = new Categoria();
            c.setIdCategoria(rs.getInt(1));
            c.setNombre_cat(rs.getString(2));
            listadoCat.add(c);
            }
        } catch (SQLException ex) {
        } finally {
            try {
                cn.con.close();
            } catch (SQLException e2) {

            }
        }
        return listadoCat;
    }

}
