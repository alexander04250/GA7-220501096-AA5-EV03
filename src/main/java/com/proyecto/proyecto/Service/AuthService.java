package com.proyecto.proyecto.Service;

import com.proyecto.proyecto.Model.User;
import com.proyecto.proyecto.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Método para registrar un usuario
    public User register(User user) {
        // Guardar la contraseña tal cual (sin encriptar)
        user.setContraseña(user.getContraseña());
        return userRepository.save(user);
    }

    // Método para hacer login
    public User login(User user) {
        // Buscar al usuario por correo
        Optional<User> foundUser = userRepository.findByCorreo(user.getCorreo());

        // Comprobar que el usuario exista y que las contraseñas coincidan
        if (foundUser.isPresent() && foundUser.get().getContraseña().equals(user.getContraseña())) {
            return foundUser.get();  // Si las credenciales coinciden, devolvemos el usuario
        }
        return null;  // Si no se encuentra el usuario o las credenciales no coinciden
    }
}
