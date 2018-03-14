/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.CoordinacionGeneral;
import com.ub.st.managers.negocio.ManagerCoordinacionGeneral;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para catálogo de coordinaciones generales
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/coordinacionesGenerales")
public class CoordinacionesGenerales extends ServiceFacade<ManagerCoordinacionGeneral, CoordinacionGeneral, Integer> {

    public CoordinacionesGenerales() {
        super(ManagerCoordinacionGeneral.class);
    }

}
