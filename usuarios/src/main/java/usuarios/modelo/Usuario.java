package usuarios.modelo;

import repositorio.Identificable;

public class Usuario implements Identificable {

	private String id;
	
	private String nombre;
	private String email;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String email) {		
		this.nombre = nombre;
		this.email = email;
	}

	@Override
	public String getId() {		
		return id;
	}

	@Override
	public void setId(String id) {		
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + "]";
	}
	
}
