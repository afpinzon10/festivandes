package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndes;
import tm.VideoAndesMaster;
import vos.Boleta;
import vos.ListaBoletas;
import vos.RF10;
import vos.Video;

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
		
		
		@PUT
		@Path("/comprar")
		@Consumes({MediaType.APPLICATION_JSON})
		@Produces({MediaType.APPLICATION_JSON})
		public Response addBoleta(ListaBoletas boleta) {
			
			FestivAndes tm = new FestivAndes(getPath());
			try {
				for (Boleta b : boleta.getBoletas()) {
					tm.addBoleta(b);
				}
				
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(boleta).build();
		}
		
		@PUT
		@Path("/comprarBoletas")
		@Consumes({MediaType.APPLICATION_JSON})
		@Produces({MediaType.APPLICATION_JSON})
		public Response addMuchasBoletas(RF10 lasBoletas) {
			
			FestivAndes tm = new FestivAndes(getPath());
			ListaBoletas boletas;
			try {
				
					boletas = tm.addMuchasBoletas(lasBoletas);
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			
			return Response.status(200).entity(boletas).build();
		}
		
		@DELETE
		@Path("/devolverBoleta")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response devolverBoleta(Boleta boleta) {
			FestivAndes tm = new FestivAndes(getPath());
			try {
				tm.devolverBoleta(boleta);
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(boleta).build();
		}
		
}

