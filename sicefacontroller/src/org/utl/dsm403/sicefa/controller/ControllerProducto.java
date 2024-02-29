
package org.utl.dsm403.sicefa.controller;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm403.sicefa.bd.ConexionMySQL;
import org.utl.dsm403.sicefa.model.Producto;
import java.sql.Types;

public class ControllerProducto {
    public List<Producto> getAllActivos() throws SQLException, ClassNotFoundException, IOException {
        //genera la cnsulta 
        String query = "select * from v_productos WHERE estatus = 1";

        //conexion con la bd
        ConexionMySQL connMysql = new ConexionMySQL();
        //abre la conexion 
        Connection conn = connMysql.abrirConexion();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        //se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Producto> productos = new ArrayList<>();
        //se recorre el resultado de la consulta - rs
        while (rs.next()) {
            Producto pro=new Producto();
            pro.setIdProducto(rs.getInt("idProducto"));
            pro.setNombre(rs.getString("nombre"));
            pro.setNombreGenerico(rs.getString("nombreGenerico"));
            pro.setFormaFarmaceutica(rs.getString("formaFarmaceutica"));
            pro.setUnidadMedida(rs.getString("unidadMedida"));
            pro.setPresentacion(rs.getString("presentacion"));
            pro.setPrincipalIndicacion(rs.getString("principalIndicacion"));
            pro.setContraindicaciones(rs.getString("contraindicaciones"));
            pro.setConcentracion(rs.getString("concentracion"));
            pro.setUnidadesEnvase(rs.getInt("unidadesEnvase"));
            pro.setPrecioCompra(rs.getFloat("precioCompra"));
            pro.setPrecioVenta(rs.getFloat("precioVenta"));
            pro.setFoto(rs.getString("foto"));
            pro.setRutaFoto(rs.getString("rutaFoto"));
            pro.setCodigoBarras(rs.getString("codigoBarras"));
            pro.setEstatus(rs.getInt("estatus"));
            productos.add(pro);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMysql.cerrarConexion(conn);
        return productos;
    }
    public List<Producto> getAllInactivos() throws SQLException, ClassNotFoundException, IOException {
        //genera la cnsulta 
        String query = "select * from v_productos WHERE estatus = 0";

        //conexion con la bd
        ConexionMySQL connMysql = new ConexionMySQL();
        //abre la conexion 
        Connection conn = connMysql.abrirConexion();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        //se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Producto> productos = new ArrayList<>();
        //se recorre el resultado de la consulta - rs
        while (rs.next()) {
            Producto pro=new Producto();
            pro.setIdProducto(rs.getInt("idProducto"));
            pro.setNombre(rs.getString("nombre"));
            pro.setNombreGenerico(rs.getString("nombreGenerico"));
            pro.setFormaFarmaceutica(rs.getString("formaFarmaceutica"));
            pro.setUnidadMedida(rs.getString("unidadMedida"));
            pro.setPresentacion(rs.getString("presentacion"));
            pro.setPrincipalIndicacion(rs.getString("principalIndicacion"));
            pro.setContraindicaciones(rs.getString("contraindicaciones"));
            pro.setConcentracion(rs.getString("concentracion"));
            pro.setUnidadesEnvase(rs.getInt("unidadesEnvase"));
            pro.setPrecioCompra(rs.getFloat("precioCompra"));
            pro.setPrecioVenta(rs.getFloat("precioVenta"));
            pro.setFoto(rs.getString("foto"));
            pro.setRutaFoto(rs.getString("rutaFoto"));
            pro.setCodigoBarras(rs.getString("codigoBarras"));
            pro.setEstatus(rs.getInt("estatus"));
            productos.add(pro);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMysql.cerrarConexion(conn);
        return productos;
    }
    
    public void delete(Producto p) throws ClassNotFoundException{
        try {
            String query="UPDATE producto SET estatus=0 WHERE idProducto="+p.getIdProducto()+";";
            
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
    public void regresar(Producto p) throws ClassNotFoundException{
        try {
            String query="UPDATE producto SET estatus=1 WHERE idProducto="+p.getIdProducto()+";";
            
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
    
    
    public int insert (Producto p) throws SQLException, IOException, IOException, ClassNotFoundException{
        String query="{call insertarProducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionMySQL conMysql=new ConexionMySQL();
        Connection conn = conMysql.abrirConexion();
        CallableStatement cstm= conn.prepareCall(query);
        
        cstm.setString(1, p.getNombre());
        cstm.setString(2, p.getNombreGenerico());
        cstm.setString(3, p.getFormaFarmaceutica());
        cstm.setString(4, p.getUnidadMedida());
        cstm.setString(5, p.getPresentacion());
        cstm.setString(6, p.getPrincipalIndicacion());
        cstm.setString(7, p.getContraindicaciones());
        cstm.setString(8, p.getConcentracion());
        cstm.setInt(9, p.getUnidadesEnvase());
        cstm.setFloat(10, p.getPrecioCompra());
        cstm.setFloat(11, p.getPrecioVenta());
        cstm.setString(12, p.getFoto());
        cstm.setString(13, p.getRutaFoto());
        
        cstm.setString(14, p.getCodigoBarras());
        
        cstm.setInt(15, p.getEstatus());
        cstm.registerOutParameter(16, Types.INTEGER);
        cstm.execute();
        p.setIdProducto(cstm.getInt(16));
       
        cstm.close();
        conn.close();
        conMysql.cerrarConexion(conn);
        
        return p.getIdProducto();
        
    }
    
    public int update(Producto p) throws ClassNotFoundException, SQLException, IOException {
        //1. Generar la sentencia SQL
        String query = "{call modificarProducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        //2. Crear la conexión a la BD
        ConexionMySQL conMySQL = new ConexionMySQL();
        //3. Se abre la conexión
        Connection conn = conMySQL.abrirConexion();
        //4. Crear el statement que llevara la consulta
        CallableStatement cstm = conn.prepareCall(query);
        //5. LLenar todos los parametros de la llamada al Procedure
        cstm.setString(1, p.getNombre());
        cstm.setString(2, p.getNombreGenerico());
        cstm.setString(3, p.getFormaFarmaceutica());
        cstm.setString(4, p.getUnidadMedida());
        cstm.setString(5, p.getPresentacion());
        cstm.setString(6, p.getPrincipalIndicacion());
        cstm.setString(7, p.getContraindicaciones());
        cstm.setString(8, p.getConcentracion());
        cstm.setInt(9, p.getUnidadesEnvase());
        cstm.setFloat(10, p.getPrecioCompra());
        cstm.setFloat(11, p.getPrecioVenta());
        cstm.setString(12, p.getFoto());
        cstm.setString(13, p.getRutaFoto());
        
        cstm.setString(14, p.getCodigoBarras());
        
        cstm.setInt(15, p.getEstatus());
        cstm.setInt(16, p.getIdProducto());

cstm.execute();

        //8. Cerrar los objetos
        cstm.close();
        conn.close();
        conMySQL.cerrarConexion(conn);

        return p.getIdProducto();
    }
    
}
