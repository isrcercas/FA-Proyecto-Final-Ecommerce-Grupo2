package com.grupo2.repositories;

import com.grupo2.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {



    /*

    findAllByUserId para traer todas las compras

    form
    detalle compra
    select productos
    select compras
    select

     */
}