import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {

	
	public void start(Stage primaryStage) throws Exception{
		HomePage homepage = new HomePage();
		
		Scene scene = homepage.getUserScene(primaryStage);
		primaryStage.setTitle("Dashboard"); //Set the stage title 
		primaryStage.setScene(scene); //Place the scene in the stage
		primaryStage.show();
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}