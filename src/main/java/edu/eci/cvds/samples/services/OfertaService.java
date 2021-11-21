package edu.eci.cvds.samples.services;
import edu.eci.cvds.samples.entities.Oferta;

import java.util.*;
public interface OfertaService {
    public abstract void registrarOferta(Oferta oferta) throws SolidaridadException;

    public abstract List<Oferta> consultarOfertas() throws SolidaridadException;

    Oferta consultarOferta(String nombre) throws SolidaridadException;

    
}
