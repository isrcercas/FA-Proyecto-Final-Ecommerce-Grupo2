package com.grupo2.controllers;


import com.grupo2.entities.Compra;
import com.grupo2.repositories.CompraRepository;
import com.grupo2.repositories.ProductoRepository;
import com.grupo2.repositories.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompraController {

    private CompraRepository compraRepository;
    private UsuarioRepository usuarioRepository;
    private ProductoRepository productoRepository;

    public CompraController(CompraRepository compraRepository, UsuarioRepository usuarioRepository, ProductoRepository productoRepository){
        this.compraRepository = compraRepository;
        this.usuarioRepository = usuarioRepository;
        this.productoRepository = productoRepository;

    }



    @GetMapping("/compras")
    public String findAll(Model model){
        List<Compra> compras = compraRepository.findAll();
        model.addAttribute("compras", compras);

        return "compra/compra-list";
    }
    // preva de subida
    // mostrar formulario para crear nueva compra
    @GetMapping("/compras/nueva")
    public String createForm(Model model) {
        model.addAttribute("compra", new Compra());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("productos", productoRepository.findAll());

        return "compra/compra-form";
    }

    // procesar formulario (crear o actualizar)
    @PostMapping("/compras") // podría ser @PostMapping("/compras/form") si en el formulario pusiera th:action="@{/compras/form}"
    public String saveForm(@ModelAttribute Compra compra) {
        compraRepository.save(compra);

        return "redirect:/compras";
    }

}
