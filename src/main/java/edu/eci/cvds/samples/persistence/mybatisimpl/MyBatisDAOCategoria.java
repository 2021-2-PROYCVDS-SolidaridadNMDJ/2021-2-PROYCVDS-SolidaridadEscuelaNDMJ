package edu.eci.cvds.samples.persistence.mybatisimpl;
import com.google.inject.Inject;

import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.*;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.persistence.CategoriasDAO;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.postgresql.util.PSQLException;

import java.util.List;
public class MyBatisDAOCategoria  implements CategoriasDAO {

    @Inject
    private CategoriaMapper categoriaMapper;


    @Override
    public void save(Categoria categoria) throws SolidaridadException {
        try{
            categoriaMapper.insertarCategoria(categoria);
        }catch (Exception e){
            throw new SolidaridadException("Error al insertar  ",e);
        }
    }

    

    @Override
    public void delete(String nombre, String idCategoria) throws SolidaridadException {

        try{
            categoriaMapper.eliminarCategoria(nombre,idCategoria);
        }catch (Exception e){
            
            throw new SolidaridadException("Error al eliminar  ",e);
        }

    }

    @Override
    public Categoria load(String nombre) throws SolidaridadException {
        try{
            return categoriaMapper.consultarCategoria(nombre);
        }catch (Exception e){
            throw new SolidaridadException("No existe dicha categoria");
        }
    }

    @Override
    public List<Categoria> load() throws SolidaridadException  {
        try{
            return categoriaMapper.consultarCategorias();
        }catch (Exception e){
            throw new SolidaridadException("Error al consultar las categorias ",e);
        }
    }
}
