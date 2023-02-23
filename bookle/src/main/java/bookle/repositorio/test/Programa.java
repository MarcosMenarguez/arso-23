package bookle.repositorio.test;

import java.time.LocalDate;

import bookle.modelo.Actividad;
import bookle.modelo.Agenda;
import bookle.modelo.Turno;
import repositorio.FactoriaRepositorios;
import repositorio.Repositorio;

public class Programa {

	public static void main(String[] args) throws Exception {
		
		Repositorio<Actividad, String> repositorio = FactoriaRepositorios.getRepositorio(Actividad.class);
		
		// 1. Creación de una actividad

		Actividad actividad = new Actividad();
		actividad.setTitulo("Entrevistas de prácticas");
		actividad.setDescripcion("Enlace Zoom: ...");
		actividad.setProfesor("Marcos");
		actividad.setEmail("marcos@um.es");

		// Día 1

		Agenda dia1 = new Agenda();		
		dia1.setFecha(LocalDate.now().plusDays(1)); // mañana

		for (int hora = 10; hora <= 14; hora++) {

			Turno turno = new Turno();
			turno.setHorario(hora + ":00h");
			dia1.getTurno().add(turno);
		}

		actividad.getAgenda().add(dia1);

		System.out.println(actividad);
		
		String id = repositorio.add(actividad);
		
		System.out.println("Actividad creada con id: " + id);
		
		System.out.println("fin.");

	}
}
