/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.managers.negocio;

import com.ub.st.daos.negocio.DaoSecretaria;
import com.ub.st.entities.negocio.Secretaria;
import com.ub.st.managers.commons.ManagerSQL;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ManagerSecretaria extends ManagerSQL<Secretaria, Integer> {

    public ManagerSecretaria() {
        super(new DaoSecretaria());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        return "secretarias";
    }

}
