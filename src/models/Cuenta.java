package models;
import java.util.List;

public class Cuenta {
    private String idCuenta;
    private String tipoCuenta;
    private double saldo;
    private List<Transaccion> transacciones;
    

    public Cuenta(String idCuenta, String tipoCuenta, double saldo) {   
        this.idCuenta = idCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.transacciones = new java.util.ArrayList<>();
    }

    public void depositar(double monto){
        if (monto > 0){
            saldo += monto;
            System.out.println("deposito correcto, la plata llego a su destino");
        } else {
            System.out.println(
            "el monto es invalido, no se puede depositar"
            );
        }
    }

    public void retirar(double monto){
        if( monto > 0 && monto <= saldo){
            saldo-=monto;
            System.out.println("retiro completado, dinero sacado con exito");
        } else {
            if (monto >=saldo){
                System.out.println("saldo insuficiente, prueba con una cantidad menor");
                } else{
                System.out.println("monto invalido, no se puede retirar");

            }
            
        }
        }


        public void mostrarHistorial(){
            if (transacciones == null || transacciones.isEmpty()) {
                System.out.println("no hay transacciones para mostrar");
                return;
            } else {
                for(Transaccion t : transacciones){
                    System.out.println(t);

                }
            }
        }

        public void agregarTransaccion(Transaccion t) {
            if (t == null) return;
            if (transacciones == null) transacciones = new java.util.ArrayList<>();
            transacciones.add(t);
        }


        public String getIdCuenta() { return idCuenta; }
        public String getTipoCuenta() { return tipoCuenta; }
        public double getSaldo() { return saldo; }
        public List<Transaccion> getTransacciones() { return transacciones; }
        public void setTipoCuenta(String tipoCuenta) { this.tipoCuenta = tipoCuenta; }
        public void setSaldo(double saldo) { this.saldo = saldo; }
        public void setTransacciones(List<Transaccion> transacciones) { this.transacciones = transacciones; }


    }

