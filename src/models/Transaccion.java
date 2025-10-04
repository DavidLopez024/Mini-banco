package models;
import java.time.LocalDateTime;

public class Transaccion {
    private String idTransaccion;
    private String tipo; //deposito o retiro
    private double monto;
    private LocalDateTime fecha;


    public Transaccion(String idTransaccion, String tipo, double monto, LocalDateTime fecha) {
        this.idTransaccion = idTransaccion;
        this.tipo=tipo;
        this.monto=monto;
        this.fecha=fecha;

    }

    //tostring
    @Override
    public String toString(){
        return "Transaccion{" + "idTransaccion='" + idTransaccion + '\'' + ", tipo='" + tipo + '\'' + ", monto=" + monto + ", fecha=" + fecha + '}';
    }

}
