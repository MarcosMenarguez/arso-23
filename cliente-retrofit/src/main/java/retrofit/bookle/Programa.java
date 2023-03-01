package retrofit.bookle;

import java.time.LocalDate;

import bookle.modelo.Actividad;
import bookle.modelo.Agenda;
import bookle.modelo.Turno;
import retrofit.bookle.Listado.ResumenExtendido;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jaxb.JaxbConverterFactory;

public class Programa {

	public static void main(String[] args) throws Exception {

		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8080/api/")
				.addConverterFactory(JaxbConverterFactory.create()).build();

		BookleRestClient service = retrofit.create(BookleRestClient.class);

		// Creación

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

		Response<Void> resultado = service.createActividad(actividad).execute();

		String url1 = resultado.headers().get("Location");

		String id1 = url1.substring(url1.lastIndexOf("/") + 1);

		System.out.println("Actividad creada: " + url1);
		System.out.println("Id: " + id1);

		// Recuperación

		Actividad actividad2 = service.getActividad(id1).execute().body();

		System.out.println("Actividad: " + actividad2.getTitulo() + " - " + actividad2.getDescripcion());

		// Actualización

		actividad2.setDescripcion("descripción actualizada");

		service.updateActividad(id1, actividad2).execute();

		System.out.println("Actividad actualizada");

		// Reserva

		Response<Void> respuesta = service.reservar(id1, LocalDate.now().plusDays(1).toString(), 2, "Antonio", "antonio@um.es").execute();

		System.out.println("Reserva realizada sobre actividad: " + id1);
		System.out.println("Código de respuesta: " + respuesta.message());

		// Listado

		Listado listado = service.getListado().execute().body();

		System.out.println("Listado:");
		for (ResumenExtendido actividadResumen : listado.getActividad()) {
			System.out.println("\t" + actividadResumen.getResumen().getTitulo());
			System.out.println("\t" + actividadResumen.getUrl());
		}

		System.out.println("fin.");

	}
}
