import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This driver class is used to setup the initial data files.
 */

/**
 * @author Kwan Juen Wen
 *
 */
public class DataFileSetup {

	public static void main(String[] args) throws FileNotFoundException {
		setupUserFile();
	}

	private static void setupUserFile() throws FileNotFoundException {
		ArrayList<User> setup = new ArrayList<User>(Arrays.asList(
			//new User("Admin0001")
		));	
		
	}
	

}
