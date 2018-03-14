/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.EstatusObservacion;
import com.ub.st.managers.negocio.ManagerEstatusObservacion;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD del catálogo de estatus de observación
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Path("/estatusObservaciones")
public class EstatusObservaciones extends ServiceFacade<ManagerEstatusObservacion, EstatusObservacion, Integer> {

    public EstatusObservaciones() {
        super(ManagerEstatusObservacion.class);
    }

}
