package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaUsuarios {
	@JsonProperty(value="usuarios")
	private List<Usuario> usuarios;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaUsuarios( @JsonProperty(value="usuarios")List<Usuario> usuarios){
		this.usuarios = usuarios;
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
}
