package co.edu.uniquindio.poo.model;

public abstract class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String contraseña;
    
    public Usuario(String id, String nombre, String email, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        }

    
    // Getters y Setters
    public String getId() { 
        return id; 
    }


    public String getNombre() { 
        return nombre; 
    }


    public String getEmail() { 
        return email; 
    }


    public String getContraseña() {
        return contraseña; 
    }

    
    public void setId(String id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }


    public void setEmail(String email) { 
        this.email = email; 
    }


    public void setContraseña(String contraseña) { 
        this.contraseña = contraseña; 
    }

    
    
    public abstract String getTipoUsuario();
}
