/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.managers.negocio;

import com.ub.st.daos.negocio.DaoEnteFilcalizador;
import com.ub.st.entities.negocio.AreaFiscalizadora;
import com.ub.st.entities.negocio.Auditoria;
import com.ub.st.entities.negocio.EnteFiscalizador;
import com.ub.st.entities.negocio.Observacion;
import com.ub.st.entities.negocio.Seguimiento;
import com.ub.st.managers.commons.ManagerSQL;
import com.ub.st.models.generales.ModelFiltroFecha;
import com.ub.st.models.negocio.ModelEstadoObservaciones;
import com.ub.st.models.negocio.ModelImportePendiente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ManagerEnteFiscalizador extends ManagerSQL<EnteFiscalizador, Integer> {

    public ManagerEnteFiscalizador() {
        super(new DaoEnteFilcalizador());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        return "entesFiscalizadores";
    }

    /**
     * obtiene los modelos de importe de entes fiscalizadores con un rango de fechas en sus observaciones
     *
     * @param filtroFechas modelo de filtro de fechas para observaciones, para ignorar una fehca mandar null
     * @return lista de modelos con los importes de los entes fiscalizadores
     * @throws Exception si existe un error de I/O
     */
    public List<ModelImportePendiente> importesPendientesPorEnteFiscalizador(ModelFiltroFecha filtroFechas) throws Exception {
        List<EnteFiscalizador> entesFiscalizadores = this.findAll();
        List<ModelImportePendiente> res = new ArrayList<>();
        ModelImportePendiente importePendiente;
        double importeObservado, importeAclarado, importeRecuperado;
        for (EnteFiscalizador ente : entesFiscalizadores) {
            importePendiente = new ModelImportePendiente();
            importeObservado = 0;
            importeAclarado = 0;
            importeRecuperado = 0;
            for (AreaFiscalizadora area : ente.getAreaFiscalizadoraList()) {
                for (Auditoria auditoria : area.getAuditoriaList()) {
                    Stream<Observacion> sObservaciones = auditoria.getObservacionList().stream();
                    if (filtroFechas.getFechaInicio() != null) {
                        sObservaciones = sObservaciones.filter(o -> !o.getFechaRegistro().before(filtroFechas.getFechaInicio()));
                    }
                    if (filtroFechas.getFechaFin() != null) {
                        sObservaciones = sObservaciones.filter(o -> !o.getFechaRegistro().after(filtroFechas.getFechaFin()));
                    }
                    for (Observacion observacion : sObservaciones.collect(toList())) {
                        importeObservado += observacion.getImporteObservado();
                        for (Seguimiento seguimiento : observacion.getSeguimientoList()) {
                            importeAclarado += seguimiento.getImporteAclarado();
                            importeRecuperado += seguimiento.getImporteRecuperado();
                        }
                    }
                }
            }
            importePendiente.setNombreEnte(ente.getNombre());
            importePendiente.setEnteId(ente.getId());
            importePendiente.setImporteAclarado(importeAclarado);
            importePendiente.setImporteRecuperado(importeRecuperado);
            importePendiente.setImporteObservado(importeObservado);
            importePendiente.setImportePendiente(importeObservado - (importeAclarado + importeRecuperado));
            res.add(importePendiente);
        }
        return res;
    }

    /**
     * obtiene los modelos de estados de observaciones agrupado por entes fiscalizadores con un rango de fechas en sus observaciones
     *
     * @param filtroFechas modelo de filtro de fechas para observaciones, para ignorar una fehca mandar null
     * @return lista de modelos con los estados de observaciones de los entes fiscalizadores
     * @throws Exception si existe un error de I/O
     */
    public List<ModelEstadoObservaciones> estadoObservacionesPorEnteFiscalizador(ModelFiltroFecha filtroFechas) throws Exception {
        List<EnteFiscalizador> entesFiscalizadores = this.findAll();
        List<ModelEstadoObservaciones> res = new ArrayList<>();
        ModelEstadoObservaciones modelEstadoObservaciones;
        int añoActual = new Date().getYear();
        for (EnteFiscalizador ente : entesFiscalizadores) {
            modelEstadoObservaciones = new ModelEstadoObservaciones(ente.getId(), ente.getNombre());
            for (AreaFiscalizadora area : ente.getAreaFiscalizadoraList()) {
                for (Auditoria auditoria : area.getAuditoriaList()) {
                    Stream<Observacion> sObservaciones = auditoria.getObservacionList().stream();
                    if (filtroFechas.getFechaInicio() != null) {
                        sObservaciones = sObservaciones.filter(o -> !o.getFechaRegistro().before(filtroFechas.getFechaInicio()));
                    }
                    if (filtroFechas.getFechaFin() != null) {
                        sObservaciones = sObservaciones.filter(o -> !o.getFechaRegistro().after(filtroFechas.getFechaFin()));
                    }
                    List<Observacion> observaciones = sObservaciones.collect(toList());
                    modelEstadoObservaciones.addNuevas((int) observaciones.stream().filter(o -> o.getFechaRegistro().getYear() == añoActual).count());
                    modelEstadoObservaciones.addVigentes((int) observaciones.stream().filter(o -> o.getFechaRegistro().getYear() != añoActual).count());
                    //modelEstadoObservaciones.addSolventadas((int) observaciones.stream().filter(o -> o.getIpra() == true && o.getStatusIpra() == 1 && o.getRecomendacionCorrectiva() == true && o.getRecomendacionPreventiva() == true).count());
                }
            }
            modelEstadoObservaciones.setTotales(modelEstadoObservaciones.getVigentes() + modelEstadoObservaciones.getNuevas() - modelEstadoObservaciones.getSolventadas());
            res.add(modelEstadoObservaciones);
        }
        return res;
    }
}
