package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")  
    public String index() {
        return "index"; 
    }

    @GetMapping("/apuestas")
    public String apuestas() {
        return "apuestas";
    }

    @GetMapping("/eventos")
    public String eventos() {
        return "eventos";
    }

    @GetMapping("/historial")
    public String historial() {
        return "historial";
    }

    @GetMapping("/perfil")
    public String perfil() {
        return "perfil";
    }
}
