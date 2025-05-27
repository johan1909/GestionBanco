package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private String direccion;
    private String telefono;
    private LocalDate fechaRegistro;
    private List<Cuenta> cuentas;
    
    public Cliente(String id, String nombre, String email, String contraseña, 
                  String direccion, String telefono) {
        super(id, nombre, email, contraseña);
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaRegistro = LocalDate.now();
        this.cuentas = new ArrayList<>();
    }
    
    // Getters y Setters
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public List<Cuenta> getCuentas() { return cuentas; }
    
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
        
    }
    
    @Override
    public String getTipoUsuario() {
        return "CLIENTE";
    }
}
