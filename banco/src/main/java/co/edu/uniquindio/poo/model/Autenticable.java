package co.edu.uniquindio.poo.model;

import java.lang.reflect.Method;

public interface Autenticable {
    boolean autenticar(String credencial);
    
    default boolean cambiarContraseña(String vieja, String nueva) {
        if (autenticar(vieja)) {
            // Asumiendo que las clases que implementan tienen setContraseña
            try {
                Method setContraseña = this.getClass().getMethod("setContraseña", String.class);
                setContraseña.invoke(this, nueva);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
