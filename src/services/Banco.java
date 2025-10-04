package services;

import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class Banco {
    private String nombre;
    private List<Usuario> usuarios;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.usuarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuario(String idUsuario) {
        if (idUsuario == null) return null;
        for (Usuario u : usuarios) {
            if (idUsuario.equals(u.getIdUsuario())) return u;
        }
        return null;
    }

    public boolean removerUsuario(String idUsuario) {
        Usuario u = buscarUsuario(idUsuario);
        if (u == null) return false;
        return usuarios.remove(u);
    }

    @Override
    public String toString() {
        return "Banco{" + "nombre='" + nombre + '\'' + ", usuarios=" + usuarios.size() + '}';
    }
}
