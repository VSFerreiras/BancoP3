package demo;

public class Empleado {

    private String nombre;
    private String cuentaRemitente;
    private String cuenta;
    private String referencia;
    private double montoPago;
    private String concepto;
    private String moneda;

    public Empleado(String nombre, String cuentaRemitente, String cuenta, String referencia, double montoPago, String concepto, String moneda) {
        this.nombre = nombre;
        this.cuentaRemitente = cuentaRemitente;
        this.cuenta = cuenta;
        this.referencia = referencia;
        this.montoPago = montoPago;
        this.concepto = concepto;
        this.moneda = moneda;
    }

    public Empleado(String nombre, String cuenta, String referencia, double montoPago, String concepto) {
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuentaRemitente() {
        return cuentaRemitente;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getReferencia() {
        return referencia;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getMoneda() {
        return moneda;
    }
}
