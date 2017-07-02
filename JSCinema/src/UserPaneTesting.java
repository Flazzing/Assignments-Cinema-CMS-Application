import javafx.application.Application;
import javafx.stage.Stage;

public class UserPaneTesting extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Dashboard"); //Set the stage title 
		primaryStage.setScene(UserPaneInterface.getUserAddRemoveModifyScene(primaryStage)); //Place the scene in the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
