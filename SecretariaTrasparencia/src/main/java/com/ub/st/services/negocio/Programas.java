/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.Programa;
import com.ub.st.managers.negocio.ManagerPrograma;
import com.ub.st.services.commons.ServiceFacade;
import javax.ws.rs.Path;

/**
 * Servicios lcrud para programas y de negocio
 * 
 * @author Jorge Barraza
 */
@Path("/programas")
public class Programas extends ServiceFacade<ManagerPrograma, Programa, Integer> {
    
    public Programas() {
        super(ManagerPrograma.class);
    }
    
}
