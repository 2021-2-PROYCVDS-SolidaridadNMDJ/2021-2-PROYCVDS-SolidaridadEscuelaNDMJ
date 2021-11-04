package edu.eci.cvds.samples.services;

public class SolidaridadException extends Exception {
    
    public static final String USUARIO_INCORRECTO = "El usuario no es valido";
    public static final String CONTRASENA_INCORRECTA = "La contrasena no es valida";

    public SolidaridadException() {

    }

    public SolidaridadException(String message) {
        super(message);
    }

     public SolidaridadException(String message, Exception Exception) {
         super(message, Exception);
     }  
}