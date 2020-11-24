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
        Creacion del menu ADMIN
        */        
        DefaultMenuItem canciones_top = DefaultMenuItem.builder()
                .value("Top Canciones")
                .command("#{menuView.canciones_top}")
                .build();
        model.getElements().add(canciones_top); 
        
        DefaultMenuItem genero_top = DefaultMenuItem.builder()
                .value("Top Genero")
                .command("#{menuView.genero_top}")
                .build();
        model.getElements().add(genero_top);
        
        DefaultMenuItem artista_top = DefaultMenuItem.builder()
                .value("Artista TOP")
                .command("#{menuView.artista_top}")
                .build();
        model.getElements().add(artista_top);
        
        DefaultMenuItem artista = DefaultMenuItem.builder()
                .value("Crear artista")
                .command("#{menuView.artista}")
                .build();
        model.getElements().add(artista); 
        
        
        /*
        Creacion del menu COMPRADOR
        */ 
        DefaultMenuItem discos = DefaultMenuItem.builder()
                .value("Discos")
                .command("#{menuView.discos}")
                .build();
        model.getElements().add(discos);        
        
        DefaultMenuItem canciones = DefaultMenuItem.builder()
                .value("Canciones")
                .command("#{menuView.canciones}")
                .build();
        model.getElements().add(canciones);  
        
        DefaultMenuItem carrito = DefaultMenuItem.builder()
                .value("Carrito")
                .command("#{menuView.carrito}")
                .build();
        model.getElements().add(carrito);
        
        
        /*
         Elemento cerrar sesion
        */
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
       
    public String canciones_top(){
        return "canciones_top?faces-redirect=true";
    }
       
    public String genero_top(){
        return "genero_top?faces-redirect=true";
    }
       
    public String artista_top(){
        return "artista_top?faces-redirect=true";
    }
       
    public String artista(){
        return "artista?faces-redirect=true";
    }
    
    public static String crear_disco(){
        return "disco?faces-redirect=true";
    }
    
    public static String crear_cancion(){
        return "cancion?faces-redirect=true";
    }

    public String discos(){
        return "discos?faces-redirect=true";
    }
       
    public String canciones(){
        return "canciones?faces-redirect=true";
    }
       
    public String carrito(){
        return "carrito?faces-redirect=true";
    }
    
    public void sign_out(){
        addMessage("Success", "Cerrando");
    }
 
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
