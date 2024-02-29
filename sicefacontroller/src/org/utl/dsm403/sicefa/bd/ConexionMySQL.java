package org.utl.dsm403.sicefa.bd;

import java.sql.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    String url = "jdbc:mysql://localhost:3306/sicefa";
    String user = "root";
    String password = "Eduardo26.";

    public Connection abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conexion = DriverManager.getConnection(url, user, password);

        return conexion;
    }

    public void cerrarConexion(Connection conexion) throws IOException, SQLException {
        if(conexion!=null){
            conexion.close();
        }
        
    }
}
