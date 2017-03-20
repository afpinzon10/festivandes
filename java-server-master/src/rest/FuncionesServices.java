package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndes;
import vos.Compania;
import vos.Funcion;

@Path("funciones")
public class FuncionesServices {
	

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
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response registrarFuncion(Funcion f){
			try {
				FestivAndes tm = new FestivAndes(getPath());
				tm.registrarFuncion(f);
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(f).build();
		}
}
