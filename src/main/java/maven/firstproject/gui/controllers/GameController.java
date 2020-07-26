package maven.firstproject.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import maven.firstproject.gui.NavigationRegistrator.Navigation;

public class GameController implements Initializable, IGenericController<StackPane> {

	@FXML
	public StackPane battlefield;
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    }

	@FXML
	public void PressedConcede(ActionEvent event) {
		Navigation.ChangeScene("Home");
	}

	@Override
	public void InitData(StackPane battlefield) {
		this.battlefield = battlefield; 
	}
}
