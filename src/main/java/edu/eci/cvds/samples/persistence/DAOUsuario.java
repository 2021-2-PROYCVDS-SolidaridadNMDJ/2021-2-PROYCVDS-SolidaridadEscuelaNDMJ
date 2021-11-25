package edu.eci.cvds.samples.persistence;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.SolidaridadException;

import java.util.List;

public interface DAOUsuario{
    public void registrarUsuario(Usuario usuario) throws SolidaridadException;

    public Usuario consultarUsuario(String email) throws SolidaridadException;

    public List<Usuario> consultarUsuarios() throws SolidaridadException;
}