package com.grupo2.repositories;

import com.grupo2.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {


  long countByCategoria_Id(Long id);

  List<Producto> findByCategoria_Id(Long id);

  List<Producto> findByNombreContainsIgnoreCase(String nombre);


}