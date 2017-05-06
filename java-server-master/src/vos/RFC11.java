package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import com.sun.jmx.snmp.Timestamp;

public class RFC11 {

	@JsonProperty(value="nombreobra")
	private String nombreobra;
	
	@JsonProperty(value="fechafuncion")
	private Timestamp fechafuncion;
	
	@JsonProperty(value="sitiofuncion")
	private String sitiofuncion;
	
	@JsonProperty(value="cantidadboletasvendidas")
	private int cantidadboletasvendidas;
	
	@JsonProperty(value="cantidadusuariosregistrados")
	private int cantidadusuariosregistrados;
	

	public RFC11(@JsonProperty(value="nombreobra") String nombreobra, @JsonProperty(value="fechafuncion") Timestamp fechafuncion, 
			@JsonProperty(value="sitiofuncion") String sitiofuncion, @JsonProperty(value="cantidadboletasvendidas") int cantidadboletasvendidas, 
			@JsonProperty(value="cantidadusuariosregistrados") int cantidadusuariosregistrados) {
		this.nombreobra = nombreobra;
		this.fechafuncion = fechafuncion;
		this.sitiofuncion = sitiofuncion;
		this.cantidadboletasvendidas = cantidadboletasvendidas;
		this.cantidadusuariosregistrados = cantidadusuariosregistrados;
		
	}


	public String getNombreobra() {
		return nombreobra;
	}


	public void setNombreobra(String nombreobra) {
		this.nombreobra = nombreobra;
	}


	public Timestamp getFechafuncion() {
		return fechafuncion;
	}


	public void setFechafuncion(Timestamp fechafuncion) {
		this.fechafuncion = fechafuncion;
	}


	public String getSitiofuncion() {
		return sitiofuncion;
	}


	public void setSitiofuncion(String sitiofuncion) {
		this.sitiofuncion = sitiofuncion;
	}


	public int getCantidadboletasvendidas() {
		return cantidadboletasvendidas;
	}


	public void setCantidadboletasvendidas(int cantidadboletasvendidas) {
		this.cantidadboletasvendidas = cantidadboletasvendidas;
	}


	public int getCantidadusuariosregistrados() {
		return cantidadusuariosregistrados;
	}


	public void setCantidadusuariosregistrados(int cantidadusuariosregistrados) {
		this.cantidadusuariosregistrados = cantidadusuariosregistrados;
	}

	
}