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
import edu.eci.cvds.samples.persistence.mybaties.*;
import edu.eci.cvds.samples.services.impl.ServicioUsuarioIMPL;


public class ServicioSolidaridadECIFactory {

    private static ServicioSolidaridadECIFactory instance = new ServicioSolidaridadECIFactory();
    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                //bind(ServicioSolidaridadECI.class).to(ServicioSolidaridadECIImpl.class);
                bind(DAOUsuario.class).to(MyBatisDAOUsuario.class);
                bind(ServicioUsuario.class).to(ServicioUsuarioimpl.class);
            }
        });
    }

    private ServicioSolidaridadECIFactory() {
        optInjector = Optional.empty();
    }

    public ServicioSolidaridadECI getServicioSolidaridadECI() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development", "mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServicioSolidaridadECI.class);
    }

    /**public ServicioSolidaridadECI getServicioSolidaridadECITesting() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test", "mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServicioSolidaridadECI.class);
    }*/

    public static ServicioSolidaridadECIFactory getInstance() {
        return instance;
    }
}