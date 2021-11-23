package edu.eci.cvds.samples.persistence.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.persistence.OfertaDAO;
import edu.eci.cvds.samples.services.SolidaridadException;
import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.*;

public class MyBatisDAOOferta implements OfertaDAO{
    @Inject
    private OfertaMapper ofertaMapper;

    @Override
    public void save(Oferta oferta) throws SolidaridadException {
        try {
            ofertaMapper.insertarOferta(oferta);
        } catch (Exception e) {
            throw new SolidaridadException("Error al insertar ", e);
        }
        
    }

    @Override
    public List<Oferta> load() throws SolidaridadException {
        try {
            return ofertaMapper.consultarOfertas();
        } catch (Exception e) {
            throw new SolidaridadException("Error al consultar ofertas ", e);
        }
    }

    @Override
    public Oferta load(String nombre) throws SolidaridadException {
        try{
            return ofertaMapper.consultarOferta(nombre);
        }catch (Exception e){
            
            throw new SolidaridadException("La oferta consultada no existe");
        }
    }
    
}
