package models;

public class Transaccion {
    private String tipo;
    private double monto;

    public Transaccion(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    public String getTipo() { return tipo; }
    public double getMonto() { return monto; }

    @Override
    public String toString() {
        return "Transaccion{" + "tipo='" + tipo + '\'' + ", monto=" + monto + '}';
    }
}
