/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamascotas;

import java.sql.Timestamp;

/**
 *
 * @author Ricardo Adrian Delgadillo Rivera 6*A T/V
 */
public class Can {
    
    private int id;
    private String nombreCan;
    private String razaCan;
    private String colorCan;
    private String patronCan;
    private String generoCan;
    private String tamaCan;
    private String caracteristicasCan;
    private String observacionesCan;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;

    public String getNombreCan() {
        return nombreCan;
    }

    public void setNombreCan(String nombreCan) {
        this.nombreCan = nombreCan;
    }

    public String getRazaCan() {
        return razaCan;
    }

    public void setRazaCan(String razaCan) {
        this.razaCan = razaCan;
    }

    public String getColorCan() {
        return colorCan;
    }

    public void setColorCan(String colorCan) {
        this.colorCan = colorCan;
    }

    public String getPatronCan() {
        return patronCan;
    }

    public void setPatronCan(String patronCan) {
        this.patronCan = patronCan;
    }

    public String getGeneroCan() {
        return generoCan;
    }

    public void setGeneroCan(String generoCan) {
        this.generoCan = generoCan;
    }

    public String getTamaCan() {
        return tamaCan;
    }

    public void setTamaCan(String tamaCan) {
        this.tamaCan = tamaCan;
    }

    public String getCaracteristicasCan() {
        return caracteristicasCan;
    }

    public void setCaracteristicasCan(String caracteristicasCan) {
        this.caracteristicasCan = caracteristicasCan;
    }

    public String getObservacionesCan() {
        return observacionesCan;
    }

    public void setObservacionesCan(String observacionesCan) {
        this.observacionesCan = observacionesCan;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Can() {
    }

    public Can(int id, String nombreCan, String razaCan, String colorCan, String patronCan, String generoCan, String tamaCan, String caracteristicasCan, String observacionesCan, Timestamp fechaInicio, Timestamp fechaFin) {
        this.id = id;
        this.nombreCan = nombreCan;
        this.razaCan = razaCan;
        this.colorCan = colorCan;
        this.patronCan = patronCan;
        this.generoCan = generoCan;
        this.tamaCan = tamaCan;
        this.caracteristicasCan = caracteristicasCan;
        this.observacionesCan = observacionesCan;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    
    
}
