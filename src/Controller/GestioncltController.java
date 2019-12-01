package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.Connexion;
import Model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GestioncltController {
	@FXML
	TextField cherch;
	@FXML
	TableView <Client> tc;
	@FXML
	TableColumn <Client,Integer> c1;
	@FXML
	TableColumn <Client,String> c2;
	@FXML
	TableColumn <Client,String> c3;
	@FXML
	TableColumn <Client,String> c4;
	@FXML
	TableColumn <Client,String> c5;
	@FXML
	TableColumn <Client,String> c6;
	@FXML
	TableColumn <Client,String> c7;
	@FXML
	TableColumn <Client,String> c8;

	@FXML
	TableColumn <Client,String> c9;
	
	@FXML Button hm;
	@FXML Button loop;
	public void consult(ActionEvent a)  {
		try {
		
		
			
				Connection cnx=Connexion.connecterDB();
				Statement stm= cnx.createStatement();
				String req="SELECT * FROM clients";
				ResultSet res=stm.executeQuery(req);
				ObservableList<Client> data=FXCollections.observableArrayList();
			
					while(res.next()) {
						Client of=new Client(res.getInt("id_clt"),res.getString("FirstName"),res.getString("LastName"),res.getString("cin"),res.getString("Address"),res.getString("Mobile"),res.getString("username"),res.getString("password"),res.getString("Mail"));
					    data.add(of);
					}
				
				for(int i=0;i<data.size();i++) {
					   c1.setCellValueFactory(new PropertyValueFactory<>("id"));
					   c2.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
					   c3.setCellValueFactory(new PropertyValueFactory<>("LastName"));
					   c4.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
					   c5.setCellValueFactory(new PropertyValueFactory<>("address"));
					   c6.setCellValueFactory(new PropertyValueFactory<>("mail"));
					   c7.setCellValueFactory(new PropertyValueFactory<>("UserName"));
					   c8.setCellValueFactory(new PropertyValueFactory<>("CIN"));
					  
					  
					
					   c9.setCellValueFactory(new PropertyValueFactory<>("password"));

					

					   tc.setItems(data);
				}
	}catch(Exception ex) {
		
		
		System.out.println(ex);
		
	}
}

	public void chercher(ActionEvent evt) throws Exception{
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/cherch.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();

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
