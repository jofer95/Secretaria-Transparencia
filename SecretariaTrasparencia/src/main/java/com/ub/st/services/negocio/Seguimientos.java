/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.services.negocio;

import com.ub.st.entities.negocio.Seguimiento;
import com.ub.st.managers.negocio.ManagerSeguimiento;
import com.ub.st.services.commons.ServiceFacade;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Servicios LCRUD para catálogo seguimientos
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Path("/seguimientos")
public class Seguimientos extends ServiceFacade<ManagerSeguimiento, Seguimiento, Integer> {

    public Seguimientos() {
        super(ManagerSeguimiento.class);
    }

    @Path("/observacion/{id}")
    @GET
    public List<Seguimiento> seguimientosDeObservacion(@HeaderParam("Authorization") String token, @PathParam("id") int id) {
        ManagerSeguimiento managerObervacion = new ManagerSeguimiento();
        return managerObervacion.stream().where(o -> o.getObservacion().getId() == id).collect(toList());
    }

}
