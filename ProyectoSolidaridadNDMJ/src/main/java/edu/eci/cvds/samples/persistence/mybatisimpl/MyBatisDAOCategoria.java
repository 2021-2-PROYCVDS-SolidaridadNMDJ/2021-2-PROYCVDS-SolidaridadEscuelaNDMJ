package edu.eci.cvds.samples.persistence.mybatisimpl;
import com.google.inject.Inject;


import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.persistence.CategoriasDAO;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.postgresql.util.PSQLException;

import java.util.List;
public class MyBatisDAOCategoria  implements CategoriasDAO {


    @Override
    public void save(Categoria categoria) throws SolidaridadException {

    }

    @Override
    public void delete(String nombre, String idCategoria) throws SolidaridadException {

    }

    @Override
    public Categoria load(String nombre) throws SolidaridadException {
        return null;
    }
}
