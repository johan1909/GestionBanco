package co.edu.uniquindio.poo.controllers;

import co.edu.uniquindio.poo.model.Banco;

public class UsuarioController {

    Banco banco;
    public UsuarioController (Banco banco){
        this.banco = banco;
    }

    public boolean iniciarsesion(String email, String contraseña){
        return banco.autenticarUsuario(email, contraseña);
    }
}
