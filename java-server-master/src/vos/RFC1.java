package vos;

import java.sql.Timestamp;

import org.codehaus.jackson.annotate.JsonProperty;



public class RFC1 {
	@JsonProperty(value="idcompania")
	private int idcompania;
	
	@JsonProperty(value="idobra")
	private int idobra;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="idusuario")
	private int idusuario;
	
	@JsonProperty(value="nombreobra")
	private String nombreobra;
	
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
	
	@JsonProperty(value="fecha")
	private Timestamp fecha;
	
	@JsonProperty(value="idespacio")
	private int idespacio;
	
	@JsonProperty(value="idfuncion")
	private int idfuncion;
	
	@JsonProperty(value="descripcion")
	private String descripcion;

	
	
	public RFC1(@JsonProperty(value="idcompania")
	 int idcompania,
	
	@JsonProperty(value="idobra")
	 int idobra,
	
	@JsonProperty(value="nombre")
	 String password,
	
	@JsonProperty(value="email")
	 String email,
	
	@JsonProperty(value="idusuario")
	 int idusuario,
	
	@JsonProperty(value="nombreobra")
	 String nombreobra,
	
	@JsonProperty(value="duracion")
	 int duracion,
	
	@JsonProperty(value="idioma")
	 String idioma,

	@JsonProperty(value="edad")
	 int edad,
	
	@JsonProperty(value="sinopsis")
	 String sinopsis,
	
	@JsonProperty(value="costo")
	 int costo,
	
	@JsonProperty(value="traduccion")
	 int traduccion,
	
	@JsonProperty(value="fecha")
	 Timestamp fecha,
	
	@JsonProperty(value="idespacio")
	 int idespacio,
	
	@JsonProperty(value="idfuncion")
	 int idfuncion,
	
	@JsonProperty(value="descripcion")
	 String descripcion) {
		super();
		this.idcompania = idcompania;
		this.idobra = idobra;
		this.nombre = password;
		this.email = email;
		this.idusuario = idusuario;
		this.nombreobra = nombreobra;
		this.duracion = duracion;
		this.idioma = idioma;
		this.edad = edad;
		this.sinopsis = sinopsis;
		this.costo = costo;
		this.traduccion = traduccion;
		this.fecha = fecha;
		this.idespacio = idespacio;
		this.idfuncion = idfuncion;
		this.descripcion = descripcion;
	}



	public int getIdcompania() {
		return idcompania;
	}



	public void setIdcompania(int idcompania) {
		this.idcompania = idcompania;
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



	public void setNombre(String password) {
		this.nombre = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getIdusuario() {
		return idusuario;
	}



	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}



	public String getNombreobra() {
		return nombreobra;
	}



	public void setNombreobra(String nombreobra) {
		this.nombreobra = nombreobra;
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



	public int getIdcategoria() {
		return idfuncion;
	}



	public void setIdcategoria(int idcategoria) {
		this.idfuncion = idcategoria;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
