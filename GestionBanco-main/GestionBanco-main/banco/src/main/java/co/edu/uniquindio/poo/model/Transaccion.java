package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
    private String id;
    private LocalDateTime fecha;
    private double monto;
    private String tipo;
    private String cuentaRelacionada;
    private String autorizador;
    
    public Transaccion(String id, LocalDateTime fecha, double monto, 
                      String tipo, String cuentaRelacionada, String autorizador) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipo = tipo;
        this.cuentaRelacionada = cuentaRelacionada;
        this.autorizador = autorizador;
    }
    
    // Getters
    public String getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public double getMonto() { return monto; }
    public String getTipo() { return tipo; }
    public String getCuentaRelacionada() { return cuentaRelacionada; }
    public String getAutorizador() { return autorizador; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s: $%.2f (Cuenta: %s, Autor: %s)",
                           fecha.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                           tipo, monto, cuentaRelacionada, autorizador);
    }
}
