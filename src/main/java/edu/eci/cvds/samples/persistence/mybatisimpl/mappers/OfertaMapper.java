package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Oferta;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OfertaMapper {
    void insertarOferta(@Param("oferta") Oferta oferta);
    List<Oferta> consultarOfertas();
    Oferta consultarOferta(@Param("nombre") String nombre);
    
}
