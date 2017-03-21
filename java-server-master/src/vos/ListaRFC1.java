package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRFC1 {
	@JsonProperty(value="rfc1")
	private List<RFC1> rfc1;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaRFC1( @JsonProperty(value="rfc1")List<RFC1> rfc1){
		this.rfc1 = rfc1;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<RFC1> getRFC1() {
		return rfc1;
	}
}
