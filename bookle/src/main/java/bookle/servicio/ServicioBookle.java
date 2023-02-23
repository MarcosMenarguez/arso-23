package bookle.servicio;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import bookle.modelo.Actividad;
import bookle.modelo.Agenda;
import bookle.modelo.Reserva;
import bookle.modelo.Turno;
import repositorio.EntidadNoEncontrada;
import repositorio.FactoriaRepositorios;
import repositorio.Repositorio;
import repositorio.RepositorioException;

public class ServicioBookle implements IServicioBookle {

	private Repositorio<Actividad, String> repositorio = FactoriaRepositorios.getRepositorio(Actividad.class);

	

	@Override
	public String create(Actividad actividad) throws RepositorioException {

		return repositorio.add(actividad);
	}

	@Override
	public void update(Actividad actividad) throws RepositorioException, EntidadNoEncontrada {
		
		repositorio.update(actividad);
	}

	@Override
	public Actividad getActividad(String id) throws RepositorioException, EntidadNoEncontrada {

		return repositorio.getById(id);
	}

	@Override
	public void removeActividad(String id) throws RepositorioException, EntidadNoEncontrada {

		Actividad actividad = repositorio.getById(id);

		repositorio.delete(actividad);
	}

	@Override
	public boolean reservar(String id, LocalDate fecha, int indice, String alumno, String email)
			throws RepositorioException, EntidadNoEncontrada {

		if (id == null || id.isBlank())
			throw new IllegalArgumentException("El identificador no debe nulo o vacío");
		
		if (fecha == null)
			throw new IllegalArgumentException("La fecha debe establecerse");

		if (indice < 1)
			throw new IllegalArgumentException("El primer turno tiene índice 1");

		if (alumno == null || alumno.isBlank())
			throw new IllegalArgumentException("El nombre del alumno no debe ser vacío");

		// email es opcional

		Actividad actividad = repositorio.getById(id);

		Agenda diaActividad = null;

		Optional<Agenda> resultado = actividad.getAgenda().stream().filter(dia -> dia.getFecha().equals(fecha))
				.findFirst();

		if (resultado.isEmpty())
			throw new IllegalArgumentException("La fecha no esta en la agenda: " + fecha);
		else
			diaActividad = resultado.get();

		if (indice > diaActividad.getTurno().size())
			throw new IllegalArgumentException("No existe el turno " + indice + " para la fecha " + fecha);

		Turno turno = diaActividad.getTurno().get(indice - 1);

		// Se considera precondición que el turno esté libre
		
		if (turno.getReserva() != null)
			throw new IllegalArgumentException("El turno ya está reservado");

		Reserva reserva = new Reserva();
		reserva.setAlumno(alumno);
		reserva.setEmail(email);

		turno.setReserva(reserva);

		repositorio.update(actividad);
	
		
		// FIXME: la operación no debería retornar un valor booleano porque no es informativo
		
		return true; 
	}

	
	
	@Override
	public List<ActividadResumen> getListadoActividades() throws RepositorioException {

		LinkedList<ActividadResumen> resultado = new LinkedList<>();

		
		for (String id : repositorio.getIds()) {
			try {
				Actividad actividad = getActividad(id);
				ActividadResumen resumen = new ActividadResumen();
				resumen.setId(actividad.getId());
				resumen.setTitulo(actividad.getTitulo());
				resumen.setProfesor(actividad.getProfesor());
				resultado.add(resumen);
				
			} catch (Exception e) {
				// No debe suceder
				e.printStackTrace(); // para depurar
			}
		}

		return resultado;
	}

}
