/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.managers.negocio;

import com.ub.st.entities.negocio.Programa;
import com.ub.st.managers.commons.ManagerSQL;
import com.ub.st.daos.negocio.DaoPrograma;

/**
 *
 * @author Jorge Barraza
 */
public class ManagerPrograma extends ManagerSQL<Programa, Integer> {

    public ManagerPrograma() {
        super(new DaoPrograma());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        return "programas";
    }
    
}
