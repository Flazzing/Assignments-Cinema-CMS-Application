import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.image.ImageView;

/**
 * This class is used to store a user's details
 */

/**
 * @author Kwan Juen Wen
 */
public class User implements Serializable {

	//This serialVersionUID is needed for User class version control
	private static final long serialVersionUID = -5590334009792883748L;
	
	private String uniqueID;
	private String username;
	private String password;
	
	public User(String uniqueID, String username, String password) throws IllegalArgumentException {
		super();
		setUniqueID(uniqueID);
		setUsername(username);
		setPassword(password);
	}
	
	public User() {
		this("User0001", "John", "123456");
	}

	@Override
	public String toString() {
		return uniqueID + "~" + username + "~" + password;
	}

	public String getUniqueID() {
		return uniqueID;
	}
	
	/*
	 * setuniqueID contains a number of requirements. These are:
	 * 1) '~' cannot be used anywhere in the ID.
	 * 2) Must have 'Admin' or 'User' at the beginning.
	 * 3) Must have a parsable integer after the identifier stated at (2).
	 * 4) The integer can NEVER be a 0.
	 * 
	 * Failure to meet any of these requirements will cause IllegalArgumentException to be thrown.
	 */
	public void setUniqueID(String uniqueID) throws IllegalArgumentException {
		if(uniqueID.contains("~")){
			throw new IllegalArgumentException("Delimiter '~' cannot be used in uniqueID.");
		}
		else if((uniqueID.startsWith("Admin") || uniqueID.startsWith("User")) == false){
			throw new IllegalArgumentException("A uniqueID must start with either 'Admin' or 'User'.");
		}
		//By this point the string has passed requirements 1 and 2
		try{
			int number = 0; //failure by default
			if(uniqueID.startsWith("Admin")){
				number = Integer.parseInt(uniqueID.substring(5));
			}
			else if(uniqueID.startsWith("User")){
				number = Integer.parseInt(uniqueID.substring(3));
			}
			
			if(number == 0){
				throw new IllegalArgumentException("THe number parsed is a 0.");
			}
		}catch(NumberFormatException nfe){
			throw new IllegalArgumentException("The number within uniqueID is not parsable");
		}
		//By this point, all requirements have been fulfilled
		this.uniqueID = uniqueID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) throws IllegalArgumentException {
		if(username.contains("~")){
			throw new IllegalArgumentException("Delimiter '~' cannot be used in username.");
		}
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	
	
	/*
	 * This method returns an ImageView based on the user's uniqueID
	 * All images are to be stored based on the user's uniqueID
	 * e.g: User "Admin0004" will have the image stored in Admin0004.jpg
	 */
	public ImageView getUserImage() throws NullPointerException, IllegalArgumentException {
		return new ImageView("userImages/" + getUniqueID() + ".jpg");
	}
	
	/*
	 * This method checks whether or not the username and password matches the user
	 */
	public boolean verifyUser(String usernameInput, String passwordInput){
		return (getUsername().equals(usernameInput)) && (getPassword().equals(passwordInput));
	}
	
	/*
	 * This method checks whether or not a user is an admin.
	 * Done by checking if the uniqueID starts with "Admin"
	 * "Admin0001" should be true, "User0001" and "Admi0001" should be false
	 */
	public boolean isAdmin(){
		return getUniqueID().startsWith("Admin");
	}
	
	/*
	 * This method is used to generate a new uniqueID based on the parameters given
	 */
	public static String generateUniqueID(boolean makeAdmin){
		ArrayList<String> uniqueIDsThatHaveBeenUsed = new ArrayList<String>();
		try {
			for(User user : getUsersFromUserFile()){
				uniqueIDsThatHaveBeenUsed.add(user.getUniqueID());
			}
		} catch (IOException ioe) {
			System.err.println("user.dat cannot be read. Resolve this.");
		} catch (SecurityException | ClassNotFoundException e) {
			System.err.println("Something happened with getUsersFromUserFile() in generateUniqueID().\n"); 
			e.printStackTrace();
		}
		
		int lastUsedUniqueID = 1;
		for(String string : uniqueIDsThatHaveBeenUsed){
			if(string.startsWith(makeAdmin ? "Admin" : "User")){
				try{
					lastUsedUniqueID = Integer.parseInt(string.substring(makeAdmin ? 5 : 4));
				}catch(NumberFormatException nfe){
					System.err.println("Error interpreting substring while generating uniqueID.");
					System.err.println("Please fix the file and try again.");
				}
			}
		}
		String newUniqueID = (makeAdmin ? "Admin" : "User") + (lastUsedUniqueID < 1000 ? "0" : "") 
				+ (lastUsedUniqueID < 100 ? "0" : "") + (lastUsedUniqueID < 10 ? "0" : "") 
				+ Integer.toString(lastUsedUniqueID + 1);
		System.out.println("New ID printed: " + newUniqueID);
		return newUniqueID;
	}
	
	/*
	 * This method outputs an arraylist of User, based on the filepath given.
	 * SecurityException: File defined by userFilePath is denied read access
	 * IOEception: IO problems.
	 * ClassNotFoundException: File read does not have a serialized object.
	 * InvalidClassException: Serial version of the class does not match that of the class descriptor read from the stream
	 */
	public static ArrayList<User> getUsersFromUserFile() 
			throws SecurityException, IOException, ClassNotFoundException, InvalidClassException {
		ArrayList<User> result = new ArrayList<User>();
		try(DataInputStream input = new DataInputStream(new FileInputStream("user.dat"))){
			while(input.available() != 0){
				String buffer = input.readUTF();
				System.out.println(buffer);
				String[] attributes = buffer.split("~", 3);
				result.add(new User(attributes[0], attributes[1], attributes[2]));
			}
		}
		return result;
	}
	
	/*
	 * This method saves an ArrayList of Users to a file, both defined by the parameters given.
	 * SecurityException is thrown if the file is denied read access
	 * IOEception is thrown for IO problems.
	 * FileNotFoundException for if the file defined by userFilePath cannot be found
	 */
	public static void saveUsersToUserFile(ArrayList<User> input) 
			throws SecurityException, FileNotFoundException, IOException {
		try(DataOutputStream output = new DataOutputStream(new FileOutputStream("user.dat"))){
			for(User user: input){
				output.writeUTF(user.toString() + "\n");
			}
			output.flush();
		}
	}
	
}
