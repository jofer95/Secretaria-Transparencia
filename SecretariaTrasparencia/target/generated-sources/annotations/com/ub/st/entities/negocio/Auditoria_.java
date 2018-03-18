package com.ub.st.entities.negocio;

import com.ub.st.entities.negocio.AreaFiscalizadora;
import com.ub.st.entities.negocio.EnteFiscalizado;
import com.ub.st.entities.negocio.Observacion;
import com.ub.st.entities.negocio.Programa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2018-03-17T23:53:31")
@StaticMetamodel(Auditoria.class)
public class Auditoria_ { 

    public static volatile SingularAttribute<Auditoria, String> descripcion;
    public static volatile ListAttribute<Auditoria, Observacion> observacionList;
    public static volatile SingularAttribute<Auditoria, String> situacionActual;
    public static volatile SingularAttribute<Auditoria, Integer> anioRealiza;
    public static volatile SingularAttribute<Auditoria, String> numero;
    public static volatile ListAttribute<Auditoria, Programa> programaList;
    public static volatile SingularAttribute<Auditoria, String> objetivos;
    public static volatile SingularAttribute<Auditoria, Integer> anioRevisa;
    public static volatile ListAttribute<Auditoria, EnteFiscalizado> enteFiscalizadoList;
    public static volatile SingularAttribute<Auditoria, Integer> id;
    public static volatile ListAttribute<Auditoria, AreaFiscalizadora> areaFiscalizadoraList;
    public static volatile SingularAttribute<Auditoria, String> nombre;

}