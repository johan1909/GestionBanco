package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Administrador extends Empleado implements Autenticable, Reportable {
    private List<String> permisos;
    
    public Administrador(String id, String nombre, String email, String contraseña) {
        super(id, nombre, email, contraseña, "ADMINISTRADOR");
        this.permisos = new ArrayList<>();
        this.permisos.addAll(Arrays.asList("GESTION_EMPLEADOS", "MONITOREO", "REPORTES"));
    }
    
    // Getters
    public List<String> getPermisos() { return permisos; }
    
    public boolean tienePermiso(String permiso) {
        return permisos.contains(permiso);
    }
    
    // Implementación de Autenticable
    @Override
    public boolean autenticar(String credencial) {
        return this.getContraseña().equals(credencial);
    }
    
    // Implementación de Reportable
    @Override
    public String generarReporte() {
        return String.format("Reporte Administrador %s - Permisos: %s", 
                           this.getNombre(), String.join(", ", permisos));
    }
    
    // Métodos específicos del administrador
    public void agregarEmpleado(Empleado empleado, List<Empleado> plantilla) {
        plantilla.add(empleado);
    }
    
    public void desactivarCuenta(Cuenta cuenta) {
        cuenta.setActiva(false);
    }
}
