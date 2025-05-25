package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Cuenta {
    private String numero;
    private double saldo;
    private Cliente cliente;
    private boolean activa;
    private List<Transaccion> historial;
    
    public Cuenta(String numero, double saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.activa = true;
        this.historial = new ArrayList<>();
    }
    
    // Getters y Setters
    public String getNumero() { 
        return numero; 
    }


    public double getSaldo() { 
        return saldo; 
    }


    public Cliente getCliente() { 
        return cliente; 
    }
    

    public boolean isActiva() { 
        return activa; 
    }


    public List<Transaccion> getHistorial() { 
        return historial; 
    }


    
    public void setNumero(String numero) { 
        this.numero = numero; 
    }



    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void setCliente(Cliente cliente) { 
        this.cliente = cliente; 
    }


    public void setActiva(boolean activa) { 
        this.activa = activa; 
    }

    
    
    // Métodos de operaciones bancarias
    public void depositar(double monto) {
        if (!activa) throw new CuentaInactivaException("La cuenta está inactiva");
        if (monto <= 0) throw new OperacionInvalidaException("Monto debe ser positivo");
        
        saldo += monto;
        registrarTransaccion("DEPOSITO", monto);
    }
    
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (!activa) throw new CuentaInactivaException("La cuenta está inactiva");
        if (monto <= 0) throw new OperacionInvalidaException("Monto debe ser positivo");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente");
        
        saldo -= monto;
        registrarTransaccion("RETIRO", monto);
    }
    
    public void transferirA(Cuenta destino, double monto) 
            throws SaldoInsuficienteException, OperacionInvalidaException {
        this.retirar(monto);
        destino.depositar(monto);
        registrarTransaccion("TRANSFERENCIA_ENVIADA", monto);
        destino.registrarTransaccion("TRANSFERENCIA_RECIBIDA", monto);
    }
    
    protected void registrarTransaccion(String tipo, double monto) {
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID().toString(),
            LocalDateTime.now(),
            monto,
            tipo,
            this.numero,
            "SISTEMA"
        );
        historial.add(transaccion);
    }
    
    // Método abstracto para aplicar intereses (implementación específica por tipo de cuenta)
    public abstract void aplicarInteres();
}
