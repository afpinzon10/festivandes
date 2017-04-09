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
import vos.ListaRFC2;
import vos.ListaRFC3;
import vos.ListaRFC4;
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
			System.out.println("lol1");
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(rfc1).build();
	}
	
	@GET
	@Path("/rfc2")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getRFC2() {
		FestivAndes tm = new FestivAndes(getPath());
		ListaRFC2 rfc2;
		try {
			rfc2 = tm.darRFC2();
			System.out.println("lol2");
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(rfc2).build();
	}
	
	@GET
	@Path("/rfc3")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getRFC3() {
		FestivAndes tm = new FestivAndes(getPath());
		ListaRFC3 rfc3;
		try {
			rfc3 = tm.darRFC3();
			System.out.println("lol3");
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(rfc3).build();
	}
	
	@GET
	@Path("/rfc4")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getRFC4() {
		FestivAndes tm = new FestivAndes(getPath());
		ListaRFC4 rfc4;
		try {
			rfc4 = tm.darRFC4();
			System.out.println("lol4");
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(rfc4).build();
	}
}
