/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.models.accesos;

/**
 * modelo de datos para inicio de sesion
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ModelLogin {

    private String usuario;
    private String contra;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

}
