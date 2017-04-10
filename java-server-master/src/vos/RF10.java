package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class RF10 {

	@JsonProperty(value="numBoletas")
	private int numBoletas;
	
	@JsonProperty(value="idfuncion")
	private int idfuncion;
	
	@JsonProperty(value="idlocalidad")
	private int idlocalidad;
	
	@JsonProperty(value="idcliente")
	private int idcliente;

	public RF10(@JsonProperty(value="numBoletas") int numBoletas, @JsonProperty(value="idfuncion") int idfuncion, 
			@JsonProperty(value="idlocalidad") int idlocalidad, @JsonProperty(value="idcliente") int idcliente) {
		super();
		this.numBoletas = numBoletas;
		this.idfuncion = idfuncion;
		this.idlocalidad = idlocalidad;
		this.idcliente = idcliente;
	}

	public int getnumBoletas() {
		return numBoletas;
	}

	public void setnumBoletas(int numBoletas) {
		this.numBoletas = numBoletas;
	}

	public int getIdfuncion() {
		return idfuncion;
	}

	public void setIdfuncion(int idfuncion) {
		this.idfuncion = idfuncion;
	}

	public int getIdlocalidad() {
		return idlocalidad;
	}

	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

}
