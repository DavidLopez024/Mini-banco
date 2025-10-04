package models;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String contrasena;
    private List<Cuenta> cuentas;

    public Usuario(String idUsuario, String nombre, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.cuentas = new ArrayList<>();
    }

    public String getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getContrasena() { return contrasena; }
    public List<Cuenta> getCuentas() { return cuentas; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }

    /**
     * Busca una cuenta por su id (numero de cuenta) y la devuelve.
     * @param numeroCuenta id de la cuenta a buscar
     * @return la Cuenta si se encuentra, o null si no existe
     */
    public Cuenta buscarCuenta(String numeroCuenta) {
        if (numeroCuenta == null) return null;
        for (Cuenta c : cuentas) {
            if (numeroCuenta.equals(c.getIdCuenta())) {
                return c;
            }
        }
        return null;
    }

    /**
     * Muestra por consola todas las cuentas del usuario.
     */
    public void mostrarCuentas() {
        if (cuentas == null || cuentas.isEmpty()) {
            System.out.println("El usuario no tiene cuentas.");
            return;
        }
        for (Cuenta c : cuentas) {
            System.out.println(c);
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario='" + idUsuario + '\'' + ", nombre='" + nombre + '\'' + ", cuentas=" + cuentas + '}';
    }

}
    

