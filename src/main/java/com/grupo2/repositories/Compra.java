package com.grupo2.repositories;

public class Compra
package com.grupo2.repositories;

import com.grupo2.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}{
}
