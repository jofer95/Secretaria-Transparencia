/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.generales;

import com.ub.st.entities.negocio.Usuario;
import com.ub.st.managers.negocio.ManagerUsuario;
import com.ub.st.models.accesos.ModelLogin;
import com.ub.st.utils.UtilsJWT;
import static com.ub.st.utils.UtilsService.*;
import com.ub.st.utils.exceptions.UsuarioInexistenteException;
import com.ub.st.utils.responses.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * servicios de acceso al sistema
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/accesos")
public class Accesos {

    @POST
    @Path("/login")
    public Response<ModelLogin> login(ModelLogin model) {
        Response r = new Response();
        try {
            ManagerUsuario managerUsuario = new ManagerUsuario();
            Usuario u = managerUsuario.login(model);
            setOkResponse(r, u, UtilsJWT.generateSessionToken(String.valueOf(u.getId())), "Bienvenido " + u.getNombre(), "Token de sesion necesario para el consumo de siguientes servicios");
        } catch (UsuarioInexistenteException e) {
            setWarningResponse(r, e.getMessage());
        } catch (Exception e) {
            setErrorResponse(r, e);
        }

        return r;
    }

}
