package vos;

import java.sql.Timestamp;

import org.codehaus.jackson.annotate.JsonProperty;

public class RFC2 {

	@JsonProperty(value="fecha")
	private Timestamp fecha;
	
	@JsonProperty(value="localidad")
	private String localidad;
	
	@JsonProperty(value="precio")
	private int precio;
	
	@JsonProperty(value="espacio")
	private String espacio;
	
	@JsonProperty(value="ubicacion")
	private String ubicacion;
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	@JsonProperty(value="ciudad")
	private String ciudad;
	
	@JsonProperty(value="telefono")
	private String telefono;
	
	@JsonProperty(value="disponible")
	private int disponible;
	
	@JsonProperty(value="obra")
	private String obra;
	
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

	public RFC2(Timestamp fecha, String localidad, int precio, String espacio, String ubicacion, String tipo,
			String ciudad, String telefono, int disponible, String obra, int duracion, String idioma, int edad,
			String sinopsis, int costo, int traduccion) {
		this.fecha = fecha;
		this.localidad = localidad;
		this.precio = precio;
		this.espacio = espacio;
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.disponible = disponible;
		this.obra = obra;
		this.duracion = duracion;
		this.idioma = idioma;
		this.edad = edad;
		this.sinopsis = sinopsis;
		this.costo = costo;
		this.traduccion = traduccion;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
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

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public String getObra() {
		return obra;
	}

	public void setObra(String obra) {
		this.obra = obra;
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
