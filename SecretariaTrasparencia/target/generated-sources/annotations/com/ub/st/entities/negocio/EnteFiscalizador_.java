package com.ub.st.entities.negocio;

import com.ub.st.entities.negocio.AreaFiscalizadora;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2018-04-10T14:59:19")
@StaticMetamodel(EnteFiscalizador.class)
public class EnteFiscalizador_ { 

    public static volatile SingularAttribute<EnteFiscalizador, Integer> id;
    public static volatile ListAttribute<EnteFiscalizador, AreaFiscalizadora> areaFiscalizadoraList;
    public static volatile SingularAttribute<EnteFiscalizador, String> nombre;

}