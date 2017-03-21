package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaRFC2 {
	@JsonProperty(value="rfc2")
	private List<RFC2> rfc2;
	
	public ListaRFC2( @JsonProperty(value="rfc2")List<RFC2> rfc2){
		this.rfc2 = rfc2;
	}

	public List<RFC2> getRFC2() {
		return rfc2;
	}
}
