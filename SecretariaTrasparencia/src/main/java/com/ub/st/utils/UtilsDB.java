/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.jinq.jpa.JinqJPAStreamProvider;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class UtilsDB {

    //<editor-fold defaultstate="collapsed" desc="JPA utils">
    /*
        the jpa clients are defined here,
        you need to add the factories and streams providers
        for each persistence unit you nedd
     */
    //</editor-fold>
    private static EntityManagerFactory eMFactory;

    /**
     * PERSISTENCE UNIT NAMES
     */
    private static final String UNIT_NAME = "st";

    /**
     * metodo fábrica de manejadores de entidad de de la base de datos "easymoney"
     *
     * @return entityManagerFactory de la conexion a la base de datos CG
     */
    public static EntityManagerFactory getEMFactoryDefault() {
        if (eMFactory == null) {
            eMFactory = Persistence.createEntityManagerFactory(UNIT_NAME);
        }
        return eMFactory;
    }

}
