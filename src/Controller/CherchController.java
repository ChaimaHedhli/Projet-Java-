package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import Model.Connexion;
import Model.Offre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CherchController implements Initializable{
	@FXML
	TableView <Offre> tv;

	@FXML
	TableColumn <Offre,String> c1;
	@FXML
	TableColumn <Offre,String> c2;
	@FXML
	TableColumn <Offre,Integer> c3;
	@FXML
	TableColumn <Offre,String> c4;
	@FXML
	TableColumn <Offre,Integer> c5;
	@FXML
	TableColumn <Offre,String> c6;
	@FXML
	TableColumn <Offre,String> c7;
	@FXML
	TableColumn <Offre,String> c8;
	@FXML
	TableColumn <Offre,String> c9;
	
	@FXML TextField  tf;		
	@FXML Button ret;	
	

	@Override
	public void initialize(URL location, ResourceBundle resources){
		
		
		   // ((Node)(e.getSource())).getScene().getWindow().hide();
			
			//int code=Integer.parseInt(tf.getText().toString());
		   tf.setText("hela");
			try {
			Connection cnx=Connexion.connecterDB();
			Statement stm= cnx.createStatement();
			
			String req="SELECT * FROM offres where Code_offre in(select Code_offre from reservation where username = 'hela')";

			
			ResultSet res=stm.executeQuery(req);
			
			
			
			ObservableList<Offre> data=FXCollections.observableArrayList();
			//ObservableList<agence> data2=FXCollections.observableArrayList();
		
				while(res.next()) {
					Offre of=new Offre(res.getInt("Code_Agence"),res.getInt("Code_offre"),res.getString("Destination"),res.getString("Ville_depart"),res.getInt("heure_depart"),res.getInt("heure_arrive"),res.getString("Date_depart"),res.getString("Date_arrivee"),res.getString("Annonce"));
				    data.add(of);
				}
				res.close();
			
			
			for(int i=0;i<data.size();i++) {
				   c1.setCellValueFactory(new PropertyValueFactory<>("code"));
				   c2.setCellValueFactory(new PropertyValueFactory<>("id"));
				   c3.setCellValueFactory(new PropertyValueFactory<>("Destination"));
				   c4.setCellValueFactory(new PropertyValueFactory<>("Ville_depart"));
				   c5.setCellValueFactory(new PropertyValueFactory<>("heure_depart"));
				   c6.setCellValueFactory(new PropertyValueFactory<>("heure_arrivee"));
				   c7.setCellValueFactory(new PropertyValueFactory<>("Date_depart"));
				   c8.setCellValueFactory(new PropertyValueFactory<>("date_arivée"));
				   c9.setCellValueFactory(new PropertyValueFactory<>("Annonce"));

				   tv.setItems(data);
			}
			
		
		
	}catch(Exception exp) {
		exp.printStackTrace();
	}
		
	}
	public void retour(ActionEvent ev) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/gestionclt.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(ev.getSource())).getScene().getWindow().hide();
	}



	
	 

		
	
	
}
