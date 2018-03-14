/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.entities.negocio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ub.st.entities.commons.EntitySQL;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@Entity
@Table(name = "ente_fiscalizado")
public class EnteFiscalizado extends EntitySQL<Integer> implements Serializable {

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enteAuditado")
//    private List<Observacion> observacionList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "enteFiscalizadoList", fetch = FetchType.EAGER)
    private List<Auditoria> auditoriaList;

    public EnteFiscalizado() {
    }

    public EnteFiscalizado(Integer id) {
        this.id = id;
    }

    public EnteFiscalizado(String nombre) {
        this.nombre = nombre;
    }

    public EnteFiscalizado(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonIgnore
    public List<Auditoria> getAuditoriaList() {
        return auditoriaList;
    }

    public void setAuditoriaList(List<Auditoria> auditoriaList) {
        this.auditoriaList = auditoriaList;
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
        if (!(object instanceof EnteFiscalizado)) {
            return false;
        }
        EnteFiscalizado other = (EnteFiscalizado) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.ub.st.entities.negocio.EnteFiscalizado[ id=" + id + " ]";
    }

    @Override
    public Integer obtenIdEntidad() {
        return id;
    }

//    public List<Observacion> getObservacionList() {
//        return observacionList;
//    }
//
//    public void setObservacionList(List<Observacion> observacionList) {
//        this.observacionList = observacionList;
//    }
}
