package edu.eci.cvds.samples.services;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.List;
import edu.eci.cvds.samples.services.SolidaridadException;

public interface ServicioUsuario{

    public abstract void registrarUsuario(Usuario usuario) throws SolidaridadException;
    public abstract Usuario consultarUsuario(String email) throws SolidaridadException;
    public abstract List<Usuario> consultarUsuarios() throws SolidaridadException;
}