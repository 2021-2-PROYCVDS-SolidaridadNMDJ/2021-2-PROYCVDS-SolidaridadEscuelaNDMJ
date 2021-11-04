package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Usuario;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UsuarioMapper {

    public registrarUsuario(@Param("usuario")Usuario usuario);
}