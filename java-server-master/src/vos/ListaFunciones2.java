package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFunciones2 {
	@JsonProperty(value="realizadas")
	private List<Funcion> realizadas;
	
	@JsonProperty(value="porasistir")
	private List<Funcion> porasistir;
	
	@JsonProperty(value="devueltas")
	private List<Funcion> devueltas;

	public ListaFunciones2(@JsonProperty(value="realizadas") List<Funcion> realizadas, @JsonProperty(value="porasistir") List<Funcion> porasistir, @JsonProperty(value="devueltas") List<Funcion> devueltas) {
		super();
		this.realizadas = realizadas;
		this.porasistir = porasistir;
		this.devueltas = devueltas;
	}

	public List<Funcion> getRealizadas() {
		return realizadas;
	}

	public void setRealizadas(List<Funcion> realizadas) {
		this.realizadas = realizadas;
	}

	public List<Funcion> getPorasistir() {
		return porasistir;
	}

	public void setPorasistir(List<Funcion> porasistir) {
		this.porasistir = porasistir;
	}

	public List<Funcion> getDevueltas() {
		return devueltas;
	}

	public void setDevueltas(List<Funcion> devueltas) {
		this.devueltas = devueltas;
	}
	
	
}
