/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.managers.negocio;

import com.ub.st.daos.negocio.DaoAuditoria;
import com.ub.st.daos.negocio.DaoSeguimiento;
import com.ub.st.entities.negocio.Auditoria;
import com.ub.st.entities.negocio.Observacion;
import com.ub.st.entities.negocio.Seguimiento;
import com.ub.st.managers.commons.ManagerSQL;
import com.ub.st.models.negocio.ModelImportePendiente;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ManagerAuditoria extends ManagerSQL<Auditoria, Integer> {

    public ManagerAuditoria() {
        super(new DaoAuditoria());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        return "auditorias";
    }

    public ModelImportePendiente importePendienteAuditoria(int id) throws Exception {
        ModelImportePendiente modelImporte = new ModelImportePendiente();

        Auditoria auditoria = this.findOne(id);
        List<Observacion> observaciones = auditoria.getObservacionList();
        List<Integer> observacionesId = observaciones.stream().map(e -> e.getId()).collect(toList());

        //importe pendiente = importe observado - ( importe aclarado + importe recuperado)                
        modelImporte.setImporteObservado(observaciones.stream().mapToDouble(o -> o.getImporteObservado()).sum());

        DaoSeguimiento daoSeguimiento = new DaoSeguimiento();
        if (!observaciones.isEmpty()) {
            List<Seguimiento> seguimientos = daoSeguimiento.stream().where(e -> observacionesId.contains(e.getObservacion().getId())).collect(toList());

            modelImporte.setImporteAclarado(seguimientos.stream().mapToDouble(e -> e.getImporteAclarado()).sum());
            modelImporte.setImporteRecuperado(seguimientos.stream().mapToDouble(e -> e.getImporteRecuperado()).sum());

            modelImporte.setImportePendiente(modelImporte.getImporteObservado() - (modelImporte.getImporteAclarado() + modelImporte.getImporteRecuperado()));
        }

        return modelImporte;
    }

    public ModelImportePendiente importePendienteAuditorias(List<Auditoria> auditorias) {
        ModelImportePendiente importePendiente = new ModelImportePendiente();
        double importeObservado = 0;
        double importeAclarado = 0;
        double importeRecuperado = 0;
        for (Auditoria auditoria : auditorias) {
            for (Observacion observacion : auditoria.getObservacionList()) {
                importeObservado += observacion.getImporteObservado();
                for (Seguimiento seguimiento : observacion.getSeguimientoList()) {
                    importeAclarado += seguimiento.getImporteAclarado();
                    importeRecuperado += seguimiento.getImporteRecuperado();
                }
            }
        }
        importePendiente.setImporteAclarado(importeAclarado);
        importePendiente.setImporteRecuperado(importeRecuperado);
        importePendiente.setImporteObservado(importeObservado);
        importePendiente.setImportePendiente(importeObservado - (importeAclarado + importeRecuperado));
        return importePendiente;
    }

}
