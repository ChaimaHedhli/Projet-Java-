package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import Model.Offre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Model.Connexion;

public class offresController implements Initializable {
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
	@FXML Button hm;
	@Override
	public void initialize(URL location, ResourceBundle resources)  {
		try {
			
			
			
			Connection cnx=Connexion.connecterDB();
			Statement stm= cnx.createStatement();
			String req="SELECT * FROM offre";
			ResultSet res=stm.executeQuery(req);
			ObservableList<Offre> data=FXCollections.observableArrayList();
		
				while(res.next()) {
					Offre of=new Offre(res.getInt("Code_Agence"),res.getInt("Code_offre"),res.getString("Destination"),res.getString("Ville_depart"),res.getInt("heure_depart"),res.getInt("heure_arrive"),res.getString("Date_depart"),res.getString("Date_arrivee"),res.getString("Annonce"));
				    data.add(of);
				}
			
			for(int i=0;i<data.size();i++) {
				   c1.setCellValueFactory(new PropertyValueFactory<>("destination"));
				   c2.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
				   c3.setCellValueFactory(new PropertyValueFactory<>("heure_depart"));
				   c4.setCellValueFactory(new PropertyValueFactory<>("date_arivée"));
				   c5.setCellValueFactory(new PropertyValueFactory<>("heure_arrivee"));
				   c6.setCellValueFactory(new PropertyValueFactory<>("ville_depart"));
				   c7.setCellValueFactory(new PropertyValueFactory<>("annonce"));
				   tv.setItems(data);
			}
	}catch(Exception ex) {
	System.out.println(ex);

	}

}
	public void home(ActionEvent ev) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/logc.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
	}
}
