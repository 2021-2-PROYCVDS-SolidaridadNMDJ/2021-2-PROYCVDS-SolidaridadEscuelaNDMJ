package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadService {
    public abstract List<Necesidad> consultarNecesidad(String nombre);
    public abstract void registrarNecesidad(Necesidad necesidad);
}
