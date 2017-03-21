package rest;

import javax.servlet.ServletContext;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndes;
import vos.ListaRFC1;
import vos.ListaUsuarios;

@Path("")
@Produces({ MediaType.APPLICATION_JSON })
public class ConsultasServices {
	@Context
	private ServletContext context;
		
	private String getPath()
	{
		return context.getRealPath("WEB-INF/ConnectionData");
	}
		
		
	private String doErrorMessage(Exception e)
	{
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	@GET
	@Path("/rfc1")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getRFC1() {
		FestivAndes tm = new FestivAndes(getPath());
		ListaRFC1 rfc1;
		try {
			rfc1 = tm.darRFC1();
			System.out.println("lol");
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(rfc1).build();
	}
}
