/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.managers.negocio;

import com.ub.st.daos.negocio.DaoSeguimiento;
import com.ub.st.entities.negocio.Seguimiento;
import com.ub.st.managers.commons.ManagerSQL;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ManagerSeguimiento extends ManagerSQL<Seguimiento, Integer> {

    public ManagerSeguimiento() {
        super(new DaoSeguimiento());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        return "seguimientos";
    }

}
