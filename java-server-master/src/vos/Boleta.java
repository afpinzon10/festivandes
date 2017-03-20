package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Boleta {
	
	@JsonProperty(value="idboleta")
	private int idboleta;
	
	@JsonProperty(value="idlocalidad")
	private int idlocalidad;
	
	@JsonProperty(value="fila")
	private int fila;
	
	@JsonProperty(value="silla")
	private int silla;
	
	@JsonProperty(value="idfuncion")
	private int idfuncion;
	
	@JsonProperty(value="idcliente")
	private int idcliente;

	public Boleta(@JsonProperty(value="idboleta") int idboleta, @JsonProperty(value="idlocalidad") int idlocalidad,
			@JsonProperty(value="fila") int fila, @JsonProperty(value="silla") int silla, 
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

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getSilla() {
		return silla;
	}

	public void setSilla(int silla) {
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