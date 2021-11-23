package edu.eci.cvds.security;

import edu.eci.cvds.samples.services.SolidaridadException;

public interface Logger {

    public void login(String correo , String password , boolean rememberMe) throws SolidaridadException ;

    public boolean isAdmin();

    public boolean isProponente();

    public boolean isPMO();

    public void logout();

    public boolean isLogged();
}