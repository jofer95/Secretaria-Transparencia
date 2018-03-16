/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package com.ub.st.utils.responses;

import com.fasterxml.jackson.annotation.*;

/**
 *  modelo de respuesta generico para servicios
 * 
 *  @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 *  @param <T> modelo encapsulado en este envoltorio de respuesta generica
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class ResponseOfEnteFiscalizador implements java.io.Serializable {

  @JsonIgnore
  private com.ub.st.entities.negocio.EnteFiscalizador _data;
  @JsonIgnore
  private com.ub.st.utils.responses.MetaData _meta;

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "data", required = false )
  public com.ub.st.entities.negocio.EnteFiscalizador getData() {
    return this._data;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "data", required = false )
  public void setData(com.ub.st.entities.negocio.EnteFiscalizador _data) {
    this._data = _data;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "meta", required = false )
  public com.ub.st.utils.responses.MetaData getMeta() {
    return this._meta;
  }

  /**
   * (no documentation provided)
   */
  @JsonProperty( value = "meta", required = false )
  public void setMeta(com.ub.st.utils.responses.MetaData _meta) {
    this._meta = _meta;
  }
}
