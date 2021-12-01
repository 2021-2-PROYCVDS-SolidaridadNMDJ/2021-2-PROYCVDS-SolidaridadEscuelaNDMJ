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
    private Usuario usuario;
    private String message;
    private List<Usuario> usuariosRegistrados;

    public void redirectRegistroDeUsuario() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        facesContext.getExternalContext().redirect("sign_up.xhtml");
    }

    public void redirectRegistroCategorias() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        facesContext.getExternalContext().redirect("RegistrarCategoria.xhtml");
    }

    public void registrarUsuario(String correo, String nombre, String apellido, String password, String rol) throws SolidaridadException{
        try {
            Usuario usuario = new Usuario(correo, password, nombre, apellido, rol);
            serviciosUsuario.registrarUsuario(usuario);
            this.message = "El usuario se registro correctamente";
        } catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("Hubo un error registrando al usuario, intentelo nuevamente");
        }
    }

    public Usuario buscarUsuario(String email) throws SolidaridadException{
        this.usuario = serviciosUsuario.consultarUsuario(email);
        return usuario;
    }

    public List<Usuario> consultarTodosLosUsuarios() throws SolidaridadException{
        try{
            if(usuariosRegistrados == null){
                usuariosRegistrados = serviciosUsuario.consultarUsuarios();
            }
            return usuariosRegistrados;
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("Hubo un error al consultar los usuarios");
        }
    }

    public List<Usuario> getUsuarios(){
        return usuariosRegistrados;
    }
    
    public void setUsuarios(List<Usuario> usuariosRegistrados){
        this.usuariosRegistrados = usuariosRegistrados;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
}