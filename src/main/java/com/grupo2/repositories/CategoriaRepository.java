package com.grupo2.repositories;

import com.grupo2.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
  List<Categoria> findByNombreContainsIgnoreCase(String nombre);


}