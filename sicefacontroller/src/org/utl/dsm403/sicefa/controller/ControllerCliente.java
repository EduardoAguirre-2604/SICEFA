package org.utl.dsm403.sicefa.controller;

import org.utl.dsm403.sicefa.model.Cliente;
import java.sql.CallableStatement;
import java.io.IOException;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.utl.dsm403.sicefa.bd.ConexionMySQL;
import org.utl.dsm403.sicefa.model.Persona;


/**
 *
 * @author perez
 */
public class ControllerCliente {

    public List<Cliente> getAllActivos() throws SQLException, ClassNotFoundException, IOException {
        //genera la cnsulta 
        String query = "select * from v_clientes WHERE estatus = 1";

        //conexion con la bd
        ConexionMySQL connMysql = new ConexionMySQL();
        //abre la conexion 
        Connection conn = connMysql.abrirConexion();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        //se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Cliente> clientes = new ArrayList<>();
        //se recorre el resultado de la consulta - rs
        while (rs.next()) {
            Persona p = new Persona(rs.getInt("idPersona"),rs.getString("nombre"),rs.getString("apellidoPaterno"),
            rs.getString("apellidoMaterno"),rs.getString("genero"),rs.getString("fechaNacimiento"),rs.getString("rfc"),
            rs.getString("curp"),rs.getString("domicilio"),rs.getString("codigoPostal"),rs.getString("ciudad"),rs.getString("estado"),
            rs.getString("telefono"),rs.getString("foto"));
            
            Cliente c= new Cliente();
            c.setIdCliente(rs.getInt("idCliente"));
            c.setEmail(rs.getString("email"));
            c.setFechaRegistro(rs.getString("fechaRegistro"));
            c.setEstatus(rs.getInt("estatus"));
            c.setPersona(p);
            
            clientes.add(c);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMysql.cerrarConexion(conn);
        return clientes;
    }
    
    
    public List<Cliente> getAllInactivos() throws SQLException, ClassNotFoundException, IOException {
        //genera la cnsulta 
        String query = "select * from v_clientes WHERE estatus = 0";

        ConexionMySQL connMysql = new ConexionMySQL();
        //abre la conexion 
        Connection conn = connMysql.abrirConexion();

        PreparedStatement pstmt = conn.prepareStatement(query);
        //se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Cliente> clientes = new ArrayList<>();
        //se recorre el resultado de la consulta - rs
        while (rs.next()) {
            Persona p = new Persona(rs.getInt("idPersona"), rs.getString("nombre"), rs.getString("apellidoPaterno"),
                    rs.getString("apellidoMaterno"), rs.getString("genero"), rs.getString("fechaNacimiento"), rs.getString("rfc"),
                    rs.getString("curp"), rs.getString("domicilio"), rs.getString("codigoPostal"), rs.getString("ciudad"), rs.getString("estado"),
                    rs.getString("telefono"), rs.getString("foto"));

            Cliente c = new Cliente();
            c.setPersona(p);
            c.setEmail(rs.getString("email"));
            c.setEstatus(rs.getInt("estatus"));
            c.setFechaRegistro(rs.getString("fechaRegistro"));
            c.setIdCliente(rs.getInt("idCliente"));
            clientes.add(c);

        }
        rs.close();
        pstmt.close();
        conn.close();
        connMysql.cerrarConexion(conn);

        return clientes;
    }

    public void delete(Cliente c) throws ClassNotFoundException {
        try {
            String query = "UPDATE cliente SET estatus=0 WHERE idCliente=" + c.getIdCliente() + ";";

            //conexion con la bd
            ConexionMySQL objConnMySql = new ConexionMySQL();

            //abre la conexion
            Connection conn = objConnMySql.abrirConexion();

            Statement stmt = conn.createStatement();

            stmt.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void regresar(Cliente c) throws ClassNotFoundException {
        try {
            String query = "UPDATE cliente SET estatus=1 WHERE idCliente=" + c.getIdCliente() + ";";

            //conexion con la bd
            ConexionMySQL objConnMySql = new ConexionMySQL();

            //abre la conexion
            Connection conn = objConnMySql.abrirConexion();

            Statement stmt = conn.createStatement();

            stmt.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int insert(Cliente c) throws SQLException, IOException, ClassNotFoundException {
        String query = "{call insertarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionMySQL conMysql = new ConexionMySQL();
        Connection conn = conMysql.abrirConexion();
        CallableStatement cstm = conn.prepareCall(query);

        cstm.setString(1, c.getPersona().getNombre());
        cstm.setString(2, c.getPersona().getApellidoPaterno());
        cstm.setString(3, c.getPersona().getApellidoMaterno());
        cstm.setString(4, c.getPersona().getGenero());
        cstm.setString(5, c.getPersona().getFechaNacimiento());
        cstm.setString(6, c.getPersona().getRfc());
        cstm.setString(7, c.getPersona().getCurp());
        cstm.setString(8, c.getPersona().getDomicilio());
        cstm.setString(9, c.getPersona().getCodigoPostal());
        cstm.setString(10, c.getPersona().getCiudad());
        cstm.setString(11, c.getPersona().getEstado());
        cstm.setString(12, c.getPersona().getTelefono());
        cstm.setString(13, c.getPersona().getFoto());
        cstm.setString(14, c.getEmail());
        cstm.setInt(15, c.getEstatus());
        cstm.registerOutParameter(16, java.sql.Types.INTEGER); 
        cstm.registerOutParameter(17, java.sql.Types.INTEGER);
        
        cstm.execute();
        
        c.getPersona().setIdPersona(cstm.getInt(16));
        c.setIdCliente(cstm.getInt(17));
        
        cstm.close();
        conn.close();
        conMysql.cerrarConexion(conn);
        
        return c.getIdCliente();

    }

    public int update(Cliente c) throws ClassNotFoundException, SQLException, IOException {
        //1. Generar la sentencia SQL
        String query = "{call modificarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        //2. Crear la conexión a la BD
        ConexionMySQL conMySQL = new ConexionMySQL();
        //3. Se abre la conexión
        Connection conn = conMySQL.abrirConexion();
        //4. Crear el statement que llevara la consulta
        CallableStatement cstm = conn.prepareCall(query);
        //5. LLenar todos los parametros de la llamada al Procedure
        cstm.setInt(1, c.getIdCliente());
        cstm.setString(2, c.getPersona().getNombre());
        cstm.setString(3, c.getPersona().getApellidoPaterno());
        cstm.setString(4, c.getPersona().getApellidoMaterno());
        cstm.setString(5, c.getPersona().getGenero());
        cstm.setString(6, c.getPersona().getFechaNacimiento());
        cstm.setString(7, c.getPersona().getRfc());
        cstm.setString(8, c.getPersona().getCurp());
        cstm.setString(9, c.getPersona().getDomicilio());
        cstm.setString(10, c.getPersona().getCodigoPostal());
        cstm.setString(11, c.getPersona().getCiudad());
        cstm.setString(12, c.getPersona().getEstado());
        cstm.setString(13, c.getPersona().getTelefono());
        cstm.setString(14, c.getPersona().getFoto());
        cstm.setString(15, c.getEmail());
        cstm.setString(16, c.getFechaRegistro());
        cstm.setInt(17, c.getEstatus());

        cstm.execute();
        
        cstm.close();
        conn.close();
        conMySQL.cerrarConexion(conn);

        return c.getIdCliente();
    }
}
