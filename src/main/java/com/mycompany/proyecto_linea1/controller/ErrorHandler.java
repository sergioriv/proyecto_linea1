/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Named(value = "errorHandler")
@RequestScoped
public class ErrorHandler {
    
    private String codigo;

    /**
     * Creates a new instance of ErrorHandler
     */
    public ErrorHandler() {
        
    }
    
   public String getStatusCode() {

        String val = String.valueOf((Integer) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.status_code"));
        
        codigo = val;
        return val;

    }

    public String getMessage() {

        String val = (String) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.message");

        return val;

    }
    
   public String getException() {

        if(!codigo.equals("404")) {
            String val = (String) ((Exception) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.exception")).toString();      

            return val;
        } else {
            return "";
        }
    }
   
    public String getExceptionType() {
        if(!codigo.equals("404")) {
            String val = FacesContext.getCurrentInstance().getExternalContext().
                    getRequestMap().get("javax.servlet.error.exception_type").toString();

            return val;
        } else 
            return "";

    }   

    public String getRequestURI() {

        return (String) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.request_uri");

    }

    public String getServletName() {

        return (String) FacesContext.getCurrentInstance().getExternalContext().
                getRequestMap().get("javax.servlet.error.servlet_name");

    }  

}
