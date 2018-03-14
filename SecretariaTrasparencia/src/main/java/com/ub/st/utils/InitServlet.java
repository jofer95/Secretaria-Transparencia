/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.utils;

import com.ub.st.daos.negocio.DaoPerfil;
import com.ub.st.daos.negocio.DaoPermiso;
import com.ub.st.daos.negocio.DaoSecretaria;
import com.ub.st.daos.negocio.DaoUsuario;
import com.ub.st.entities.negocio.Perfil;
import com.ub.st.entities.negocio.Permiso;
import com.ub.st.entities.negocio.Secretaria;
import com.ub.st.entities.negocio.Usuario;
import com.ub.st.services.commons.ServiceFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.reflections.Reflections;

/**
 * arranque de la aplicacion, configuracion y desconfiguracion
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class InitServlet implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("hola");

        DaoPermiso daoPermiso = new DaoPermiso();
        DaoPerfil daoPerfil = new DaoPerfil();
        DaoUsuario daoUsuario = new DaoUsuario();
        DaoSecretaria daoSecretaria = new DaoSecretaria();

        //creacion de permisos                
        List<String> clasesARegistrar = this.getClassesSimpleNameFromPackage("com.ub.st.services.negocio");
        List<Permiso> permisos = new ArrayList<>();
        for (String clase : clasesARegistrar) {
            try {
                Permiso p = daoPermiso.findOne(clase);
                if (p == null) {
                    p = new Permiso();
                    p.setId(clase);
                    p.setDescripcion("generado por listener");
                    daoPermiso.persist(p);
                }
                permisos.add(p);
            } catch (Exception ex) {
                Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //creacion de perfil
        Perfil perfil = null;
        try {
            perfil = daoPerfil.findFirst();
            if (perfil == null) {
                perfil = new Perfil();
                perfil.setNombre("administrador");
                perfil.setPermisoList(permisos);
                daoPerfil.persist(perfil);
            } else {
                perfil.setPermisoList(permisos);
                daoPerfil.update(perfil);
            }

        } catch (Exception e) {
        }

        Secretaria secre = null;
        try {
            secre = daoSecretaria.findFirst();
            if (secre == null) {
                secre = new Secretaria();
                secre.setNombre("General");
                daoSecretaria.persist(secre);
            }
        } catch (Exception ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //crear usuario administrador
        Usuario admin = null;
        try {
            admin = daoUsuario.findFirst();
            if (admin == null) {
                admin = new Usuario();
                admin.setCorreo("ubg700@gmail.com");
                admin.setNombre("admin");
                admin.setContra(UtilsSecurity.cifrarMD5("1234"));
                admin.setPerfil(perfil);
                admin.setSecretaria(secre);
                daoUsuario.persist(admin);
            }

        } catch (Exception e) {
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("bye");
    }

    private List<String> getClassesSimpleNameFromPackage(String packageName) {
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends ServiceFacade>> subtypes = reflections.getSubTypesOf(ServiceFacade.class);
        return subtypes.stream().map(c -> c.getSimpleName()).collect(toList());
    }
}
