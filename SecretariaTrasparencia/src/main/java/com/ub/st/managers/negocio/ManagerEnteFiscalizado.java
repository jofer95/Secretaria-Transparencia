/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.managers.negocio;

import com.ub.st.daos.negocio.DaoEnteFiscalizado;
import com.ub.st.entities.negocio.Auditoria;
import com.ub.st.entities.negocio.EnteFiscalizado;
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
public class ManagerEnteFiscalizado extends ManagerSQL<EnteFiscalizado, Integer> {

    public ManagerEnteFiscalizado() {
        super(new DaoEnteFiscalizado());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        return "entesFiscalizados";
    }

    /**
     * Calcula los importe agrupados por ente fiscalizado
     *
     * @param filtroFechas modelo de filtro de fechas, mandar null o no mandar alguna fecha para ignorar el filtro
     * @return lista de modelos de importes
     * @throws Exception si existe un error de I/O
     */
    public List<ModelImportePendiente> importesPendientesPorEnteFiscalizado(ModelFiltroFecha filtroFechas) throws Exception {
        List<EnteFiscalizado> entesFiscalizados = this.findAll();
        List<ModelImportePendiente> res = new ArrayList<>();
        ModelImportePendiente importePendiente;
        double importeObservado, importeAclarado, importeRecuperado;
        for (EnteFiscalizado ente : entesFiscalizados) {
            importePendiente = new ModelImportePendiente();
            importeObservado = 0;
            importeAclarado = 0;
            importeRecuperado = 0;
            for (Auditoria auditoria : ente.getAuditoriaList()) {
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
     * obtiene los estaos de las observaciones agrupado por ente fiscalizado
     *
     * @param filtroFecha modelo de filtro por fechas, mandar null alguna fecha para ignorar el filtrado
     * @return lista de modelos de estados de observaciones
     * @throws Exception
     */
    public List<ModelEstadoObservaciones> estadoObservacionesPorEnteFiscalizado(ModelFiltroFecha filtroFecha) throws Exception {
        List<EnteFiscalizado> entesFiscalizados = this.findAll();
        List<ModelEstadoObservaciones> res = new ArrayList<>();
        ModelEstadoObservaciones modelEstadoObservaciones;
        int añoActual = new Date().getYear();
        for (EnteFiscalizado ente : entesFiscalizados) {
            modelEstadoObservaciones = new ModelEstadoObservaciones(ente.getId(), ente.getNombre());
            for (Auditoria auditoria : ente.getAuditoriaList()) {
                Stream<Observacion> sObservaciones = auditoria.getObservacionList().stream();
                if (filtroFecha.getFechaInicio() != null) {
                    sObservaciones = sObservaciones.filter(o -> !o.getFechaRegistro().before(filtroFecha.getFechaInicio()));
                }
                if (filtroFecha.getFechaFin() != null) {
                    sObservaciones = sObservaciones.filter(o -> !o.getFechaRegistro().after(filtroFecha.getFechaFin()));
                }
                List<Observacion> observaciones = sObservaciones.collect(toList());
                modelEstadoObservaciones.addNuevas((int) observaciones.stream().filter(o -> o.getFechaRegistro().getYear() == añoActual).count());
                modelEstadoObservaciones.addVigentes((int) observaciones.stream().filter(o -> o.getFechaRegistro().getYear() != añoActual).count());
                //modelEstadoObservaciones.addSolventadas((int) observaciones.stream().filter(o -> o.getIpra() == true && o.getStatusIpra() == 1 && o.getRecomendacionCorrectiva() == true && o.getRecomendacionPreventiva() == true).count());
            }
            modelEstadoObservaciones.setTotales(modelEstadoObservaciones.getVigentes() + modelEstadoObservaciones.getNuevas() - modelEstadoObservaciones.getSolventadas());
            res.add(modelEstadoObservaciones);
        }
        return res;
    }

}
