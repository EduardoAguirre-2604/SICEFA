package org.utl.dsm403.sicefa.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm403.sicefa.bd.ConexionMySQL;
import org.utl.dsm403.sicefa.model.Pedido;

public class ControllerPedido {

    public List<Pedido> getAllPendientes() throws ClassNotFoundException, SQLException, IOException {
        //Generar la consulta
        String query = "SELECT * FROM vista_control_pedidos WHERE estatus = 1";

        //Conectarse a la BD
        ConexionMySQL connMySQL = new ConexionMySQL();
        //Abrir la conexion
        Connection conn = connMySQL.abrirConexion();
        //Crear el objeto que lleva la sentencia a la BD
        PreparedStatement pstmt = conn.prepareStatement(query);
        //Se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Pedido> pedidos = new ArrayList<>();
        while (rs.next()) {
            Pedido p = new Pedido();
            
            p.setIdCompra(rs.getInt("idCompra"));
            p.setFecha(rs.getString("fecha"));
            p.setEstatus(rs.getInt("estatus"));
            p.setNombreSucursal(rs.getString("nombreSucursal"));
            p.setCodigoPostalSucursal(rs.getString("codigoPostalSucursal"));
            p.setCiudadSucursal(rs.getString("ciudadSucursal"));
            p.setEstadoSucursal(rs.getString("estadoSucursal"));
            p.setNombreEmpleado(rs.getString("nombreEmpleado"));
            p.setNombreProducto(rs.getString("nombreProducto"));
            p.setCantidadProducto(rs.getInt("cantidadProducto"));
            p.setPrecioCompra(rs.getFloat("precioCompra"));
            p.setTotalPedido(rs.getDouble("totalPedido"));
            
            pedidos.add(p);
            
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.cerrarConexion(conn);
        
        return pedidos;
    }
    
    public List<Pedido> getAllAtendidos() throws ClassNotFoundException, SQLException, IOException {
        //Generar la consulta
        String query = "SELECT * FROM vista_control_pedidos WHERE estatus = 2";

        //Conectarse a la BD
        ConexionMySQL connMySQL = new ConexionMySQL();
        //Abrir la conexion
        Connection conn = connMySQL.abrirConexion();
        //Crear el objeto que lleva la sentencia a la BD
        PreparedStatement pstmt = conn.prepareStatement(query);
        //Se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Pedido> pedidos = new ArrayList<>();
        while (rs.next()) {
            Pedido p = new Pedido();
            
            p.setIdCompra(rs.getInt("idCompra"));
            p.setFecha(rs.getString("fecha"));
            p.setEstatus(rs.getInt("estatus"));
            p.setNombreSucursal(rs.getString("nombreSucursal"));
            p.setCodigoPostalSucursal(rs.getString("codigoPostalSucursal"));
            p.setCiudadSucursal(rs.getString("ciudadSucursal"));
            p.setEstadoSucursal(rs.getString("estadoSucursal"));
            p.setNombreEmpleado(rs.getString("nombreEmpleado"));
            p.setNombreProducto(rs.getString("nombreProducto"));
            p.setCantidadProducto(rs.getInt("cantidadProducto"));
            p.setPrecioCompra(rs.getFloat("precioCompra"));
            p.setTotalPedido(rs.getDouble("totalPedido"));
            
            pedidos.add(p);
            
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.cerrarConexion(conn);
        
        return pedidos;
    }
    public void atenderPedido(int idCompra) throws SQLException, ClassNotFoundException, IOException{
        //1. Generar la sentencia SQL
        String query = "{call AtenderPedido(?)}";
        //2. Crear la conexión a la BD
        ConexionMySQL conMySQL = new ConexionMySQL();
        //3. Se abre la conexión
        Connection conn = conMySQL.abrirConexion();
        //4. Crear el statement que llevara la consulta
        CallableStatement cstm = conn.prepareCall(query);
        //5. LLenar todos los parametros de la llamada al Procedure
        cstm.setInt(1, idCompra);
        //6.Ejecutar la sentencia
        cstm.execute();
        //8. Cerrar los objetos
        cstm.close();
        conn.close();
        conMySQL.cerrarConexion(conn);
    }
}
