package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRF11 {
	@JsonProperty(value="rf11")
	private List<RF11> rf11;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaRF11( @JsonProperty(value="rf11")List<RF11> rf11){
		this.rf11 = rf11;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<RF11> getRF11() {
		return rf11;
	}
}
