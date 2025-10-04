package models;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	private String idCuenta;
	private double saldo;
	private List<Transaccion> transacciones;

	public Cuenta(String idCuenta, double saldoInicial) {
		this.idCuenta = idCuenta;
		this.saldo = saldoInicial;
		this.transacciones = new ArrayList<>();
	}

	public String getIdCuenta() { return idCuenta; }
	public double getSaldo() { return saldo; }
	public List<Transaccion> getTransacciones() { return transacciones; }

	public void depositar(double monto) {
		if (monto <= 0) return;
		saldo += monto;
		transacciones.add(new Transaccion("DEPOSITO", monto));
	}

	public boolean retirar(double monto) {
		if (monto <= 0 || monto > saldo) return false;
		saldo -= monto;
		transacciones.add(new Transaccion("RETIRO", -monto));
		return true;
	}

	@Override
	public String toString() {
		return "Cuenta{" + "idCuenta='" + idCuenta + '\'' + ", saldo=" + saldo + '}';
	}
}

