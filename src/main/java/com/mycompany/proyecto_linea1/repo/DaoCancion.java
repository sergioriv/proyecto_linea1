/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.repo;

import com.mycompany.proyecto_linea1.entities.ECancion;
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
public class DaoCancion {

    private final String db = "jdbc:postgresql://localhost:5432/lineaUno";
    private final String usuarioP = "postgres";
    private final String contrasenaServer = "1234";
    
    public int agregarCancion(ECancion cancion){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.create_song(?,?,?)}");
            process.setInt(1, cancion.getIdDisco());
            process.setString(2, cancion.getNombre());
            process.setInt(3, cancion.getValor());
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
    
    public List<ECancion> listaCanciones(){    
     try {
            List<ECancion> cancion = new ArrayList<>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.select_song()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                ECancion song = new ECancion();
                song.setIdCancion(result.getInt(1));
                song.setNombreArtista(result.getString(2));
                song.setFotoArtista(result.getString(3));
                song.setGeneroArtista(result.getString(4));
                song.setNombreDisco(result.getString(5));
                song.setNombre(result.getString(6));
                song.setValor(result.getInt(7));
                cancion.add(song);
            }
            conec.close();
            return cancion;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }
    
    public List<ECancion> listaCancionesTop(){    
     try {
            List<ECancion> cancion = new ArrayList<>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.select_song_top()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                ECancion song = new ECancion();
                song.setNombre(result.getString(1));
                song.setCantidad(result.getInt(2));
                song.setNombreArtista(result.getString(3));
                song.setGeneroArtista(result.getString(4));
                song.setFotoArtista(result.getString(5));
                cancion.add(song);
            }
            conec.close();
            return cancion;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;   
    }    
}
