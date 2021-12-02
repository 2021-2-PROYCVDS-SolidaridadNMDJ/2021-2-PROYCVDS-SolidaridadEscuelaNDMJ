package edu.eci.cvds.samples.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.postgresql.util.PSQLException;
import org.primefaces.model.chart.*;
import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.List;


@ManagedBean(name = "OfertaBean")
@ApplicationScoped
public class OfertaBean extends BaseBean{

    @Inject
    private OfertaService ofertaService;

    public Oferta consultarOferta(String nombre) throws SolidaridadException{
        try{
            return ofertaService.consultarOferta(nombre);

        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("La oferta no existe");
        }
    }

    public void registrarOferta( String nombreCategoria,String nombre, String descripcion, String estado)throws SolidaridadException{

        try{
           
                ofertaService.registrarOferta(new Oferta(nombreCategoria, nombre,descripcion,estado));

         } catch (Exception e){
                e.printStackTrace();
                throw new SolidaridadException("La Oferta  no es valida");
                
            }
        }
        public List<Oferta> consultarOfertas() throws SolidaridadException{
            try{
                return ofertaService.consultarOfertas();
            }catch (Exception e){
                throw new SolidaridadException("Error al consultar las ofertas ");
            }
        }

}