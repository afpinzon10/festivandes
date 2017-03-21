package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndes;
import tm.VideoAndesMaster;
import vos.ListaPreferencias;
import vos.ListaUsuarios;
import vos.ListaVideos;
import vos.Preferencia;
import vos.Usuario;
import vos.Video;

@Path("usuarios/{idUsuario}/clientes/{idCliente}")
public class PreferenciaServices {
	
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
	public Response getPreferencias(
			@javax.ws.rs.PathParam("idUsuario") String idUsuario, 
			@javax.ws.rs.PathParam("idCliente") String idCliente) {
		FestivAndes tm = new FestivAndes(getPath());
		ListaPreferencias preferencias;
		try {
			preferencias = tm.darPreferencias(idUsuario, idCliente);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(preferencias).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addVideo(Preferencia preferencia, 
			@javax.ws.rs.PathParam("idUsuario") String idUsuario, 
			@javax.ws.rs.PathParam("idCliente") String idCliente) {
		FestivAndes tm = new FestivAndes(getPath());
		try {
			tm.addPreferencia(preferencia, idUsuario, idCliente);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(preferencia).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateVideo(Preferencia preferencia, 
			@javax.ws.rs.PathParam("idUsuario") String idUsuario, 
			@javax.ws.rs.PathParam("idCliente") String idCliente) {
		FestivAndes tm = new FestivAndes(getPath());
		try {
			tm.updatePreferencia(preferencia, idUsuario, idCliente);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(preferencia).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVideo(Preferencia preferencia, 
			@javax.ws.rs.PathParam("idUsuario") String idUsuario, 
			@javax.ws.rs.PathParam("idCliente") String idCliente) {
		FestivAndes tm = new FestivAndes(getPath());
		try {
			tm.deletePreferencia(preferencia, idUsuario, idCliente);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(preferencia).build();
	}


	
}
