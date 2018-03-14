/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.TipoObservacion;
import com.ub.st.managers.negocio.ManagerTipoObservacion;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para catálogo de los tipos de observación
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Path("/tiposObservaciones")
public class TiposObservaciones extends ServiceFacade<ManagerTipoObservacion, TipoObservacion, Integer> {

    public TiposObservaciones() {
        super(ManagerTipoObservacion.class);
    }

}
