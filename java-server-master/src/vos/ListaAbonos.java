package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAbonos {
	@JsonProperty(value="abonos")
	private List<Abono> abonos;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaAbonos( @JsonProperty(value="abonos")List<Abono> abonos){
		this.abonos = abonos;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Abono> getAbonos() {
		return abonos;
	}
}
