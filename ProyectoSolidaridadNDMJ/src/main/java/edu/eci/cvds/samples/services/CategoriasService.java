package edu.eci.cvds.samples.services;
import edu.eci.cvds.samples.entities.Categoria;
import org.postgresql.util.PSQLException;

public interface CategoriasService {
    public void registrarCategoria(Categoria categoria) throws SolidaridadException;
    public void actualizarCategoria(String categoriaNombre, String nombre, String descripcion, String estado)
            throws SolidaridadException, PSQLException;

    public Categoria consultarCategoria(String nombre) throws SolidaridadException;
    
    public void eliminarCategoria(String nombre, String idCategoria) throws SolidaridadException;
}
