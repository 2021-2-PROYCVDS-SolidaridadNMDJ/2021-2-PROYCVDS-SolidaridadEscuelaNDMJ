package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Respuesta;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RespuestaMapper {
    void insertarRespuesta (@Param("nombre") Respuesta respuesta);
    void consultarRespuesta (@Param("Respuesta") Respuesta respuesta);
    
}
