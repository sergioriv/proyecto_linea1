/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.controller;

import com.mycompany.proyecto_linea1.entities.ECancion;
import com.mycompany.proyecto_linea1.entities.EDisco;
import com.mycompany.proyecto_linea1.repo.DaoArtista;
import com.mycompany.proyecto_linea1.repo.DaoCancion;
import com.mycompany.proyecto_linea1.repo.DaoDisco;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Named(value = "cancionCrear")
@ViewScoped
public class CrearCancion implements Serializable{
    
    private List<Integer> idDisco;
    private List<String> nombreDisco; 
    private Integer idDisc;
    private String Nombre; 
    private Integer Valor;
    int id = 0;
    
    public CrearCancion(){
        DaoDisco daE = new DaoDisco();
        
        idDisco = new ArrayList<Integer>();
        nombreDisco = new ArrayList<String>();
        
        idDisco.addAll(daE.listaIdDiscos());
        nombreDisco.addAll(daE.listaNombreDiscos());
    }

    
    public void save() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        DaoCancion daC = new DaoCancion();
        ECancion cancion = new ECancion();
        cancion.setIdDisco(idDisc);
        cancion.setNombre(Nombre);
        cancion.setValor(Valor);
        id = daC.agregarCancion(cancion);
        if(id!=0){
            context.addMessage(null, new FacesMessage("Cancion registrada"));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cancion no registrada", ""));
        }
    }
    
    public List<Integer> getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(List<Integer> idDisco) {
        this.idDisco = idDisco;
    }

    public List<String> getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(List<String> nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public Integer getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(Integer idDisc) {
        this.idDisc = idDisc;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getValor() {
        return Valor;
    }

    public void setValor(Integer Valor) {
        this.Valor = Valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
