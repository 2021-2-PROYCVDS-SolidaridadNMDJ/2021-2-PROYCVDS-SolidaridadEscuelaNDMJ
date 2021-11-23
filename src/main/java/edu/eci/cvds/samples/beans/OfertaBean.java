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
    

}