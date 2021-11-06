package edu.eci.cvds.samples.beans;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServicioUsuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;


@ManagedBean(name = "registarbean")
@ViewScoped
public class RegistroBean extends BaseBean {
    @Inject
    private ServicioUsuario servicio;

    public void registroUsuario(String correo, String nombre, String apellido, String password, String rol) {
        Usuario usuario = new Usuario(correo, password, nombre, apellido, rol);
        servicio.registrarUsuario(usuario);
        System.out.println(usuario);
    }
}