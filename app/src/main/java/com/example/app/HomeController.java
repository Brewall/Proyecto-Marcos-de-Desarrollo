package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private double saldoUsuario = 500.00;
    private String nombreUsuario = "Carlos Rodríguez";
    private String emailUsuario = "carlos@example.com";
    private String telefonoUsuario = "+51 912345678";

    @ModelAttribute
    public void agregarDatosUsuario(Model model) {
        model.addAttribute("saldo", saldoUsuario);
        model.addAttribute("nombre", nombreUsuario);
        model.addAttribute("email", emailUsuario);
        model.addAttribute("telefono", telefonoUsuario);
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("reclamo", new Reclamo());
        return "index";
    }

    @GetMapping("/apuestas")
    public String apuestas() {
        return "apuestas";
    }

    @GetMapping("/home")
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

     @PostMapping("/enviarReclamo")
    public String procesarReclamo(@ModelAttribute Reclamo reclamo, Model model) {
        model.addAttribute("mensaje", "Tu reclamo fue registrado correctamente ✅");
        model.addAttribute("tipoMensaje", "success");
        model.addAttribute("datos", reclamo);
        model.addAttribute("reclamo", new Reclamo()); // limpia el form
        return "index";
    }

    // Getters para que FormularioController pueda acceder a los datos
    public double getSaldoUsuario() {
        return saldoUsuario;
    }

    public void setSaldoUsuario(double saldoUsuario) {
        this.saldoUsuario = saldoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }
}