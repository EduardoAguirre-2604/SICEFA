package org.utl.dsm403.sicefa.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.utl.dsm403.sicefa.controller.ControllerPedido;
import org.utl.dsm403.sicefa.model.Pedido;

@Path("pedido")
public class RESTPedido {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("estatus") @DefaultValue("true") boolean estatus) {
        String out = "";
        try {
            ControllerPedido cp = new ControllerPedido();
            List<Pedido> listaPedidos = estatus ? cp.getAllPendientes() : cp.getAllAtendidos();
            Gson objGson = new Gson();
            out = objGson.toJson(listaPedidos);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            out = "{\"error\":\"Se produjo un error en la ejecución\"}";
        }
        return Response.ok(out).build();
    }

    @Path("atender")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response atender(@QueryParam("idCompra") @DefaultValue("0") int idCompra) {
        String out = "";
        try {
            ControllerPedido objPE = new ControllerPedido();
            objPE.atenderPedido(idCompra);
            out = "{\"response\":\"OK\"}";
            
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            out = "{\"error\":\"Se produjo un error en la ejecución\"}";
        }
        return Response.ok(out).build();
    }
}
