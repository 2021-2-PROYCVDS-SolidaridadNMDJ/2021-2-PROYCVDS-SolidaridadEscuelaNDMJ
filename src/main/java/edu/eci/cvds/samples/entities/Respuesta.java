package edu.eci.cvds.samples.entities;

public class Respuesta {
    private String idrespuesta;
    private String nombre;
    private String comentarios;
    private String fechacreacion;
    private String pertencea;

    public Respuesta(String idrespuesta, String nombre, String comentarios, String fechacreacion, String pertenecea ){

        this.idrespuesta = idrespuesta;
        this.nombre = nombre;
        this.comentarios = comentarios;
        this.fechacreacion = fechacreacion;
        this.pertencea = pertenecea;
    }

    public Respuesta (){

    }

    public String getIdRespuesta(){
        return idrespuesta;
    }

    public String getNombre(){
        return nombre;        
    }

    public String getComentarios(){
        return comentarios;
    }

    public String getFechaCreacion(){
        return fechacreacion;
    }

    public String getPertenceA(){
        return pertencea;
    }

    public void setIdRespuesta(){
        this.idrespuesta = idrespuesta;
    }

    public void setNombre (){
        this.nombre = nombre;
    }

    public void setComentarios(){
        this.comentarios = comentarios;
    }

    public void setFechaCreacion(){
        this.fechacreacion = fechacreacion;
    }

    public void setPerteneceA(){
        this.pertencea = pertencea;
    }
    
}
