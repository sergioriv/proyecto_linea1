/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_linea1.controller;

import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Sergio Rivera
 */
@Named(value = "menuView")
@RequestScoped
public class MenuView {
    
    private MenuModel model;
 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
 
        /*
        Creacion del menu
        */
        DefaultMenuItem item = DefaultMenuItem.builder()
                .value("Inicio")
                .command("#{menuView.save}")
                .build();
        model.getElements().add(item);
        
        
        model.getElements().add( menu_sign_out() );
    }
    
    private DefaultMenuItem menu_sign_out(){
        DefaultMenuItem cerrar = DefaultMenuItem.builder()
                .value("Cerrar sesión")
                .command("#{menuView.sign_out}")
                .update("messages")
                .icon("pi pi-sign-out")
                .containerStyleClass("ui-menubar-options")
                .build();
        return cerrar;
    }
 
    public MenuModel getModel() {
        return model;
    }
 
    public void save() {
        addMessage("Success", "Data saved");
    }
 
    public void update() {
        addMessage("Success", "Data updated");
    }
 
    public void delete() {
        addMessage("Success", "Data deleted");
    }
    
    public void sign_out(){
        addMessage("Success", "Cerrando");
    }
 
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
