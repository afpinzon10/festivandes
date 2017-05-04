
package vos;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC8Obras {
	
	private ArrayList<Funcion> funciones;

	@JsonProperty(value="idobra")
	private int idobra;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="duracion")
	private int duracion;
	
	@JsonProperty(value="idioma")
	private String idioma;
	
	@JsonProperty(value="edad")
	private int edad;
	
	@JsonProperty(value="sinopsis")
	private String sinopsis;
	
	@JsonProperty(value="costo")
	private int costo;
	
	@JsonProperty(value="traduccion")
	private int traduccion;

	public RFC8Obras(ArrayList<Funcion> funciones, @JsonProperty(value="idobra") int idobra, @JsonProperty(value="nombre") String nombre, 
			@JsonProperty(value="duracion") int duracion, @JsonProperty(value="idioma") String idioma, @JsonProperty(value="edad") int edad,
			@JsonProperty(value="sinopsis") String sinopsis, @JsonProperty(value="costo") int costo, @JsonProperty(value="traduccion") int traduccion) {
		super();
		this.funciones = funciones;
		this.idobra = idobra;
		this.nombre = nombre;
		this.duracion = duracion;
		this.idioma = idioma;
		this.edad = edad;
		this.sinopsis = sinopsis;
		this.costo = costo;
		this.traduccion = traduccion;
	}

	public ArrayList<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}

	public int getIdobra() {
		return idobra;
	}

	public void setIdobra(int idobra) {
		this.idobra = idobra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(int traduccion) {
		this.traduccion = traduccion;
	}

}
