package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.persistence.NecesidadDAO;
import edu.eci.cvds.samples.services.NecesidadService;

import java.util.List;

public class NecesidadServiceIMPL implements NecesidadService {
    private NecesidadDAO DAOnec;

    public List<Necesidad> consultarNecesidad(String nombre){
        return DAOnec.consultarNecesidad(nombre);

    }
    public void registrarNecesidad(Necesidad necesidad){
        DAOnec.registrarNecesidad(necesidad);
    }


}
