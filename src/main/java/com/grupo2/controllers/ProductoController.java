package com.grupo2.controllers;

import com.grupo2.entities.Producto;
import com.grupo2.repositories.CategoriaRepository;
import com.grupo2.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ProductoController {

    private ProductoRepository productoRepository;
    private CategoriaRepository categoriaRepository;


    public ProductoController(ProductoRepository productoRepository,
                              CategoriaRepository categoriaRepository){

        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;

    }


    @GetMapping("/productos")
    public String findAll(Model model) {

        // esta correcto, pero no se aplica el principio de responsabilidad unica
        // model.addAttribute("productos", productoRepository.findAll());
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaRepository.findAll());

        // nos lleva al html
        return "producto/producto-list";
    }
}
