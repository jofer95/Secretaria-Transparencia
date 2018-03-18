/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.entities.negocio;

import com.ub.st.entities.commons.EntitySQL;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Entity
@Cacheable(false)
@Table(name = "seguimiento")
public class Seguimiento extends EntitySQL<Integer> implements Serializable {    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "antecedentes")
    private String antecedentes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_dictamen")
    private int numeroDictamen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "docuemntacion_recibida")
    private String docuemntacionRecibida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "documentacion_anexa")
    private String documentacionAnexa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "recomendacion_preventiva")
    private String recomendacionPreventiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "recomendacion_correctiva")
    private String recomendacionCorrectiva;
    @JoinColumn(name = "observacion", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Observacion observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_aclarado")
    private double importeAclarado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_recuperado")
    private double importeRecuperado;
    @Column(name = "numero_oficio")
    private String numeroOficio;
    @NotNull
    @Size(max = 2147483647)
    @Column(name = "comentario")
    private String comentario;
    @NotNull
    @Size(max = 2147483647)
    @Column(name = "numero_oficio_entefiscalizador")
    private String numeroOficioEntefiscalizador;

    public Seguimiento() {
    }

    public Seguimiento(Integer id) {
        this.id = id;
    }

    public Seguimiento(Integer id, String antecedentes, int numeroDictamen, String docuemntacionRecibida, String documentacionAnexa, String recomendacionPreventiva, String recomendacionCorrectiva) {
        this.id = id;
        this.antecedentes = antecedentes;
        this.numeroDictamen = numeroDictamen;
        this.docuemntacionRecibida = docuemntacionRecibida;
        this.documentacionAnexa = documentacionAnexa;
        this.recomendacionPreventiva = recomendacionPreventiva;
        this.recomendacionCorrectiva = recomendacionCorrectiva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public int getNumeroDictamen() {
        return numeroDictamen;
    }

    public void setNumeroDictamen(int numeroDictamen) {
        this.numeroDictamen = numeroDictamen;
    }

    public String getDocuemntacionRecibida() {
        return docuemntacionRecibida;
    }

    public void setDocuemntacionRecibida(String docuemntacionRecibida) {
        this.docuemntacionRecibida = docuemntacionRecibida;
    }

    public String getDocumentacionAnexa() {
        return documentacionAnexa;
    }

    public void setDocumentacionAnexa(String documentacionAnexa) {
        this.documentacionAnexa = documentacionAnexa;
    }

    public String getRecomendacionPreventiva() {
        return recomendacionPreventiva;
    }

    public void setRecomendacionPreventiva(String recomendacionPreventiva) {
        this.recomendacionPreventiva = recomendacionPreventiva;
    }

    public String getRecomendacionCorrectiva() {
        return recomendacionCorrectiva;
    }

    public void setRecomendacionCorrectiva(String recomendacionCorrectiva) {
        this.recomendacionCorrectiva = recomendacionCorrectiva;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }

    public double getImporteAclarado() {
        return importeAclarado;
    }

    public void setImporteAclarado(double importeAclarado) {
        this.importeAclarado = importeAclarado;
    }

    public double getImporteRecuperado() {
        return importeRecuperado;
    }

    public void setImporteRecuperado(double importeRecuperado) {
        this.importeRecuperado = importeRecuperado;
    }

    public String getNumeroOficio() {
        return numeroOficio;
    }

    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
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
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.st.entities.negocio.Seguimiento[ id=" + id + " ]";
    }

    @Override
    public Integer obtenIdEntidad() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNumeroOficioEntefiscalizador() {
        return numeroOficioEntefiscalizador;
    }

    public void setNumeroOficioEntefiscalizador(String numeroOficioEntefiscalizador) {
        this.numeroOficioEntefiscalizador = numeroOficioEntefiscalizador;
    }

}
