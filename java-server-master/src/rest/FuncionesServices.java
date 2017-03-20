package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndes;
import tm.VideoAndesMaster;
import vos.Compania;
import vos.Funcion;
import vos.ListaVideos;
import vos.Video;

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
		
	
		
		@PUT
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
		
		
		//RF9

		@POST
		@Path("/realizado")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response realizarFuncion(Funcion func) {
			FestivAndes tm = new FestivAndes(getPath());
			try {
				tm.realizarFuncion(func);
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(func).build();
		}
		
}
