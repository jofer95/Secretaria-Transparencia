/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
package com.ub.st.entities.commons;

import com.fasterxml.jackson.annotation.*;

/**
 *  clase padre para entidades SQL
 * 
 *  @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 *  @param <K> tipo de dato de la llave primaria de la entidad
 */
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class EntitySQL<K extends java.lang.Object> extends com.ub.st.entities.commons.IEntity<K> {

}
