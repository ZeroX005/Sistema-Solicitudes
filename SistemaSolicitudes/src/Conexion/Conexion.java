package Conexion;

import java.sql.*;

public class Conexion {
    
        public Connection con;
        
        public Conexion(){
            try {
                String url = "jdbc:mysql://localhost:3306/proyecto2";
                String Driver = "com.mysql.cj.jdbc.Driver";
                String user = "root";
                String clave = "";
                Class.forName(Driver);
                con = DriverManager.getConnection(url, user, clave);
            }catch(Exception e){
                System.out.println("Error al conectar BD: " +e);
            }
        }
                
}
