/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.OrganismoDescentralizado;
import com.ub.st.managers.negocio.ManagerOrganismoDescentralizado;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para organismos descentralizados
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/organismosDescentralizados")
public class OrganismosDescentralizados extends ServiceFacade<ManagerOrganismoDescentralizado, OrganismoDescentralizado, Integer> {

    public OrganismosDescentralizados() {
        super(ManagerOrganismoDescentralizado.class);
    }

}
