package maven.firstproject.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import maven.firstproject.businessobjects.Card;
import maven.firstproject.gui.NavigationRegistrator.Navigation;
import maven.firstproject.gui.controllers.CardLoader;

public class GUI extends Application implements Runnable {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Navigation.ActiveStage = primaryStage;
		Navigation.ChangeScene("Home");
		
		CardLoader cl = new CardLoader();
		
		Card card = new Card();
		card.Description = "yess hehe";
		
		cl.LoadCard(Navigation.ActiveStage.getScene().getRoot(), card);
		
		primaryStage.show();
	}

	@Override
	public void run() {
		launch();
	}
}
