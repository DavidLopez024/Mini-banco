package app;

import java.time.LocalDateTime;
import models.Cuenta;
import models.Transaccion;
import models.Usuario;
import services.Banco;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Mi Mini Banco");

        // Crear usuarios
        Usuario u1 = new Usuario("u001", "David", "pass123");
        Usuario u2 = new Usuario("u002", "Ana", "clave456");

        // Crear cuentas
        Cuenta c1 = new Cuenta("c1001", "Ahorros", 100.0);
        Cuenta c2 = new Cuenta("c1002", "Corriente", 250.0);

        // Asociar cuentas a usuarios
        u1.agregarCuenta(c1);
        u2.agregarCuenta(c2);

        // Agregar usuarios al banco
        banco.agregarUsuario(u1);
        banco.agregarUsuario(u2);

        // Hacer transacciones
        Transaccion t1 = new Transaccion("t001", "deposito", 50.0, LocalDateTime.now());
        c1.agregarTransaccion(t1);
        c1.depositar(50.0);

        // Mostrar estado
        System.out.println(banco);
        System.out.println("Usuario u1: " + banco.buscarUsuario("u001"));
        System.out.println("Cuentas de u1:");
        banco.buscarUsuario("u001").mostrarCuentas();
    }
}