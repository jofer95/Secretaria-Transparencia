/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.entities.negocio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ub.st.entities.commons.EntitySQL;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Entity
@Cacheable(false)
@Table(name = "observacion")
public class Observacion extends EntitySQL<Integer> implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "recomendacion_preventiva")
    private boolean recomendacionPreventiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "des_recomendacion_preventiva")
    private String desRecomendacionPreventiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ipra")
    private boolean ipra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_ipra")
    private int statusIpra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recomendacion_correctiva")
    private boolean recomendacionCorrectiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "des_recomendacion_correctiva")
    private String desRecomendacionCorrectiva;

    @JoinColumn(name = "ente_auditado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EnteFiscalizado enteAuditado;
    @JoinColumn(name = "estatus", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstatusObservacion estatus;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_expediente")
    private String numeroExpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_observacion")
    private String numeroObservacion;
    @JoinColumn(name = "contratista", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Contratista contratista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "pendiente")
    private String pendiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observacion", fetch = FetchType.EAGER)
    private List<Seguimiento> seguimientoList;
    @JoinColumn(name = "auditoria", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)    
    private Auditoria auditoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_observado")
    private double importeObservado;
    @JoinColumn(name = "tipo_observacion", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoObservacion tipoObservacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public Observacion() {
    }

    public Observacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getNumeroObservacion() {
        return numeroObservacion;
    }

    public void setNumeroObservacion(String numeroObservacion) {
        this.numeroObservacion = numeroObservacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Contratista getContratista() {
        return contratista;
    }

    public void setContratista(Contratista contratista) {
        this.contratista = contratista;
    }

    public String getPendiente() {
        return pendiente;
    }

    public void setPendiente(String pendiente) {
        this.pendiente = pendiente;
    }

    @JsonIgnore
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    @Override
    public Integer obtenIdEntidad() {
        return id;
    }

    public double getImporteObservado() {
        return importeObservado;
    }

    public void setImporteObservado(double importeObservado) {
        this.importeObservado = importeObservado;
    }

    public TipoObservacion getTipoObservacion() {
        return tipoObservacion;
    }

    public void setTipoObservacion(TipoObservacion tipoObservacion) {
        this.tipoObservacion = tipoObservacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observacion)) {
            return false;
        }
        Observacion other = (Observacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.st.entities.negocio.Observacion[ id=" + id + " ]";
    }

    public EnteFiscalizado getEnteAuditado() {
        return enteAuditado;
    }

    public void setEnteAuditado(EnteFiscalizado enteAuditado) {
        this.enteAuditado = enteAuditado;
    }

    public EstatusObservacion getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusObservacion estatus) {
        this.estatus = estatus;
    }

    public boolean getRecomendacionPreventiva() {
        return recomendacionPreventiva;
    }

    public void setRecomendacionPreventiva(boolean recomendacionPreventiva) {
        this.recomendacionPreventiva = recomendacionPreventiva;
    }

    public String getDesRecomendacionPreventiva() {
        return desRecomendacionPreventiva;
    }

    public void setDesRecomendacionPreventiva(String desRecomendacionPreventiva) {
        this.desRecomendacionPreventiva = desRecomendacionPreventiva;
    }

    public boolean getIpra() {
        return ipra;
    }

    public void setIpra(boolean ipra) {
        this.ipra = ipra;
    }

    public int getStatusIpra() {
        return statusIpra;
    }

    public void setStatusIpra(int statusIpra) {
        this.statusIpra = statusIpra;
    }

    public boolean getRecomendacionCorrectiva() {
        return recomendacionCorrectiva;
    }

    public void setRecomendacionCorrectiva(boolean recomendacionCorrectiva) {
        this.recomendacionCorrectiva = recomendacionCorrectiva;
    }

    public String getDesRecomendacionCorrectiva() {
        return desRecomendacionCorrectiva;
    }

    public void setDesRecomendacionCorrectiva(String desRecomendacionCorrectiva) {
        this.desRecomendacionCorrectiva = desRecomendacionCorrectiva;
    }

}
