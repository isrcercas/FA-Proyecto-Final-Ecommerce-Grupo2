package com.grupo2.controllers;


import com.grupo2.entities.Compra;
import com.grupo2.entities.Producto;
import com.grupo2.entities.Usuario;
import com.grupo2.repositories.CompraRepository;
import com.grupo2.repositories.ProductoRepository;
import com.grupo2.repositories.UsuarioRepository;
//import com.sun.beans.decoder.ArrayElementHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.AttributedString;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CompraController {
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    @GetMapping("/compras")
    public String findAll(Model model){
        List<Compra> compras = compraRepository.findAll();
        model.addAttribute("compras", compras);

        return "compra/compra-list";
    }


    // mostrar formulario para crear nueva compra
    @GetMapping("/compras/nueva")
    public String createForm(Model model) {
        Compra compra = new Compra();
        compra.setFechaDeCompra(LocalDate.now());

        model.addAttribute("compra", compra);
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("usuarios", usuarioRepository.findAll());


        return "compra/compra-form";
    }



    // procesar formulario (crear o actualizar)
    @PostMapping("/compras") // podría ser @PostMapping("/compras/form") si en el formulario pusiera th:action="@{/compras/form}"
    public String saveForm(@ModelAttribute("compra") Compra compra,
                           @RequestParam("productoId") Long productoId,
                           @RequestParam("usuarioId") Long usuarioId) {
        Producto producto = productoRepository.findById(productoId).orElseThrow();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();

        AttributedString model = null;
        if(compra.getCantidad() > producto.getStock()){
            //model.addAttribute("compra",  "Cantidad mayor que Stock");
            return "redirect:/compras";
        }

        // Calcular total
        double total = producto.getPrecio() * compra.getCantidad();
        Integer stock = producto.getStock() - compra.getCantidad();



        // Asignar valores
        compra.setProducto(producto);
        compra.setUsuario(usuario);
        compra.setTotal(total);
        producto.setStock(stock);

        // Guardar en BD
        compraRepository.save(compra);
        productoRepository.save(producto);

        return "redirect:/compras";
    }



}
