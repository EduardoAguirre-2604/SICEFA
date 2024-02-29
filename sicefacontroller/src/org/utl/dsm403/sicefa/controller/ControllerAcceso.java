
package org.utl.dsm403.sicefa.controller;

import java.io.IOException;
import org.utl.dsm403.sicefa.bd.ConexionMySQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author oscar
 */
public class ControllerAcceso {
    public String login(String nombreUsuario, String contrasenia) throws ClassNotFoundException, SQLException, IOException{
        //1. Definir la consulta
        String query = "SELECT rol FROM usuario WHERE nombreUsuario='"+nombreUsuario+
                        "' AND contrasenia='"+contrasenia+"';";
        //2. Establecemos la conexion
        ConexionMySQL objConMySQL = new ConexionMySQL();
        //3. abrir la conexion
        Connection objConn = objConMySQL.abrirConexion();
        //4. Se genera el objeto que envia la sentencia a la bd
        Statement stmt = objConn.createStatement();
        //5. Se ejecuta la sentencia
        ResultSet objRS = stmt.executeQuery(query);
        //6. Obtener el resultado
        String rol = "";
        if(objRS.next()){
            rol = objRS.getString("rol");
        } else {
            rol = "ERROR";
        }
        //6. Cerrar los objetos de comunicación con la BD
        objRS.close();
        stmt.close();
        objConn.close();
        objConMySQL.cerrarConexion(objConn);
        return rol;
    }
}
