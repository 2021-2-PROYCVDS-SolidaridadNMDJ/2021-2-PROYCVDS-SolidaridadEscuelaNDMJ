/**package edu.eci.cvds.samples.beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServicioUsuario;
import edu.eci.cvds.samples.services.SolidaridadException;


@ManagedBean(name = "registarbean")
@ViewScoped
public class RegistroBean extends BaseBean {
    @Inject
    private ServicioUsuario servicio;

    public void registroUsuario(String correo, String nombre, String apellido, String password, String rol) throws SolidaridadException {
        Usuario usuario = new Usuario(correo, password, nombre, apellido, rol);
        servicio.registrarUsuario(usuario);
        System.out.println(usuario);
    }
}*/