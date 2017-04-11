package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class NotaDebito {
	

	
	@JsonProperty(value="valordevolucion")
	private int valordevolucion;
	
	@JsonProperty(value="idcliente")
	private int idcliente;

	public NotaDebito( 
			@JsonProperty(value="valordevolucion") int valordevolucion, @JsonProperty(value="idcliente") int idcliente) {
		this.valordevolucion = valordevolucion;
		this.idcliente = idcliente;
	}

	public int getValordevolucion() {
		return valordevolucion;
	}

	public void setValordevolucion(int valordevolucion) {
		this.valordevolucion = valordevolucion;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	}