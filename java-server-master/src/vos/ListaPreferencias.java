package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaPreferencias {

	@JsonProperty(value="preferencias")
	private List<Preferencia> preferencias;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaPreferencias( @JsonProperty(value="preferencias")List<Preferencia> preferencias){
		this.preferencias = preferencias;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Preferencia> getPreferencias() {
		return preferencias;
	}
}
