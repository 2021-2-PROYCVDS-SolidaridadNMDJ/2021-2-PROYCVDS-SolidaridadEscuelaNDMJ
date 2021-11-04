package edu.eci.cvds.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.UsuarioMapper;
import java.util.List;

public class MyBatisDAOUsiario implements DAOUsuario{
    private UsuarioMapper usmap = null;

    public void registrarUsuario(Usuario usuario){
        pmap.registrarUsuario(usuario);
    }

}
