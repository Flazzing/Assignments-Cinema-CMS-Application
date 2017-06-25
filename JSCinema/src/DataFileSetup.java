import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This driver class is used to setup the initial data files, and test them.
 */

/**
 * @author Kwan Juen Wen
 *
 */
public class DataFileSetup {

	public static void main(String[] args) throws FileNotFoundException {
		if(new File("user.dat").exists()){
			testAppendUserFile();
		}
		else{
			manualSetupUserFile();
		}
		printUserFile();
	}

	//This method is used to create a file called user.dat manually
	public static void manualSetupUserFile() {
		ArrayList<User> setup = new ArrayList<User>(Arrays.asList(
			new User("Admin0001", "John", "123456"),
			new User("User0001", "Nancy", "1234"),
			new User("User0002", "Blake", "123")
		));	
		
		User.saveUsersToUserFile(setup);
	}
	
	private static void testAppendUserFile() {
		ArrayList<User> users = User.getUsersFromUserFile();
		users.add(new User(User.generateUniqueID(true), "Mike", "002"));
		users.add(new User(User.generateUniqueID(false), "John", "002"));
	}
	
	private static void printUserFile(){
		ArrayList<User> users =  User.getUsersFromUserFile();
		
		System.out.println(users);
	}
	

}
