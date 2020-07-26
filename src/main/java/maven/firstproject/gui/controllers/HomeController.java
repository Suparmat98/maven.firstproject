package maven.firstproject.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import maven.firstproject.gui.NavigationRegistrator.Navigation;

public class HomeController implements Initializable, IGenericController<String> {

	@Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    }

	@FXML
	public void PressedPlay(ActionEvent event) {
		Navigation.ChangeScene(GameController.class, "Game", null);
	}

	@FXML
	public void PressedExit(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML
	public void PressedEditDecks(ActionEvent event) {
		Navigation.ChangeScene("EditDeck");
	}

	@Override
	public void InitData(String data) { 
	}
}
