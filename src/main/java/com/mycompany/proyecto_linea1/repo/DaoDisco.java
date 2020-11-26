/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.repo;

import com.mycompany.proyecto_linea1.entities.EDisco;
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
public class DaoDisco {
    
    private final String db = "jdbc:postgresql://localhost:5432/lineaUno";
    private final String usuarioP = "postgres";
    private final String contrasenaServer = "1234";
    
    public int agregarDisco(EDisco disco){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.create_disc(?,?,?)}");
            process.setInt(1, disco.getIdArtista());
            process.setString(2, disco.getNombre());
            process.setInt(3, disco.getValor());
            ResultSet result = process.executeQuery();
            while(result.next()){
                return result.getInt(1);
            }
            conec.close();
        } catch (SQLException ex) {
            System.out.println("errorrrrrrrrr: " + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<EDisco> listaDiscos(){    
     try {
            List<EDisco> disco = new ArrayList<>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.select_disc()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                EDisco disc = new EDisco();
                disc.setIdDisco(result.getInt(1));
                disc.setNombreArtista(result.getString(2));
                disc.setFotoArtista(result.getString(3));
                disc.setGeneroArtista(result.getString(4));
                disc.setNombre(result.getString(5));
                disc.setValor(result.getInt(6));
                disco.add(disc);
            }
            conec.close();
            return disco;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }

    public List<String> listaNombreDiscos(){    
     try {
            List<String> artistas = new ArrayList<>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.select_disc()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                artistas.add(result.getString(5));
            }
            conec.close();
            return artistas;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
    
    public List<Integer> listaIdDiscos(){    
     try {
            List<Integer> artistas = new ArrayList<>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.select_disc()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                artistas.add(result.getInt(1));
            }
            conec.close();
            return artistas;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
}
