package com.ub.st.entities.negocio;

import com.ub.st.entities.negocio.Auditoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2018-05-05T13:48:08")
@StaticMetamodel(Programa.class)
public class Programa_ { 

    public static volatile SingularAttribute<Programa, String> siglas;
    public static volatile SingularAttribute<Programa, String> programa;
    public static volatile ListAttribute<Programa, Auditoria> auditoriaList;
    public static volatile SingularAttribute<Programa, Integer> id;

}