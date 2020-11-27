/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.repo;

import com.mycompany.proyecto_linea1.entities.User;
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
public class LoginService {
    
    private final String db = "jdbc:postgresql://localhost:5432/lineaUno";
    private final String usuarioP = "postgres";
    private final String contrasenaServer = "root";
    
    public Boolean login(String user, String password){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.login(?,?)}");
            process.setString(1, user);
            process.setString(2, password);
            ResultSet result = process.executeQuery();
            while(result.next()){
                User u = new User();
                u.setId(result.getInt(2));
                u.setNombre(result.getString(3));
                if(result.getBoolean(5)==true){
                    u.setAdmin("Admin");
                    return true;
                }else{
                    u.setAdmin("Comprador");
                    return true;
                }
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
