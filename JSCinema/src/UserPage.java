import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class UserPage extends Application{
	
	
	
	public void start(Stage primaryStage) throws Exception{
		UserScene userScene = new UserScene();
		
		Scene scene = userScene.getUserScene(primaryStage);
		primaryStage.setTitle("Home Page"); //Set the stage title 
		primaryStage.setScene(scene); //Place the scene in the stage
		primaryStage.show();
	}
	
	


	public static void main(String[]args){
		Application.launch(args);
}
}

