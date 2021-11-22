package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.DAOUsuario;
import edu.eci.cvds.samples.services.ServicioUsuario;
import edu.eci.cvds.samples.services.SolidaridadException;
import java.util.List;

public class ServicioUsuarioIMPL implements ServicioUsuario{
    @Inject
    private DAOUsuario usDAO;

    @Override
    public void registrarUsuario(Usuario usuario)  throws SolidaridadException {
        try{
            usDAO.registrarUsuario(usuario);
        }
        catch (Exception e){
            throw new SolidaridadException("Error al registrar el usuario",e);
        }
    }

    @Override
    public Usuario consultarUsuario(String email) throws SolidaridadException{
        try{
            Usuario usuario = usDAO.consultarUsuario(email);
            return usuario;
        }
        catch (Exception e){
            throw new SolidaridadException("El usuario no existe",e);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws SolidaridadException{
        try{
            return usDAO.consultarUsuarios();
        }
        catch (Exception e){
            throw new SolidaridadException("No se encuentran usuarios",e);
        }
    }
}