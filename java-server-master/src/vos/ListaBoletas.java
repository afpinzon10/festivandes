package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBoletas {
	@JsonProperty(value="boletas")
	private List<Boleta> boletas;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaBoletas( @JsonProperty(value="boletas")List<Boleta> usuarios){
		this.boletas = boletas;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Boleta> getBoletas() {
		return boletas;
	}
}
