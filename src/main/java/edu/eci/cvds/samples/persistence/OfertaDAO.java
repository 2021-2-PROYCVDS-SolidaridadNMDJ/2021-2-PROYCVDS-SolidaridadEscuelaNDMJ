package edu.eci.cvds.samples.persistence;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.SolidaridadException;
import java.util.*;
public interface OfertaDAO {

    void save(Oferta oferta) throws SolidaridadException;

    List<Oferta> load() throws SolidaridadException;

    Oferta load(String nombre) throws SolidaridadException;
    
}
