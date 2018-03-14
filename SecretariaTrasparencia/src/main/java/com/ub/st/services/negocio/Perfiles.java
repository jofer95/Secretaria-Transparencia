/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.Perfil;
import com.ub.st.managers.negocio.ManagerPerfil;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para los perfiles del sistema
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/perfiles")
public class Perfiles extends ServiceFacade<ManagerPerfil, Perfil, Integer> {

    public Perfiles() {
        super(ManagerPerfil.class);
    }

}
