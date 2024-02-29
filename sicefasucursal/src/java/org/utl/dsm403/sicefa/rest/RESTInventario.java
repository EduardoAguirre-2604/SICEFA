/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm403.sicefa.rest;
import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm403.sicefa.controller.ControllerInventario;
import org.utl.dsm403.sicefa.model.Inventario;

@Path("inventario")
public class RESTInventario {
    
    @Path("getAllUno")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getAllUno() {
    try {
        ControllerInventario objCP = new ControllerInventario();
        List<Inventario> listainventario = objCP.getAllUno();

        Gson objGson = new Gson();
        String out = objGson.toJson(listainventario);

        return Response.ok(out).build();
    } catch (SQLException ex) {
        ex.printStackTrace(); // Imprime la traza de la excepción en la consola (se recomienda tener un mejor manejo de logs en producción)
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("{\"error\":\"Se produjo un error en la ejecución debido a una SQLException\"}")
                .build();
    } catch (ClassNotFoundException | IOException ex) {
        ex.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("{\"error\":\"Se produjo un error en la ejecución debido a una excepción de tipo ClassNotFoundException o IOException\"}")
                .build();
    }
}

    
    @Path("getAllDos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDos() {
        String out = "";
        try {
            ControllerInventario objCP = new ControllerInventario();
            List<Inventario> listainventario = objCP.getAllDos();

            Gson objGson = new Gson();
            out = objGson.toJson(listainventario);

        } catch (SQLException ex) {
            out = "{\"error\":\"Se produjo un error en la ejecucionn\"}";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RESTEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RESTEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(out).build();
    }
    
    @Path("getAllTres")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTres() {
        String out = "";
        try {
            ControllerInventario objCP = new ControllerInventario();
            List<Inventario> listainventario = objCP.getAllTres();

            Gson objGson = new Gson();
            out = objGson.toJson(listainventario);

        } catch (SQLException ex) {
            out = "{\"error\":\"Se produjo un error en la ejecucionn\"}";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RESTEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RESTEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(out).build();
    }
}
