package co.edu.uniquindio.poo.model;

public class Empleado extends Usuario {
    private String puesto;
    
    public Empleado(String id, String nombre, String email, String contraseña, String puesto) {
        super(id, nombre, email, contraseña);
        this.puesto = puesto;
    }
    
    // Getters y Setters
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    
    @Override
    public String getTipoUsuario() {
        return "EMPLEADO";
    }
}
