package com.grupo2.controllers;


import com.grupo2.entities.Categoria;
import com.grupo2.entities.Compra;
import com.grupo2.entities.Usuario;
import com.grupo2.repositories.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/usuarios")
    public String findAll(Model model) {

        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return "usuario/usuario-list";
    }

    // Obtener usuario por ID
    @GetMapping("/usuarios/{id}")
    public String obtenerUsuarioPorId(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuario/usuario-detail";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            List<Usuario> usuarios = usuarioRepository.findAll();
            model.addAttribute("usuarios", usuarios);
            return "usuario/usuario-list";
        }
    }      //actualizar usuario//

    @GetMapping("/usuarios/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuario/usuario-form";  // Aquí se carga el formulario con los datos del usuario
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "redirect:/usuarios";  // O rediriges a la lista con mensaje
        }

    }
    //registrar nuevo usuario

    @GetMapping("/usuarios/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario()); // usuario vacío
        return "usuario/usuario-form";


    }

    //formulario de registro

    @PostMapping("/usuarios/registro")
    public String registrarUsuario(@RequestParam String nombre,
                                   @RequestParam String email,
                                   @RequestParam String password,
                                   @RequestParam String direccion,
                                   Model model) {

        if (usuarioRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Ya existe un usuario con este email");
            model.addAttribute("usuario", new Usuario()); // Para que no se rompa el formulario
           return "usuario/usuario-form";
        }

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setDireccion(direccion);

        usuarioRepository.save(usuario);

        return "redirect:/usuarios"; // redirige a la lista

    }

}

