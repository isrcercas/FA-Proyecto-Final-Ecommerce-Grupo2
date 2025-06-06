package com.grupo2.controllers;


import com.grupo2.entities.Compra;
import com.grupo2.entities.Usuario;
import com.grupo2.repositories.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Mostrar formulario de registro
    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "usuario/usuario-form";
    }

    // Registrar nuevo usuario
    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam String nombre,
                                   @RequestParam String email,
                                   @RequestParam String password,
                                   @RequestParam String direccion,
                                   Model model) {
        // Validar que el email no exista
        if (usuarioRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Ya existe un usuario con este email");
            return "usuario/usuario-form";
        }

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setDireccion(direccion);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        model.addAttribute("mensaje", "Usuario registrado correctamente");
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario/usuario-list";
    }

    // Mostrar formulario de login
    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "usuario/usuario-form";
    }

    // Login simple
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndPassword(email, password);

        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuario/usuario-detail";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "usuario/usuario-form";
        }
    }

    // Obtener todos los usuarios
    @GetMapping("/lista")
    public String obtenerTodosLosUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario/usuario-list";
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public String obtenerUsuarioPorId(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuario/usuario-detail";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "usuario/usuario-list";
        }
    }

    // Obtener usuario por email
    @GetMapping("/buscar")
    public String obtenerUsuarioPorEmail(@RequestParam String email, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuario/usuario-detail";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            List<Usuario> usuarios = usuarioRepository.findAll();
            model.addAttribute("usuarios", usuarios);
            return "usuario/usuario-list";
        }
    }

    // Mostrar formulario de actualización
    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuario/usuario-form";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            List<Usuario> usuarios = usuarioRepository.findAll();
            model.addAttribute("usuarios", usuarios);
            return "usuario/usuario-list";
        }
    }

    // Actualizar datos del usuario
    @PostMapping("/actualizar/{id}")
    public String actualizarUsuario(@PathVariable Long id,
                                    @RequestParam String nombre,
                                    @RequestParam String email,
                                    @RequestParam String password,
                                    @RequestParam String direccion,
                                    Model model) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (!usuarioExistente.isPresent()) {
            model.addAttribute("error", "Usuario no encontrado");
            List<Usuario> usuarios = usuarioRepository.findAll();
            model.addAttribute("usuarios", usuarios);
            return "usuario/usuario-list";
        }

        Usuario usuario = usuarioExistente.get();
        usuario.setNombreUsuario(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setDireccion(direccion);

        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        model.addAttribute("usuario", usuarioActualizado);
        model.addAttribute("mensaje", "Usuario actualizado correctamente");
        return "usuario/usuario-detail";
    }

    // Obtener compras de un usuario
    @GetMapping("/{id}/compras")
    public String obtenerComprasDelUsuario(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            model.addAttribute("error", "Usuario no encontrado");
            List<Usuario> usuarios = usuarioRepository.findAll();
            model.addAttribute("usuarios", usuarios);
            return "usuario/usuario-list";
        }

        List<Compra> compras = usuario.get().getCompras();
        model.addAttribute("compras", compras);
        model.addAttribute("usuario", usuario.get());
        return "usuario/usuario-detail";
    }
/*
    // Eliminar usuario
    @PostMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id, Model model) {
        if (!usuarioRepository.findById(id).isPresent()) {
            model.addAttribute("error", "Usuario no encontrado");
        } else {
            usuarioRepository.deleteById(id);
            model.addAttribute("mensaje", "Usuario eliminado correctamente");
        }

        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario/usuario-list";
    }
    */

}