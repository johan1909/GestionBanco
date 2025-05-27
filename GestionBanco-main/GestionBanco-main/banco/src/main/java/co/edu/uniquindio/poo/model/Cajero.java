package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cajero extends Empleado implements Autenticable, Reportable {
    private String codigoCajero;
    private LocalDateTime horarioTrabajo;
    private List<Transaccion> transaccionesRealizadas;
    
    // Constructor
    public Cajero(String id, String nombre, String email, String contraseña, 
                 String puesto, String codigoCajero, LocalDateTime horarioTrabajo) {
        super(id, nombre, email, contraseña, puesto);
        this.codigoCajero = codigoCajero;
        this.horarioTrabajo = horarioTrabajo;
        this.transaccionesRealizadas = new ArrayList<>();
    }
    
    // Getters y Setters
    public String getCodigoCajero() {
        return codigoCajero;
    }
    
    public LocalDateTime getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(LocalDateTime horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

    public void setCodigoCajero(String codigoCajero) {
        this.codigoCajero = codigoCajero;
    }
    
    // Implementación de la interfaz Autenticable
    @Override
    public boolean autenticar(String credencial) {
        return this.getContraseña().equals(credencial);
    }
    
    // Implementación de la interfaz Reportable
    @Override
    public String generarReporte() {
        return String.format("Reporte del Cajero %s - Transacciones realizadas: %d", 
                           this.getNombre(), transaccionesRealizadas.size());
    }
    
    // Métodos específicos del cajero
    public void realizarDeposito(Cuenta cuenta, double monto) throws OperacionInvalidaException {
        if (monto <= 0) {
            throw new OperacionInvalidaException("El monto del depósito debe ser positivo");
        }
        
        cuenta.depositar(monto);
        registrarTransaccion(cuenta, "DEPOSITO", monto);
    }
    
    public void realizarRetiro(Cuenta cuenta, double monto) 
            throws SaldoInsuficienteException, LimiteSobregiroException {
        if (cuenta instanceof CuentaCorriente) {
            CuentaCorriente cuentaCorrienteAux = (CuentaCorriente) cuenta;
            cuentaCorrienteAux.retirar(monto);
        } else {
            cuenta.retirar(monto);
        }
        
        registrarTransaccion(cuenta, "RETIRO", monto);
    }






    





    
    public double consultarSaldo(Cuenta cuenta) {
        registrarTransaccion(cuenta, "CONSULTA_SALDO", 0);
        return cuenta.getSaldo();
    }
    




    public void transferir(Cuenta origen, Cuenta destino, double monto) 
            throws SaldoInsuficienteException, OperacionInvalidaException {
        if (origen.equals(destino)) {
            throw new OperacionInvalidaException("No puede transferir a la misma cuenta");
        }
        
        origen.retirar(monto);
        destino.depositar(monto);
        
        registrarTransaccion(origen, "TRANSFERENCIA_ENVIADA", monto);
        registrarTransaccion(destino, "TRANSFERENCIA_RECIBIDA", monto);
    }
    




    private void registrarTransaccion(Cuenta cuenta, String tipo, double monto) {
        Transaccion transaccion = new Transaccion(
            UUID.randomUUID().toString(),
            LocalDateTime.now(),
            monto,
            tipo,
            cuenta.getNumero(),
            this.getCodigoCajero()
        );
        
        transaccionesRealizadas.add(transaccion);
        // Aquí también podrías guardar la transacción en una base de datos
    }
    
    // Método para generar reporte de transacciones del día
    public String generarReporteDiario() {
        double totalDepositos = transaccionesRealizadas.stream()
            .filter(t -> t.getTipo().equals("DEPOSITO"))
            .mapToDouble(Transaccion::getMonto)
            .sum();
            
        double totalRetiros = transaccionesRealizadas.stream()
            .filter(t -> t.getTipo().equals("RETIRO"))
            .mapToDouble(Transaccion::getMonto)
            .sum();
            
        return String.format(
            "Reporte Diario - Cajero: %s\n" +
            "Total Depósitos: $%.2f\n" +
            "Total Retiros: $%.2f\n" +
            "Saldo Neto: $%.2f\n" +
            "Total Transacciones: %d",
            this.getNombre(), totalDepositos, totalRetiros, 
            (totalDepositos - totalRetiros), transaccionesRealizadas.size()
        );
    }
}
