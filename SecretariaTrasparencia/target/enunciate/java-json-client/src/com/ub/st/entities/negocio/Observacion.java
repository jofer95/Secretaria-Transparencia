/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package com.ub.st.entities.negocio;

import com.fasterxml.jackson.annotation.*;

/**
 * 
 *  @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class Observacion extends com.ub.st.entities.commons.EntitySQL<java.lang.Integer> {

  @JsonIgnore
  private java.lang.Integer _id;
  @JsonIgnore
  private java.lang.String _numeroExpediente;
  @JsonIgnore
  private java.lang.String _numeroObservacion;
  @JsonIgnore
  private java.lang.String _descripcion;
  @JsonIgnore
  private com.ub.st.entities.negocio.Contratista _contratista;
  @JsonIgnore
  private java.lang.String _pendiente;
  @JsonIgnore
  private com.ub.st.entities.negocio.Auditoria _auditoria;
  @JsonIgnore
  private double _importeObservado;
  @JsonIgnore
  private com.ub.st.entities.negocio.TipoObservacion _tipoObservacion;
  @JsonIgnore
  private java.util.Date _fechaRegistro;
  @JsonIgnore
  private com.ub.st.entities.negocio.EnteFiscalizado _enteAuditado;
  @JsonIgnore
  private com.ub.st.entities.negocio.EstatusObservacion _estatus;
  @JsonIgnore
  private boolean _recomendacionPreventiva;
  @JsonIgnore
  private java.lang.String _desRecomendacionPreventiva;
  @JsonIgnore
  private boolean _ipra;
  @JsonIgnore
  private int _statusIpra;
  @JsonIgnore
  private boolean _recomendacionCorrectiva;
  @JsonIgnore
  private java.lang.String _desRecomendacionCorrectiva;

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "id", required = false )
  public java.lang.Integer getId() {
    return this._id;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "id", required = false )
  public void setId(java.lang.Integer _id) {
    this._id = _id;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "numeroExpediente", required = false )
  public java.lang.String getNumeroExpediente() {
    return this._numeroExpediente;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "numeroExpediente", required = false )
  public void setNumeroExpediente(java.lang.String _numeroExpediente) {
    this._numeroExpediente = _numeroExpediente;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "numeroObservacion", required = false )
  public java.lang.String getNumeroObservacion() {
    return this._numeroObservacion;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "numeroObservacion", required = false )
  public void setNumeroObservacion(java.lang.String _numeroObservacion) {
    this._numeroObservacion = _numeroObservacion;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "descripcion", required = false )
  public java.lang.String getDescripcion() {
    return this._descripcion;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "descripcion", required = false )
  public void setDescripcion(java.lang.String _descripcion) {
    this._descripcion = _descripcion;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "contratista", required = false )
  public com.ub.st.entities.negocio.Contratista getContratista() {
    return this._contratista;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "contratista", required = false )
  public void setContratista(com.ub.st.entities.negocio.Contratista _contratista) {
    this._contratista = _contratista;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "pendiente", required = false )
  public java.lang.String getPendiente() {
    return this._pendiente;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "pendiente", required = false )
  public void setPendiente(java.lang.String _pendiente) {
    this._pendiente = _pendiente;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "auditoria", required = false )
  public com.ub.st.entities.negocio.Auditoria getAuditoria() {
    return this._auditoria;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "auditoria", required = false )
  public void setAuditoria(com.ub.st.entities.negocio.Auditoria _auditoria) {
    this._auditoria = _auditoria;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "importeObservado", required = false )
  public double getImporteObservado() {
    return this._importeObservado;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "importeObservado", required = false )
  public void setImporteObservado(double _importeObservado) {
    this._importeObservado = _importeObservado;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "tipoObservacion", required = false )
  public com.ub.st.entities.negocio.TipoObservacion getTipoObservacion() {
    return this._tipoObservacion;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "tipoObservacion", required = false )
  public void setTipoObservacion(com.ub.st.entities.negocio.TipoObservacion _tipoObservacion) {
    this._tipoObservacion = _tipoObservacion;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "fechaRegistro", required = false )
  public java.util.Date getFechaRegistro() {
    return this._fechaRegistro;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "fechaRegistro", required = false )
  public void setFechaRegistro(java.util.Date _fechaRegistro) {
    this._fechaRegistro = _fechaRegistro;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "enteAuditado", required = false )
  public com.ub.st.entities.negocio.EnteFiscalizado getEnteAuditado() {
    return this._enteAuditado;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "enteAuditado", required = false )
  public void setEnteAuditado(com.ub.st.entities.negocio.EnteFiscalizado _enteAuditado) {
    this._enteAuditado = _enteAuditado;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "estatus", required = false )
  public com.ub.st.entities.negocio.EstatusObservacion getEstatus() {
    return this._estatus;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "estatus", required = false )
  public void setEstatus(com.ub.st.entities.negocio.EstatusObservacion _estatus) {
    this._estatus = _estatus;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "recomendacionPreventiva", required = false )
  public boolean getRecomendacionPreventiva() {
    return this._recomendacionPreventiva;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "recomendacionPreventiva", required = false )
  public void setRecomendacionPreventiva(boolean _recomendacionPreventiva) {
    this._recomendacionPreventiva = _recomendacionPreventiva;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "desRecomendacionPreventiva", required = false )
  public java.lang.String getDesRecomendacionPreventiva() {
    return this._desRecomendacionPreventiva;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "desRecomendacionPreventiva", required = false )
  public void setDesRecomendacionPreventiva(java.lang.String _desRecomendacionPreventiva) {
    this._desRecomendacionPreventiva = _desRecomendacionPreventiva;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "ipra", required = false )
  public boolean getIpra() {
    return this._ipra;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "ipra", required = false )
  public void setIpra(boolean _ipra) {
    this._ipra = _ipra;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "statusIpra", required = false )
  public int getStatusIpra() {
    return this._statusIpra;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "statusIpra", required = false )
  public void setStatusIpra(int _statusIpra) {
    this._statusIpra = _statusIpra;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "recomendacionCorrectiva", required = false )
  public boolean getRecomendacionCorrectiva() {
    return this._recomendacionCorrectiva;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "recomendacionCorrectiva", required = false )
  public void setRecomendacionCorrectiva(boolean _recomendacionCorrectiva) {
    this._recomendacionCorrectiva = _recomendacionCorrectiva;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "desRecomendacionCorrectiva", required = false )
  public java.lang.String getDesRecomendacionCorrectiva() {
    return this._desRecomendacionCorrectiva;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "desRecomendacionCorrectiva", required = false )
  public void setDesRecomendacionCorrectiva(java.lang.String _desRecomendacionCorrectiva) {
    this._desRecomendacionCorrectiva = _desRecomendacionCorrectiva;
  }
}
