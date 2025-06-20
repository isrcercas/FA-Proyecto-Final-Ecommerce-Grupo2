package com.grupo2.controllers;


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
    @GetMapping("/usuarios/{id}")
    public String usuarioView(Model model, @PathVariable Long id){

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if(usuarioOpt.isPresent()){
            model.addAttribute("usuario", usuarioOpt.get());
        }else{
            model.addAttribute("error", "Usuario no encontrado");
        }

        return "usuario/usuario-detail";
    }

    @GetMapping("/usuarios/{id}/editar")
    public String usuarioEdit(Model model, @PathVariable Long id){

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if(usuarioOpt.isPresent()){
            model.addAttribute("usuario", usuarioOpt.get());
        }else{
            model.addAttribute("error", "404 Categoria no encontrada");
        }
    return "usuario/usuario-form";
    }

    @GetMapping("usuarios/nuevo")
    public String usuarioNew(Model model){

        model.addAttribute("usuario", new Usuario());

        return "usuario/usuario-form";
    }

    @PostMapping("/usuarios")
    public String usuarioSave(@ModelAttribute Usuario usuario){
        usuarioRepository.save(usuario);

        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/{id}/eliminar")
    public String usuarioDelete(@PathVariable Long id){

        usuarioRepository.deleteById(id);

        return "redirect:/usuarios";
    }

}
