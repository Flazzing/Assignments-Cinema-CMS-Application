import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminPage extends Application {

	private Stage mainStage;
	
	public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	public void start(Stage primaryStage) throws Exception{
		setMainStage(primaryStage);
		startAdminPage(getMainStage());
	}
	
	public void startAdminPage(Stage primaryStage) throws Exception{
		Dashboard dashboard = new Dashboard();
		
		Scene scene = dashboard.getDashboard(primaryStage);
		primaryStage.setTitle("Dashboard"); //Set the stage title 
		primaryStage.setScene(scene); //Place the scene in the stage
		primaryStage.show();
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}

