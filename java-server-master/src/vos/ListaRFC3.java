package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRFC3 {
	
	@JsonProperty(value="rfc3")
	private List<RFC3> rfc3;
	
	public ListaRFC3( @JsonProperty(value="rfc3")List<RFC3> rfc3){
		this.rfc3 = rfc3;
	}

	public List<RFC3> getRFC3() {
		return rfc3;
	}
	
}
