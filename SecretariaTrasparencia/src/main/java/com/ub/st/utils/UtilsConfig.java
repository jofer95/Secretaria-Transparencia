/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.utils;

import com.ub.st.entities.negocio.ConfigMail;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public final class UtilsConfig {

    static int getSecondsSessionJwtExp() {
        return 120000;
    }

    static ConfigMail getResetPasswordConfigMail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
