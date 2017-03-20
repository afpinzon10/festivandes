package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Boleta {
	
	@JsonProperty(value="idboleta")
	private int idboleta;
	
	@JsonProperty(value="idlocalidad")
	private int idlocalidad;
	
	@JsonProperty(value="fila")
	private String fila;
	
	@JsonProperty(value="silla")
	private String silla;
	
	@JsonProperty(value="idfuncion")
	private int idfuncion;
	
	@JsonProperty(value="idcliente")
	private int idcliente;

	public Boleta(@JsonProperty(value="idboleta") int idboleta, @JsonProperty(value="idlocalidad") int idlocalidad,
			@JsonProperty(value="fila") String fila, @JsonProperty(value="silla") String silla, 
			@JsonProperty(value="idfuncion") int idfuncion, @JsonProperty(value="idcliente") int idcliente) {
		this.idboleta = idboleta;
		this.idlocalidad = idlocalidad;
		this.fila = fila;
		this.silla = silla;
		this.idfuncion = idfuncion;
		this.idcliente = idcliente;
	}

	public int getIdboleta() {
		return idboleta;
	}

	public void setIdboleta(int idboleta) {
		this.idboleta = idboleta;
	}

	public int getIdlocalidad() {
		return idlocalidad;
	}

	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public String getSilla() {
		return silla;
	}

	public void setSilla(String silla) {
		this.silla = silla;
	}

	public int getIdfuncion() {
		return idfuncion;
	}

	public void setIdfuncion(int idfuncion) {
		this.idfuncion = idfuncion;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	
}