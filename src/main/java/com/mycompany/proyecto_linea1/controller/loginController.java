/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.controller;

import com.mycompany.proyecto_linea1.entities.User;
import com.mycompany.proyecto_linea1.repo.LoginService;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Named(value="ControlLogin")
@RequestScoped
public class loginController{

    private String email;
    private String contraseña;
    
    public loginController(){
        
    }
    
    public void logearse() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        LoginService lo = new LoginService();
        Boolean v = lo.login(email, contraseña);
        if(User.isAdmin()=="Admin"){
            context.getExternalContext().redirect("/proyecto_linea1/faces/secure/admin/canciones_top.xhtml");
        }else{
            context.getExternalContext().redirect("/proyecto_linea1/faces/secure/comprador/discos.xhtml");
        }
        if(v == true){
            context.addMessage(null, new FacesMessage("Welcome"));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales Invalidas", ""));
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
