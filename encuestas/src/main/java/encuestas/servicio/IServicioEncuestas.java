package encuestas.servicio;

import java.time.LocalDateTime;
import java.util.List;

import encuestas.modelo.Encuesta;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;

public interface IServicioEncuestas {

	String create(String titulo, String instrucciones, LocalDateTime apertura, LocalDateTime cierre, List<String> opciones) throws RepositorioException;
	
	boolean haVotado(String id, String usuario) throws RepositorioException, EntidadNoEncontrada;
	
	void votar(String id, int opcion, String usuario) throws RepositorioException, EntidadNoEncontrada;
	
	Encuesta getById(String id) throws RepositorioException, EntidadNoEncontrada;
	
	void remove(String id) throws RepositorioException, EntidadNoEncontrada;
	
	List<EncuestaResumen> getListadoResumen() throws RepositorioException, EntidadNoEncontrada;
}
