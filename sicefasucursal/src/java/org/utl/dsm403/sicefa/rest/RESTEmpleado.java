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
import org.utl.dsm403.sicefa.controller.ControllerEmpleado;
import org.utl.dsm403.sicefa.model.Empleado;
import org.utl.dsm403.sicefa.model.Sucursal;

@Path("empleado")
public class RESTEmpleado {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("activo") @DefaultValue("true") boolean activo) {
        String out = "";
        try {
            ControllerEmpleado objCE = new ControllerEmpleado();
            List<Empleado> listaEmpleados = activo ? objCE.getAllActivos() : objCE.getAllInactivos();
            Gson objGson = new Gson();
            out = objGson.toJson(listaEmpleados);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            out = "{\"error\":\"Se produjo un error en la ejecución\"}";
        }
        return Response.ok(out).build();
    }

    @Path("delete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("idE") @DefaultValue("0") String idE) throws ClassNotFoundException {
        Empleado e = new Empleado();
        e.setIdEmpleado(Integer.parseInt(idE));
        ControllerEmpleado objCE = new ControllerEmpleado();
        objCE.delete(e);
        String out = "{\"response\":\"OK\"}";
        return Response.ok(out).build();
    }

    @Path("activar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response activar(@QueryParam("idE") @DefaultValue("0") String idE) throws ClassNotFoundException {
        Empleado e = new Empleado();
        e.setIdEmpleado(Integer.parseInt(idE));
        ControllerEmpleado objCE = new ControllerEmpleado();
        objCE.activar(e);
        String out = "{\"response\":\"OK\"}";
        return Response.ok(out).build();
    }

    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("e") @DefaultValue("") String empleado) throws ClassNotFoundException, IOException {
        Gson objGson = new Gson();
        Empleado e = objGson.fromJson(empleado, Empleado.class);

        String out = "";

        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            int idEmpleadoGenerado = objCE.insert(e);
            out = "{\"result\":\"Empleado insertado exitosamente\"}";
            out = String.format(out, idEmpleadoGenerado);
        } catch (SQLException ex) {
            out = "{\"result\":\"Error al insertar el empleado: " + ex.getMessage() + "\"}";
        }
        return Response.ok(out).build();
    }

    @Path("update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("e") String empleado) {
        Gson objGson = new Gson();
        Empleado e = objGson.fromJson(empleado, Empleado.class);

        String out;
        ControllerEmpleado objCE = new ControllerEmpleado();

        try {
            int resultado = objCE.update(e);

            if (resultado > 0) {
                out = "{\"result\":\"Empleado actualizado exitosamente\"}";
            } else {
                out = "{\"result\":\"No se encontró el empleado a actualizar\"}";
            }

        } catch (SQLException | ClassNotFoundException | IOException ex) {
            out = "{\"result\":\"Error al actualizar el empleado: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }

    @Path("getAllSuc")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSucursales() throws IOException, ClassNotFoundException {
        ControllerEmpleado objCE = new ControllerEmpleado();
        String out = "";
        try {
            List<Sucursal> listaSuc = objCE.getAllSucursal();
            Gson objGson = new Gson();
            out = objGson.toJson(listaSuc);
        } catch (SQLException ex) {
            out = "{\"error\":\"No se pudo cargar la información\"}";
        }
        return Response.ok(out).build();
    }
}
