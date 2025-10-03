package com.example.app;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FormularioController {

    @Autowired
    private HomeController homeController;

    // Método para agregar datos al modelo (similar al HomeController)
    @ModelAttribute
    public void agregarDatosUsuario(Model model) {
        model.addAttribute("saldo", homeController.getSaldoUsuario());
        model.addAttribute("nombre", homeController.getNombreUsuario());
        model.addAttribute("email", homeController.getEmailUsuario());
        model.addAttribute("telefono", homeController.getTelefonoUsuario());
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String nombre, Model model) {
        model.addAttribute("resultado", "Resultado de búsqueda para: " + nombre);
        return "apuestas";
    }

    @PostMapping("/apuesta")
    public String apostar(@RequestParam double monto,
                          @RequestParam String partido,
                          @RequestParam(required = false) String tipo,
                          @RequestParam(required = false) String terminos,
                          RedirectAttributes redirectAttributes) {

        double saldoActual = homeController.getSaldoUsuario();

        // LÓGICA PARA REDUCIR EL SALDO
        if (monto > 0 && monto <= saldoActual) {
            homeController.setSaldoUsuario(saldoActual - monto);
            redirectAttributes.addFlashAttribute("mensaje", "¡Apuesta realizada exitosamente! -€" + monto);
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");

            String tipoApuesta = (tipo != null) ? tipo : "simple";
            String mensajeTipo = tipoApuesta.equals("combinada") ? " (Combinada)" : " (Simple)";
            redirectAttributes.addFlashAttribute("resultado", "Apuesta de " + monto + "€ en: " + partido + mensajeTipo);

        } else if (monto > saldoActual) {
            // Saldo insuficiente
            redirectAttributes.addFlashAttribute("mensaje", "Saldo insuficiente. Tu saldo actual es: €" + saldoActual);
            redirectAttributes.addFlashAttribute("tipoMensaje", "danger");
        } else {
            // Monto inválido
            redirectAttributes.addFlashAttribute("mensaje", "Monto inválido. Debe ser mayor a 0.");
            redirectAttributes.addFlashAttribute("tipoMensaje", "danger");
        }

        return "redirect:/apuestas";
    }

    // método de recargar saldo
    @PostMapping("/recargar")
    public String recargarSaldo(@RequestParam double monto, RedirectAttributes redirectAttributes) {
        if (monto > 0) {
            double nuevoSaldo = homeController.getSaldoUsuario() + monto;
            homeController.setSaldoUsuario(nuevoSaldo);
            redirectAttributes.addFlashAttribute("mensaje", "Saldo recargado exitosamente! +€" + monto);
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "Monto de recarga inválido");
            redirectAttributes.addFlashAttribute("tipoMensaje", "danger");
        }
        return "redirect:/perfil";
    }

    @PostMapping("/actualizar-perfil")
    public String actualizarPerfil(@RequestParam String nombre,
                                   @RequestParam String email,
                                   @RequestParam String telefono,
                                   RedirectAttributes redirectAttributes) {

        // Validar datos
        if (nombre != null && !nombre.trim().isEmpty() &&
                email != null && !email.trim().isEmpty()) {

            // Actualizar datos del usuario
            homeController.setNombreUsuario(nombre.trim());
            homeController.setEmailUsuario(email.trim());
            homeController.setTelefonoUsuario(telefono != null ? telefono.trim() : "");

            redirectAttributes.addFlashAttribute("mensaje", "Perfil actualizado exitosamente!");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "Nombre y email son obligatorios");
            redirectAttributes.addFlashAttribute("tipoMensaje", "danger");
        }

        return "redirect:/perfil";
    }

    // Cambiar contraseña
    @PostMapping("/cambiar-password")
    public String cambiarPassword(@RequestParam String currentPassword,
                                  @RequestParam String newPassword,
                                  Model model) {
        model.addAttribute("mensaje", "Contraseña cambiada exitosamente!");
        model.addAttribute("tipoMensaje", "success");
        return "perfil";
    }
}



