/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.managers.negocio;

import com.ub.st.daos.commons.DaoSQLFacade;
import com.ub.st.daos.negocio.DaoOrganismoDescentralizado;
import com.ub.st.entities.negocio.OrganismoDescentralizado;
import com.ub.st.managers.commons.ManagerSQL;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ManagerOrganismoDescentralizado extends ManagerSQL<OrganismoDescentralizado, Integer> {

    public ManagerOrganismoDescentralizado() {
        super(new DaoOrganismoDescentralizado());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        return "organismoDescentralizado";
    }

}
