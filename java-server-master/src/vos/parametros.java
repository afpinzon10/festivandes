package vos;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class parametros {

	
	private ArrayList<Preferencia> preferencias;
	
	@JsonProperty(value="fecha1")
	private int fecha1;
	
	@JsonProperty(value="fecha2")
	private String fecha2;
	
	@JsonProperty(value="apellido")
	private String apellido;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="identificacion")
	private String identificacion;

	public parametros(ArrayList<Preferencia> preferencias, @JsonProperty(value="idusuario") int idusuario, 
			@JsonProperty(value="nombre") String nombre, @JsonProperty(value="apellido") String apellido, 
			@JsonProperty(value="email") String email, @JsonProperty(value="identificacion")String identificacion) {
		this.preferencias = preferencias;
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.identificacion = identificacion;
	}
	

	public parametros( @JsonProperty(value="idusuario") int idusuario, 
			@JsonProperty(value="nombre") String nombre, @JsonProperty(value="apellido") String apellido, 
			@JsonProperty(value="email") String email, @JsonProperty(value="identificacion")String identificacion) {
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.identificacion = identificacion;
	}

	public ArrayList<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(ArrayList<Preferencia> preferencias) {
		this.preferencias = preferencias;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	

}
