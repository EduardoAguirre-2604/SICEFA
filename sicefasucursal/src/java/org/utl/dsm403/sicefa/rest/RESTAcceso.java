package org.utl.dsm403.sicefa.rest;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import org.utl.dsm403.sicefa.controller.ControllerAcceso;

/**
 *
 * @author oscar
 */
@Path("acceso")
public class RESTAcceso {

    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("u") @DefaultValue("") String u, @FormParam("c") @DefaultValue("") String c) {
        String out = "";
        try {
            ControllerAcceso objCA = new ControllerAcceso();
            String tu = objCA.login(u, c);
            out = "{\"rol\":\"" + tu + "\"}";
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            out = "{\"error\":\"" + ex.getLocalizedMessage() + "\"}";
        }
        return Response.ok(out).build();
    }
}
