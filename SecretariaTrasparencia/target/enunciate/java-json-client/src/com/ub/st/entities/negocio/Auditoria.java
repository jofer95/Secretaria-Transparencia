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
public class Auditoria extends com.ub.st.entities.commons.EntitySQL<java.lang.Integer> {

  @JsonIgnore
  private java.lang.Integer _id;
  @JsonIgnore
  private int _anioRealiza;
  @JsonIgnore
  private int _anioRevisa;
  @JsonIgnore
  private java.lang.String _situacionActual;
  @JsonIgnore
  private java.lang.String _numero;
  @JsonIgnore
  private java.lang.String _nombre;
  @JsonIgnore
  private java.lang.String _descripcion;
  @JsonIgnore
  private java.lang.String _objetivos;
  @JsonIgnore
  private java.util.List<com.ub.st.entities.negocio.EnteFiscalizado> _enteFiscalizadoList;
  @JsonIgnore
  private java.util.List<com.ub.st.entities.negocio.AreaFiscalizadora> _areaFiscalizadoraList;
  @JsonIgnore
  private java.util.List<com.ub.st.entities.negocio.Programa> _programaList;

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
  @JsonProperty( value = "anioRealiza", required = false )
  public int getAnioRealiza() {
    return this._anioRealiza;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "anioRealiza", required = false )
  public void setAnioRealiza(int _anioRealiza) {
    this._anioRealiza = _anioRealiza;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "anioRevisa", required = false )
  public int getAnioRevisa() {
    return this._anioRevisa;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "anioRevisa", required = false )
  public void setAnioRevisa(int _anioRevisa) {
    this._anioRevisa = _anioRevisa;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "situacionActual", required = false )
  public java.lang.String getSituacionActual() {
    return this._situacionActual;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "situacionActual", required = false )
  public void setSituacionActual(java.lang.String _situacionActual) {
    this._situacionActual = _situacionActual;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "numero", required = false )
  public java.lang.String getNumero() {
    return this._numero;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "numero", required = false )
  public void setNumero(java.lang.String _numero) {
    this._numero = _numero;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "nombre", required = false )
  public java.lang.String getNombre() {
    return this._nombre;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "nombre", required = false )
  public void setNombre(java.lang.String _nombre) {
    this._nombre = _nombre;
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
  @JsonProperty( value = "objetivos", required = false )
  public java.lang.String getObjetivos() {
    return this._objetivos;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "objetivos", required = false )
  public void setObjetivos(java.lang.String _objetivos) {
    this._objetivos = _objetivos;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "enteFiscalizadoList", required = false )
  public java.util.List<com.ub.st.entities.negocio.EnteFiscalizado> getEnteFiscalizadoList() {
    return this._enteFiscalizadoList;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "enteFiscalizadoList", required = false )
  public void setEnteFiscalizadoList(java.util.List<com.ub.st.entities.negocio.EnteFiscalizado> _enteFiscalizadoList) {
    this._enteFiscalizadoList = _enteFiscalizadoList;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "areaFiscalizadoraList", required = false )
  public java.util.List<com.ub.st.entities.negocio.AreaFiscalizadora> getAreaFiscalizadoraList() {
    return this._areaFiscalizadoraList;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "areaFiscalizadoraList", required = false )
  public void setAreaFiscalizadoraList(java.util.List<com.ub.st.entities.negocio.AreaFiscalizadora> _areaFiscalizadoraList) {
    this._areaFiscalizadoraList = _areaFiscalizadoraList;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "programaList", required = false )
  public java.util.List<com.ub.st.entities.negocio.Programa> getProgramaList() {
    return this._programaList;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "programaList", required = false )
  public void setProgramaList(java.util.List<com.ub.st.entities.negocio.Programa> _programaList) {
    this._programaList = _programaList;
  }
}
