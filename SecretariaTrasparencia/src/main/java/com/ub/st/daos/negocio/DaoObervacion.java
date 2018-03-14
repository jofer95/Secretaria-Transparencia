/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.daos.negocio;

import com.ub.st.daos.commons.DaoSQLFacade;
import com.ub.st.entities.negocio.Observacion;
import com.ub.st.utils.UtilsDB;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class DaoObervacion extends DaoSQLFacade<Observacion, Integer> {

    public DaoObervacion() {
        super(UtilsDB.getEMFactoryDefault(), Observacion.class);
    }

    @Override
    public List<Observacion> persistAll(List<Observacion> entities) throws Exception {
        entities.forEach(o -> o.setFechaRegistro(new Date()));
        return super.persistAll(entities); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persist(Observacion entity) throws Exception {
        entity.setFechaRegistro(new Date());
        super.persist(entity); //To change body of generated methods, choose Tools | Templates.
    }

}
