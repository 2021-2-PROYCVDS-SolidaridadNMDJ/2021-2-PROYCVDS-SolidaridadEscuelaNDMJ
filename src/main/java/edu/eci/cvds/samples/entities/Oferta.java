package edu.eci.cvds.samples.entities;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Random;
import java.util.UUID;

public class Oferta {
    private String idOferta;
    private String nombreCategoria;
    private String nombre;
    private String descripcion;
    private Date fechacreacion;
    private String estado;
    private Date fechamodificacion;

    public Oferta(String nombreCategoria,String nombre,String descripcion,String estado){
      byte[] array = new byte[10]; // length is bounded by 10
      new Random().nextBytes(array);
      String generatedString = new String(array, Charset.forName("UTF-8"));
        
        this.idOferta= generatedString;
        this.nombreCategoria = nombreCategoria;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.fechacreacion= Date.valueOf(LocalDate.now());
        this.estado=estado;
        this.fechamodificacion=Date.valueOf(LocalDate.now());
    }

    public String getIdOferta() {
        return idOferta;
     }

     public void setIdOferta(String idOferta) {
        this.idOferta = idOferta;
     }

     public String getnombreCategoria() {
        return this.nombreCategoria;
     }

     public String getNombre() {
        return this.nombre;
     }
 
     public void setNombre(String nombre) {
        this.nombre = nombre;
     }

     public String getDescripcion() {
        return this.descripcion;
     }
 
     public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
     }
 
     public Date getFechacreacion() {
        return this.fechacreacion;
     }
 
     public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
     }

     public String getEstado() {
        return this.estado;
     }
 
     public void setEstado(String estado) {
        this.estado = estado;
     }
 
     public Date getFechamodificacion() {
         return this.fechamodificacion;
     }
 
     public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
     }

    
    
}
