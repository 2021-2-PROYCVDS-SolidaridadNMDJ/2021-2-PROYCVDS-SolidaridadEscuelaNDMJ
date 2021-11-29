package edu.eci.cvds.guice;
import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.samples.persistence.*;
import edu.eci.cvds.samples.persistence.mybatisimpl.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.impl.*;
import edu.eci.cvds.security.Logger;
import edu.eci.cvds.security.ShiroLogger;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Clase GuiceContextListener de la aplicación.
 * 
 * @author Nicolas Camacho
 * @author David Perez
 * @author Julian Peña
 * @author Juan Mejia
 * @version 1.0
 */
public class GuiceContextListener implements ServletContextListener {

    /**
     * Método del guice.
     * 
     * @param servletContextEvent Argumentos del programa.
     */
    
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
      ServletContext servletContext = servletContextEvent.getServletContext();
      servletContext.removeAttribute(Injector.class.getName()); }
     

    /**
     * Método del guice.
     * 
     * @param servletContextEvent Argumentos del programa.
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // TODO Add service class associated to Stub implementation
                bind(DAOUsuario.class).to(MyBatisDAOUsuario.class);
                bind(ServicioUsuario.class).to(ServicioUsuarioIMPL.class);

                bind(CategoriasDAO.class).to(MyBatisDAOCategoria.class);
                bind(CategoriasService.class).to(CategoriasServiceImpl.class);

                bind(OfertaService.class).to(OfertaServiceIMPL.class);
                bind(OfertaDAO.class).to(MyBatisDAOOferta.class);

                bind(NecesidadDAO.class).to(MyBatisDAONecesidad.class);
                bind(NecesidadService.class).to(NecesidadServiceIMPL.class);

                bind(Logger.class).to(ShiroLogger.class);
            }
        });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}