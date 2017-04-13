
package vos;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC8 {

	@JsonProperty(value="idusuario")
	private int idusuario;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="idcompania")
	private int idcompania;

	private ArrayList<RFC8Funcion> funciones;
	
	private ArrayList<RFC8Espacio> espacios;

	public RFC8(@JsonProperty(value="idusuario") int idusuario, @JsonProperty(value="nombre") String nombre, 
			@JsonProperty(value="email") String email, @JsonProperty(value="idcompania") int idcompania, ArrayList<RFC8Funcion> funciones,
			ArrayList<RFC8Espacio> espacios) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.email = email;
		this.idcompania = idcompania;
		this.funciones = funciones;
		this.espacios = espacios;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdcompania() {
		return idcompania;
	}

	public void setIdcompania(int idcompania) {
		this.idcompania = idcompania;
	}

	public ArrayList<RFC8Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(ArrayList<RFC8Funcion> funciones) {
		this.funciones = funciones;
	}

	public ArrayList<RFC8Espacio> getEspacios() {
		return espacios;
	}

	public void setEspacios(ArrayList<RFC8Espacio> espacios) {
		this.espacios = espacios;
	}
}
