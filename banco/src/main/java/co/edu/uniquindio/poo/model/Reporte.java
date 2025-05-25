package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.UUID;

public class Reporte {
    private String id;
    private LocalDate fechaGeneracion;
    private String tipo;
    private String contenido;
    private String generadoPor;
    
    public Reporte(String tipo, String contenido, String generadoPor) {
        this.id = UUID.randomUUID().toString();
        this.fechaGeneracion = LocalDate.now();
        this.tipo = tipo;
        this.contenido = contenido;
        this.generadoPor = generadoPor;
    }
    
    // Getters
    public String getId() { return id; }
    public LocalDate getFechaGeneracion() { return fechaGeneracion; }
    public String getTipo() { return tipo; }
    public String getContenido() { return contenido; }
    public String getGeneradoPor() { return generadoPor; }
    
    public void exportarAPdf(String rutaArchivo) {
        // Implementación para exportar a PDF
    }
    
    public void exportarATxt(String rutaArchivo) {
        // Implementación para exportar a texto plano
    }
}
