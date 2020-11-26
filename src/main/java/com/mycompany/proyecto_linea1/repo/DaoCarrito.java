/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.repo;

import com.mycompany.proyecto_linea1.entities.User;
import com.mycompany.proyecto_linea1.entities.ECancion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DaoCarrito {

    private final String db = "jdbc:postgresql://localhost:5432/lineaUno";
    private final String usuarioP = "postgres";
    private final String contrasenaServer = "1234";
    
    public Boolean comprar(Boolean disc,Integer id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.create_sale(?,?)}");
            process.setBoolean(1, disc);
            process.setInt(2, id);
            ResultSet result = process.executeQuery();
            while(result.next()){
                User u = new User();
                u.setId(id);
                return true;
            }
            conec.close();
        } catch (SQLException ex) {
            System.out.println("errorrrrrrrrr: " + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
