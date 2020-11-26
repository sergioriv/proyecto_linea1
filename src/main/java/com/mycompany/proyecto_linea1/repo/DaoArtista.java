/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.repo;

import com.mycompany.proyecto_linea1.entities.EArtista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DaoArtista {

    private final String db = "jdbc:postgresql://localhost:5432/lineaUno";
    private final String usuarioP = "postgres";
    private final String contrasenaServer = "1234";
    
    public EArtista listaArtistas(){    
     try {
            EArtista artistas = new EArtista();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.select_artist_top()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                artistas.setId(result.getInt(1));
                artistas.setNombre(result.getString(2));
                artistas.setNacionalidad(result.getString(3));
                artistas.setGenero(result.getString(4));
                artistas.setFechaNacimiento(result.getDate(5));
                artistas.setFoto(result.getString(6));
                artistas.setTotal(result.getInt(7));
                System.out.println(result.getInt(1));
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
    
    public List<String> listaNombreArtistas(){    
     try {
            List<String> artistas = new ArrayList<>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.select_artist()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                artistas.add(result.getString(2));
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
    
    public List<Integer> listaIdArtistas(){    
     try {
            List<Integer> artistas = new ArrayList<>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.select_artist()}");
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
    
    public ArrayList<String> listaGenero(){
        try {
            ArrayList<String> genero = new ArrayList<>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.enum_gender()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                genero.add(result.getString(1));
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
    
    public ArrayList<String> listaNacionalidad(){
        try {
            ArrayList<String> nacionalidad = new ArrayList<>();
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.enum_nationality()}");
            ResultSet result = process.executeQuery();
            while(result.next()){
                nacionalidad.add(result.getString(1));
            }
            conec.close();
            return nacionalidad;
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int agregarArtista(EArtista artista){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conec = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            CallableStatement process = conec.prepareCall("{call public.create_artist(?,?::nationality,?::gender,?,?)}");
            process.setString(1, artista.getNombre());
            process.setString(2, artista.getNacionalidad());
            process.setString(3, artista.getGenero());
            process.setDate(4, artista.getFechaNacimiento());
            process.setString(5, artista.getFoto());
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
}
