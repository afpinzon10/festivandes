package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndes;
import vos.ListaBoletas;

@Path("boletas")
public class BoletaServices {
	

		@Context
		private ServletContext context;
		
		private String getPath() {
			return context.getRealPath("WEB-INF/ConnectionData");
		}
		
		
		private String doErrorMessage(Exception e){
			return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
		}
		

		@GET
		@Produces({ MediaType.APPLICATION_JSON })
		public Response getUsuarios() {
			FestivAndes tm = new FestivAndes(getPath());
			ListaBoletas boletas;
			try {
				boletas = tm.darBoletas();
				System.out.println("lol");
				
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(boletas).build();
		}
}

