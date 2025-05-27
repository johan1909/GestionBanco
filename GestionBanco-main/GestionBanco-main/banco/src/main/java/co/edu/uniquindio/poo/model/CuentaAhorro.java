package co.edu.uniquindio.poo.model;

public class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    
    public CuentaAhorro(String numero, double saldo, Cliente cliente, double tasaInteres) {
        super(numero, saldo, cliente);
        this.tasaInteres = tasaInteres;
    }
    
    // Getters y Setters
    public double getTasaInteres() { return tasaInteres; }
    public void setTasaInteres(double tasaInteres) { this.tasaInteres = tasaInteres; }
    
    @Override
    public void aplicarInteres() {
        double interes = getSaldo() * tasaInteres / 100;
        depositar(interes);
        registrarTransaccion("INTERES_ACUMULADO", interes);
    }
}
