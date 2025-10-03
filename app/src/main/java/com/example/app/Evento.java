package com.example.app;

public class Evento {
    private String categoria;
    private String fecha;
    private String torneo;
    private String partido;
    private double cuotaLocal;
    private double cuotaEmpate;
    private double cuotaVisitante;

    // Constructor
    public Evento(String categoria, String fecha, String torneo, String partido, double cuotaLocal, double cuotaEmpate, double cuotaVisitante) {
        this.categoria = categoria;
        this.fecha = fecha;
        this.torneo = torneo;
        this.partido = partido;
        this.cuotaLocal = cuotaLocal;
        this.cuotaEmpate = cuotaEmpate;
        this.cuotaVisitante = cuotaVisitante;
    }

    // Getters
    public String getCategoria() { return categoria; }
    public String getFecha() { return fecha; }
    public String getTorneo() { return torneo; }
    public String getPartido() { return partido; }
    public double getCuotaLocal() { return cuotaLocal; }
    public double getCuotaEmpate() { return cuotaEmpate; }
    public double getCuotaVisitante() { return cuotaVisitante; }
}

