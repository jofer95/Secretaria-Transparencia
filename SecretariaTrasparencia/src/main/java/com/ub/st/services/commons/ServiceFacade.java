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
import static com.ub.st.utils.UtilsService.*;
import com.ub.st.utils.exceptions.TokenExpiradoException;
import com.ub.st.utils.exceptions.TokenInvalidoException;
import com.ub.st.utils.responses.Response;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * clase de servicios generales LCRUD para entidades que no requiere profundidad de acceso
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 * @param <M>
 * @param <T> entidad a manejar por esta clase servicio
 * @param <K> tipo de dato de llave primaria de la entidad a menejar por esta clase servicio
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServiceFacade<M extends ManagerFacade<T, K>, T extends IEntity<K>, K> {

    protected final Class<M> clazz;

    public ServiceFacade(Class<M> clazz) {
        this.clazz = clazz;
    }

    /**
     * proporciona el listado de las entidades de esta clase servicio
     *
     * @param request contexto de peticion necesario para obtener datos como ip, sistema operativo y navegador del cliente
     * @param token token de sesion
     * @return reponse, con su campo data asignado con una lista de las entidades de esta clase servicio
     */
    @GET
    public Response<List<T>> listar(@Context HttpServletRequest request, @HeaderParam("Authorization") String token) {
        Response response = new Response();
        try {
            ManagerFacade<T, K> manager = clazz.newInstance();
            manager.setToken(token);
            setOkResponse(response, manager.findAll(), "Entidades encontradas");
            //<editor-fold defaultstate="collapsed" desc="BITACORIZAR">
//            try {
//                UtilsBitacora.ModeloBitacora bitacora = new UtilsBitacora.ModeloBitacora(manager.getUsuario(), new Date(), "Listar", request);
//                UtilsBitacora.bitacorizar(manager.nombreColeccionParaRegistros(), bitacora);
//            } catch (UnsupportedOperationException e) {
//            }
            //</editor-fold>            
        } catch (TokenExpiradoException | TokenInvalidoException e) {
            setInvalidTokenResponse(response);
        } catch (Exception ex) {
            setErrorResponse(response, ex);
        }
        return response;
    }

    /**
     * obtiene una entidad en particular por su identificador de esta clase servicio
     *
     * @param request contexto de peticion necesario para obtener datos como ip, sistema operativo y navegador del cliente
     * @param token token de sesion
     * @param id identificador de la entidad buscada
     * @return response, con su campo data asignado con la entidad buscada
     */
    @GET
    @Path("/{id}")
    public Response<T> detalle(@Context HttpServletRequest request, @HeaderParam("Authorization") String token, @PathParam("id") K id) {
        Response response = new Response();
        try {
            ManagerFacade<T, K> manager = clazz.newInstance();
            manager.setToken(token);
            setOkResponse(response, manager.findOne(id), "Entidad encontrada");
            //<editor-fold defaultstate="collapsed" desc="BITACORIZAR">
//            try {
//                UtilsBitacora.ModeloBitacora bitacora = new UtilsBitacora.ModeloBitacora(manager.getUsuario(), new Date(), "Detalle", request);
//                UtilsBitacora.bitacorizar(manager.nombreColeccionParaRegistros(), bitacora);
//            } catch (UnsupportedOperationException e) {
//            }
            //</editor-fold>
        } catch (TokenExpiradoException | TokenInvalidoException ex) {
            setInvalidTokenResponse(response);
        } catch (Exception ex) {
            setErrorResponse(response, ex);
        }
        return response;
    }

    /**
     * persiste la entidad de esta clase servicio en base de datos
     *
     * @param request contexto de peticion necesario para obtener datos como ip, sistema operativo y navegador del cliente
     * @param token token de sesion
     * @param t entidad a persistir en base de datos
     * @return response con el estatus y el mensaje
     */
    @POST
    public Response<T> alta(@Context HttpServletRequest request, @HeaderParam("Authorization") String token, T t) {
        Response response = new Response();
        try {
            ManagerFacade<T, K> manager = clazz.newInstance();
            manager.setToken(token);
            setOkResponse(response, manager.persist(t), "Entidad persistida");
            //<editor-fold defaultstate="collapsed" desc="BITACORIZAR">
//            try {
//                UtilsBitacora.ModeloBitacora bitacora = new UtilsBitacora.ModeloBitacora(manager.getUsuario(), new Date(), "Alta", request);
//                UtilsBitacora.bitacorizar(manager.nombreColeccionParaRegistros(), bitacora);
//            } catch (UnsupportedOperationException e) {
//            }
            //</editor-fold>
        } catch (TokenExpiradoException | TokenInvalidoException ex) {
            setInvalidTokenResponse(response);
        } catch (Exception ex) {
            setErrorResponse(response, ex);
        }
        return response;
    }

    /**
     * actualiza la entidad proporsionada a su equivalente en base de datos, tomando como referencia su identificador
     *
     * @param request contexto de peticion necesario para obtener datos como ip, sistema operativo y navegador del cliente
     * @param token token de sesion
     * @param t entidad con los datos actualizados
     * @return Response, en data asignado con la entidad que se actualizó
     */
    @PUT
    public Response<T> modificar(@Context HttpServletRequest request, @HeaderParam("Authorization") String token, T t) {
        Response response = new Response();
        try {
            ManagerFacade<T, K> manager = clazz.newInstance();
            manager.setToken(token);
            manager.update(t);
            setOkResponse(response, t, "Entidad actualizada");
            //<editor-fold defaultstate="collapsed" desc="BITACORIZAR">
//            try {
//                UtilsBitacora.ModeloBitacora bitacora = new UtilsBitacora.ModeloBitacora(manager.getUsuario(), new Date(), "Modificar", request);
//                UtilsBitacora.bitacorizar(manager.nombreColeccionParaRegistros(), bitacora);
//            } catch (UnsupportedOperationException e) {
//            }
            //</editor-fold>    
        } catch (TokenExpiradoException | TokenInvalidoException ex) {
            setInvalidTokenResponse(response);
        } catch (Exception ex) {
            setOkResponse(response, token);
        }
        return response;
    }

    /**
     * eliminar la entidad proporsionada
     *
     * @param request contexto de peticion necesario para obtener datos como ip, sistema operativo y navegador del cliente
     * @param token token de sesion
     * @param t entidad proporsionada
     * @return
     */
    @DELETE
    public Response<T> eliminar(@Context HttpServletRequest request, @HeaderParam("Authorization") String token, T t) {
        Response response = new Response();
        try {
            ManagerFacade<T, K> manager = clazz.newInstance();
            manager.setToken(token);
            manager.delete(t.obtenIdEntidad());
            setOkResponse(response, t.obtenIdEntidad(), "Entidad eliminada");
            //<editor-fold defaultstate="collapsed" desc="BITACORIZAR">
//            try {
//                UtilsBitacora.ModeloBitacora bitacora = new UtilsBitacora.ModeloBitacora(manager.getUsuario(), new Date(), "Eliminar", request);
//                UtilsBitacora.bitacorizar(manager.nombreColeccionParaRegistros(), bitacora);
//            } catch (UnsupportedOperationException e) {
//            }
            //</editor-fold>
        } catch (TokenExpiradoException | TokenInvalidoException ex) {
            setInvalidTokenResponse(response);
        } catch (Exception ex) {
            setErrorResponse(response, ex);
        }
        return response;
    }

}
