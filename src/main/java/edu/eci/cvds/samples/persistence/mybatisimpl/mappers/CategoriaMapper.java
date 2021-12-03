package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;
import edu.eci.cvds.samples.entities.Categoria;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface CategoriaMapper {

    void insertarCategoria(@Param("categoria") Categoria categoria);

    void eliminarCategoria(@Param("idCategoria") String idCategoria);

    Categoria consultarCategoria(@Param("nombre") String nombre);
    void update(@Param("categoria") Categoria categoria, @Param("aNombre") String aNombre);
    List<Categoria> consultarCategorias();
}
