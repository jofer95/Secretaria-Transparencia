/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.models.negocio;

/**
 * modelo para el reporte de estado de las observaciones agrupado por ente (fiscalizado o fiscalizador)
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ModelEstadoObservaciones {

    private int enteId;
    private String nombreEnte;
    private int vigentes;
    private int nuevas;
    private int solventadas;
    private int totales;

    public ModelEstadoObservaciones() {
    }

    public ModelEstadoObservaciones(int enteId, String nombreEnte) {
        this.enteId = enteId;
        this.nombreEnte = nombreEnte;
    }

    public int getEnteId() {
        return enteId;
    }

    public void setEnteId(int enteId) {
        this.enteId = enteId;
    }

    public String getNombreEnte() {
        return nombreEnte;
    }

    public void setNombreEnte(String nombreEnte) {
        this.nombreEnte = nombreEnte;
    }

    public int getVigentes() {
        return vigentes;
    }

    public void setVigentes(int vigentes) {
        this.vigentes = vigentes;
    }

    public int getNuevas() {
        return nuevas;
    }

    public void setNuevas(int nuevas) {
        this.nuevas = nuevas;
    }

    public int getSolventadas() {
        return solventadas;
    }

    public void setSolventadas(int solventadas) {
        this.solventadas = solventadas;
    }

    public int getTotales() {
        return totales;
    }

    public void setTotales(int totales) {
        this.totales = totales;
    }

    public void addVigentes(int vigentes) {
        this.vigentes += vigentes;
    }

    public void addNuevas(int nuevas) {
        this.nuevas += nuevas;
    }

    public void addSolventadas(int solventadas) {
        this.solventadas += solventadas;
    }

    public void addTotales(int totales) {
        this.totales += totales;
    }

}
