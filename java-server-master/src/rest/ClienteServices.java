package rest;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.FestivAndes;
import vos.Abono;
import vos.Cliente;
import vos.ListaAbonos;
import vos.ListaFunciones;
import vos.ListaFunciones2;

@Path("")
@Produces({ MediaType.APPLICATION_JSON })
public class ClienteServices
{
		
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
	@Path("usuarios/{idUsuario}/clientes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response darClientesUsuario(@PathParam("idUsuario") String id)
	{
		System.out.println("prueba");
		FestivAndes tm = new FestivAndes(getPath());
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try
		{
			//clientes = tm.darClientesUsuario(id);
		}
		catch(Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(clientes).build();
	}
	
	
	@GET
	@Path("clientes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response darClientes()
	{
		FestivAndes tm = new FestivAndes(getPath());
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try
		{
			//clientes = tm.darClientes();
		}
		catch(Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(clientes).build();
	}
	
	
	@POST
	@Path("usuarios/{idUsuario}/clientes")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarCliente(Cliente c){
		try {
			FestivAndes tm = new FestivAndes(getPath());
			tm.registrarCliente(c);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(c).build();
	}
	
	@GET
	@Path("usuarios/{idusuario}/clientes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response darAbonos(@PathParam("idUsuario") int usuario){
		FestivAndes tm = new FestivAndes(getPath());
		ListaAbonos abonos;
		try
		{
			abonos = tm.darAbonos();
		}
		catch(Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(abonos).build();
	}

	@POST
	@Path("usuarios/{idusuario}/clientes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarAbono(@PathParam("idUsuario") int usuario, Abono b){
		Abono ab = null;
		try {
			FestivAndes tm = new FestivAndes(getPath());
			ab = new Abono(b.getIdabono(), b.getIdfuncion(), b.getIdlocalidad(), usuario, b.getPrecio());
			tm.registrarAbono(ab);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		
		return Response.status(200).entity(ab).build();
	}
	
	@DELETE
	@Path("usuarios/{idusuario}/clientes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response devolverAbono(@PathParam("idUsuario") int usuario, Abono b){
		Abono ab = null;
		try {
			FestivAndes tm = new FestivAndes(getPath());
			ab = new Abono(b.getIdabono(), b.getIdfuncion(), b.getIdlocalidad(), usuario, b.getPrecio());
			tm.devolverAbono(ab);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		
		return Response.status(200).entity(ab).build();
	}
	
	@GET
	@Path("clientes/{idcliente}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response RFC7(@PathParam("idcliente") int idcliente){
		FestivAndes tm = new FestivAndes(getPath());
		ListaFunciones2 funciones;
		try
		{
			funciones = tm.darRFC7(idcliente);
		}
		catch(Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(abonos).build();
	}

	
}
	
