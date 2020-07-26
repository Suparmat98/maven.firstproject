package maven.firstproject.gui.controllers;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import maven.firstproject.gui.NavigationRegistrator.Navigation;

public class GenericController implements Initializable, IGenericController<String> {
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    }
	
	//region EditDeck
	@FXML
	public void PressedDone(ActionEvent event) {
		Navigation.ChangeScene("Home");
	}

	@Override
	public void InitData(String data) {
	}
}