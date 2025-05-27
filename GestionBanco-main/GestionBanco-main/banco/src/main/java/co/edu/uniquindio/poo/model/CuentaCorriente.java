package co.edu.uniquindio.poo.model;

public class CuentaCorriente extends Cuenta {
    private double limiteSobregiro;
    
    public CuentaCorriente(String numero, double saldo, Cliente cliente, double limiteSobregiro) {
        super(numero, saldo, cliente);
        this.limiteSobregiro = limiteSobregiro;
    }
    
    // Getters y Setters
    public double getLimiteSobregiro() { return limiteSobregiro; }
    public void setLimiteSobregiro(double limiteSobregiro) { this.limiteSobregiro = limiteSobregiro; }
    
    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (!isActiva()) throw new CuentaInactivaException("La cuenta está inactiva");
        if (monto <= 0) throw new OperacionInvalidaException("Monto debe ser positivo");
        
        double saldoDisponible = getSaldo() + limiteSobregiro;
        if (monto > saldoDisponible) {
            throw new SaldoInsuficienteException("Excede límite de sobregiro");
        }
        
        setSaldo(getSaldo() - monto);
        registrarTransaccion("RETIRO", monto);
    }
    
    @Override
    public void aplicarInteres() {
        // Cuentas corrientes normalmente no generan intereses
    }



    
}
