package com.ub.st.entities.negocio;

import com.ub.st.entities.negocio.Permiso;
import com.ub.st.entities.negocio.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2018-03-14T01:13:57")
@StaticMetamodel(Perfil.class)
public class Perfil_ { 

    public static volatile ListAttribute<Perfil, Usuario> usuarioList;
    public static volatile SingularAttribute<Perfil, Integer> id;
    public static volatile SingularAttribute<Perfil, String> nombre;
    public static volatile ListAttribute<Perfil, Permiso> permisoList;

}