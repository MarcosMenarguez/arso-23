package enlaces.servicio.test;

import enlaces.servicio.IServicioEnlaces;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;

public class Programa {

	public static void main(String[] args) throws RepositorioException {
		
		IServicioEnlaces servicio = FactoriaServicios.getServicio(IServicioEnlaces.class);
		
		servicio.findAll().forEach(System.out::println);
		
		System.out.println("fin.");
		
	}
}
