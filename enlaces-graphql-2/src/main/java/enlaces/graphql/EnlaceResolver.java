package enlaces.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;

import enlaces.modelo.Enlace;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;
import usuarios.modelo.Usuario;
import usuarios.servicio.IServicioUsuarios;

public class EnlaceResolver implements GraphQLResolver<Enlace> {

	private IServicioUsuarios servicio = FactoriaServicios.getServicio(IServicioUsuarios.class);
	
	public Usuario publicadoPor(Enlace enlace) throws RepositorioException, EntidadNoEncontrada {
		
		return servicio.findByEmail(enlace.getEmailUsuario());
	}
	
}
