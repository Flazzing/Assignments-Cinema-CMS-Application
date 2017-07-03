import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is used to start the Admin's side of the program.
 */

/**
 * @author Kwan Juen Wen (Steve)
 */

public class MainApplication extends Application {

	private static Stage mainStage;
	private static ArrayList<User> listOfUsers = User.getUsersFromUserFile();
	private static User userLoggedIn;
	private static Scene loginScene;
	
	public static Stage getMainStage() {
		return mainStage;
	}

	public static void setMainStage(Stage mainStage) {
		MainApplication.mainStage = mainStage;
	}

	public static ArrayList<User> getListOfUsers() {
		return listOfUsers;
	}

	public static void setListOfUsers(ArrayList<User> usersFromUserFile) {
		MainApplication.listOfUsers = usersFromUserFile;
	}

	public static User getUserLoggedIn() {
		return userLoggedIn;
	}

	public static void setUserLoggedIn(User userLoggedIn) {
		MainApplication.userLoggedIn = userLoggedIn;
	}

	public static Scene getLoginScene() {
		return loginScene;
	}

	public static void setLoginScene(Scene loginScene) {
		MainApplication.loginScene = loginScene;
	}
	
	public void start(Stage primaryStage) throws Exception{
		for(User user: getListOfUsers()){
			System.out.println(user.getUniqueID() + " " + user.getUsername() + " " + user.getPassword());
		}
		setLoginScene(LoginPage.generateLoginScreen());
		
		setMainStage(primaryStage);
		getMainStage().setScene(getLoginScene());
		getMainStage().show();
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}

