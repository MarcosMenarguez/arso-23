package enlaces.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import enlaces.modelo.Enlace;
import enlaces.servicio.IServicioEnlaces;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;

public class Mutation implements GraphQLRootResolver {
    
	private IServicioEnlaces servicio = FactoriaServicios.getServicio(IServicioEnlaces.class);
	
    public Enlace crearEnlace(String url, String descripcion, String emailUsuario) throws RepositorioException {
        
    	return servicio.crear(url, descripcion, emailUsuario);
    }
}
