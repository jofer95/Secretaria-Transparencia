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
public class TipoObservacion extends com.ub.st.entities.commons.EntitySQL<java.lang.Integer> {

  @JsonIgnore
  private java.lang.Integer _id;
  @JsonIgnore
  private java.lang.String _nombre;

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
}
