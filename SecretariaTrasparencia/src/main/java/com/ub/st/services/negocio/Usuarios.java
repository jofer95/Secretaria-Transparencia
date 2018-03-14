/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.Usuario;
import com.ub.st.managers.negocio.ManagerUsuario;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para catálogo de los usuarios del sistema
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/usuarios")
public class Usuarios extends ServiceFacade<ManagerUsuario, Usuario, Integer> {

    public Usuarios() {
        super(ManagerUsuario.class);
    }

}
