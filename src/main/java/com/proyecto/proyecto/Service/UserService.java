package com.proyecto.proyecto.Service;

import com.proyecto.proyecto.Model.User;
import com.proyecto.proyecto.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;  // Importa Optional

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Registrar o guardar usuario
    public User save(User user) {
        return userRepository.save(user);
    }

    // Buscar usuario por ID
    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);  // Usa Optional para manejar el resultado de la búsqueda
        return user.orElse(null);  // Si no se encuentra, retorna null
    }

    // Eliminar usuario
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    // Lógica de login
    public User login(User user) {
        Optional<User> foundUser = userRepository.findByCorreo(user.getCorreo());
        if (foundUser.isPresent() && foundUser.get().getContraseña().equals(user.getContraseña())) {
            return foundUser.get();
        }
        return null;
    }
}


