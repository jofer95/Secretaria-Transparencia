/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.EntidadCoordinada;
import com.ub.st.managers.negocio.ManagerEntidadCoordinada;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para catálogo entidades coordinadas
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/entidadesCoordinadas")
public class EntidadesCoordinadas extends ServiceFacade<ManagerEntidadCoordinada, EntidadCoordinada, Integer> {

    public EntidadesCoordinadas() {
        super(ManagerEntidadCoordinada.class);
    }

}
