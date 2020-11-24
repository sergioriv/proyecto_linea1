/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_linea1.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio Rivera
 */
public class Postgresql {

    private final String db = "jdbc:postgresql://localhost:5432/lineaUno";
    private final String usuarioP = "postgres";
    private final String contrasenaServer = "root";

    private static Connection connection = null;

    public String getDb() {
        return db;
    }

    public String getUsuarioP() {
        return usuarioP;
    }

    public String getContrasenaServer() {
        return contrasenaServer;
    }

    public Connection Conectar() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (connection == null) {
            try {
                
                connection = DriverManager.getConnection(db, usuarioP, contrasenaServer);
            } catch (SQLException ex) {
                Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return connection;
    }

}
