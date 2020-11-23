/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_linea1.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Sergio Rivera
 */
@Named(value = "index")
@RequestScoped
public class index {
    
    private String valor = "valooor";

    /**
     * Creates a new instance of index
     */
    public index() {
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
