/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm403.sicefa.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm403.sicefa.controller.ControllerProducto;
import org.utl.dsm403.sicefa.model.Producto;

/**
 *
 * @author hp
 */
@Path("producto")
public class RESTProducto {
    
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("estatus") @DefaultValue("true") boolean estatus) {
        String out = "";
        try {
            ControllerProducto objCP = new ControllerProducto();
            List<Producto> listaProductos = estatus ? objCP.getAllActivos() : objCP.getAllInactivos();

            Gson objGson = new Gson();
            out = objGson.toJson(listaProductos);

        } catch (SQLException ex) {
            out = "{\"error\":\"Se produjo un error en la ejecucion\"}";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RESTEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RESTEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(out).build();
    }
    
    
    @Path("delete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("idP") @DefaultValue("0") String idP) throws ClassNotFoundException {
        Producto p = new Producto();
        p.setIdProducto(Integer.parseInt(idP));
        ControllerProducto objCP = new ControllerProducto();
        objCP.delete(p);
        String out = "{\"result\":\"Producto Desactivado Satisfactoriamente \"}";
        return Response.ok(out).build();
    }
    
    @Path("regresar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response regresar(@QueryParam("idPr") @DefaultValue("0") String idPr) throws ClassNotFoundException {
        Producto p = new Producto();
        p.setIdProducto(Integer.parseInt(idPr));
        ControllerProducto objCP = new ControllerProducto();
        objCP.regresar(p);
        String out = "{\"result\":\"activo\"}";
        return Response.ok(out).build();
    }
    
    
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("p") @DefaultValue("") String producto) throws IOException, ClassNotFoundException {
        Gson objGson = new Gson();

        Producto p = objGson.fromJson(producto, Producto.class);

        String out = "";

        ControllerProducto objCP = new ControllerProducto();
        try {
            int idProductoGenerado = objCP.insert(p);
            out = "{\"result\":\"Productoo insertado exitosamente\"}";
            out = String.format(out, idProductoGenerado);

        } catch (SQLException ex) {
            out = "{\"error\":\"Error al insertar \"}";
        }
        return Response.ok(out).build();
    }
    
    
    @Path("update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("p")  @DefaultValue("0") String producto) {
        Gson objGson = new Gson();
        Producto p = objGson.fromJson(producto, Producto.class);

        String out;
        ControllerProducto objCP = new ControllerProducto();

        try {
            int resultado = objCP.update(p);

            if (resultado > 0) {
                out = "{\"result\":\"Producto actualizado exitosamente\"}";
            } else {
                out = "{\"error\":\"No se encontró el empleado a actualizar\"}";
            }

        } catch (SQLException | ClassNotFoundException | IOException ex) {
            out = "{\"result\":\"Error al actualizar el producto: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }
    
    
    
    
}
