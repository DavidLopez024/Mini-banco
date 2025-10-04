package services;   

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import models.Usuario;

/**
 * Servicio Banco: gestiona usuarios y persiste en data/banco.json
 */
public class Banco {
	private List<Usuario> usuarios;
	private final Gson gson;
	private static final String DATA_FILE = "data/banco.json";

	public Banco() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
		this.usuarios = new ArrayList<>();
		cargarDatos();
	}

	/**
	 * Registra un nuevo usuario y lo persiste.
	 * @param nombre nombre del usuario
	 * @param contrasena contraseña del usuario
	 * @return el Usuario creado
	 */
	public Usuario registrarUsuario(String nombre, String contrasena) {
		String id = UUID.randomUUID().toString();
		Usuario u = new Usuario(id, nombre, contrasena);
		usuarios.add(u);
		guardarDatos();
		return u;
	}

	/**
	 * Intenta iniciar sesión con idUsuario y contraseña.
	 * @param idUsuario id del usuario
	 * @param contrasena contraseña
	 * @return el Usuario si las credenciales coinciden, o null en caso contrario
	 */
	public Usuario iniciarSesion(String idUsuario, String contrasena) {
		Usuario u = buscarUsuario(idUsuario);
		if (u != null && u.getContrasena() != null && u.getContrasena().equals(contrasena)) {
			return u;
		}
		return null;
	}

	/**
	 * Guarda la lista de usuarios en el JSON (data/banco.json).
	 */
	public void guardarDatos() {
		try {
			Path path = Paths.get(DATA_FILE);
			// asegurar que el directorio existe
			if (path.getParent() != null) {
				Files.createDirectories(path.getParent());
			}
			try (BufferedWriter w = new BufferedWriter(new FileWriter(path.toFile()))) {
				String json = gson.toJson(usuarios);
				w.write(json);
			}
		} catch (IOException e) {
			System.err.println("Error guardando datos del banco: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Carga los datos desde data/banco.json. Si no existe, mantiene la lista vacía.
	 */
	private void cargarDatos() {
		File f = new File(DATA_FILE);
		if (!f.exists()) return;
		try (BufferedReader r = new BufferedReader(new FileReader(f))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = r.readLine()) != null) {
				sb.append(line).append(System.lineSeparator());
			}
			String json = sb.toString().trim();
			if (json.isEmpty()) return;
			Type type = new TypeToken<List<Usuario>>() {}.getType();
			List<Usuario> loaded = gson.fromJson(json, type);
			if (loaded != null) {
				this.usuarios = loaded;
			}
		} catch (IOException e) {
			System.err.println("Error cargando datos del banco: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Busca un usuario por su id.
	 * @param idUsuario id a buscar
	 * @return Usuario encontrado o null
	 */
	public Usuario buscarUsuario(String idUsuario) {
		if (idUsuario == null) return null;
		for (Usuario u : usuarios) {
			if (idUsuario.equals(u.getIdUsuario())) return u;
		}
		return null;
	}

	// getter para pruebas/uso
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
}

