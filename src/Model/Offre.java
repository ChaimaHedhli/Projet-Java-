package Model;

public class Offre {
	private int code;
	private int id;
	private String destination;
	private String date_depart;
	private String date_arivée;
	private String ville_depart;
	private int heure_depart;
	private int heure_arrivee;
	private String annonce;
	
	
	public int getId() {
		return this.id;
	}
	public String getAnnonce() {
		return this.annonce;
	}
	public void setAnnonce(String annonce) {
		this.annonce=annonce;
	}
	public void setId(int id) {
		this.id=id;
	}
	public Offre(int code,int id,String a,String f,int c,int e,String b,String d,String r) {
		this.code=code;
		this.id=id;
		destination=a;
		date_depart=b;
		heure_depart=c;
		date_arivée=d;
		heure_arrivee=e;
		annonce=r;
		ville_depart=f;
		
		
	}
	public Offre(int a ,String b) {
		id=a;
		annonce=b;
	}
	public String getDate_depart() {
		return date_depart;
	}
	public void setDate_depart(String date_depart) {
		this.date_depart = date_depart;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate_arivée() {
		return date_arivée;
	}
	public void setDate_arivée(String date_arivée) {
		this.date_arivée = date_arivée;
	}
	public String getVille_depart() {
		return ville_depart;
	}
	public void setVille_depart(String ville_depart) {
		this.ville_depart = ville_depart;
	}
	public int getHeure_depart() {
		return heure_depart;
	}
	public void setHeure_depart(int heure_depart) {
		this.heure_depart = heure_depart;
	}
	public int getHeure_arrivee() {
		return heure_arrivee;
	}
	public void setHeure_arrivee(int heure_arrivee) {
		this.heure_arrivee = heure_arrivee;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	

}
