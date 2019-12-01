package Model;
import java.sql.* ;

public class Connexion {
	public static Connection connecterDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver ok");
			String url="jdbc:mysql://localhost/client";
			String user="root";
			String password="";
			
			Connection cnx=DriverManager.getConnection(url, user, password);
			System.out.println("connexion bien etablie");
			return cnx;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*public static void main(String[] args) throws Exception{
		
		Connection cnx= connecterDB();
		Statement stm=cnx.createStatement();
		String req2="DELETE FROM clients WHERE FirstName='jalled'";
		//String req="INSERT INTO clients(id_clt,FirstName,LastName,Mobile,Address,Mail,BirthDay) VALUES(5,'hedhly','cheima','12158963','bizerte','azerty',NULL)";
		//PreparedStatement prepa=cnx.prepareStatement(req);
		//prepa.executeUpdate();
		stm.executeUpdate(req2);
		
		stm.close();
		}*/
}
