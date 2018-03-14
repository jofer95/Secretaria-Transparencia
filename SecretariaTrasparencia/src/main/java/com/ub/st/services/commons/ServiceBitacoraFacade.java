/*
 * Copyright (C) 2017 Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ub.st.services.commons;

import com.ub.st.entities.commons.IEntity;
import com.ub.st.managers.commons.ManagerFacade;
import com.ub.st.utils.UtilsBitacora;
import com.ub.st.utils.UtilsBitacora.ModeloBitacora;
import static com.ub.st.utils.UtilsService.setErrorResponse;
import static com.ub.st.utils.UtilsService.setInvalidTokenResponse;
import com.ub.st.utils.exceptions.TokenExpiradoException;
import com.ub.st.utils.exceptions.TokenInvalidoException;
import com.ub.st.utils.responses.Response;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * clase de servicios para bitacoras de acciones
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 * @param <M> clase manejadora de entidades
 * @param <T> entidad a manejar por esta clase servicio
 * @param <K> tipo de dato de llave primaria de la entidad a menejar por esta clase servicio
 */
public abstract class ServiceBitacoraFacade<M extends ManagerFacade<T, K>, T extends IEntity<K>, K> extends ServiceFacade<M, T, K> {

    public ServiceBitacoraFacade(Class<M> clazz) {
        super(clazz);
    }

    /**
     * obtener todo los registros de bitacoras de esta entidad
     *
     * @param token token de sesion
     * @return en data, la lista de modelos de bitacora
     */
    @GET
    @Path("/bitacoras")
    public Response<List<ModeloBitacora>> obtenerBitacoras(@HeaderParam("Authorization") String token) {
        Response res = new Response();
        try {
            ManagerFacade<T, K> manager = clazz.newInstance();
            manager.setToken(token);
            res.setData(UtilsBitacora.bitacoras(manager.nombreColeccionParaRegistros()));
            res.setDevMessage("Bitácoras de esta entidad");
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            setInvalidTokenResponse(res);
        } catch (Exception ex) {
            setErrorResponse(res, ex);
        }
        return res;
    }

    /**
     * obtener los registros de bitcoras de esta entidad dentro del rango de fechas proporsionado
     *
     * @param token token de sesion
     * @param fechaInicial los milisegundos que representan la fecha inicial de filtrado
     * @param fechaFinal los milisegundos que representan la fecha final del filtrado
     * @return en data, la lista de modelos de bitacora que estan dentro del rango de fechas propuesto
     */
    @GET
    @Path("/bitacoras/{fechaInicial}/{fechaFinal}")
    public Response obtenerBitacorasRangoFechas(@HeaderParam("Authorization") String token, @PathParam("fechaInicial") Date fechaInicial, @PathParam("fechaFinal") Date fechaFinal) {
        Response res = new Response();
        try {
            ManagerFacade<T, K> manager = clazz.newInstance();
            manager.setToken(token);
            res.setData(UtilsBitacora.bitacorasEntre(manager.nombreColeccionParaRegistros(), fechaInicial, fechaFinal));
            res.setDevMessage("Bitácoras de esta entidad");
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            setInvalidTokenResponse(res);
        } catch (Exception e) {
            setErrorResponse(res, e);
        }
        return res;

    }

    /**
     * obtener los registros de bitcoras de esta entidad desde de la fecha proporsionada
     *
     * @param token token de sesion
     * @param fechaInicial los milisegundos que representan la fecha inicial desde la cual obtener la bitacora
     * @return en data, la lista de modelos de bitacora que estan a partir de la fecha proporsionada
     */
    @GET
    @Path("/bitacoras/desde/{fechaInicial}")
    public Response obtenerBitacorasDesdeFecha(@HeaderParam("Authorization") String token, @PathParam("fechaInicial") Date fechaInicial) {
        Response res = new Response();
        try {
            ManagerFacade<T, K> manager = clazz.newInstance();
            manager.setToken(token);
            res.setData(UtilsBitacora.bitacorasDesde(manager.nombreColeccionParaRegistros(), fechaInicial));
            res.setDevMessage("Bitácoras de esta entidad");
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            setInvalidTokenResponse(res);
        } catch (Exception e) {
            setErrorResponse(res, e);
        }
        return res;
    }

    /**
     * obtener los registros de bitcoras de esta entidad hasta la fecha proporsionada
     *
     * @param token token de sesion
     * @param fechaFinal los milisegundos que representan la fecha final hasta la cual obtener la bitacora
     * @return en data, la lista de modelos de bitacora que estan hasta de la fecha proporsionada
     */
    @GET
    @Path("/bitacoras/hasta/{fechaFinal}")
    public Response obtenerBitacorasHastaFecha(@HeaderParam("Authorization") String token, @PathParam("fechaFinal") Date fechaFinal) {
        Response res = new Response();
        try {
            ManagerFacade<T, K> manager = clazz.newInstance();
            manager.setToken(token);
            res.setData(UtilsBitacora.bitacorasHasta(manager.nombreColeccionParaRegistros(), fechaFinal));
            res.setDevMessage("Bitácoras de esta entidad");
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            setInvalidTokenResponse(res);
        } catch (Exception e) {
            setErrorResponse(res, e);
        }
        return res;
    }

    /**
     * obtiene por stacktrace el id de la accion actual en ejecucion
     *
     * @return id de accion actual en ejecucion
     */
    protected static String accionActual() {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String raiz = "com.ub.st.";
        return className.substring(raiz.length()) + "." + Thread.currentThread().getStackTrace()[2].getMethodName();
    }

}
