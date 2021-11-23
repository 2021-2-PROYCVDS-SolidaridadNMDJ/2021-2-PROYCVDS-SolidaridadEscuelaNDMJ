package edu.eci.cvds.samples.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import com.google.inject.Inject;
import edu.eci.cvds.samples.services.SolidaridadException;
import edu.eci.cvds.samples.services.ServicioUsuario;
import edu.eci.cvds.security.Logger;

import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BaseBean {
    @Inject
    private ServicioUsuario serviciosUsuario;
    @Inject
    private Logger logger;
    private String username;
    private String password;
    private Boolean rememberMe;
    private String message;


    /**
     * Metodo que permite iniciar sesion a un usuario validando sus credenciales mediante
     * protocolo HTML
     * @throws IOException
     * @throws ExcepcionServiciosBancoProyectos
     */
    public void login() throws IOException, SolidaridadException {
        if(!logger.isLogged()) {
            logger.login(username, password, false);
            redirectHome();
        }
        else{
            sesionExistente();
        }
    }

    public void sesionExistente() throws IOException {
        this.message = "Ya hay otro usuario logueado";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }


    public void redirectHome() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if(logger.isAdmin()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("username", username);
            facesContext.getExternalContext().redirect("../admin/administrador.xhtml");
        }
        /**if(logger.isProponente()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("username", username);
            facesContext.getExternalContext().redirect("../proponente/proponente.xhtml");
        }
        if(logger.isPMO()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("username", username);
            facesContext.getExternalContext().redirect("../PMO/pmo.xhtml");
        }**/
    }

    public void redirectBusquedaIniciativas() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        facesContext.getExternalContext().redirect("../publico/busquedaIniciativaPalabras.xhtml");
    }

    /**
     * Metodo que permite cerrar sesion de usuario
     * @throws IOException
     */
    public void logOut() throws  IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");
        logger.logout();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, "PrimeFaces Rocks."));
    }
}