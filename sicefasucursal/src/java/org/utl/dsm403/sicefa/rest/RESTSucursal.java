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
import org.utl.dsm403.sicefa.controller.ControllerSucursal;
import org.utl.dsm403.sicefa.model.Sucursal;

/**
 *
 * @author Aaron
 */
@Path("sucursal")
public class RESTSucursal {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("estatus") @DefaultValue("true") boolean estatus) throws IOException {
        String out = "";
        try {

            ControllerSucursal cu = new ControllerSucursal();
            List<Sucursal> listaSucursal = estatus ? cu.getAllActivas() : cu.getAllInactivas();
            Gson objGson = new Gson();
            out = objGson.toJson(listaSucursal);
        } catch (SQLException ex) {
            out = "{\"error\":\"Se produjo un error\"}";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RESTSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(out).build();
    }

    @Path("deleteSuc")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSuc(@QueryParam("idS") @DefaultValue("") String idS) throws ClassNotFoundException {
        Sucursal s = new Sucursal();
        s.setIdSucursal(Integer.parseInt(idS));
        ControllerSucursal objSU = new ControllerSucursal();
        objSU.deleteSuc(s);
        String out = "{\"response\":\"ok\"}";
        return Response.ok(out).build();
    }

    @Path("activeSuc")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response activarSuc(@QueryParam("idSuc") @DefaultValue("0") String idSuc) throws ClassNotFoundException {
        Sucursal s = new Sucursal();
        s.setIdSucursal(Integer.parseInt(idSuc));
        ControllerSucursal objSuc = new ControllerSucursal();
        objSuc.activarSuc(s);
        String out = "{\"response\":\"ok\"}";
        return Response.ok(out).build();
    }
    @Path("insertarSucursal")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarSucursal(@FormParam("s") @DefaultValue("") String sucursal) throws IOException, ClassNotFoundException{
        Gson objGson = new Gson();
        Sucursal s = objGson.fromJson(sucursal, Sucursal.class);
        String out = "";
        ControllerSucursal objSU = new ControllerSucursal();
        
        try {
            int resultado = objSU.insertarSucursal(s);

            if (resultado > 0) {
                out = "{\"result\":\"Sucursal insertada exitosamente\"}";
            } else {
                out = "{\"result\":\"Sucursal insertada \"}";
            }

        } catch (SQLException  ex) {
            out = "{\"result\":\"Error al insertar la sucursal: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }
    
    @Path("update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarSucursal(@FormParam("suc") @DefaultValue("") String suc) throws IOException, ClassNotFoundException{
        Gson objGson = new Gson();
        Sucursal s = objGson.fromJson(suc, Sucursal.class);
        String out = "";
        ControllerSucursal objSU = new ControllerSucursal();
        
        try {
            int resultado = objSU.updateSucursal(s);

            if (resultado > 0) {
                out = "{\"result\":\"Datos modificados exitosamente\"}";
            } else {
                out = "{\"result\":\"Sucursal modifcada \"}";
            }

        } catch (SQLException  ex) {
            out = "{\"result\":\"Error al modificar la sucursal: " + ex.getMessage() + "\"}";
        }

        return Response.ok(out).build();
    }
}
