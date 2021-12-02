package edu.eci.cvds.samples.services;
import edu.eci.cvds.samples.entities.Categoria;
import org.postgresql.util.PSQLException;
import java.util.List;

public interface CategoriasService {
    public void registrarCategoria(Categoria categoria) throws SolidaridadException;


    public Categoria consultarCategoria(String nombre) throws SolidaridadException;

    public abstract List<Categoria> consultarCategorias() throws SolidaridadException;
    
    public void eliminarCategoria(String idCategoria) throws SolidaridadException;
}
