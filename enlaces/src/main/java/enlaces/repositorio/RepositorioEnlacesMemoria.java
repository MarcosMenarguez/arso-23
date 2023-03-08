package enlaces.repositorio;

import enlaces.modelo.Enlace;
import repositorio.RepositorioException;
import repositorio.RepositorioMemoria;

public class RepositorioEnlacesMemoria extends RepositorioMemoria<Enlace> {

	public RepositorioEnlacesMemoria()  {
		
		// Datos iniciales
		
		try {
			String url1 = "https://um.es";
			String descripcion1 = "Universidad de Murcia";
			String emailUsuario1 = "marcos@um.es";
			
			Enlace enlace1 = new Enlace(url1, descripcion1, emailUsuario1);
			this.add(enlace1);
			
			String url2 = "https://dis.um.es";
			String descripcion2 = "Departamento de Informática y Sistemas";
			String emailUsuario2 = "marcos@um.es";
			
			Enlace enlace2 = new Enlace(url2, descripcion2, emailUsuario2);
			this.add(enlace2);
			
		} catch (RepositorioException e) {
			e.printStackTrace(); // no debe suceder en un repositorio en memoria
		}
		
	}
	
}
