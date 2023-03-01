package encuestas.repositorio;

import java.time.LocalDateTime;
import java.util.Arrays;

import encuestas.modelo.Encuesta;
import repositorio.RepositorioException;
import repositorio.RepositorioMemoria;


/*
 * Esta clase es opcional.
 * Su utilidad es que en tiempo de compilación se compruebe que Actividad
 * implementa la interfaz Identificable.
 */
public class RepositorioEncuestasMemoria extends RepositorioMemoria<Encuesta> {

	public RepositorioEncuestasMemoria() {
		
		// Datos iniciales para pruebas
		
		try {
			Encuesta encuesta = new Encuesta("Test 1", "Instrucciones", 
					LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1), Arrays.asList("Opción 1", "Opción 2"));
			
			this.add(encuesta);
		} catch (RepositorioException e) {
			
			// No debe suceder
			e.printStackTrace();
		}
		
	}
	
}
