package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRFC11 {
	@JsonProperty(value="rfc11")
	private List<RFC11> rfc11;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaRFC11( @JsonProperty(value="rfc11")List<RFC11> rfc11){
		this.rfc11 = rfc11;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<RFC11> getRFC11() {
		return rfc11;
	}
}
