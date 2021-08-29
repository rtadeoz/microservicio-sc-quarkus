package aforo255.security.jwt;

import java.util.HashMap;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import aforo255.security.jwt.model.Security;
import aforo255.security.jwt.service.TokenService;

@Path("/profile")
public class ProfileResource {

	@Inject
	TokenService service ;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		
		return "Mi nombres es Stywar  Vargas chino ";
	}
	
	@Path("/security")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public HashMap<String, String> getToken(Security security )
	{
		// Vaidar de BD que el usuario exista 
		String email="ObtenerBD";		
		final String token = service.generateToken(security.getUsername(), email);
		
		return new HashMap<String, String>() {{
			put ("access_token",token);
			
		}};
		
		
	}
	
	

	
}
