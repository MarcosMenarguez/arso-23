package usuarios.servicio;

import java.util.List;

import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import usuarios.modelo.Usuario;

public interface IServicioUsuarios {

	Usuario findByEmail(String email) throws RepositorioException, EntidadNoEncontrada ;
	
	List<Usuario> findAll() throws RepositorioException;	
}
