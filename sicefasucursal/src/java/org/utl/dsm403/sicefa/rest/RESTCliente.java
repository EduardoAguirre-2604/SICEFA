/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm403.sicefa.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
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
import org.utl.dsm403.sicefa.controller.ControllerCliente;
import org.utl.dsm403.sicefa.model.Cliente;

/**
 *
 * @author perez
 */
@Path("cliente")
public class RESTCliente {
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("activo") @DefaultValue("true") boolean activo) {
        String out = "";
        try {
            ControllerCliente objCE = new ControllerCliente();
            List<Cliente> listaClientes = activo ? objCE.getAllActivos() : objCE.getAllInactivos();

            Gson objGson = new Gson();
            out = objGson.toJson(listaClientes);

        } catch (SQLException ex) {
            out = "{\"error\":\"Se produjo un error en la ejecucion\"}";
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(RESTEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(out).build();
    }
    
    @Path("delete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("idC") @DefaultValue("0") String idC) throws ClassNotFoundException {
        Cliente c = new Cliente();
        c.setIdCliente(Integer.parseInt(idC));
        ControllerCliente objCC = new ControllerCliente();
        objCC.delete(c);
        String out = "{\"result\":\"Cliente Desactivado Satisfactoriamente \"}";
        return Response.ok(out).build();
    }

    @Path("regresar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response regresar(@QueryParam("idCli") @DefaultValue("0") String idCli) throws ClassNotFoundException {
        Cliente c = new Cliente();
        c.setIdCliente(Integer.parseInt(idCli));
        ControllerCliente objCE = new ControllerCliente();
        objCE.regresar(c);
        String out = "{\"result\":\"activo\"}";
        return Response.ok(out).build();
    }
    
    
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("c") @DefaultValue("") String cliente) throws IOException, ClassNotFoundException {
        Gson objGson = new Gson();

        Cliente c = objGson.fromJson(cliente, Cliente.class);

        String out = "";

        ControllerCliente objCE = new ControllerCliente();
        try {
            int resultado = objCE.insert(c);

            if (resultado > 0) {
                out = "{\"result\":\"Cliente insertado correctamente\"}";
            } else {
                out = "{\"result\":\"No se encontró el cliente a actualizar\"}";
            }

        } catch (SQLException ex) {
            out = "{\"result\":\"Error al insertar el cliente: " + ex.getMessage() + "\"}";
        }
        return Response.ok(out).build();
    }
    
    @Path("update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("c")  @DefaultValue("0") String cliente) {
        Gson objGson = new Gson();
        Cliente c = objGson.fromJson(cliente, Cliente.class);

        String out;
        ControllerCliente objCE = new ControllerCliente();

        try {
            int resultado = objCE.update(c);

            if (resultado > 0) {
                out = "{\"result\":\"Se modifico el cliente exitosamente\"}";
            } else {
                out = "{\"error\":\"No se encontró el cliente a modificar\"}";
            }

        } catch (SQLException | ClassNotFoundException | IOException ex) {
            out = "{\"result\":\"Error al actualizar el cliente: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }
}


