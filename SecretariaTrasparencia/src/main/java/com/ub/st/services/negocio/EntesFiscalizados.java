/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.EnteFiscalizado;
import com.ub.st.managers.negocio.ManagerEnteFiscalizado;
import com.ub.st.models.generales.ModelFiltroFecha;
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
 * Servicios LCRUD para catálogo entes fiscalizados
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/entesFiscalizados")
public class EntesFiscalizados extends ServiceFacade<ManagerEnteFiscalizado, EnteFiscalizado, Integer> {

    public EntesFiscalizados() {
        super(ManagerEnteFiscalizado.class);
    }

    /**
     * obtiene los importes calculados de las auditorias agrupados por ente fiscalizado
     *
     * @param token token de sesion
     * @param filtroFecha modelo de filtro de fechas, para ignorar una de las fechas mandar null o no mandar
     * @return lista de importes por ente fiscalizador
     */
    @POST
    @Path("/importes")
    public Response<List<ModelImportePendiente>> importesPendientesPorEnteFiscalizado(@HeaderParam("Authorization") final String token, ModelFiltroFecha filtroFecha) {
        Response<List<ModelImportePendiente>> res = new Response<>();
        try {
            ManagerEnteFiscalizado managerEnteFiscalizado = new ManagerEnteFiscalizado();
            managerEnteFiscalizado.setToken(token);
            UtilsService.setOkResponse(res, managerEnteFiscalizado.importesPendientesPorEnteFiscalizado(filtroFecha), "Importes por ente finscalizado");
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            UtilsService.setInvalidTokenResponse(res);
        } catch (Exception e) {
            UtilsService.setErrorResponse(res, e);
        }
        return res;
    }

    /**
     * obtiene observaciones y el estado en el que estan agrupados por ente fiscalizado
     *
     * @param token token de sesion
     * @param filtroFecha modelo de filtro de fechas, para ignorar una de las fechas mandar null o no mandar
     * @return lista de estados de observaciones por ente fiscalizado
     */
    @POST
    @Path("/observaciones")
    public Response<List<ModelImportePendiente>> estadoObservacionesPorEnteFiscalizado(@HeaderParam("Authorization") final String token, ModelFiltroFecha filtroFecha) {
        Response<List<ModelImportePendiente>> res = new Response<>();
        try {
            ManagerEnteFiscalizado managerEnteFiscalizado = new ManagerEnteFiscalizado();
            managerEnteFiscalizado.setToken(token);
            UtilsService.setOkResponse(res, managerEnteFiscalizado.estadoObservacionesPorEnteFiscalizado(filtroFecha), "Estados observaciones por ente finscalizado");
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            UtilsService.setInvalidTokenResponse(res);
        } catch (Exception e) {
            UtilsService.setErrorResponse(res, e);
        }
        return res;
    }

}
