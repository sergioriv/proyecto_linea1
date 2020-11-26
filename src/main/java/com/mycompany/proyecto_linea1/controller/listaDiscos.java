/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.controller;

import com.mycompany.proyecto_linea1.entities.ECancion;
import com.mycompany.proyecto_linea1.entities.EDisco;
import com.mycompany.proyecto_linea1.repo.DaoArtista;
import com.mycompany.proyecto_linea1.repo.DaoDisco;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Named(value = "discoLista")
@RequestScoped
public class listaDiscos implements Serializable{

    private List<EDisco> discos;
    
    public listaDiscos(){
        DaoDisco daD = new DaoDisco();
        
        discos = new ArrayList<EDisco>();
        
        discos.addAll(daD.listaDiscos());
    }

    public List<EDisco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<EDisco> discos) {
        this.discos = discos;
    }
}
