package Model;

public class agence {
	private String libelle;
	private String localisation;
	private String username;
	private String password;
	private int code;
	public agence(int code,String libelle, String localisation, String username, String password) {
		this.code = code;
		this.libelle = libelle;
		this.localisation = localisation;
		this.username = username;
		this.password = password;
		
	}
	public agence(int code,String libelle, String localisation){
		this.code = code;
		this.libelle = libelle;
		this.localisation = localisation;
		
		
	}
	// id houwa nafssou fel controller
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

}
