/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.entities.negocio;

import com.ub.st.entities.commons.EntitySQL;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
@Entity
@Table(name = "estatus_observacion")
@NamedQueries({
    @NamedQuery(name = "EstatusObservacion.findAll", query = "SELECT e FROM EstatusObservacion e")})
public class EstatusObservacion extends EntitySQL<Integer> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estatus")
//    private List<Observacion> observacionList;

    public EstatusObservacion() {
    }

    public EstatusObservacion(Integer id) {
        this.id = id;
    }

    public EstatusObservacion(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    public List<Observacion> getObservacionList() {
//        return observacionList;
//    }
//
//    public void setObservacionList(List<Observacion> observacionList) {
//        this.observacionList = observacionList;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstatusObservacion)) {
            return false;
        }
        EstatusObservacion other = (EstatusObservacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ub.st.entities.negocio.EstatusObservacion[ id=" + id + " ]";
    }

    @Override
    public Integer obtenIdEntidad() {
        return id;
    }

}
