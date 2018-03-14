/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
//        try {
//            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
//            resources.add(jacksonProvider);
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically populated with all resources defined in the project. If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.ub.st.services.commons.ServiceFacade.class);
        resources.add(com.ub.st.services.generales.Accesos.class);
        resources.add(com.ub.st.services.generales.Carga.class);
        resources.add(com.ub.st.services.negocio.Auditorias.class);
        resources.add(com.ub.st.services.negocio.Contratistas.class);
        resources.add(com.ub.st.services.negocio.CoordinacionesGenerales.class);
        resources.add(com.ub.st.services.negocio.EntesFiscalizadores.class);
        resources.add(com.ub.st.services.negocio.EntesFiscalizados.class);
        resources.add(com.ub.st.services.negocio.EntidadesCoordinadas.class);
        resources.add(com.ub.st.services.negocio.EstatusObservaciones.class);
        resources.add(com.ub.st.services.negocio.Obervaciones.class);
        resources.add(com.ub.st.services.negocio.OrganismosDescentralizados.class);
        resources.add(com.ub.st.services.negocio.OrganismosDesconcentrados.class);
        resources.add(com.ub.st.services.negocio.Perfiles.class);
        resources.add(com.ub.st.services.negocio.Permisos.class);
        resources.add(com.ub.st.services.negocio.Programas.class);
        resources.add(com.ub.st.services.negocio.Secretarias.class);
        resources.add(com.ub.st.services.negocio.Seguimientos.class);
        resources.add(com.ub.st.services.negocio.TiposObservaciones.class);
        resources.add(com.ub.st.services.negocio.Usuarios.class);
    }

}
