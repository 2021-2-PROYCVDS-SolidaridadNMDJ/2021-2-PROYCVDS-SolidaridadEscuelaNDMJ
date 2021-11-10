package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Necesidad;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NecesidadMapper {
    public List<Necesidad> consultarNecesidad(@Param("Nombre") String nombre);
    public void registrarNecesidad(@Param("Necesidad")Necesidad necesidad);
}
