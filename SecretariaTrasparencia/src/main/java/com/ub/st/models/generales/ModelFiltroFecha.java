/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.models.generales;

import java.util.Date;

/**
 * modelo de filtro de fechas generico
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ModelFiltroFecha {

    private Date fechaInicio;
    private Date fechaFin;

    public ModelFiltroFecha() {
    }

    public ModelFiltroFecha(Date fechaInicio, Date fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
