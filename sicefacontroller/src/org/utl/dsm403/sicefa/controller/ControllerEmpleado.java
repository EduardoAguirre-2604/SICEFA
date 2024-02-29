package org.utl.dsm403.sicefa.controller;

import java.sql.CallableStatement;
import java.sql.Types;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm403.sicefa.bd.ConexionMySQL;
import org.utl.dsm403.sicefa.model.Empleado;
import org.utl.dsm403.sicefa.model.Persona;
import org.utl.dsm403.sicefa.model.Sucursal;
import org.utl.dsm403.sicefa.model.Usuario;

public class ControllerEmpleado {

    public List<Empleado> getAllActivos() throws ClassNotFoundException, SQLException, IOException {
        //Generar la consulta
        String query = "SELECT * FROM v_empleados WHERE activo = 1";

        //Conectarse a la BD
        ConexionMySQL connMySQL = new ConexionMySQL();

        //Abrir la conexion
        Connection conn = connMySQL.abrirConexion();
        //Crear el objeto que lleva la sentencia a la BD
        PreparedStatement pstmt = conn.prepareStatement(query);
        //Se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Empleado> empleados = new ArrayList<>();
        //Se recorre el resultado de la consulta - rs
        while (rs.next()) {

            Usuario u = new Usuario();
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombreUsuario(rs.getString("nombreUsuario"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));

            Sucursal s = new Sucursal();
            s.setIdSucursal(rs.getInt("idSucursal"));
            s.setNombre(rs.getString("nombreSucursal"));
            s.setTitular(rs.getString("titularSucursal"));
            s.setRfc(rs.getString("rfcSucursal"));
            s.setDomicilio(rs.getString("domicilioSucursal"));
            s.setColonia(rs.getString("colonia"));
            s.setCodigoPostal(rs.getString("cpSucursal"));
            s.setCiudad(rs.getString("ciudadSucursal"));
            s.setEstado(rs.getString("estadoSucursal"));
            s.setTelefono(rs.getString("telefonoSucursal"));
            s.setLatitud(rs.getString("latitudSucursal"));
            s.setLongitud(rs.getString("longitudSucursal"));
            s.setEstatus(rs.getInt("estatusSucursal"));

            Persona p = new Persona();
            p.setIdPersona(rs.getInt("idPersona"));
            p.setNombre(rs.getString("nombre"));
            p.setApellidoPaterno(rs.getString("apellidoPaterno"));
            p.setApellidoMaterno(rs.getString("apellidoMaterno"));
            p.setGenero(rs.getString("genero"));
            p.setFechaNacimiento(rs.getString("fechaNacimiento"));
            p.setRfc(rs.getString("rfc"));
            p.setCurp(rs.getString("curp"));
            p.setDomicilio(rs.getString("domicilio"));
            p.setCodigoPostal(rs.getString("codigoPostal"));
            p.setCiudad(rs.getString("ciudad"));
            p.setEstado(rs.getString("estado"));
            p.setTelefono(rs.getString("telefono"));
            p.setFoto(rs.getString("foto"));

            Empleado e = new Empleado();
            e.setIdEmpleado(rs.getInt("idEmpleado"));
            e.setCodigo(rs.getString("codigo"));
            e.setFechaIngreso(rs.getString("fechaIngreso"));
            e.setPuesto(rs.getString("puesto"));
            e.setSalarioBruto(rs.getFloat("salarioBruto"));
            e.setEmail(rs.getString("email"));
            e.setActivo(rs.getInt("activo"));
            e.setPersona(p);
            e.setSucursal(s);
            e.setUsuario(u);

            empleados.add(e);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.cerrarConexion(conn);

        return empleados;
    }

    public List<Empleado> getAllInactivos() throws ClassNotFoundException, SQLException, IOException {
        //Generar la consulta
        String query = "SELECT * FROM v_empleados WHERE activo = 0";

        //Conectarse a la BD
        ConexionMySQL connMySQL = new ConexionMySQL();

        //Abrir la conexion
        Connection conn = connMySQL.abrirConexion();
        //Crear el objeto que lleva la sentencia a la BD
        PreparedStatement pstmt = conn.prepareStatement(query);
        //Se ejecuta la sentencia y se recibe el resultado
        ResultSet rs = pstmt.executeQuery();

        List<Empleado> empleados = new ArrayList<>();
        //Se recorre el resultado de la consulta - rs
        while (rs.next()) {

            Usuario u = new Usuario();
            u.setIdUsuario(rs.getInt("idUsuario"));
            u.setNombreUsuario(rs.getString("nombreUsuario"));
            u.setContrasenia(rs.getString("contrasenia"));
            u.setRol(rs.getString("rol"));

            Sucursal s = new Sucursal();
            s.setIdSucursal(rs.getInt("idSucursal"));
            s.setNombre(rs.getString("nombreSucursal"));
            s.setTitular(rs.getString("titularSucursal"));
            s.setRfc(rs.getString("rfcSucursal"));
            s.setDomicilio(rs.getString("domicilioSucursal"));
            s.setColonia(rs.getString("colonia"));
            s.setCodigoPostal(rs.getString("cpSucursal"));
            s.setCiudad(rs.getString("ciudadSucursal"));
            s.setEstado(rs.getString("estadoSucursal"));
            s.setTelefono(rs.getString("telefonoSucursal"));
            s.setLatitud(rs.getString("latitudSucursal"));
            s.setLongitud(rs.getString("longitudSucursal"));
            s.setEstatus(rs.getInt("estatusSucursal"));

            Persona p = new Persona();
            p.setIdPersona(rs.getInt("idPersona"));
            p.setNombre(rs.getString("nombre"));
            p.setApellidoPaterno(rs.getString("apellidoPaterno"));
            p.setApellidoMaterno(rs.getString("apellidoMaterno"));
            p.setGenero(rs.getString("genero"));
            p.setFechaNacimiento(rs.getString("fechaNacimiento"));
            p.setRfc(rs.getString("rfc"));
            p.setCurp(rs.getString("curp"));
            p.setDomicilio(rs.getString("domicilio"));
            p.setCodigoPostal(rs.getString("codigoPostal"));
            p.setCiudad(rs.getString("ciudad"));
            p.setEstado(rs.getString("estado"));
            p.setTelefono(rs.getString("telefono"));
            p.setFoto(rs.getString("foto"));

            Empleado e = new Empleado();
            e.setIdEmpleado(rs.getInt("idEmpleado"));
            e.setCodigo(rs.getString("codigo"));
            e.setFechaIngreso(rs.getString("fechaIngreso"));
            e.setPuesto(rs.getString("puesto"));
            e.setSalarioBruto(rs.getFloat("salarioBruto"));
            e.setEmail(rs.getString("email"));
            e.setActivo(rs.getInt("activo"));
            e.setPersona(p);
            e.setSucursal(s);
            e.setUsuario(u);

            empleados.add(e);
        }
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.cerrarConexion(conn);

        return empleados;
    }

    public void delete(Empleado e) throws ClassNotFoundException {
        try {
            //1. Generar la consulta
            String query = "UPDATE empleado SET activo=0 WHERE idEmpleado=" + e.getIdEmpleado() + ";";
            //2.Generar la conexion con el gestor
            ConexionMySQL objConnMySQL = new ConexionMySQL();
            //3.Abrir la conexion
            Connection conn = objConnMySQL.abrirConexion();
            //4.Crear objeto que lleva la sentencia - Stament
            Statement stmt = conn.createStatement();
            //5.Ejecutar la query
            stmt.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void activar(Empleado e) throws ClassNotFoundException {
        try {
            //1. Generar la consulta
            String query = "UPDATE empleado SET activo=1 WHERE idEmpleado=" + e.getIdEmpleado() + ";";
            //2.Generar la conexion con el gestor
            ConexionMySQL objConnMySQL = new ConexionMySQL();
            //3.Abrir la conexion
            Connection conn = objConnMySQL.abrirConexion();
            //4.Crear objeto que lleva la sentencia - Stament
            Statement stmt = conn.createStatement();
            //5.Ejecutar la query
            stmt.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int insert(Empleado e) throws ClassNotFoundException, SQLException, IOException {
        //1. Generar la sentencia SQL
        String query = "{call insertarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        //2. Crear la conexión a la BD
        ConexionMySQL conMySQL = new ConexionMySQL();
        //3. Se abre la conexión
        Connection conn = conMySQL.abrirConexion();
        //4. Crear el statement que llevara la consulta
        CallableStatement cstm = conn.prepareCall(query);
        //5. LLenar todos los parametros de la llamada al Procedure
        cstm.setString(1, e.getPersona().getNombre());
        cstm.setString(2, e.getPersona().getApellidoPaterno());
        cstm.setString(3, e.getPersona().getApellidoMaterno());
        cstm.setString(4, e.getPersona().getGenero());
        cstm.setString(5, e.getPersona().getFechaNacimiento());
        cstm.setString(6, e.getPersona().getRfc());
        cstm.setString(7, e.getPersona().getCurp());
        cstm.setString(8, e.getPersona().getDomicilio());
        cstm.setString(9, e.getPersona().getCodigoPostal());
        cstm.setString(10, e.getPersona().getCiudad());
        cstm.setString(11, e.getPersona().getEstado());
        cstm.setString(12, e.getPersona().getTelefono());
        cstm.setString(13, e.getPersona().getFoto());

        cstm.setInt(14, e.getSucursal().getIdSucursal());

        cstm.setString(15, e.getUsuario().getNombreUsuario());
        cstm.setString(16, e.getUsuario().getContrasenia());
        cstm.setString(17, e.getUsuario().getRol());

        cstm.setString(18, e.getEmail());
        cstm.setString(19, e.getPuesto());
        cstm.setFloat(20, e.getSalarioBruto());

        cstm.registerOutParameter(21, Types.INTEGER);
        cstm.registerOutParameter(22, Types.INTEGER);
        cstm.registerOutParameter(23, Types.INTEGER);
        cstm.registerOutParameter(24, Types.VARCHAR);

        //6.Ejecutar la sentencia
        cstm.execute();
        //7. Obtener todos los parametros de retorno
        e.getPersona().setIdPersona(cstm.getInt(21));
        e.getUsuario().setIdUsuario(cstm.getInt(22));
        e.setIdEmpleado(cstm.getInt(23));
        e.setCodigo(cstm.getString(24));

        //8. Cerrar los objetos
        cstm.close();
        conn.close();
        conMySQL.cerrarConexion(conn);

        return e.getIdEmpleado();
    }

    public int update(Empleado e) throws ClassNotFoundException, SQLException, IOException {
        //1. Generar la sentencia SQL
        String query = "{call modificarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        //2. Crear la conexión a la BD
        ConexionMySQL conMySQL = new ConexionMySQL();
        //3. Se abre la conexión
        Connection conn = conMySQL.abrirConexion();
        //4. Crear el statement que llevara la consulta
        CallableStatement cstm = conn.prepareCall(query);
        //5. LLenar todos los parametros de la llamada al Procedure
        cstm.setInt(1, e.getIdEmpleado());
        cstm.setString(2, e.getPersona().getNombre());
        cstm.setString(3, e.getPersona().getApellidoPaterno());
        cstm.setString(4, e.getPersona().getApellidoMaterno());
        cstm.setString(5, e.getPersona().getGenero());
        cstm.setString(6, e.getPersona().getFechaNacimiento());
        cstm.setString(7, e.getPersona().getRfc());
        cstm.setString(8, e.getPersona().getCurp());
        cstm.setString(9, e.getPersona().getDomicilio());
        cstm.setString(10, e.getPersona().getCodigoPostal());
        cstm.setString(11, e.getPersona().getCiudad());
        cstm.setString(12, e.getPersona().getEstado());
        cstm.setString(13, e.getPersona().getTelefono());
        cstm.setString(14, e.getPersona().getFoto());

        cstm.setString(15, e.getUsuario().getNombreUsuario());
        cstm.setString(16, e.getUsuario().getContrasenia());
        cstm.setString(17, e.getUsuario().getRol());

        cstm.setString(18, e.getEmail());
        cstm.setString(19, e.getPuesto());
        cstm.setFloat(20, e.getSalarioBruto());

        cstm.setInt(21, e.getSucursal().getIdSucursal());

        //6. Ejecutar la sentencia
        cstm.execute();
        //7. Obtener todos los parametros de retorno
//        e.getPersona().setIdPersona(cstm.getInt(22));
//        e.getUsuario().setIdUsuario(cstm.getInt(23));
//        e.setIdEmpleado(cstm.getInt(24));
//        e.setCodigo(cstm.getString(25));

        //8. Cerrar los objetos
        cstm.close();
        conn.close();
        conMySQL.cerrarConexion(conn);

        return e.getIdEmpleado();
    }

    public List<Sucursal> getAllSucursal() throws SQLException, IOException, ClassNotFoundException {
        List<Sucursal> listaSucursales = new ArrayList<>();

        //1. Crear la sentencia SQL
        String query = "SELECT * FROM sucursal";
        //2. Se establece la conexion con la BD
        ConexionMySQL connMySQL = new ConexionMySQL();
        //3. Se abre la conexion
        Connection conn = connMySQL.abrirConexion();
        //4. Se genera el statement para enviar la consulta
        PreparedStatement pstmt = conn.prepareStatement(query);
        //5. Se prepara un ResultSet para obtener la respuesta de la BD
        ResultSet rs = pstmt.executeQuery();
        //6. Recorrer el rs y extraer los datos

        while (rs.next()) {
            Sucursal s = new Sucursal();
            s.setIdSucursal(rs.getInt("idSucursal"));
            s.setNombre(rs.getString("nombre"));
            s.setTitular(rs.getString("titular"));
            s.setCiudad(rs.getString("ciudad"));
            s.setCodigoPostal(rs.getString("codigoPostal"));
            s.setColonia(rs.getString("colonia"));
            s.setDomicilio(rs.getString("domicilio"));
            s.setEstado(rs.getString("estado"));
            s.setEstatus(rs.getInt("estatus"));
            s.setLatitud(rs.getString("latitud"));
            s.setLongitud(rs.getString("longitud"));
            s.setRfc(rs.getString("rfc"));
            s.setTelefono(rs.getString("telefono"));

            listaSucursales.add(s);
        }

        //7. Cerrar todos los objetos
        rs.close();
        pstmt.close();
        conn.close();
        connMySQL.cerrarConexion(conn);

        //8. Devolver la informacion
        return listaSucursales;
    }
}
