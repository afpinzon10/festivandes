package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Preferencia {

	@JsonProperty(value="idcliente")
	private int idcliente;
	
	@JsonProperty(value="idcategoria")
	private int idcategoria;
	
	@JsonProperty(value="edad")
	private int edad;
	
	@JsonProperty(value="tipoespacio")
	private String tipoespacio;

	public Preferencia(@JsonProperty(value="idcliente") int idcliente, @JsonProperty(value="idcategoria") int idcategoria, @JsonProperty(value="edad") int edad, @JsonProperty(value="tipoespacio") String tipoespacio) {
		this.idcliente = idcliente;
		this.idcategoria = idcategoria;
		this.edad = edad;
		this.tipoespacio = tipoespacio;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTipoespacio() {
		return tipoespacio;
	}

	public void setTipoespacio(String tipoespacio) {
		this.tipoespacio = tipoespacio;
	}
	
	
}
