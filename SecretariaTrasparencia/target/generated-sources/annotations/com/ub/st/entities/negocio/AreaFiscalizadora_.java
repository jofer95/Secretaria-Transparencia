package com.ub.st.entities.negocio;

import com.ub.st.entities.negocio.Auditoria;
import com.ub.st.entities.negocio.EnteFiscalizador;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2018-03-17T23:53:31")
@StaticMetamodel(AreaFiscalizadora.class)
public class AreaFiscalizadora_ { 

    public static volatile SingularAttribute<AreaFiscalizadora, EnteFiscalizador> enteFiscalizador;
    public static volatile ListAttribute<AreaFiscalizadora, Auditoria> auditoriaList;
    public static volatile SingularAttribute<AreaFiscalizadora, Integer> id;
    public static volatile SingularAttribute<AreaFiscalizadora, String> nombre;

}