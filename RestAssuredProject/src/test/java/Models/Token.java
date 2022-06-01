package Models;

import com.google.gson.*;
import com.google.gson.annotations.Expose;

public class Token {
	
	//@Expose(serialize=true, deserialize=false)
	private String email;
	
	//@Expose(serialize=true, deserialize=false)
	private String password;
	
	/*@Expose(serialize=false, deserialize=true)
	private  String id_token;
	
	@Expose(serialize=false, deserialize=true)
	private transient String access_token;
	
	@Expose(serialize=false, deserialize=true)
	private transient String session;*/
	
	//, String id_token, String access_token, String session
	public Token(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		/*this.id_token = id_token;
		this.access_token = access_token;
		this.session = session;*/
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public String getId_token() {
		return id_token;
	}
	public void setId_token(String id_token) {
		this.id_token = id_token;
	}
	public String getAccess_token() {
		return access_token;*/
/*	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;*/
	//}
	
	@Override
	public String toString() {
		return "Token [email=" + email + ", password=" + password + "]";
	}

	
	
	
}
	