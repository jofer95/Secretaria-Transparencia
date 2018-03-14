/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.Contratista;
import com.ub.st.managers.negocio.ManagerContratista;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD de contratistas
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/contratistas")
public class Contratistas extends ServiceFacade<ManagerContratista, Contratista, Integer> {

    public Contratistas() {
        super(ManagerContratista.class);
    }

}
