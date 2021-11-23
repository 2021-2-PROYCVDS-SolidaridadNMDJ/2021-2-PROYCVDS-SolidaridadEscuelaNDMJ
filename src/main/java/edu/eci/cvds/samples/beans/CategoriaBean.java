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

@ManagedBean(name = "CategoriasBean")
@ApplicationScoped
public class CategoriaBean extends BaseBean{

    @Inject
    private CategoriasService categoriasService;

    public Categoria consultarCategoria(String nombre) throws SolidaridadException{
        try{
            return categoriasService.consultarCategoria(nombre);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("La categoria no existe");
        }
    }

    public void eliminarCategoria( String nombre, String idCategoria)throws SolidaridadException{
        try{
            categoriasService.eliminarCategoria(nombre, idCategoria);
        }catch (Exception e){
            
            e.printStackTrace();
        }
    }

    public void registrarCategoria( String nombre, String descripcion)throws SolidaridadException{

        try{
           
                categoriasService.registrarCategoria(new Categoria(nombre, descripcion));

         } catch (Exception e){
                e.printStackTrace();
                throw new SolidaridadException("La categoria no es valida");
                
            }
        }


}
