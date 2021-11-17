package edu.eci.cvds.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.persistence.NecesidadDAO;
import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.NecesidadMapper;

import java.util.List;

public class MyBatisDAONecesidad implements NecesidadDAO {
    @Inject
    private NecesidadMapper necesidadMapper = null;
    public List<Necesidad> consultarNecesidad(String nombre){
        return necesidadMapper.consultarNecesidad(nombre);

    }
    public void registrarNecesidad(Necesidad necesidad){
        necesidadMapper.registrarNecesidad(necesidad);
    }



}
