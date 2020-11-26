/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.repo;

import com.mycompany.proyecto_linea1.entities.EGenero;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DaoGenero {

    private final String db = "jdbc:postgresql://localhost:5432/lineaUno";
    private final String usuarioP = "postgres";
    private final String contrasenaServer = "1234";
    
    public List<EGenero> listaGeneroTop(){    
     try {
            List<EGenero> genero = new ArrayList<EGenero>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.select_gender_top()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                EGenero gender = new EGenero();
                gender.setNombre(result.getString(1));
                gender.setValor(result.getInt(2));
                genero.add(gender);
            }
            conec.close();
            return genero;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
    
}
