package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormularioController {

    @GetMapping("/buscar")
    public String buscar(@RequestParam String nombre, Model model) {
        model.addAttribute("resultado", "Resultado de búsqueda para: " + nombre);
        return "apuestas"; // dashboard.html
    }

    @GetMapping("/filtrar")
    public String filtrar(@RequestParam String categoria, Model model) {
        model.addAttribute("resultado", "Filtrando apuestas por categoría: " + categoria);
        return "eventos";
    }

    @PostMapping("/registro")
    public String registrar(@RequestParam String usuario, @RequestParam String clave, Model model) {
        model.addAttribute("resultado", "Usuario registrado: " + usuario + " con clave [" + clave + "]");
        return "perfil";
    }

    @PostMapping("/apuesta")
    public String apostar(@RequestParam double monto, @RequestParam String partido, Model model) {
        model.addAttribute("resultado", "Apuesta realizada de " + monto + " en el partido: " + partido);
        return "historial";
    }
}



