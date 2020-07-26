package maven.firstproject.gui;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import maven.firstproject.gui.controllers.IGenericController;
import maven.firstproject.gui.controllers.GenericController;

public class NavigationRegistrator {
	public static class Navigation {
		
		public static Stage ActiveStage;
		
		public static void ChangeScene(String toSceneName)
		{
			ChangeScene(GenericController.class, toSceneName, null);
		}
		
		public static <U extends IGenericController<T>, T> void ChangeScene(Class<U> u, String toSceneName, T data)
		{
			StackPane layout = LoadController(u, toSceneName, data);
			
			Scene scene = new Scene(layout, 1080, 720);
			
			Navigation.ChangeScene(scene);
		}
		
		public static FXMLLoader GetLoader(String page){
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(GetSceneURLFromString(page));
			return loader;
		}
		
		public static <U extends IGenericController<T>, T> StackPane LoadController(Class<U> u, String page, T data)
		{
			FXMLLoader loader = GetLoader(page);
			
			if (data != null)
			{
				U controller = loader.<U>getController();
				controller.InitData(data);
			}
			
			StackPane pane = null;
			try {
				pane = loader.load();
			} catch (IOException e) {
				System.out.println("Could not load controller.");
				e.printStackTrace();
			}
			
			return pane;
		}
		
		public static void ChangeScene(Scene toScene){
			ActiveStage.setScene(toScene);
		}
		
		public static URL GetSceneURLFromString(String toSceneName)
		{
			 String path = String.format("pages/%1$s.fxml", toSceneName);
			 URL url = Navigation.class.getResource(path);
			 return url;
		}
	}
}
