package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadService {
    public List<Necesidad> consultarNecesidad(String nombre);
    public void registrarNecesidad(Necesidad necesidad);
}
