package com.grupo2.controllers;

import com.grupo2.entities.Categoria;
import com.grupo2.repositories.CategoriaRepository;
import com.grupo2.repositories.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.grupo2.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class CategoriaController {

    private ProductoRepository productoRepository;
    private CategoriaRepository categoriaRepository;



    public CategoriaController(CategoriaRepository categoriaRepository, ProductoRepository productoRepository){
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
    }

    @GetMapping("/categorias")
    public String findAll(Model model){

        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);

        return "categoria/categoria-list";
    }


    @GetMapping("/categorias/nueva")
    public String createForm(Model model) {
        model.addAttribute("categoria", new Categoria());

        return "categoria/categoria-form";
    }

    @GetMapping("/categorias/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);

        if (categoriaOpt.isPresent()) {
            model.addAttribute("categoria", categoriaOpt.get());
        } else {
            model.addAttribute("error", "404 Categoría Not Found");
        }

        return "categoria/categoria-form";
    }

    @PostMapping("/categorias")
    public String saveForm(@ModelAttribute Categoria categoria) {
        categoriaRepository.save(categoria);

        return "redirect:/categorias";
    }
/*
    @PostMapping("/categorias/{id}/eliminar")
    public String delete(@PathVariable Long id) {
        if (productoRepository.countByCategoria_Id(id) > 0) {
            return "redirect:/categoria/categorias?error=true";
        }
        categoriaRepository.deleteById(id);

        return "redirect:/categoria/categorias";
    }
*/
    // filtrar categorías por nombre
    @GetMapping("/categorias/buscar") // http:localhost:8080/categorias/buscar?nombre=frutas
    public String findByName(Model model, @RequestParam("nombre") String nombre) {
        List<Categoria> categorias = categoriaRepository.findByNombreContainsIgnoreCase(nombre);
        model.addAttribute("categorias", categorias);
        model.addAttribute("busquedaActual", nombre);

        return "categoria/categoria-list";
    }

}
