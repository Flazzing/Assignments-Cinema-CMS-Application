
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminPage extends Application {

	private static Stage mainStage;
	private static User userLoggedIn;
	
	public static Stage getMainStage() {
		return mainStage;
	}

	public static void setMainStage(Stage mainStage) {
		AdminPage.mainStage = mainStage;
	}

	public static User getUserLoggedIn() {
		return userLoggedIn;
	}

	public static void setUserLoggedIn(User userLoggedIn) {
		AdminPage.userLoggedIn = userLoggedIn;
	}

	public void start(Stage primaryStage) throws Exception{
		setMainStage(primaryStage);
		//startAdminPage(getMainStage());
		getMainStage().setScene(LoginPage.generateLoginScreen());
		getMainStage().show();
	}
	
	public void startAdminPage(Stage primaryStage) throws Exception{
		Dashboard dashboard = new Dashboard();
		
		Scene scene = dashboard.getDashboard(primaryStage);
		primaryStage.setTitle("Dashboard"); //Set the stage title 
		primaryStage.setScene(scene); //Place the scene in the stage
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}

