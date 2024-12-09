package com.proyecto.proyecto.Controller;

import com.proyecto.proyecto.Model.User;
import com.proyecto.proyecto.Service.UserService; // Asegúrate de tener un servicio que gestione los usuarios
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")  // Aquí se definen los endpoints
public class Authcontroller {

    @Autowired
    private UserService userService;  // Asegúrate de tener un servicio que maneje la lógica de usuarios

    // POST: Registrar un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.save(user);  // Guarda el nuevo usuario
        return ResponseEntity.ok(savedUser);  // Retorna el usuario registrado con estado 200
    }

    // POST: Login de usuario
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = userService.login(user);  // Aquí deberías implementar la lógica de autenticación
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        }
        return ResponseEntity.status(401).body(null);  // 401 Unauthorized si no hay coincidencia
    }

    // GET: Obtener usuario por ID
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User user = userService.findById(id);  // Llama al servicio que busca el usuario por id
        if (user == null) {
            return ResponseEntity.status(404).body(null);  // Retorna 404 si no se encuentra
        }
        return ResponseEntity.ok(user);  // Retorna 200 si el usuario es encontrado
    }

    // PUT: Actualizar usuario por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User updatedUser) {
        User existingUser = userService.findById(id);  // Busca el usuario por id
        if (existingUser == null) {
            return ResponseEntity.status(404).body(null);  // Retorna 404 si el usuario no existe
        }

        // Actualiza los datos del usuario
        existingUser.setCorreo(updatedUser.getCorreo());
        existingUser.setContraseña(updatedUser.getContraseña());
        User updated = userService.save(existingUser);  // Guarda el usuario actualizado
        return ResponseEntity.ok(updated);  // Retorna el usuario actualizado con estado 200
    }

    // DELETE: Eliminar usuario por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        User user = userService.findById(id);  // Busca el usuario por id
        if (user == null) {
            return ResponseEntity.status(404).build();  // Retorna 404 si el usuario no existe
        }

        userService.delete(id);  // Elimina al usuario
        return ResponseEntity.status(204).build();  // Retorna 204 No Content si la eliminación fue exitosa
    }
}
    