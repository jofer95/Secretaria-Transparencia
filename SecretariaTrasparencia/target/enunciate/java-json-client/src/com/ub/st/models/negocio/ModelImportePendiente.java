/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package com.ub.st.models.negocio;

import com.fasterxml.jackson.annotation.*;

/**
 *  modelo con los importes calculados de las auditorias segun un ente
 * 
 *  @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class ModelImportePendiente implements java.io.Serializable {

  @JsonIgnore
  private double _importeObservado;
  @JsonIgnore
  private double _importeRecuperado;
  @JsonIgnore
  private double _importeAclarado;
  @JsonIgnore
  private double _importePendiente;
  @JsonIgnore
  private int _enteId;
  @JsonIgnore
  private java.lang.String _nombreEnte;

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
  @JsonProperty( value = "importeRecuperado", required = false )
  public double getImporteRecuperado() {
    return this._importeRecuperado;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "importeRecuperado", required = false )
  public void setImporteRecuperado(double _importeRecuperado) {
    this._importeRecuperado = _importeRecuperado;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "importeAclarado", required = false )
  public double getImporteAclarado() {
    return this._importeAclarado;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "importeAclarado", required = false )
  public void setImporteAclarado(double _importeAclarado) {
    this._importeAclarado = _importeAclarado;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "importePendiente", required = false )
  public double getImportePendiente() {
    return this._importePendiente;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "importePendiente", required = false )
  public void setImportePendiente(double _importePendiente) {
    this._importePendiente = _importePendiente;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "enteId", required = false )
  public int getEnteId() {
    return this._enteId;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "enteId", required = false )
  public void setEnteId(int _enteId) {
    this._enteId = _enteId;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "nombreEnte", required = false )
  public java.lang.String getNombreEnte() {
    return this._nombreEnte;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "nombreEnte", required = false )
  public void setNombreEnte(java.lang.String _nombreEnte) {
    this._nombreEnte = _nombreEnte;
  }
}
