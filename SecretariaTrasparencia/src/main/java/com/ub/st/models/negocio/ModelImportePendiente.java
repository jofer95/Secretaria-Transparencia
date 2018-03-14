/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.models.negocio;

/**
 * modelo con los importes calculados de las auditorias segun un ente
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ModelImportePendiente {

    private int enteId;
    private String nombreEnte;
    private double importePendiente;
    private double importeObservado;
    private double importeRecuperado;
    private double importeAclarado;

    public ModelImportePendiente() {
    }

    public ModelImportePendiente(int enteId) {
        this.enteId = enteId;
    }

    public double getImporteObservado() {
        return importeObservado;
    }

    public void setImporteObservado(double importeObservado) {
        this.importeObservado = importeObservado;
    }

    public double getImporteRecuperado() {
        return importeRecuperado;
    }

    public void setImporteRecuperado(double importeRecuperado) {
        this.importeRecuperado = importeRecuperado;
    }

    public double getImporteAclarado() {
        return importeAclarado;
    }

    public void setImporteAclarado(double importeAclarado) {
        this.importeAclarado = importeAclarado;
    }

    public double getImportePendiente() {
        return importePendiente;
    }

    public void setImportePendiente(double importePendiente) {
        this.importePendiente = importePendiente;
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

    @Override
    public String toString() {
        return "ModelImportePendiente{" + "importePendiente=" + importePendiente + '}';
    }

}
