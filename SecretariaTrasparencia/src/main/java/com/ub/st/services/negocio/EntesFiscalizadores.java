/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.EnteFiscalizador;
import com.ub.st.managers.negocio.ManagerEnteFiscalizador;
import com.ub.st.models.generales.ModelFiltroFecha;
import com.ub.st.models.negocio.ModelEstadoObservaciones;
import com.ub.st.models.negocio.ModelImportePendiente;
import com.ub.st.services.commons.ServiceFacade;
import com.ub.st.utils.UtilsService;
import com.ub.st.utils.exceptions.TokenExpiradoException;
import com.ub.st.utils.exceptions.TokenInvalidoException;
import com.ub.st.utils.responses.Response;
import java.util.List;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Servicios LCRUD para catálogo entes fiscalizadores
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/entesFiscalizadores")
public class EntesFiscalizadores extends ServiceFacade<ManagerEnteFiscalizador, EnteFiscalizador, Integer> {

    public EntesFiscalizadores() {
        super(ManagerEnteFiscalizador.class);
    }

    /**
     * obtiene los importes calculados de las auditorias agrupados por ente fiscalizador
     *
     * @param token token de sesion
     * @param filtroFecha modelo de filtro de fechas, para ignorar una de las fechas mandar null o no mandar
     * @return lista de importes por ente fiscalizador
     */
    @POST
    @Path("/importes")
    public Response<List<ModelImportePendiente>> importesPendientesPorEnteFiscalizador(@HeaderParam("Authorization") final String token, ModelFiltroFecha filtroFecha) {
        Response<List<ModelImportePendiente>> res = new Response<>();
        try {
            ManagerEnteFiscalizador managerEnteFiscalizador = new ManagerEnteFiscalizador();
            managerEnteFiscalizador.setToken(token);
            UtilsService.setOkResponse(res, managerEnteFiscalizador.importesPendientesPorEnteFiscalizador(filtroFecha), "Importes por ente finscalizador");
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            UtilsService.setInvalidTokenResponse(res);
        } catch (Exception e) {
            UtilsService.setErrorResponse(res, e);
        }
        return res;
    }

    /**
     * obtiene los estados de las observaciones agrupados por ente fiscalizador
     *
     * @param token token de sesion
     * @param filtroFecha modelo de filtro de fechas, para ignorar una de las fechas mandar null o no mandar
     * @return lista de estados de observaciones por ente fiscalizador
     */
    @POST
    @Path("/observaciones")
    public Response<List<ModelEstadoObservaciones>> estadosObservacionesPorEnteFiscalizador(@HeaderParam("Authorization") final String token, ModelFiltroFecha filtroFecha) {
        Response<List<ModelEstadoObservaciones>> res = new Response<>();
        try {
            ManagerEnteFiscalizador managerEnteFiscalizador = new ManagerEnteFiscalizador();
            managerEnteFiscalizador.setToken(token);
            UtilsService.setOkResponse(res, managerEnteFiscalizador.estadoObservacionesPorEnteFiscalizador(filtroFecha), "Estados observaciones por ente finscalizador");
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            UtilsService.setInvalidTokenResponse(res);
        } catch (Exception e) {
            UtilsService.setErrorResponse(res, e);
        }
        return res;
    }

}
