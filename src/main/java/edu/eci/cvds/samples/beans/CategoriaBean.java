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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean(name = "CategoriaBean")
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

    public void eliminarCategoria(  String idCategoria)throws SolidaridadException{
        try{
            categoriasService.eliminarCategoria( idCategoria);
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

        public List<Categoria> consultarCategorias() throws SolidaridadException{
            try{
                return categoriasService.consultarCategorias();
            }catch (Exception e){
                throw new SolidaridadException("Error al consultar las categorias ");
            }
        }



        public void redirectConsultarCategorias() throws IOException{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            facesContext.getExternalContext().redirect("ConsultarCategoria.xhtml");
        }

        public void actualizarCategoria(String nombreCategoria, String nombre, String descripcion, String estado) throws SolidaridadException, PSQLException {
            try{
                categoriasService.actualizarCategoria(nombreCategoria,nombre,descripcion,estado);
            }catch (Exception e){
                throw new SolidaridadException("Error al actualizar la categoria "+nombre);
            }
        }
}
