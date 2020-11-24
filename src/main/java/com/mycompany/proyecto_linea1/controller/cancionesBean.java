/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_linea1.controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Sergio Rivera
 */
@Named(value = "cancionesBean")
@RequestScoped
public class cancionesBean implements Serializable {

    /**
     * Creates a new instance of cancionesBean
     */
    public cancionesBean() {
    }
    
    public String crear(){
        
        String redirect = MenuView.crear_cancion();
        return redirect;
    }
    
}
