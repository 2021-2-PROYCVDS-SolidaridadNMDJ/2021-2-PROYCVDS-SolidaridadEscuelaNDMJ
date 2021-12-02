package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadService {
    public abstract Necesidad consultarNecesidad(String nombre);
    public abstract List<Necesidad> consultarNecesidades();
    public abstract void registrarNecesidad(Necesidad necesidad);
}
