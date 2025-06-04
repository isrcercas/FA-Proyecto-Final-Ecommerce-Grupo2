package com.grupo2.controllers;

import com.grupo2.entities.Usuario;
import com.grupo2.repositories.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){

        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/usuarios")
    public String findAll(Model model){

        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        return "usuario/usuario-list";
    }

}
