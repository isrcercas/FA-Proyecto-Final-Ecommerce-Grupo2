package com.grupo2.repositories;

public class Usuario {
    package com.grupo2.repositories;

import com.grupo2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        // Consultas personalizadas si es necesario
    }
}
