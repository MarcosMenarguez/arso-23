package bookle.servicio;

import java.time.LocalDate;

import bookle.modelo.Actividad;
import bookle.modelo.Agenda;
import bookle.modelo.Turno;
import servicio.FactoriaServicios;


public class Main {

	public static void main(String[] args) throws Exception {
		
				
		IServicioBookle servicio = FactoriaServicios.getServicio(IServicioBookle.class);
		
		// 1. Creación de una actividad
		
		Actividad actividad = new Actividad();
		actividad.setTitulo("Entrevistas de prácticas");
		actividad.setDescripcion("Enlace Zoom: ...");
		actividad.setProfesor("Marcos");
		actividad.setEmail("marcos@um.es");
		
		// Día 1
		
		Agenda dia1 = new Agenda();
		dia1.setFecha(LocalDate.now().plusDays(1));		
		for (int hora = 10; hora <= 14; hora++) {
		
			Turno turno = new Turno();
			turno.setHorario(hora + ":00h");
			dia1.getTurno().add(turno);
		}
		
		actividad.getAgenda().add(dia1);
		
		// Día 2
		
		Agenda dia2 = new Agenda();
		dia1.setFecha(LocalDate.now().plusDays(1));
		for (int hora = 17; hora <= 19; hora++) {		
			Turno turno = new Turno();
			turno.setHorario(hora + ":00h");
			dia2.getTurno().add(turno);
		}
		
		actividad.getAgenda().add(dia2);
		
		String id = servicio.create(actividad);
		
		// 2. Actualización
		
		actividad = servicio.getActividad(id);
		
		actividad.setDescripcion("Enlace Zoom");
		
		servicio.update(actividad);
		
		// 3. Reserva
		
		boolean resultado = servicio.reservar(id, LocalDate.now().plusDays(1), 1, "Juan", "juan@um.es");
		
		System.out.println(resultado);
		
		// 4. Listado de resúmenes
		
		System.out.println("Listado:");
		for (ActividadResumen resumen : servicio.getListadoActividades())
			System.out.println("\t" + resumen);
		
		
		System.out.println("Fin.");
	}
}
