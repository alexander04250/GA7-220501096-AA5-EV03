package com.proyecto.proyecto.Model;

public class LoginRequest {
    private String correo;  // Cambiar email a correo
    private String contraseña;  // Cambiar password a contraseña

    // Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

