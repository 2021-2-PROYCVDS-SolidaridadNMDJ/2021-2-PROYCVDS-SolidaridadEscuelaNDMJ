package edu.eci.cvds.samples.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(LoginBean.class);

    private String user;
    private String password;
    public boolean logeado = false;

    public void login() {
        Subject userActual = SecurityUtils.getSubject();
        UsernamePasswordToken uPToken = new UsernamePasswordToken(getUser(), new Sha256Hash(getPasswd()).toHex());

        try {
            userActual.login(uPToken);
            userActual.getSession().setAttribute("correo", user);
            if (userActual.hasRole("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/administrador.xhtml");
            }
            setLogeado(true);
        } catch (UnknownAccountException ex) {
            error("Unknown account");
            log.error(ex.getMessage(), ex);
        } catch (IncorrectCredentialsException ex) {
            error("Wrong password");
            log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
            error("Locked account");
            log.error(ex.getMessage(), ex);
        } catch (AuthenticationException ex) {
            error("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        } catch (IOException ex) {
            error("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return password;
    }

    public void setPasswd(String passwd) {
        this.password = passwd;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    private void error(String message) {
        FacesContext.getCurrentInstance().addMessage("Shiro",
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "error"));
    }
}
