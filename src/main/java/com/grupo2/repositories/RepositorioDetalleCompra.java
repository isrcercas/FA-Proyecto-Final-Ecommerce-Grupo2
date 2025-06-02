package com.grupo2.repositories;

import com.grupo2.entities.Detalle_Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraRepository extends JpaRepository<Detalle_Compra, Long> {
    // Consultas personalizadas si es necesario
}