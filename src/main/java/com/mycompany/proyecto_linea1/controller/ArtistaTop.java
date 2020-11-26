/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.controller;

import com.mycompany.proyecto_linea1.entities.EArtista;
import com.mycompany.proyecto_linea1.repo.DaoArtista;
import java.io.Serializable;
import java.sql.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

@Named(value="artistaTopBean")
@ViewScoped
public class ArtistaTop implements Serializable{

    private String foto;
    private String nombre;
    private Integer totalVentas;
    private String genero;
    private String nacionalidad;
    private Date nacimiento;
    
    public ArtistaTop(){
        DaoArtista artista = new DaoArtista();
        EArtista art = new EArtista();
        art = artista.listaArtistas();
        foto = art.getFoto();
        nombre = art.getNombre();
        totalVentas = art.getTotal();
        genero = art.getGenero();
        nacionalidad = art.getNacionalidad();
        nacimiento = art.getFechaNacimiento();
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Integer totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    
    
    
}
