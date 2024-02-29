package org.utl.dsm403.sicefa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm403.sicefa.model.Inventario;

public class Main {

    public static void main(String[] args) {
        try {
            ControllerInventario cp = new ControllerInventario();
            List<Inventario> pedidos = cp.getAllUno();
            System.out.println(pedidos);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
