package com.example.app;

public class Reclamo {
	private String nombre;
    private String correo;
    private String descripcion;

    // 🔹 Constructor vacío (Spring lo necesita para binding)
    public Reclamo() {
    }

    // 🔹 Constructor con parámetros (opcional)
    public Reclamo(String nombre, String correo, String descripcion) {
        this.nombre = nombre;
        this.correo = correo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
