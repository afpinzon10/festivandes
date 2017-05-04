
package vos;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC8Funcion {

	@JsonProperty(value="idfuncion")
	private int idfuncion;
	
	@JsonProperty(value="fecha")
	private Timestamp fecha;
	
	@JsonProperty(value="idespacio")
	private int idespacio;
	
	@JsonProperty(value="idobra")
	private int idobra;
	
	@JsonProperty(value="realizado")
	private int realizado;

	public RFC8Funcion(@JsonProperty(value="idfuncion") int idfuncion, @JsonProperty(value="fecha") Timestamp fecha, @JsonProperty(value="idespacio") int idespacio, 
			@JsonProperty(value="idobra") int idobra, @JsonProperty(value="realizado") int realizado) {
		super();
		this.idfuncion = idfuncion;
		this.fecha = fecha;
		this.idespacio = idespacio;
		this.idobra = idobra;
		this.realizado = realizado;
	}

	public int getIdfuncion() {
		return idfuncion;
	}

	public void setIdfuncion(int idfuncion) {
		this.idfuncion = idfuncion;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getIdespacio() {
		return idespacio;
	}

	public void setIdespacio(int idespacio) {
		this.idespacio = idespacio;
	}

	public int getIdobra() {
		return idobra;
	}

	public void setIdobra(int idobra) {
		this.idobra = idobra;
	}

	public int getRealizado() {
		return realizado;
	}

	public void setRealizado(int realizado) {
		this.realizado = realizado;
	}
}
