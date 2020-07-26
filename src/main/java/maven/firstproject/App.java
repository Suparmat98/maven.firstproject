package maven.firstproject;

import maven.firstproject.businessobjects.Card;
import maven.firstproject.businessobjects.Repository;
import maven.firstproject.data.DatabaseConnector;
import maven.firstproject.data.DatabaseUpdater;

public class App  {

	// This is the main thread
	public static void main(String[] args) throws InterruptedException {
		
		// Start a new database connection
		Runnable RunnableConnector = new DatabaseConnector();
		new Thread(RunnableConnector).start();
		
		// Update the database
		Runnable Updater = new DatabaseUpdater();
		new Thread(Updater).start();
		
		// Show the gui to the user
		//Runnable gui = new GUI();
		//new Thread(gui).start();
		
		/*Card card = new Repository<Card>().Get(new Card(), 1);
		card.Attack = 50;
		card.Save();
		Card card2 = new Card();
		card2.Name = "you";
		card2.Description = "you";
		card2.Attack = 3;
		card2.Defense = 3;
		card2.Save();
		*/
	}
}