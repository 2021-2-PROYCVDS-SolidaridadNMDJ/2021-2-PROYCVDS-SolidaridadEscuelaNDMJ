package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadDAO {
    public List<Necesidad> consultarNecesidad(String nombre);
    public void registrarNecesidad(Necesidad necesidad);
}
