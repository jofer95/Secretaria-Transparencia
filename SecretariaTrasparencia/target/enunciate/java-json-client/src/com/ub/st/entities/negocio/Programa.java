/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package com.ub.st.entities.negocio;

import com.fasterxml.jackson.annotation.*;

/**
 * 
 *  @author Jorge Barraza
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class Programa extends com.ub.st.entities.commons.EntitySQL<java.lang.Integer> {

  @JsonIgnore
  private java.lang.Integer _id;
  @JsonIgnore
  private java.lang.String _programa;
  @JsonIgnore
  private java.lang.String _siglas;
  @JsonIgnore
  private java.util.List<com.ub.st.entities.negocio.Auditoria> _auditoriaList;

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
  @JsonProperty( value = "programa", required = false )
  public java.lang.String getPrograma() {
    return this._programa;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "programa", required = false )
  public void setPrograma(java.lang.String _programa) {
    this._programa = _programa;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "siglas", required = false )
  public java.lang.String getSiglas() {
    return this._siglas;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "siglas", required = false )
  public void setSiglas(java.lang.String _siglas) {
    this._siglas = _siglas;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "auditoriaList", required = false )
  public java.util.List<com.ub.st.entities.negocio.Auditoria> getAuditoriaList() {
    return this._auditoriaList;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "auditoriaList", required = false )
  public void setAuditoriaList(java.util.List<com.ub.st.entities.negocio.Auditoria> _auditoriaList) {
    this._auditoriaList = _auditoriaList;
  }
}
