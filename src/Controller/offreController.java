package Controller;

import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Model.Connexion;

public class offreController   {
	@FXML Button tbl;

	@FXML TextField t1;
	@FXML TextField t2;
	@FXML TextField t3;
	@FXML TextField t4;
	@FXML TextField t5;
	@FXML TextField t6;
	@FXML TextField t7;
	@FXML TextField t8;
	@FXML TextArea t9;
	@FXML Label lab;
	@FXML Button hm;
	
	
	
	
	
	public void remplir_table(ActionEvent ev) throws Exception{
		Connection cnx=Connexion.connecterDB();
		Statement stm=cnx.createStatement();
		int a=Integer.parseInt( t1.getText());
		int b=Integer.parseInt(t2.getText());
		
		String c=t3.getText();
		String d=t4.getText();
		int e=Integer.parseInt( t5.getText());
		int f=Integer.parseInt(t6.getText());
		String g= t7.getText();
		String h=t8.getText();
	    String i=t9.getText();
				
		System.out.println("helaaaa");
		String req="INSERT INTO offre(Code_Agence,Code_offre,Destination,Ville_depart,heure_depart,heure_arrive,Date_depart,Date_arrivee,Annonce) VALUES('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"')";
		System.out.println("chhhhhh");
	    stm.executeUpdate(req);
	    System.out.println("enfinnnn");
		lab.setText("OFFRE AJOUTEE AVEC SUCCES ");
		
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
	}
	
}
	