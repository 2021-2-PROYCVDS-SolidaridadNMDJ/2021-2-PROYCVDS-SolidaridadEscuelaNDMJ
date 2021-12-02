package edu.eci.cvds.samples.entities;

import java.util.Date;

public class Necesidad {
    private int id;
    private String id_categoria;
    private String nombre;
    private String descripcion;
    private String urgencia;
    private Date fechaCreacion;
    private String estado;
    private Date fechaModificacion;

    /**public Necesidad(int id, String id_categoria,String nombre,String descripcion,String urgencia,Date fechaCreacion,String estado,Date fechaModificacion){
        this.id = id;
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.nombre = nombre;
        this.urgencia = urgencia;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }**/

    public Necesidad(String id_categoria,String nombre,String descripcion,String urgencia,Date fechaCreacion,String estado,Date fechaModificacion){
        this.id = id;
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.nombre = nombre;
        this.urgencia = urgencia;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }
    public Necesidad(){

    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

}
