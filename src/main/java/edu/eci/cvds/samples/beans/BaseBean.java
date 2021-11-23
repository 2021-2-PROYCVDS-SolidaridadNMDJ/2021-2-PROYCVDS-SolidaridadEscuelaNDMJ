
package edu.eci.cvds.samples.beans;

import com.google.inject.Injector;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.Serializable;

public abstract class BaseBean implements Serializable {
    private Injector injector;

    /**
     * Método que realiza la inyeccion del Servlet.
     * @return injector retorno del programa.
     */
    public Injector getInjector() {
        if (injector == null) {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
                    .getContext();
            injector = (Injector) servletContext.getAttribute(Injector.class.getName());
        }
        return injector;
    }

    /**
     * Método que guarda la inyeccion del Servlet.
     * @param injector Argumento del programa.
     */
    public void setInjector(Injector injector) {
        this.injector = injector;
    }

    /**
     * Método postconstructor.
     */
    @PostConstruct
    public void init() {
        getInjector().injectMembers(this);
    }
}