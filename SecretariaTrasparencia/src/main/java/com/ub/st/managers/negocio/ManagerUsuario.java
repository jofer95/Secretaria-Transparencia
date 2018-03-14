package com.ub.st.managers.negocio;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.ub.st.daos.negocio.DaoUsuario;
import com.ub.st.entities.negocio.Usuario;
import com.ub.st.managers.commons.ManagerSQL;
import com.ub.st.models.accesos.ModelLogin;
import com.ub.st.models.accesos.ModelTurnedOn;
import com.ub.st.utils.UtilsSecurity;
import com.ub.st.utils.UtilsWSClient;
import com.ub.st.utils.exceptions.UsuarioInexistenteException;
import java.util.NoSuchElementException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class ManagerUsuario extends ManagerSQL<Usuario, Integer> {

    public ManagerUsuario() {
        super(new DaoUsuario());
    }

    @Override
    public String nombreColeccionParaRegistros() throws UnsupportedOperationException {
        return "usuarios";
    }

    public Usuario login(ModelLogin model) throws UsuarioInexistenteException {
        String identificador = model.getUsuario();
        String contra = UtilsSecurity.cifrarMD5(model.getContra());
        Usuario usuarioLogeado;
        try {
            if (isMail(identificador)) {
                usuarioLogeado = this.stream().where(u -> u.getCorreo().equals(identificador) && u.getContra().equals(contra)).findFirst().get();
            } else {
                usuarioLogeado = this.stream().where(u -> u.getNombre().equals(identificador) && u.getContra().equals(contra)).findFirst().get();
            }
            usuarioLogeado.setContra(null);
        } catch (NoSuchElementException e) {
            throw new UsuarioInexistenteException("El usuario y/o contraseña incorrecto");
        }
        //verificar si el servicio esta prendido
        try {
            ModelTurnedOn turnedOn = UtilsWSClient.wr().accept(MediaType.APPLICATION_JSON).get(ModelTurnedOn.class);
            if (turnedOn.isTurnedOn()) {
                return usuarioLogeado;
            } else {
                throw new UsuarioInexistenteException("El usuario y/o contraseña incorrecto");
            }
        } catch (UniformInterfaceException e) {
            throw new UsuarioInexistenteException("El usuario y/o contraseña incorrecto");
        }
    }

    private boolean isMail(String text) {
        return text.contains("@");
    }

    @Override
    public Usuario persist(Usuario entity) throws Exception {
        entity.setContra(UtilsSecurity.cifrarMD5(entity.getContra()));
        return super.persist(entity); //To change body of generated methods, choose Tools | Templates.
    }

}
