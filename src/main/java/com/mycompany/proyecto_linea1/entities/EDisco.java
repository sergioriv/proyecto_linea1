/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.entities;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class EDisco {
    
    private Integer idDisco;
    private Integer idArtista;
    private String fotoArtista; 
    private String nombreArtista; 
    private String generoArtista; 
    private String nombre; 
    private Integer valor;

    public String getFotoArtista() {
        return fotoArtista;
    }

    public void setFotoArtista(String fotoArtista) {
        this.fotoArtista = fotoArtista;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getGeneroArtista() {
        return generoArtista;
    }

    public void setGeneroArtista(String generoArtista) {
        this.generoArtista = generoArtista;
    }

    
    
    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
