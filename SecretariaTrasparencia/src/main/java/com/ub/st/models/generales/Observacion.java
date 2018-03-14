/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.models.generales;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class Observacion {

    private int anio;
    private int anioRevisa;
    private int numeroExpediente;
    private boolean ipra;
    private String estadoIpra;
    private String auditoria;
    private String numeroObservacion;
    private double montoObservado;
    private double montoAclarado;
    private boolean situacionCorrectiva;
    private boolean situacionPreventiva;
    private String enteFizcalizado;
    private String descripcion;
    private String areaFiscalizada;

    public String getAreaFiscalizada() {
        return areaFiscalizada;
    }

    public void setAreaFiscalizada(String areaFiscalizada) {
        this.areaFiscalizada = areaFiscalizada;
    }

    public boolean isIpra() {
        return ipra;
    }

    public void setIpra(boolean ipra) {
        this.ipra = ipra;
    }

    public String getEstadoIpra() {
        return estadoIpra;
    }

    public void setEstadoIpra(String estadoIpra) {
        this.estadoIpra = estadoIpra;
    }

    public int getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(int numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public Observacion() {
    }

    public String getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(String auditoria) {
        this.auditoria = auditoria;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getAnioRevisa() {
        return anioRevisa;
    }

    public void setAnioRevisa(int anioRevisa) {
        this.anioRevisa = anioRevisa;
    }

    public String getNumeroObservacion() {
        return numeroObservacion;
    }

    public void setNumeroObservacion(String numeroObservacion) {
        this.numeroObservacion = numeroObservacion;
    }

    public boolean isSituacionCorrectiva() {
        return situacionCorrectiva;
    }

    public void setSituacionCorrectiva(boolean situacionCorrectiva) {
        this.situacionCorrectiva = situacionCorrectiva;
    }

    public boolean isSituacionPreventiva() {
        return situacionPreventiva;
    }

    public void setSituacionPreventiva(boolean situacionPreventiva) {
        this.situacionPreventiva = situacionPreventiva;
    }

    public String getEnteFizcalizado() {
        return enteFizcalizado;
    }

    public void setEnteFizcalizado(String enteFizcalizado) {
        this.enteFizcalizado = enteFizcalizado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMontoObservado() {
        return montoObservado;
    }

    public void setMontoObservado(double montoObservado) {
        this.montoObservado = montoObservado;
    }

    public double getMontoAclarado() {
        return montoAclarado;
    }

    public void setMontoAclarado(double montoAclarado) {
        this.montoAclarado = montoAclarado;
    }

}
