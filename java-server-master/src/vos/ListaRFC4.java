package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRFC4 {

	@JsonProperty(value="rfc4")
	private List<RFC4> rfc4;
	
	public ListaRFC4( @JsonProperty(value="rfc4")List<RFC4> rfc4){
		this.rfc4 = rfc4;
	}

	public List<RFC4> getRFC4() {
		return rfc4;
	}
	
}
