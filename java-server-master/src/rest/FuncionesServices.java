package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndes;
import tm.VideoAndesMaster;
import vos.Abono;
import vos.Compania;
import vos.Funcion;
import vos.ListaFunciones;
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
		
		@GET
		@Produces({ MediaType.APPLICATION_JSON })
		public Response getFunciones() {
			FestivAndes tm = new FestivAndes(getPath());
			ListaFunciones funciones;
			try {
				funciones = tm.darFunciones();
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			return Response.status(200).entity(funciones).build();
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
		
		
		@DELETE
		@Path("/cancelar")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response cancelarFuncion(int idFuncion){
			Abono ab = null;
			try {
				FestivAndes tm = new FestivAndes(getPath());
				tm.cancelarFuncion(idFuncion);
			} catch (Exception e) {
				return Response.status(500).entity(doErrorMessage(e)).build();
			}
			
			return Response.status(200).entity(ab).build();
		}
		
}
