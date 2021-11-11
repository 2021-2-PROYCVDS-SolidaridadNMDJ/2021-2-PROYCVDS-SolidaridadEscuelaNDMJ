package edu.eci.cvds.samples.services;

import static com.google.inject.Guice.createInjector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;

import edu.eci.cvds.samples.persistence.*;
import edu.eci.cvds.samples.persistence.mybatisimpl.*;
import edu.eci.cvds.samples.services.impl.CategoriasServiceImpl;
import edu.eci.cvds.samples.services.impl.ServicioUsuarioIMPL;
//import edu.eci.cvds.security.Logger;
//import edu.eci.cvds.security.ShiroLogger;


public class ServiciosSolidaridadFactory {

    private static ServiciosSolidaridadFactory instance = new ServiciosSolidaridadFactory();
    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(DAOUsuario.class).to(MyBatisDAOUsuario.class);
                bind(CategoriasDAO.class).to(MyBatisDAOCategoria.class);
                bind(ServicioUsuario.class).to(ServicioUsuarioIMPL.class);
                //bind(Logger.class).to(ShiroLogger.class);
            }
        });
    }

    private ServiciosSolidaridadFactory() {
        optInjector = Optional.empty();
    }

    public ServicioUsuario getServicioUsuario() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development", "mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServicioUsuario.class);
    }

    /**public ServicioSolidaridadECI getServicioSolidaridadECITesting() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test", "mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServicioSolidaridadECI.class);
    }*/

    public static ServiciosSolidaridadFactory getInstance() {
        return instance;
    }
}