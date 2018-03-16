package com.ub.st.entities.negocio;

import com.ub.st.entities.negocio.Observacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2018-03-16T12:08:32")
@StaticMetamodel(Seguimiento.class)
public class Seguimiento_ { 

    public static volatile SingularAttribute<Seguimiento, String> recomendacionCorrectiva;
    public static volatile SingularAttribute<Seguimiento, Double> importeAclarado;
    public static volatile SingularAttribute<Seguimiento, String> numeroOficio;
    public static volatile SingularAttribute<Seguimiento, String> documentacionAnexa;
    public static volatile SingularAttribute<Seguimiento, String> antecedentes;
    public static volatile SingularAttribute<Seguimiento, String> recomendacionPreventiva;
    public static volatile SingularAttribute<Seguimiento, Integer> id;
    public static volatile SingularAttribute<Seguimiento, String> docuemntacionRecibida;
    public static volatile SingularAttribute<Seguimiento, Integer> numeroDictamen;
    public static volatile SingularAttribute<Seguimiento, Double> importeRecuperado;
    public static volatile SingularAttribute<Seguimiento, Observacion> observacion;

}