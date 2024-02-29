/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm403.sicefa.controller;

import java.io.IOException;
import java.util.List;
import org.utl.dsm403.sicefa.model.Inventario;
import java.sql.SQLException;
import org.utl.dsm403.sicefa.bd.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.utl.dsm403.sicefa.model.Producto;

public class ControllerInventario {
    
    public List<Inventario> getAllUno() throws SQLException, ClassNotFoundException, IOException {
        //genera la cnsulta 
        String query = "select * from v_productos_suc_1";

        //conexion con la bd
        ConexionMySQL connMysql = new ConexionMySQL();
        //abre la conexion 
        Connection conn = connMysql.abrirConexion();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        //se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Inventario> inventarios1 = new ArrayList<>();
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
            
            Inventario in = new Inventario();
            in.setIdInventario(rs.getInt("idInventario"));
            in.setExistencias(rs.getInt("existencias"));
            in.setSucursal(rs.getInt("idSucursal"));
            in.setProducto(pro);
            inventarios1.add(in);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMysql.cerrarConexion(conn);
        return inventarios1;
    }
    
    public List<Inventario> getAllDos() throws SQLException, ClassNotFoundException, IOException {
        //genera la cnsulta 
        String query = "select * from v_productos_suc_2";

        //conexion con la bd
        ConexionMySQL connMysql = new ConexionMySQL();
        //abre la conexion 
        Connection conn = connMysql.abrirConexion();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        //se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Inventario> inventarios1 = new ArrayList<>();
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
            
            Inventario in = new Inventario();
            in.setIdInventario(rs.getInt("idInventario"));
            in.setExistencias(rs.getInt("existencias"));
            in.setSucursal(rs.getInt("idSucursal"));
            in.setProducto(pro);
            inventarios1.add(in);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMysql.cerrarConexion(conn);
        return inventarios1;
    }
    
    public List<Inventario> getAllTres() throws SQLException, ClassNotFoundException, IOException {
        //genera la cnsulta 
        String query = "select * from v_productos_suc_3";

        //conexion con la bd
        ConexionMySQL connMysql = new ConexionMySQL();
        //abre la conexion 
        Connection conn = connMysql.abrirConexion();
        
        PreparedStatement pstmt = conn.prepareStatement(query);
        //se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Inventario> inventarios1 = new ArrayList<>();
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
            
            Inventario in = new Inventario();
            in.setIdInventario(rs.getInt("idInventario"));
            in.setExistencias(rs.getInt("existencias"));
            in.setSucursal(rs.getInt("idSucursal"));
            in.setProducto(pro);
            inventarios1.add(in);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMysql.cerrarConexion(conn);
        return inventarios1;
    }
}
