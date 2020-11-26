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
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Named(value = "cancionLista")
@ViewScoped
public class listaCanciones implements Serializable{
    
    private List<ECancion> cancion;
    
    public listaCanciones(){
        DaoCancion daC = new DaoCancion();
       
        cancion = new ArrayList<ECancion>();
        
        cancion.addAll(daC.listaCanciones());
    }

    public List<ECancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<ECancion> cancion) {
        this.cancion = cancion;
    }
}
