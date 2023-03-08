package enlaces.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import enlaces.modelo.Enlace;
import enlaces.servicio.IServicioEnlaces;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;

public class Query implements GraphQLRootResolver {
    
	private IServicioEnlaces servicio = FactoriaServicios.getServicio(IServicioEnlaces.class);
	
    public List<Enlace> findAll() throws RepositorioException {
        return servicio.findAll();
    }
}