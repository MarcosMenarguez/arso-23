package enlaces.modelo;

import repositorio.Identificable;

public class Enlace implements Identificable {

	private String id; // gestionado por el repositorio
	
    private String url;
    private String descripcion;
    private String emailUsuario;

    public Enlace() {
    	
    }
    
	public Enlace(String url, String descripcion, String emailUsuario) {
		this.url = url;
		this.descripcion = descripcion;
		this.emailUsuario = emailUsuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEmailUsuario() {
		return emailUsuario;
	}
	
    public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	@Override
	public String toString() {
		return "Enlace [id=" + id + ", url=" + url + ", descripcion=" + descripcion + ", emailUsuario=" + emailUsuario
				+ "]";
	}
	
}
