

import com.sun.glass.ui.TouchInputSupport;
import com.sun.media.jfxmedia.events.NewFrameEvent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{ 
	private static Stage mainStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(new Scene(root, 200, 200));
		primaryStage.show();
		
	}
	
	public static void main (String[] args){
		launch(args);
	}
	
	public static Stage getPrimaryStage(){
		return mainStage;
	}
}
