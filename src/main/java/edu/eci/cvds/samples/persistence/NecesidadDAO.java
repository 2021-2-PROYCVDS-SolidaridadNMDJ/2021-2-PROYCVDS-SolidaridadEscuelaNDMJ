package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadDAO {
    public Necesidad consultarNecesidad(String nombre);
    public List<Necesidad> consultarNecesidades();
    public void registrarNecesidad(Necesidad necesidad);
}
