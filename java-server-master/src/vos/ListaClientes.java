package vos;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaClientes {
	@JsonProperty(value="clientes")
	private List<Cliente> clientes;
	
	public ListaClientes(@JsonProperty(value="clientes")List<Cliente> clientes) {
		// TODO Auto-generated constructor stub
		this.clientes = clientes;
	}

}
