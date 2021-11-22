package edu.eci.cvds.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.DAOUsuario;
import edu.eci.cvds.samples.services.SolidaridadException;
import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.UsuarioMapper;
import java.util.List;

public class MyBatisDAOUsuario implements DAOUsuario{
    @Inject
    private UsuarioMapper usmap = null;

    @Override
    public void registrarUsuario(Usuario usuario) throws SolidaridadException{
        try{
            usmap.registrarUsuario(usuario);
        }
        catch (Exception e){
            throw new SolidaridadException("Error al registrar el usuario",e);
        }   
    }

    @Override
    public Usuario consultarUsuario(String email) throws SolidaridadException{
        try{
            Usuario usuario = usmap.consultarUsuario(email);
            return usuario;
        }
        catch (Exception e){
            throw new SolidaridadException("El usuario no existe",e);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws SolidaridadException{
        try{
            return usmap.consultarUsuarios();
        }
        catch (Exception e){
            throw new SolidaridadException("No se encuentran usuarios",e);
        }
    }
}
