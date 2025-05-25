package co.edu.uniquindio.poo.model;

public interface Reportable {
    String generarReporte();
    
    default void guardarReporte() {
        String reporte = generarReporte();
        // Implementación para guardar en archivo o base de datos
        System.out.println("Guardando reporte: " + reporte);
    }
}
