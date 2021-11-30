package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.persistence.NecesidadDAO;
import edu.eci.cvds.samples.services.NecesidadService;
import com.google.inject.Inject;

import java.util.List;

public class NecesidadServiceIMPL implements NecesidadService {
    @Inject
    private NecesidadDAO DAOnec;

    @Override
    public List<Necesidad> consultarNecesidad(String nombre){
        return DAOnec.consultarNecesidad(nombre);

    }
    @Override
    public void registrarNecesidad(Necesidad necesidad){
        DAOnec.registrarNecesidad(necesidad);
    }


}
