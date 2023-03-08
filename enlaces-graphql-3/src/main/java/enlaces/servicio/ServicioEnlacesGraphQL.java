package enlaces.servicio;

import java.util.List;

import enlaces.modelo.Enlace;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;

/*
 * Esta clase decora el servicio original con las anotaciones GraphQL
 */
public class ServicioEnlacesGraphQL implements IServicioEnlaces {

	private IServicioEnlaces servicio = FactoriaServicios.getServicio(IServicioEnlaces.class);
	
	@GraphQLMutation
	@Override
	public Enlace crear(String url, String descripcion, String emailUsuario) throws RepositorioException {
		
		return servicio.crear(url, descripcion, emailUsuario);
	}

	@GraphQLQuery
	@Override
	public List<Enlace> findAll() throws RepositorioException {
		
		return servicio.findAll();
	}

}
