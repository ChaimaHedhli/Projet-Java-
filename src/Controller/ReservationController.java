package Controller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Model.Connexion;

public class ReservationController implements Initializable{
	@FXML Button hm;
	@FXML Button vd;
	@FXML Button fich;
	@FXML TextField a1;
	@FXML TextField a2;
	@FXML TextField a3;
	@FXML TextField a4;
	@FXML ListView <String> liste;
	
	
	@FXML
	public void reserver(ActionEvent e) throws Exception {
		Connection cnx= Connexion.connecterDB();
		Statement stm=cnx.createStatement();
		String a=a1.getText();
		//int aa=Integer.toString(a);
		String b=a2.getText();
		//int bb=Integer.toString(b)
		String c=a3.getText();
		String d=a4.getText();
		String req="INSERT INTO reservatio(username,Code_offre,code_agence,num_passport" + 
				") values('"+a+"','"+b+"','"+c+"','"+d+"')";
	    stm.executeUpdate(req);
	    stm.close();
	    ((Node)(e.getSource())).getScene().getWindow().hide();
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
	@FXML 
	public void fichier(ActionEvent evnt) throws Exception {
		System.out.println("d5alttt ");
		FileWriter f=new FileWriter("reservationnn.txt");
		BufferedWriter out=new BufferedWriter(f);
		java.awt.Desktop.getDesktop().open(new File("reservationnn.txt"));
		
		

out.write("Code de réservation est :"+a1.getText()+" Le Numéro de passerport est :"+a2.getText()+" Type payement :"+liste.getSelectionModel().getSelectedItem());
		out.close();
		System.out.println("fichier cree");
		PrintWriter x=new PrintWriter(f);
		//Button btn=new Button("Ouvrir dans un fichier! ");//Tzid listeView bb b scene builder
		
    

		// pour l'affichage
		/*public void lectureFichier(){
		String Ligne;

		try {
		BufferedReader entree = new BufferedReader(f);
		do {
		           ligne= entree.readLine();
		           if(ligne!=null) System.out.println(ligne);
		        } while(ligne!=null);
		        }
		        catch(IOException e){e.printStackTrace();}
		    }}*/

		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		liste.getItems().addAll("especes","carte bancaire");
		
	}

}
