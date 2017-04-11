package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaNotaDebito {
	@JsonProperty(value="notadebito")
	private List<NotaDebito> notadebito;

	public ListaNotaDebito(@JsonProperty(value="notadebito") List<NotaDebito> notadebito) {
		super();
		this.notadebito = notadebito;
	}

	public List<NotaDebito> getNotadebito() {
		return notadebito;
	}
	

}
