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

public class ActeurController {
@FXML Button cl;
@FXML Button ag;
public void inscri_client(ActionEvent e1) throws Exception{
	System.out.println("helaaa");
	Parent root=FXMLLoader.load(getClass().getResource("../Vue/client.fxml"));
	System.out.print("erreur");
	Scene scene =new Scene(root);
	
	
	Stage stage =new Stage(StageStyle.DECORATED);
	stage.setTitle("welcome");
	stage.setScene(scene);
	stage.show();
	((Node)(e1.getSource())).getScene().getWindow().hide();
}
public void inscri_agence(ActionEvent e2) throws Exception{
	System.out.println("helaaa");
	Parent root=FXMLLoader.load(getClass().getResource("../Vue/agence.fxml"));
	System.out.print("erreur");
	Scene scene =new Scene(root);
	Stage stage =new Stage(StageStyle.DECORATED);
	stage.setTitle("welcome");
	stage.setScene(scene);
	stage.show();
	((Node)(e2.getSource())).getScene().getWindow().hide();
	
}





}
