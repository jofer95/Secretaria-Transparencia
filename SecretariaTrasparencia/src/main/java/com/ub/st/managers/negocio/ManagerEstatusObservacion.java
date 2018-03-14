/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.managers.negocio;

import com.ub.st.daos.negocio.DaoEstatusObservacion;
import com.ub.st.entities.negocio.EstatusObservacion;
import com.ub.st.managers.commons.ManagerSQL;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class ManagerEstatusObservacion extends ManagerSQL<EstatusObservacion, Integer> {

    public ManagerEstatusObservacion() {
        super(new DaoEstatusObservacion());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        return "estatusObservaciones";
    }

}
