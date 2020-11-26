/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_linea1.controller;

import com.mycompany.proyecto_linea1.entities.ECancion;
import com.mycompany.proyecto_linea1.repo.DaoCancion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Sergio Rivera
 */
@Named(value = "cancionesBean")
@RequestScoped
public class cancionesBean implements Serializable {

    private List<ECancion> cancion;
    
    public cancionesBean() {
        DaoCancion daC = new DaoCancion();
       
        cancion = new ArrayList<ECancion>();
        
        cancion.addAll(daC.listaCancionesTop());
    }
    
    public String crear(){
        String redirect = MenuView.crear_cancion();
        return redirect;
    }

    public List<ECancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<ECancion> cancion) {
        this.cancion = cancion;
    }
}
