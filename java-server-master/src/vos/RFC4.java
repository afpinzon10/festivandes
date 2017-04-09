package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC4 {

	@JsonProperty(value="vendidas")
	private int vendidas;
	
	@JsonProperty(value="producido")
	private int producido;
	
	@JsonProperty(value="idfuncion")
	private int idfuncion;
	
	@JsonProperty(value="sitio")
	private String sitio;
	
	@JsonProperty(value="cliente")
	private boolean cliente;
	
	@JsonProperty(value="porcentaje")
	private double porcentaje;

	public RFC4(@JsonProperty(value="vendidas") int vendidas, @JsonProperty(value="producido") int producido, 
			@JsonProperty(value="idfuncion") int idfuncion, @JsonProperty(value="sitio") String sitio, 
			@JsonProperty(value="cliente") boolean cliente, @JsonProperty(value="porcentaje") double porcentaje) {
		this.vendidas = vendidas;
		this.producido = producido;
		this.idfuncion = idfuncion;
		this.sitio = sitio;
		this.cliente = cliente;
		this.porcentaje = porcentaje;
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

	public int getIdfuncion() {
		return idfuncion;
	}

	public void setIdfuncion(int idfuncion) {
		this.idfuncion = idfuncion;
	}

	public String getSitio() {
		return sitio;
	}

	public void setSitio(String sitio) {
		this.sitio = sitio;
	}

	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	
}
