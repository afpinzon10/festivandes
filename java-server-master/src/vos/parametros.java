package vos;


import org.codehaus.jackson.annotate.JsonProperty;

public class Parametros {

	
	
	@JsonProperty(value="fecha1")
	private String fecha1;
	
	@JsonProperty(value="fecha2")
	private String fecha2;
	
	@JsonProperty(value="idcompania")
	private int idcompania;
	
	@JsonProperty(value="orderby")
	private String orderby;
	
	@JsonProperty(value="descripcion")
	private String descripcion;

	@JsonProperty(value="nombreLocalidad")
	private String nombreLocalidad;
	
	@JsonProperty(value="hora1")
	private String hora1;
	
	@JsonProperty(value="hora2")
	private String hora2;
	

	@JsonProperty(value="day")
	private String day;
	
	@JsonProperty(value="conteo")
	private String conteo;

	public Parametros(@JsonProperty(value="fecha1") String fecha1, @JsonProperty(value="fecha2") String fecha2, @JsonProperty(value="idcompania") int idcompania,
			@JsonProperty(value="orderby") String orderby, @JsonProperty(value="descripcion") String descripcion,
			@JsonProperty(value="nombreLocalidad") String nombreLocalidad, @JsonProperty(value="hora1")String hora1,
			@JsonProperty(value="hora2") String hora2, @JsonProperty(value="day") String day, 
			@JsonProperty(value="conteo") String conteo) {
		super();
		this.fecha1 = fecha1;
		this.fecha2 = fecha2;
		this.idcompania = idcompania;
		this.orderby = orderby;
		this.descripcion = descripcion;
		this.nombreLocalidad = nombreLocalidad;
		this.hora1 = hora1;
		this.hora2 = hora2;
		this.day = day;
		this.conteo = conteo;
	}

	
	public Parametros(@JsonProperty(value="fecha1") String fecha1, @JsonProperty(value="fecha2") String fecha2, @JsonProperty(value="idcompania") int idcompania,
			@JsonProperty(value="orderby") String orderby) {
		super();
		this.fecha1 = fecha1;
		this.fecha2 = fecha2;
		this.idcompania = idcompania;
		this.orderby = orderby;
		
	}
	
	public Parametros(@JsonProperty(value="fecha1") String fecha1, @JsonProperty(value="fecha2") String fecha2, 
			 @JsonProperty(value="descripcion") String descripcion,
			@JsonProperty(value="nombreLocalidad") String nombreLocalidad, @JsonProperty(value="hora1")String hora1,
			@JsonProperty(value="hora2") String hora2, @JsonProperty(value="day") String day) {
		super();
		this.fecha1 = fecha1;
		this.fecha2 = fecha2;
		this.descripcion = descripcion;
		this.nombreLocalidad = nombreLocalidad;
		this.hora1 = hora1;
		this.hora2 = hora2;
		this.day = day;
	}



	
	public Parametros(@JsonProperty(value="conteo") String conteo) {
		super();
		
		this.conteo = conteo;
	}


	public String getFecha1() {
		return fecha1;
	}


	public void setFecha1(String fecha1) {
		this.fecha1 = fecha1;
	}


	public String getFecha2() {
		return fecha2;
	}


	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}


	public int getIdcompania() {
		return idcompania;
	}


	public void setIdcompania(int idcompania) {
		this.idcompania = idcompania;
	}


	public String getOrderby() {
		return orderby;
	}


	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombreLocalidad() {
		return nombreLocalidad;
	}


	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}


	public String getHora1() {
		return hora1;
	}


	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}


	public String getHora2() {
		return hora2;
	}


	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getConteo() {
		return conteo;
	}


	public void setConteo(String conteo) {
		this.conteo = conteo;
	}

	

}
