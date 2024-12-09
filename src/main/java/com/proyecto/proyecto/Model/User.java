package com.proyecto.proyecto.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_usuario")
    private int IdUsuario;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    // Constructor sin parámetros (opcional pero recomendado)
    public User() {}

    // Constructor con parámetros
    public User(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    // Getter para IdUsuario
    public int getIdUsuario() {
        return IdUsuario;
    }

    // Setter para IdUsuario
    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    // Getter para correo
    public String getCorreo() {
        return correo;
    }

    // Setter para correo
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Getter para contraseña
    public String getContraseña() {
        return contraseña;
    }

    // Setter para contraseña
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}



