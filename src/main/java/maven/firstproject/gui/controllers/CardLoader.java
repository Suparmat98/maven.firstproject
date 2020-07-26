package maven.firstproject.gui.controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import maven.firstproject.businessobjects.Card;
import maven.firstproject.gui.NavigationRegistrator.Navigation;

public class CardLoader {
	public StackPane BuildCard(Card card) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Navigation.GetSceneURLFromString("CardTemplate"));
		
		CardController controller = loader.<CardController>getController();
		controller.InitData(card);
		
		StackPane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pane;
	}
	
	public void LoadCard(Parent loadedPane, Card card)
	{
		//loadedPane.getChildrenUnmodifiable().add(BuildCard(card));
	}
}
