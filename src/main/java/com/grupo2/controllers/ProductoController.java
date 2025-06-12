package com.grupo2.controllers;

import com.grupo2.entities.Producto;
import com.grupo2.repositories.CategoriaRepository;
import com.grupo2.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    private ProductoRepository productoRepository;
    private CategoriaRepository categoriaRepository;


    public ProductoController(ProductoRepository productoRepository,
                              CategoriaRepository categoriaRepository){

        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;

    }


    // anotación que mapea las peticiones GET a la URL "/productos"
    @GetMapping("/productos") // http://localhost:8082/productos
    public String findAll(Model model) {
        // crear una lista con todos los productos
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "producto/producto-list";
    }

    @GetMapping("/") // http://localhost:8082/index.html
    public String findAllIndex(Model model) {
        // crear una lista con todos los productos
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "index";
    }

    @GetMapping("/productos/{id}") // http://localhost:8082/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Producto> productoOpt = productoRepository.findById(id);

        if (productoOpt.isPresent()) {
            model.addAttribute("producto", productoOpt.get());
        } else {
            model.addAttribute("error", "404 Producto Not Found");
        }

        return "producto/producto-detail";
    }

    // mostrar formulario para crear nuevo producto
    @GetMapping("/productos/nuevo")
    public String createForm(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "producto/producto-form";
    }
    /*
    @PostMapping("/productos")
    public String saveForm(Model model){

        productoRepository.save(producto);
        return "redirect:/productos";
    }
    */

    // mostrar formulario para editar producto existente
    @GetMapping("/productos/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Producto> productoOpt = productoRepository.findById(id);

        if (productoOpt.isPresent()) {
            model.addAttribute("producto", productoOpt.get());
            model.addAttribute("categorias", categoriaRepository.findAll());
        } else {
            model.addAttribute("error", "Producto no encontrado");
        }
        return "producto/producto-form";
    }

    // procesar formulario (crear o actualizar)
    @PostMapping("/productos") // podría ser @PostMapping("/productos/form") si en el formulario pusiera th:action="@{/productos/form}"
    public String saveForm(@ModelAttribute Producto producto) {
        productoRepository.save(producto);

        return "redirect:/productos";
    }
/*
    // FILTROS
    // filtrar productos por categoria
    @GetMapping("/productos/categoria/{categoriaId}") // http://localhost:8080/productos/categoria/1
    public String findByCategoria(Model model, @PathVariable Long categoriaId) {
        List<Producto> productos = productoRepository.findByCategoria_Id(categoriaId);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "producto/producto-list";
    }


    // filtrar productos por nombre
    @GetMapping("/productos/buscar") // http://localhost:8080/productos/buscar?nombre=manzana
    public String findByNombre(Model model, @RequestParam("nombre") String nombre) {
        List<Producto> productos = productoRepository.findByNombreContainsIgnoreCase(nombre);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("busquedaActual", nombre);

        return "producto/producto-list";
    }
*/
}
