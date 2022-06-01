package Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Gettoken {
	
	@JsonProperty("id_token")
     private  String id_token;
	
	@JsonProperty("access_token")
	private  String access_token;
	
	@JsonProperty("session")
	private  String session;
	




	public Gettoken() {

		id_token = "";
		access_token = "";
		session = "";
	}
	
	


	public Gettoken(String id_token, String access_token, String session) {
		super();
		
		this.id_token = "id_token";
		this.access_token = "access_token";
		this.session = "session";
	}

	


	@JsonProperty("id_token")
	public String getId_token() {
		return id_token;
	}

	@JsonProperty("id_token")
	public void setId_token(String id_token) {
		this.id_token = id_token;
	}

	@JsonProperty("access_token")
	public String getAccess_token() {
		return access_token;
	}

	@JsonProperty("access_token")
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	@JsonProperty("session")
	public String getSession() {
		return session;
	}
	
	@JsonProperty("session")
	public void setSession(String session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "Gettoken [id_token=" + id_token + ", access_token=" + access_token + ", session=" + session + "]";
	}
	
	
}
