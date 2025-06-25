package com.grupo2.repositories;

import com.grupo2.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    @Query("select sum(c) from Compra c where c.total = ?1")
    long sumByTotal(Double total);


}