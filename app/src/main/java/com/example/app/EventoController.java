package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EventoController {

    private List<Evento> eventos = List.of(
            new Evento("Futbol", "Hoy, 20:00", "Champions League - Final", "Real Madrid vs PSG", 1.85, 3.40, 2.10),
            new Evento("Basket", "Mañana, 02:30", "NBA Finals", "Lakers vs Celtics", 2.10, 3.20, 1.90),
            new Evento("Futbol", "12 Jun, 16:00", "Premier League", "Manchester City vs Liverpool", 1.95, 3.50, 2.05),
            new Evento("Tenis", "15 Jul, 14:00", "Wimbledon - Semifinal", "Djokovic vs Alcaraz", 1.75, 0, 2.15),
            new Evento("FutbolAmericano", "11 Feb, 23:30", "Super Bowl", "Chiefs vs 49ers", 1.80, 0, 2.00),
            new Evento("Beisbol", "25 Oct, 20:00", "MLB World Series", "Yankees vs Dodgers", 2.25, 0, 1.65),
            new Evento("Boxeo", "18 Ago, 22:00", "Boxeo - Peso Pesado", "Fury vs Usyk", 1.60, 0, 2.40),
            new Evento("Formula1", "26 May, 15:00", "Gran Premio de Mónaco", "Verstappen vs Hamilton", 1.45, 0, 2.75)
    );

    @GetMapping("/eventos")
    public String verEventos(Model model) {
        model.addAttribute("eventos", eventos);
        return "eventos";
    }

    @GetMapping("/filtrar")
    public String filtrar(@RequestParam String categoria, Model model) {
        List<Evento> filtrados = eventos.stream()
                .filter(e -> e.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());

        model.addAttribute( "eventos", filtrados);
        model.addAttribute("resultado", "Filtrando eventos por categoría: " + categoria);
        return "eventos";
    }
}

