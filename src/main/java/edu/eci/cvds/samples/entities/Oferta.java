package edu.eci.cvds.samples.entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Date;
import java.util.UUID;

public class Oferta {
    private int idOferta;
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private Date fechacreacion;
    private String estado;
    private Date fechamodificacion;

    public Oferta(int idCategoria,String nombre,String descripcion,String estado){
        int random = (int)(Math.random()*10000+1);
        
        this.idOferta= 120000 + random;
        this.idCategoria=idCategoria;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.fechacreacion= Date.valueOf(LocalDate.now());
        this.estado=estado;
        this.fechamodificacion=Date.valueOf(LocalDate.now());
    }

    public int getIdOferta() {
        return idOferta;
     }

     public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
     }

     public int getIdCategoria() {
        return this.idCategoria;
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