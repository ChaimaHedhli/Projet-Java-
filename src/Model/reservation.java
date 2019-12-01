package Model;

public class reservation {
	private String username;
	private int code_agence;
	private int code_offre;
	private int num_passport;
	
	public reservation(String username,int code_agence, int code_offre, int num_passport) {
		this.username=username;
		this.code_agence = code_agence;
		this.code_offre = code_offre;
		this.num_passport = num_passport;
		
	}

	public int getnum_passsport() {
		return num_passport;
	}
	
	
	public void setnum_passsport(int num_passport) {
		this.num_passport=num_passport;
	}
	
	public int getCode_agence() {
		return code_agence;
	}
	public void setCode_agence(int code_agence) {
		this.code_agence = code_agence;
	}
	public int getCode_offre() {
		return code_offre;
	}
	public void setCode_offre(int code_offre) {
		this.code_offre = code_offre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
