/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.controller;

import com.mycompany.proyecto_linea1.entities.ECancion;
import com.mycompany.proyecto_linea1.entities.EDisco;
import com.mycompany.proyecto_linea1.repo.DaoCarrito;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Named(value = "carrito")
@SessionScoped
public class Carrito implements Serializable{
    
    private List<EDisco> disco = new ArrayList<EDisco>();
    private List<ECancion> cancion = new ArrayList<ECancion>();
    private Integer total = 0;

    public Carrito(){
        
    }
    
    public void save(){
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        DaoCarrito ca = new DaoCarrito();
        if(!disco.isEmpty()){
            for (EDisco eDisco : disco) {
                ca.comprar(true, eDisco.getIdDisco());
            }
            disco.clear();
        }
        
        if(!cancion.isEmpty()){
            for (ECancion eCancion: cancion) {
                ca.comprar(false, eCancion.getIdCancion());
            }
            cancion.clear();
        }
        total=0;
        if(!cancion.isEmpty() || !disco.isEmpty()){
            context.addMessage(null, new FacesMessage("Gracias por su Compra"));
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    public void addDisc(EDisco discoE){
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        this.disco.add(discoE);
        this.total+=discoE.getValor();
        context.addMessage(null, new FacesMessage("Disco Agregado"));
    }
    
    public void addSong(ECancion cancionE){
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        this.cancion.add(cancionE);
        this.total+=cancionE.getValor();
        context.addMessage(null, new FacesMessage("Cancion Agregada"));
    }
    
    public void deleteDisc(EDisco discoE){
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        this.disco.remove(discoE);
        this.total-=discoE.getValor();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Disco Eliminado", ""));
    }
    
    public void deleteSong(ECancion cancionE){
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        this.cancion.remove(cancionE);
        this.total-=cancionE.getValor();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cancion Eliminada", ""));
    }    
    
    public List<EDisco> getDisco() {
        return disco;
    }

    public void setDisco(List<EDisco> disco) {
        this.disco = disco;
    }

    public List<ECancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<ECancion> cancion) {
        this.cancion = cancion;
    }
}
