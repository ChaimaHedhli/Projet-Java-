package Model;

public class Client {
	private int id;
	private String FirstName;
	private String LastName;
	private String CIN;
	private String address;
	private String Mobile;
	private String UserName;
	private String password;
	private String mail;
	
	public Client(int id,String firstName, String lastName, String cIN, String address, String mobile, String userName,
			String password,String Mail) {
		this.setId(id);
		FirstName = firstName;
		LastName = lastName;
		CIN = cIN;
		this.address = address;
		Mobile = mobile;
		UserName = userName;
		this.password = password;
		mail=Mail;
	}
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getCIN() {
		return CIN;
	}
	public String getAddress() {
		return address;
	}
	public String getMobile() {
		return Mobile;
	}
	public String getUserName() {
		return UserName;
	}
	public String getPassword() {
		return password;
	}
	public void setFirstName(String FirstName) {
		this.FirstName=FirstName;
	}
	public void setLastName(String LastName) {
		this.LastName=LastName;
	}
	public void setCIN(String CIN) {
		this.CIN=CIN;
	}
	public void setAddress(String address) {
		 this.address=address;
	}
	public void setMobile(String Mobile) {
		this.Mobile=Mobile;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setUserName(String UserName) {
		this.UserName=UserName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

}
