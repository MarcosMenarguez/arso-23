package enlaces.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import enlaces.modelo.Enlace;
import enlaces.servicio.IServicioEnlaces;
import enlaces.servicio.ServicioEnlaces;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;
import usuarios.modelo.Usuario;
import usuarios.servicio.IServicioUsuarios;
import usuarios.servicio.ServicioUsuarios;

public class Query implements GraphQLRootResolver {
    
	private IServicioUsuarios servicioUsuarios = FactoriaServicios.getServicio(IServicioUsuarios.class);
	private IServicioEnlaces servicioEnlaces = FactoriaServicios.getServicio(IServicioEnlaces.class);
	
    public List<Enlace> allEnlaces() throws RepositorioException {
        return servicioEnlaces.findAll();
    }
    
    public List<Usuario> allUsuarios() throws RepositorioException {
        return servicioUsuarios.findAll();
    }
    
    public Usuario usuarioByEmail(String email) throws RepositorioException, EntidadNoEncontrada {
    	
    	return servicioUsuarios.findByEmail(email);
    }
}