package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class gestionController {
	@FXML Button clt;
	@FXML Button ag;
	@FXML
	public void clients(ActionEvent ev) throws  Exception{
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/gestionclt.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(ev.getSource())).getScene().getWindow().hide();
		

	}
	@FXML
	public void agences(ActionEvent e3) throws Exception {
		System.out.println("helaaa");
		Parent root=FXMLLoader.load(getClass().getResource("../Vue/gestionag.fxml"));
		System.out.print("erreur");
		Scene scene =new Scene(root);
		Stage stage =new Stage(StageStyle.DECORATED);
		stage.setTitle("welcome");
		stage.setScene(scene);
		stage.show();
		((Node)(e3.getSource())).getScene().getWindow().hide();
	}

}
