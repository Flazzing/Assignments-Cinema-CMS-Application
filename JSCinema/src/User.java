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
	private String imageFilePath;
	private String username;
	private String password;
	
	public String getUniqueID() {
		return uniqueID;
	}
	
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	public String getImagePath() {
		return imageFilePath;
	}
	
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public ImageView getUserImage() throws NullPointerException, IllegalArgumentException {
		return new ImageView(imageFilePath);
	}
	
	/*
	 * This method outputs an arraylist of User, based on the filepath given.
	 * SecurityException: File defined by userFilePath is denied read access
	 * IOEception: IO problems.
	 * ClassNotFoundException: File read does not have a serialized object.
	 * InvalidClassException: Serial version of the class does not match that of the class descriptor read from the stream
	 */
	public static ArrayList<User> getUsersFromFile(String userFilePath) 
			throws SecurityException, IOException, ClassNotFoundException, InvalidClassException {
		ArrayList<User> result = new ArrayList<User>();
		try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(userFilePath))){
			while(input.available() != 0){ //If at EOF
				Object buffer = input.readObject();
				if(buffer instanceof User){
					result.add((User) buffer);
				}
				else{
					System.err.println("Something other than a User class has been read by getUsersFromFile.");
				}
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
	public static void saveUsersToFile(String userFilePath, ArrayList<User> input) 
			throws SecurityException, FileNotFoundException, IOException {
		try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(userFilePath))){
			for(User user: input){
				output.writeObject(user);
			}
			output.flush();
		}
	}
	
}
