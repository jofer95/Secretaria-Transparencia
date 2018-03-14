/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.daos.negocio;

import com.ub.st.daos.commons.DaoSQLFacade;
import com.ub.st.entities.negocio.Programa;
import com.ub.st.utils.UtilsDB;

/**
 *
 * @author Jorge Barraza
 */
public class DaoPrograma extends DaoSQLFacade<Programa, Integer> {
    
    public DaoPrograma() {
        super(UtilsDB.getEMFactoryDefault(), Programa.class);
    }
    
}
