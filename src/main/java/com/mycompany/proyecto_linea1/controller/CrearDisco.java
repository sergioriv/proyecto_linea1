/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.controller;

import com.mycompany.proyecto_linea1.entities.EArtista;
import com.mycompany.proyecto_linea1.entities.EDisco;
import com.mycompany.proyecto_linea1.repo.DaoArtista;
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

@Named(value = "discoCrear")
@ViewScoped
public class CrearDisco implements Serializable{
    
    private List<Integer> idArtista;
    private List<String> nombreArtista; 
    private Integer idArt;
    private String Nombre; 
    private Integer Valor;
    int id = 0;
    
    public CrearDisco() {
        DaoArtista daA = new DaoArtista();
        
        idArtista = new ArrayList<Integer>();
        nombreArtista = new ArrayList<String>();
        
        idArtista.addAll(daA.listaIdArtistas());
        nombreArtista.addAll(daA.listaNombreArtistas());
    }
    
    public void save() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        DaoDisco daD = new DaoDisco();
        EDisco disco = new EDisco();
        disco.setIdArtista(idArt);
        disco.setNombre(Nombre);
        disco.setValor(Valor);
        id = daD.agregarDisco(disco);
        if(id!=0){
            context.addMessage(null, new FacesMessage("Disco registrado"));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Disco no registrado", ""));
        }
    }

    public Integer getIdArt() {
        return idArt;
    }

    public void setIdArt(Integer idArt) {
        this.idArt = idArt;
    }

    public Integer getValor() {
        return Valor;
    }

    public void setValor(Integer Valor) {
        this.Valor = Valor;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public List<Integer> getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(List<Integer> idArtista) {
        this.idArtista = idArtista;
    }

    public List<String> getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(List<String> nombreArtista) {
        this.nombreArtista = nombreArtista;
    }
}
