package maven.firstproject.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import maven.firstproject.businessobjects.Card;

public class CardController implements Initializable, IGenericController<Card> {
	
	@FXML
	public Text description = new Text();
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    }
	
	public void InitData(Card card){
		description.setText(card.Description);
	}
}
