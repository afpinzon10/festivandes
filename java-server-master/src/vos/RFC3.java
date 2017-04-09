package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC3 {

	@JsonProperty(value="idfuncion")
	private int idfuncion;
	
	@JsonProperty(value="vendidas")
	private int vendidas;
	
	@JsonProperty(value="producido")
	private int producido;
	
	@JsonProperty(value="localidad")
	private String localidad;
	
	@JsonProperty(value="cliente")
	private boolean cliente;

	public RFC3(@JsonProperty(value="idfuncion") int idfuncion, @JsonProperty(value="vendidas") int vendidas, @JsonProperty(value="producido")int producido, 
			@JsonProperty(value="localidad") String localidad, @JsonProperty(value="cliente") boolean cliente) {
		this.idfuncion = idfuncion;
		this.vendidas = vendidas;
		this.producido = producido;
		this.localidad = localidad;
		this.cliente = cliente;
	}

	public int getIdfuncion() {
		return idfuncion;
	}

	public void setIdfuncion(int idfuncion) {
		this.idfuncion = idfuncion;
	}

	public int getVendidas() {
		return vendidas;
	}

	public void setVendidas(int vendidas) {
		this.vendidas = vendidas;
	}

	public int getProducido() {
		return producido;
	}

	public void setProducido(int producido) {
		this.producido = producido;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}
	
}