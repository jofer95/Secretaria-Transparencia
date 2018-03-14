/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.Auditoria;
import com.ub.st.managers.negocio.ManagerAuditoria;
import com.ub.st.models.negocio.ModelImportePendiente;
import com.ub.st.services.commons.ServiceFacade;
import static com.ub.st.utils.UtilsService.*;
import com.ub.st.utils.exceptions.TokenExpiradoException;
import com.ub.st.utils.exceptions.TokenInvalidoException;
import com.ub.st.utils.responses.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Servicios lcrud para auditorias
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/auditorias")
public class Auditorias extends ServiceFacade<ManagerAuditoria, Auditoria, Integer> {

    public Auditorias() {
        super(ManagerAuditoria.class);
    }

    /**
     * Genera los datos de los importes de una auditoria en particular
     *
     * @param token token de sesion
     * @param id identificador de la auditoria a generar los importes
     * @return modelo de importes de una auditoria
     */
    @GET
    @Path("/importePendienteAuditoria/{id}")
    public Response<ModelImportePendiente> importePendienteAuditoria(@HeaderParam("Authorization") String token, @PathParam("id") int id) {
        Response<ModelImportePendiente> r = new Response();
        try {
            ManagerAuditoria managerAuditoria = new ManagerAuditoria();
            managerAuditoria.setToken(token);
            r.setData(managerAuditoria.importePendienteAuditoria(id));
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            setInvalidTokenResponse(r);
        } catch (Exception ex) {
            Logger.getLogger(Auditorias.class.getName()).log(Level.SEVERE, null, ex);
            setErrorResponse(r, ex);
        }

        return r;
    }

}
