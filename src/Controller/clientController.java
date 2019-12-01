package Controller;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Statement;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Model.Connexion;

public class clientController {
	@FXML Button vd;
	@FXML Button log;
	@FXML Button hm;
	@FXML TextField f1;
	@FXML TextField f2;
	@FXML TextField f3;
	@FXML TextField f4;
	@FXML TextField f5;
	@FXML TextField f6;
	@FXML TextField f7;
	@FXML TextField f8;
	@FXML TextField f9;
	@FXML Label lb;
	
	
	/*@FXML
	public void test(KeyEvent evt) {
		char a=evt.getKeyChar();
		if(!(Character.isDigit(a) || (a==KeyEvent.VK_BACK_SPACE)|| a==KeyEvent.VK_DELETE)) {
			evt.consume();
			
		}
	}*/
	@FXML
	public void ajout_log(ActionEvent ev) throws Exception {
		Connection cnx=Connexion.connecterDB();
		Statement stm=cnx.createStatement();
		/*f3.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ev) {
				
			}
			
		});*/
		
		
		String a=f1.getText();
		String b=f2.getText();
		String c=f3.getText();
		String d=f4.getText();
		
		String e= f5.getText();
		String f=f6.getText();
	    String g=f7.getText();
	    String h=f8.getText();
	    String l=f9.getText();
	    
	    if(a.equals("")||b.equals("")||c.equals("")||d.equals("")||e.equals("")||f.equals("")||g.equals("")||h.equals("")||l.equals("")||!h.equals(l)) {

			Alert alert=new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("AUTHENTIFICATION");
			alert.setHeaderText(null);
			alert.setContentText("Veuillez verifier vos Informations");
			alert.showAndWait();
	    	
	    
		}else {
		

		Statement stm2=cnx.createStatement();

		
		String req="INSERT INTO clients(id_clt,FirstName,LastName,Mobile,Address,Mail,username,password,cin" + 
				                  ") VALUES(NULL,'"+a+"','"+b+"','"+e+"','"+d+"','"+f+"','"+g+"','"+h+"','"+c+"')";
		System.out.println("chhhhhh");
	    stm2.executeUpdate(req);
	    System.out.println("enfinnnn1");
	    
	    String req2="INSERT INTO log_client(id_log_client,username_client,password_client) VALUES(NULL,'"+g+"','"+h+"')";
	    stm.executeUpdate(req2);
	    System.out.println("enfinnnn22");
	    lb.setText("Welcome.Vous pouvez consulter nos offres => Press LOGIN");
	    System.out.println("kkkkkkkkkkkkkkkkkkkk");
	    //((Node)(ev.getSource())).getScene().getWindow().hide();
		}
	    
		
		
	}
	@FXML
	public void authentifier(ActionEvent ev) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/log.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(ev.getSource())).getScene().getWindow().hide();
	}
	@FXML
	public void home(ActionEvent ev) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/logc.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(ev.getSource())).getScene().getWindow().hide();
	}
	

}
