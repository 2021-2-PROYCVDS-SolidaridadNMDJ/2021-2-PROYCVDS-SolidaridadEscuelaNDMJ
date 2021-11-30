package edu.eci.cvds.samples.beans;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.services.SolidaridadException;
import edu.eci.cvds.samples.services.NecesidadService;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
//import java.sql.Date;
import java.util.Date;

@SuppressWarnings("deprecation")
@ManagedBean(name = "necesidadBean")
@SessionScoped

public class NecesidadBean extends BaseBean {
    @Inject
     private NecesidadService necesidadService;
     private String message;

     public void registrarNecesidad(String categoria,String nombre,String descripcion,String urgencia,String estado)throws SolidaridadException{
         try {
            Necesidad necesidad = new Necesidad(categoria, nombre, descripcion, urgencia, new Date((new java.util.Date()).getTime()),"En Proceso", new Date((new java.util.Date()).getTime()));
            necesidadService.registrarNecesidad(necesidad);
            this.message = "La necesidad se registro correctamente";
        } catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("Hubo un error al registrar la necesidad");
        }
     }
}