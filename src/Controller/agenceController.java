package Controller;

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

public class agenceController {
	@FXML Button ajt;
	@FXML Button retour;
	@FXML Button hm;
	@FXML TextField b1;
	@FXML TextField b2;
	@FXML TextField b3;
	
	@FXML TextField b4;
	@FXML TextField b5;
	@FXML TextField b6;
	@FXML Label l;
	
	public void authentifier(ActionEvent ev) throws Exception {
		Connection cnx=Connexion.connecterDB();
		Statement stm=cnx.createStatement();
		String a=b1.getText();
		String b=b2.getText();
		String c=b3.getText();
		String d=b4.getText();
		String h=b5.getText();
		
		int cd=Integer.parseInt(b6.getText().toString());
		if(!h.equals(d)) {
			Alert alert=new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("AUTHENTIFICATION");
			alert.setHeaderText(null);
			alert.setContentText("verifier vos informations");
			alert.showAndWait();
		}		
		System.out.println("helaaaa");
		String req="INSERT INTO agence(Code_agence,libellé,Localisation,UserName,Password" + 
				                  ") VALUES('"+cd+"','"+a+"','"+b+"','"+c+"','"+d+"')";
		System.out.println("chhhhhh");
	    stm.executeUpdate(req);
	    System.out.println("enfinnnn1");
	    String req2="INSERT INTO log_agence(id_log_agence,username_agence,password_agence) values(NULL,'"+c+"','"+d+"')";
	    stm.executeUpdate(req2);
	    System.out.println("enfinnnn22");
	    l.setText("Welcome .Press LOGIN");
		
	}
	
	public void log(ActionEvent e) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/log.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(e.getSource())).getScene().getWindow().hide();
		
	}
	public void home(ActionEvent ev) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/log_agence.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(ev.getSource())).getScene().getWindow().hide();
	}

}
