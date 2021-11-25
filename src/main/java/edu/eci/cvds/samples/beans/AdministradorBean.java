package edu.eci.cvds.samples.beans;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.SolidaridadException;
import edu.eci.cvds.samples.services.ServicioUsuario;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "adminBean")
@SessionScoped

public class AdministradorBean extends BaseBean {
    @Inject
    private ServicioUsuario serviciosUsuario;
    private String rol;
    private Usuario usuario;
    private String area;
    private String message;
    private List<Usuario> usuariosRegistrados;

    public void redirectRegistroDeUsuario() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        facesContext.getExternalContext().redirect("sign_up.xhtml");
    }

    public void registrarUsuario(String correo, String nombre, String apellido, String password, String rol) throws SolidaridadException{
        try {
            Usuario usuario = new Usuario(correo, password, nombre, apellido, rol);
            serviciosUsuario.registrarUsuario(usuario);
            this.message = "El usuario se registro correctamente";
        } catch (Exception e){
            this.message = "Hubo un error registrando al usuario, intentelo nuevamente";
        }
    }
}