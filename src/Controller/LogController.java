package Controller;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Model.Connexion;
public class LogController   {
	@FXML
	private TextField user;
	@FXML
	private TextField psw;
	@FXML
	private Button b1,b2;
	
	
	public void sign (ActionEvent e1) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/acteur.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(e1.getSource())).getScene().getWindow().hide();
		
	}
	
	@FXML
	public void login(ActionEvent e3) throws Exception {
		if(user.getText().equals("admin")&&psw.getText().equals("admin")) {
			Parent root=FXMLLoader.load(getClass().getResource("../Vue/gestion.fxml"));
			System.out.print("erreur");
			Scene scene =new Scene(root);
			Stage stage =new Stage(StageStyle.DECORATED);
			stage.setTitle("welcome");
			stage.setScene(scene);
			stage.show();
			((Node)(e3.getSource())).getScene().getWindow().hide();
			
		}else {
		 Connection cnx=Connexion.connecterDB();
		 Statement st=cnx.createStatement();
		 Statement st2=cnx.createStatement();
		 
		String req="SELECT * FROM log_client where username_client='"+user.getText()+"'and password_client='"+psw.getText()+"'";
		String req2="SELECT * FROM log_agence where username_agence='"+user.getText()+"'and password_agence='"+psw.getText()+"'";
		ResultSet res2=st2.executeQuery(req2);
		ResultSet res=st.executeQuery(req);
		
		
		if(res2.next()) {
			Parent root=FXMLLoader.load(getClass().getResource("../Vue/log_agence.fxml"));
			System.out.print("erreur");
			Scene scene =new Scene(root);
			Stage stage =new Stage(StageStyle.DECORATED);
			stage.setTitle("welcome");
			stage.setScene(scene);
			stage.show();
			((Node)(e3.getSource())).getScene().getWindow().hide();
		
		
	
		    
		}
	
		else if(res.next()) {
			System.out.println("helaaa");
		    Parent root=FXMLLoader.load(getClass().getResource("../Vue/logc.fxml"));
		    System.out.print("erreur");
		    Scene scene =new Scene(root);
		    Stage stage =new Stage(StageStyle.DECORATED);
		    stage.setTitle("welcome");
		    stage.setScene(scene);
		    stage.show();
		    ((Node)(e3.getSource())).getScene().getWindow().hide();
		
		}
		else {
			Alert alert=new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("AUTHENTIFICATION");
			alert.setHeaderText(null);
			alert.setContentText("Compte Introuvable");
			alert.showAndWait();
		}
	
		}	
	}
}

