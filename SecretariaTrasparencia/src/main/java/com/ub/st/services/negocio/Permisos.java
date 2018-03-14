/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.Permiso;
import com.ub.st.managers.negocio.ManagerPermiso;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para los permisos del sistema
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/permisos")
public class Permisos extends ServiceFacade<ManagerPermiso, Permiso, String> {

    public Permisos() {
        super(ManagerPermiso.class);
    }

}
