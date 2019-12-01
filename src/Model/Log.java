package Model;

public class Log {
	private String UserName;
	private String Password;
	public Log(String x1,String x2) {
		this.UserName=x1;
		this.Password=x2;
	}
	public String getUserName() {
		return UserName;
	}
	public String getPassword() {
		return Password;
	}
	public void setUserName(String UserName) {
		this.UserName=UserName;
	}
	public void setPassword(String Password ) {
		 this.Password=Password;
	}
	

}
