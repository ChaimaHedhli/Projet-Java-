package Controller;

import Model.Offre;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Model.Connexion;

public class logcControlller {
	@FXML
	Button btn1,btn2,btn3,btn4;

	
	

	
	
	public void profil (ActionEvent e ) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/client.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(e.getSource())).getScene().getWindow().hide();
	}
	public void avion(ActionEvent ev) throws  Exception{
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/offres.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		

	}
	
	public void reserver(ActionEvent e3) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/reservation.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(e3.getSource())).getScene().getWindow().hide();
	}
	public void ticket(ActionEvent e4) {
		
	}
	

}
