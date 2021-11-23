package edu.eci.cvds.samples.services.impl;
import com.google.inject.Inject;
import edu.eci.cvds.samples.persistence.CategoriasDAO;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.CategoriasService;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.postgresql.util.PSQLException;
import javax.transaction.Transactional;
import java.util.List;

public class CategoriasServiceImpl implements CategoriasService {
    @Inject
    private CategoriasDAO categoriasDAO;

    @Transactional
    @Override
    public void registrarCategoria(Categoria categoria) throws SolidaridadException {
        try{
            categoriasDAO.save(categoria);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("Error al insertar categoria");
        }
    }

  
    @Override
    public Categoria consultarCategoria(String nombre) throws SolidaridadException {
        try{
            return categoriasDAO.load(nombre);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("La categoria "+nombre+" no existe");
        }
    }

    @Override
    public List<Categoria> consultarCategorias() throws SolidaridadException {
        try{
            return categoriasDAO.load();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SolidaridadException("No se encuentran categorias");
        }
    }
 
    @Override
    public void eliminarCategoria(String nombre,String idCategoria) throws SolidaridadException {
        try{
            categoriasDAO.delete(nombre, idCategoria);
        }catch (Exception e){
            System.out.println("2");
            e.printStackTrace();
        } 
        
    }

}