/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.Secretaria;
import com.ub.st.managers.negocio.ManagerSecretaria;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para catálogo de las secretarias
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/secretarias")
public class Secretarias extends ServiceFacade<ManagerSecretaria, Secretaria, Integer> {

    public Secretarias() {
        super(ManagerSecretaria.class);
    }

}
