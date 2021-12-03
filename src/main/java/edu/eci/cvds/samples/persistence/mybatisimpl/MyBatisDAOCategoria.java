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
    public void delete( String idCategoria) throws SolidaridadException {

        try{
            categoriaMapper.eliminarCategoria(idCategoria);
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

    @Override
    public void update(Categoria categoria, String nombre, String descripcion, String estado) throws SolidaridadException, PSQLException {
        try{
            String aNombre = categoria.getNombre();
            if (nombre != null){
                categoria.setNombre(nombre);
            }
            if (descripcion != null){
                categoria.setDescripcion(descripcion);
            }
            if (descripcion != null){
                categoria.setEstado(estado);
            }
            categoriaMapper.update(categoria,aNombre);

        }catch (Exception e){
            throw new SolidaridadException("Error al actualizar la categoria "+nombre);
        }
    }
}
