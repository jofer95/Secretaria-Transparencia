package com.ub.st.entities.negocio;

import com.ub.st.entities.negocio.Auditoria;
import com.ub.st.entities.negocio.Contratista;
import com.ub.st.entities.negocio.EnteFiscalizado;
import com.ub.st.entities.negocio.EstatusObservacion;
import com.ub.st.entities.negocio.Seguimiento;
import com.ub.st.entities.negocio.TipoObservacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.5.v20170607-rNA", date="2018-04-10T14:59:19")
@StaticMetamodel(Observacion.class)
public class Observacion_ { 

    public static volatile SingularAttribute<Observacion, Boolean> recomendacionCorrectiva;
    public static volatile SingularAttribute<Observacion, String> descripcion;
    public static volatile SingularAttribute<Observacion, Double> importeObservado;
    public static volatile SingularAttribute<Observacion, String> desRecomendacionPreventiva;
    public static volatile SingularAttribute<Observacion, EnteFiscalizado> enteAuditado;
    public static volatile SingularAttribute<Observacion, String> numeroObservacion;
    public static volatile SingularAttribute<Observacion, TipoObservacion> tipoObservacion;
    public static volatile SingularAttribute<Observacion, String> desRecomendacionCorrectiva;
    public static volatile SingularAttribute<Observacion, Date> fechaRegistro;
    public static volatile SingularAttribute<Observacion, Boolean> ipra;
    public static volatile SingularAttribute<Observacion, String> pendiente;
    public static volatile SingularAttribute<Observacion, Integer> statusIpra;
    public static volatile SingularAttribute<Observacion, String> numeroExpediente;
    public static volatile SingularAttribute<Observacion, Contratista> contratista;
    public static volatile ListAttribute<Observacion, Seguimiento> seguimientoList;
    public static volatile SingularAttribute<Observacion, EstatusObservacion> estatus;
    public static volatile SingularAttribute<Observacion, Boolean> recomendacionPreventiva;
    public static volatile SingularAttribute<Observacion, Integer> id;
    public static volatile SingularAttribute<Observacion, Auditoria> auditoria;

}