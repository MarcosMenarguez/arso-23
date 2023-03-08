package enlaces.servicio;

import java.util.List;

import enlaces.modelo.Enlace;
import repositorio.FactoriaRepositorios;
import repositorio.Repositorio;
import repositorio.RepositorioException;

public class ServicioEnlaces implements IServicioEnlaces {

	private Repositorio<Enlace, String> repositorio = FactoriaRepositorios.getRepositorio(Enlace.class);
		
	@Override
	public Enlace crear(String url, String descripcion, String emailUsuario) throws RepositorioException {
		
		Enlace enlace = new Enlace(url, descripcion, emailUsuario);
	
		String id = repositorio.add(enlace);
		
		return enlace;
	}

	@Override
	public List<Enlace> findAll() throws RepositorioException {
		
		return repositorio.getAll();
	}
	
}
