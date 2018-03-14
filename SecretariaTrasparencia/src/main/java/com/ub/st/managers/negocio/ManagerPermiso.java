/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.managers.negocio;

import com.ub.st.daos.negocio.DaoPermiso;
import com.ub.st.entities.negocio.Permiso;
import com.ub.st.managers.commons.ManagerSQL;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ManagerPermiso extends ManagerSQL<Permiso, String> {

    public ManagerPermiso() {
        super(new DaoPermiso());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}
