/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.OrganismoDesconcentrado;
import com.ub.st.managers.negocio.ManagerOrganismoDesconcentrado;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para organismos desconcentrados
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/organismosDesconcentrados")
public class OrganismosDesconcentrados extends ServiceFacade<ManagerOrganismoDesconcentrado, OrganismoDesconcentrado, Integer> {

    public OrganismosDesconcentrados() {
        super(ManagerOrganismoDesconcentrado.class);
    }

}
