package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.DAOUsuario;
import edu.eci.cvds.samples.services.ServicioUsuario;

public class ServicioUsuarioIMPL implements ServicioUsuario{
    @Inject
    private DAOUsuario usDAO;

    public void registrarUsuario(Usuario usuario){
        usDao.registrarUsuario(usuario);
    }

}