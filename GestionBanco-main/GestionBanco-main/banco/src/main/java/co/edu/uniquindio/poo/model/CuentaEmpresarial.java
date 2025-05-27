package co.edu.uniquindio.poo.model;

public class CuentaEmpresarial extends CuentaCorriente {
    private String razonSocial;
    private String nit;
    
    public CuentaEmpresarial(String numero, double saldo, Cliente cliente, 
                            double limiteSobregiro, String razonSocial, String nit) {
        super(numero, saldo, cliente, limiteSobregiro);
        this.razonSocial = razonSocial;
        this.nit = nit;
    }
    
    // Getters y Setters
    public String getRazonSocial() { return razonSocial; }
    public String getNit() { return nit; }
    
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }
    public void setNit(String nit) { this.nit = nit; }
    
    @Override
    public void aplicarInteres() {
        // Intereses especiales para cuentas empresariales
        double interes = getSaldo() * 0.005; // 0.5%
        depositar(interes);
        registrarTransaccion("INTERES_EMPRESARIAL", interes);
    }
}
