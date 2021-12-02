package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Necesidad;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NecesidadMapper {
    public Necesidad consultarNecesidad(@Param("Nombre") String nombre);
    public List<Necesidad> consultarNecesidades();
    public void registrarNecesidad(@Param("Necesidad")Necesidad necesidad);
}
