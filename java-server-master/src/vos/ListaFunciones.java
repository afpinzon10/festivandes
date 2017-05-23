package vos;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFunciones {
	@JsonProperty(value="funciones")
	private List<Funcion> funciones;
	
	/**
	 * Constructor de la clase ListaVideos
	 * @param videos - videos para agregar al arreglo de la clase
	 */
	public ListaFunciones( @JsonProperty(value="funciones")List<Funcion> funciones){
		this.funciones = funciones;
	}

	public ListaFunciones() {
		funciones = new ArrayList<Funcion>();
	}

	/**
	 * Método que retorna la lista de videos
	 * @return  List - List con los videos
	 */
	public List<Funcion> getFunciones() {
		return funciones;
	}
	
	public void addFunciones(ListaFunciones funcionesNew){
		this.funciones.addAll(funcionesNew.getFunciones());
	}
}
