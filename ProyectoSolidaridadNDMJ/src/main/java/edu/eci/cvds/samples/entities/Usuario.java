package edu.eci.cvds.samples.entities;

public class Usuario{
    private String idCorreo;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String rol;

    public Usuario(String idCorreo, String contraseña, String nombre, String apellido, String rol ){
        this.idCorreo = idCorreo;
        this.contraseña=contraseña;
        this.nombre=nombre;
        this.apellido=apellido;
        this.rol = rol;
    }
    public Usuario(){

    }

    public String getIdCorreo() {
        return idCorreo;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setIdCorreo(String idCorreo) {
        this.idCorreo = idCorreo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}