package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Abono {

	@JsonProperty(value="idabono")
	private int idabono;
	
	@JsonProperty(value="idfuncion")
	private int idfuncion;
	
	@JsonProperty(value="idlocalidad")
	private int idlocalidad;
	
	@JsonProperty(value="idcliente")
	private int idcliente;
	
	@JsonProperty(value="precio")
	private int precio;

	public Abono(@JsonProperty(value="idabono") int idabono, @JsonProperty(value="idfuncion") int idfuncion, 
			@JsonProperty(value="idlocalidad") int idlocalidad, @JsonProperty(value="idcliente") int idcliente, 
			@JsonProperty(value="precio") int precio) {
		super();
		this.idabono = idabono;
		this.idfuncion = idfuncion;
		this.idlocalidad = idlocalidad;
		this.idcliente = idcliente;
		this.precio = precio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getIdabono() {
		return idabono;
	}

	public void setIdabono(int idabono) {
		this.idabono = idabono;
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
