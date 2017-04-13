
package vos;

import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC8Espacio {

	private ArrayList<RFC8Funcion> funciones;

	@JsonProperty(value="idespacio")
	private int idespacio;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	@JsonProperty(value="ubicacion")
	private String ubicacion;
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	@JsonProperty(value="ciudad")
	private String ciudad;
	
	@JsonProperty(value="telefono")
	private String telefono;
	
	@JsonProperty(value="horainicio")
	private Date horainicio;
	
	@JsonProperty(value="horafin")
	private Date horafin;
	
	@JsonProperty(value="dinerogenerado")
	private int dinerogenerado;

	public RFC8Espacio(ArrayList<RFC8Funcion> funciones, @JsonProperty(value="idespacio") int idespacio, @JsonProperty(value="nombre") String nombre, 
			@JsonProperty(value="capacidad") int capacidad, @JsonProperty(value="ubicacion") String ubicacion,
			@JsonProperty(value="tipo") String tipo, @JsonProperty(value="ciudad") String ciudad, @JsonProperty(value="telefono") String telefono, 
			@JsonProperty(value="horainicio") Date horainicio, @JsonProperty(value="horafin") Date horafin, @JsonProperty(value="dinerogenerado") int dinerogenerado) {
		super();
		this.funciones = funciones;
		this.idespacio = idespacio;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.horainicio = horainicio;
		this.horafin = horafin;
		this.dinerogenerado = dinerogenerado;
	}

	public ArrayList<RFC8Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(ArrayList<RFC8Funcion> funciones) {
		this.funciones = funciones;
	}

	public int getIdespacio() {
		return idespacio;
	}

	public void setIdespacio(int idespacio) {
		this.idespacio = idespacio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(Date horainicio) {
		this.horainicio = horainicio;
	}

	public Date getHorafin() {
		return horafin;
	}

	public void setHorafin(Date horafin) {
		this.horafin = horafin;
	}

	public int getDinerogenerado() {
		return dinerogenerado;
	}

	public void setDinerogenerado(int dinerogenerado) {
		this.dinerogenerado = dinerogenerado;
	}
}
