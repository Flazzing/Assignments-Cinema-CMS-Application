
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Steve
 *
 */
public class AdminPage extends Application {

	private static Stage mainStage;
	private static ArrayList<User> listOfUsers = User.getUsersFromUserFile();
	private static User userLoggedIn;
	private static Scene loginScene;
	
	public static Stage getMainStage() {
		return mainStage;
	}

	public static void setMainStage(Stage mainStage) {
		AdminPage.mainStage = mainStage;
	}

	public static ArrayList<User> getListOfUsers() {
		return listOfUsers;
	}

	public static void setListOfUsers(ArrayList<User> usersFromUserFile) {
		AdminPage.listOfUsers = usersFromUserFile;
	}

	public static User getUserLoggedIn() {
		return userLoggedIn;
	}

	public static void setUserLoggedIn(User userLoggedIn) {
		AdminPage.userLoggedIn = userLoggedIn;
	}

	public static Scene getLoginScene() {
		return loginScene;
	}

	public static void setLoginScene(Scene loginScene) {
		AdminPage.loginScene = loginScene;
	}
	
	public void start(Stage primaryStage) throws Exception{
		setLoginScene(LoginPage.generateLoginScreen());
		
		setMainStage(primaryStage);
		getMainStage().setScene(getLoginScene());
		getMainStage().show();
	}
	
	/* Not needed right now
	public void startAdminPage(Stage primaryStage) throws Exception{
		Dashboard dashboard = new Dashboard();
		
		Scene scene = dashboard.getDashboard(primaryStage);
		primaryStage.setTitle("Dashboard"); //Set the stage title 
		primaryStage.setScene(scene); //Place the scene in the stage
	}
	*/
	
	public static void main(String[] args){
		Application.launch(args);
	}
}

