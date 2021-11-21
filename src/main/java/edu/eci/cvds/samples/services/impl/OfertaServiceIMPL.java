package edu.eci.cvds.samples.services.impl;
import com.google.inject.Inject;
import edu.eci.cvds.samples.persistence.*;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.SolidaridadException;
import javax.transaction.Transactional;
import java.util.List;

public class OfertaServiceIMPL implements OfertaService {

    @Inject
    private OfertaDAO ofertaDAO;

    @Override
    public void registrarOferta(Oferta oferta) throws SolidaridadException {
        try{
            ofertaDAO.save(oferta);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Oferta> consultarOfertas() throws SolidaridadException {
        try {
            return ofertaDAO.load();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SolidaridadException("No se encuentran clientes");
        }
    }

    @Override
    public Oferta consultarOferta(String nombre) throws SolidaridadException {
        try{
            return ofertaDAO.load(nombre);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("La oferta "+nombre+" no existe");
        }
    }


   
    
}
