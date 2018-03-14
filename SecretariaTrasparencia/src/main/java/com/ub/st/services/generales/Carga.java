/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.generales;

import com.ub.st.daos.negocio.DaoAreaFiscalizadora;
import com.ub.st.daos.negocio.DaoAuditoria;
import com.ub.st.daos.negocio.DaoEnteFiscalizado;
import com.ub.st.daos.negocio.DaoObervacion;
import com.ub.st.daos.negocio.DaoSeguimiento;
import com.ub.st.entities.negocio.AreaFiscalizadora;
import com.ub.st.entities.negocio.Auditoria;
import com.ub.st.entities.negocio.EnteFiscalizado;
import com.ub.st.entities.negocio.Seguimiento;
import com.ub.st.models.generales.Observacion;
import com.ub.st.utils.UtilsService;
import com.ub.st.utils.responses.Response;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toSet;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/carga")
public class Carga {

    @POST
    @Path("/observaciones")
    public Response<String> carga(List<Observacion> observaciones) {
        Response r = new Response();
        try {
            final DaoAuditoria daoAuditoria = new DaoAuditoria();
            final DaoEnteFiscalizado daoEnteFiscalizado = new DaoEnteFiscalizado();
            final DaoAreaFiscalizadora daoAreaFiscalizadora = new DaoAreaFiscalizadora();
            final DaoObervacion daoObervacion = new DaoObervacion();
            final DaoSeguimiento daoSeguimiento = new DaoSeguimiento();

            Map<String, Map<String, List<Observacion>>> map = observaciones.stream().collect(Collectors.groupingBy(Observacion::getAuditoria, Collectors.groupingBy(Observacion::getEnteFizcalizado)));
            Set<Observacion> auditorias = observaciones.stream().collect(toSet());

            for (Map.Entry<String, Map<String, List<Observacion>>> auditoria : map.entrySet()) {
                for (Map.Entry<String, List<Observacion>> auditoriaObservacion : auditoria.getValue().entrySet()) {

                    Auditoria au = new Auditoria();
                    au.setAnioRealiza(auditoriaObservacion.getValue().get(0).getAnio());
                    au.setAnioRevisa(auditoriaObservacion.getValue().get(0).getAnioRevisa());
                    au.setNombre(auditoria.getKey());
                    au.setSituacionActual("carga desde excel");

                    //existe el ente, si no crealo
                    EnteFiscalizado ente;
                    try {
                        String enteFiscalizado = auditoriaObservacion.getValue().get(0).getEnteFizcalizado();
                        ente = daoEnteFiscalizado.stream().where(e -> e.getNombre().equals(enteFiscalizado)).findFirst().get();
                    } catch (Exception e) {
                        ente = new EnteFiscalizado(auditoriaObservacion.getValue().get(0).getEnteFizcalizado());
                        try {
                            daoEnteFiscalizado.persist(ente);
                        } catch (Exception ex) {
                            Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    au.setEnteFiscalizadoList(Arrays.asList(ente));

                    //colocar el area fiscalizadora
                    try {
                        au.setAreaFiscalizadoraList(Arrays.asList(daoAreaFiscalizadora.stream().where(area -> area.getEnteFiscalizador().getId() == 8).findAny().get()));
                    } catch (Exception ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        //guardar la auditoria
                        daoAuditoria.persist(au);
                        for (Observacion observacion : auditoriaObservacion.getValue()) {
                            com.ub.st.entities.negocio.Observacion obser = new com.ub.st.entities.negocio.Observacion();
                            obser.setAuditoria(au);
                            obser.setNumeroObservacion(String.valueOf(observacion.getNumeroObservacion()));
                            obser.setImporteObservado(observacion.getMontoObservado());
//                            obser.setRecomendacionCorrectiva(observacion.isSituacionCorrectiva());
//                            obser.setRecomendacionPreventiva(observacion.isSituacionPreventiva());
                            obser.setDescripcion(observacion.getDescripcion());
//                            obser.setIpra(observacion.isIpra());
                            obser.setPendiente("");
                            if (observacion.isIpra()) {
                                if (!observacion.getEstadoIpra().equals("PRESCRITO")) {
//                                    obser.setStatusIpra(1);
                                } else {
//                                    obser.setStatusIpra(0);
                                }
                            }
//                            obser.setDesRecomendacionCorrectiva("");
//                            obser.setDesRecomendacionPreventiva("");

                            daoObervacion.persist(obser);

                            if (observacion.getMontoAclarado() > 0f) {

                                Seguimiento s = new Seguimiento();
                                s.setObservacion(obser);
                                s.setAntecedentes("");
                                s.setDocuemntacionRecibida("");
                                s.setDocumentacionAnexa("");
                                s.setImporteAclarado(observacion.getMontoAclarado());
                                s.setImporteRecuperado(0);
                                s.setNumeroOficio("");
                                s.setRecomendacionCorrectiva("");
                                s.setRecomendacionPreventiva("");

                                daoSeguimiento.persist(s);
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, e);
            UtilsService.setErrorResponse(r, e);
        }
        return r;
    }

    @POST
    @Path("/observacionesASF")
    public Response<String> cargaASF(List<Observacion> observaciones) {
        Response r = new Response();
        try {
            final DaoAuditoria daoAuditoria = new DaoAuditoria();
            final DaoEnteFiscalizado daoEnteFiscalizado = new DaoEnteFiscalizado();
            final DaoAreaFiscalizadora daoAreaFiscalizadora = new DaoAreaFiscalizadora();
            final DaoObervacion daoObervacion = new DaoObervacion();
            final DaoSeguimiento daoSeguimiento = new DaoSeguimiento();

            Map<String, Map<String, List<Observacion>>> map = observaciones.stream().collect(Collectors.groupingBy(Observacion::getAuditoria, Collectors.groupingBy(Observacion::getEnteFizcalizado)));
            Set<Observacion> auditorias = observaciones.stream().collect(toSet());

            for (Map.Entry<String, Map<String, List<Observacion>>> auditoria : map.entrySet()) {
                for (Map.Entry<String, List<Observacion>> auditoriaObservacion : auditoria.getValue().entrySet()) {

                    Auditoria au = new Auditoria();
                    au.setAnioRealiza(auditoriaObservacion.getValue().get(0).getAnio());
                    au.setAnioRevisa(auditoriaObservacion.getValue().get(0).getAnioRevisa());
                    au.setNumero(String.valueOf((int) Float.parseFloat(auditoria.getKey())));
                    au.setSituacionActual("carga desde excel");

                    //existe el ente, si no crealo
                    EnteFiscalizado ente;
                    try {
                        String enteFiscalizado = auditoriaObservacion.getValue().get(0).getEnteFizcalizado();
                        ente = daoEnteFiscalizado.stream().where(e -> e.getNombre().equals(enteFiscalizado)).findFirst().get();
                    } catch (Exception e) {
                        ente = new EnteFiscalizado(auditoriaObservacion.getValue().get(0).getEnteFizcalizado());
                        try {
                            daoEnteFiscalizado.persist(ente);
                        } catch (Exception ex) {
                            Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    au.setEnteFiscalizadoList(Arrays.asList(ente));

                    //colocar el area fiscalizadora
                    AreaFiscalizadora areaFiscalizadora;
                    try {
                        String nombreArea = auditoriaObservacion.getValue().get(0).getAreaFiscalizada();
                        areaFiscalizadora = daoAreaFiscalizadora.stream().where(area -> area.getNombre().equals(nombreArea)).findFirst().get();
                    } catch (Exception ex) {
                        areaFiscalizadora = new AreaFiscalizadora();
                        areaFiscalizadora.setNombre(auditoriaObservacion.getValue().get(0).getAreaFiscalizada());
                        daoAreaFiscalizadora.persist(areaFiscalizadora);
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    au.setAreaFiscalizadoraList(Arrays.asList(areaFiscalizadora));

                    try {
                        //guardar la auditoria
                        daoAuditoria.persist(au);
                        for (Observacion observacion : auditoriaObservacion.getValue()) {
                            com.ub.st.entities.negocio.Observacion obser = new com.ub.st.entities.negocio.Observacion();
                            obser.setAuditoria(au);
                            obser.setNumeroObservacion(observacion.getNumeroObservacion());
                            obser.setImporteObservado(observacion.getMontoObservado());
//                            obser.setRecomendacionCorrectiva(observacion.isSituacionCorrectiva());
//                            obser.setRecomendacionPreventiva(observacion.isSituacionPreventiva());
                            obser.setDescripcion(observacion.getDescripcion());
//                            obser.setIpra(observacion.isIpra());
                            obser.setPendiente("");
//                            if (observacion.isIpra()) {
//                                if (!observacion.getEstadoIpra().equals("PRESCRITO")) {
//                                    obser.setStatusIpra(1);
//                                } else {
//                                    obser.setStatusIpra(0);
//                                }
//                            }
//                            obser.setDesRecomendacionCorrectiva("");
//                            obser.setDesRecomendacionPreventiva("");

                            daoObervacion.persist(obser);

                            if (observacion.getMontoAclarado() > 0f) {

                                Seguimiento s = new Seguimiento();
                                s.setObservacion(obser);
                                s.setAntecedentes("");
                                s.setDocuemntacionRecibida("");
                                s.setDocumentacionAnexa("");
                                s.setImporteAclarado(observacion.getMontoAclarado());
                                s.setImporteRecuperado(0);
                                s.setNumeroOficio("");
                                s.setRecomendacionCorrectiva("");
                                s.setRecomendacionPreventiva("");

                                daoSeguimiento.persist(s);
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, e);
            UtilsService.setErrorResponse(r, e);
        }
        return r;
    }

}
