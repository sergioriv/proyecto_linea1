/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto_linea1.controller;

import com.mycompany.proyecto_linea1.entities.EArtista;
import com.mycompany.proyecto_linea1.repo.DaoArtista;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.file.UploadedFile;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Named(value = "artistaCrear")
@ViewScoped
public class CrearArtista implements Serializable{
    
    private String nombre;
    private String nacionalidad;
    private String genero;
    private Date fechaNacimiento;
    private UploadedFile foto;
    private String ruta = "C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\proyecto_linea1\\src\\main\\webapp\\resources\\img\\";
    
    private List<String> generos;
    private List<String> nacionalidades;
    
    int id = 0;
    
   
    public CrearArtista(){
        DaoArtista daA = new DaoArtista();
        
        generos = new ArrayList<String>();
        nacionalidades = new ArrayList<String>();
        
        generos.addAll(daA.listaGenero());
        nacionalidades.addAll(daA.listaNacionalidad());
    }
    
    public void save() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        DaoArtista daA = new DaoArtista();
        guardarImg(foto.getFileName(),foto.getInputStream());
        EArtista art = new EArtista();
        art.setFoto(foto.getFileName());
        art.setNombre(nombre);
        art.setGenero(genero);
        art.setNacionalidad(nacionalidad);
        art.setFechaNacimiento(sqlFecha(fechaNacimiento));
        id = daA.agregarArtista(art);
        if(id!=0){
            context.addMessage(null, new FacesMessage("Artista registrado"));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Artista no Registrado", ""));
        }
    }
    
    public void guardarImg(String nombreImg, InputStream in){
        if(foto != null){
            try {
            OutputStream out = new FileOutputStream(new File(ruta + nombreImg));
            int reader = 0;
            byte[] bytes = new byte[(int)getFoto().getSize()];
            while((reader = in.read(bytes)) != -1){
                out.write(bytes,0,reader);
            }
            in.close();
            out.flush();
            out.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    public List<String> getNacionalidades() {
        return nacionalidades;
    }

    public void setNacionalidades(List<String> nacionalidades) {
        this.nacionalidades = nacionalidades;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public java.sql.Date sqlFecha(java.util.Date calendarDate) {
        return new java.sql.Date(calendarDate.getTime());
    }

}
