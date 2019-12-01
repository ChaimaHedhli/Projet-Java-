package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Connexion;
import Model.Offre;
import Model.agence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class GestionAgenceController {
	
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
	@FXML
	TextField c10;
	@FXML
	TextField c11;
	@FXML
	TextField c12;
	@FXML Button btn1;	
	@FXML Button btn2;	
	@FXML Button hm;	
	@FXML TextField tf;
	
	
@FXML	
public void consulter(ActionEvent evt) throws Exception {	
 
		
		
		System.out.println("consultationnnn ");
		Connection cnx=Connexion.connecterDB();
		Statement stm= cnx.createStatement();
		String req="SELECT * FROM offre";
		ResultSet res=stm.executeQuery(req);
		ObservableList<Offre> data=FXCollections.observableArrayList();
	
			while(res.next()) {
				Offre of=new Offre(res.getInt("Code_Agence"),res.getInt("Code_offre"),res.getString("Destination"),res.getString("Ville_depart"),res.getInt("heure_depart"),res.getInt("heure_arrive"),res.getString("Date_depart"),res.getString("Date_arrivee"),res.getString("Annonce"));
			    data.add(of);
			    System.out.println("data t3abet");
			}
		
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

}
@FXML

public void chercher(ActionEvent ev) throws Exception{
	
	if(!tf.getText().equals("")) {
	
		
		int code=Integer.parseInt(tf.getText().toString());
		
		Connection cnx=Connexion.connecterDB();
		Statement stm= cnx.createStatement();
		
		String req="SELECT * FROM offre where Code_agence=" + code + "";
		
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
		Statement stm2= cnx.createStatement();
		String req2="SELECT Code_agence,libellé,Localisation FROM agence where Code_agence =" + code + "";
		ResultSet res2=stm2.executeQuery(req2);
		while(res2.next()) {
			int a=res2.getInt("Code_Agence");
			c10.setText(Integer.toString(a));
			c11.setText(res2.getString("libellé"));
			c12.setText(res2.getString("Localisation"));
		    //data2.add(ag);
		}
		res2.close();

		/*for(int i=0;i<data2.size();i++) {
			   c10.setCellValueFactory(new PropertyValueFactory<>("code"));
			   c11.setCellValueFactory(new PropertyValueFactory<>("libelle"));
			   c12.setCellValueFactory(new PropertyValueFactory<>("localisation"));
			  

			   tv2.setItems(data);
		}*/
		
		}

else {
	Alert alert=new Alert(Alert.AlertType.INFORMATION);
	alert.setTitle("AUTHENTIFICATION");
	alert.setHeaderText(null);
	alert.setContentText("Saisir le code d'agence a rechercher");
	alert.showAndWait();
	
}
}
public void home(ActionEvent ev) throws Exception {
	System.out.println("helaaa");
	Parent root=FXMLLoader.load(getClass().getResource("../Vue/gestion.fxml"));
	System.out.print("erreur");
	Scene scene =new Scene(root);
	Stage stage =new Stage(StageStyle.DECORATED);
	stage.setTitle("welcome");
	stage.setScene(scene);
	stage.show();
	((Node)(ev.getSource())).getScene().getWindow().hide();
}
}

