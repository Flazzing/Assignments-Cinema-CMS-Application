import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * This class is used to generate the panes needed to perform the following tasks:
 * 		- Add user
 * 		- Remove user
 * 		- Edit username
 * 		- Edit user type (admin/user)
 * 		- Reset password of a user, using admin's password as confirmation
 */

/**
 * @author Steve
 *
 */
public class UserPaneInterface {
	
	/*
	 * This function serves as a wrapper for the 
	 */
	
	
	/*
	 * This function creates the interface to add users
	 */
	public static GridPane getAddUserInterface(){
		GridPane result = new GridPane();
		
		Label title = new Label("Add User");
		
		Label[] desc = {
				new Label("Type of user: "),
				new Label("Username: "),
				new Label("Password: "),
				new Label("Confirm Password: ")
		};
		
		RadioButton[] userTypeRadioButtons = {
				new RadioButton("Admin"), new RadioButton("User")
		};
		
		final ToggleGroup userType = new ToggleGroup();
		
		userTypeRadioButtons[0].setToggleGroup(userType);
		userTypeRadioButtons[1].setToggleGroup(userType);
		
		//'User' type is selected by default
		userTypeRadioButtons[1].setSelected(true);
		
		TextField[] newUserInput = {
				new TextField(), //Username
				new PasswordField(), //Password
				new PasswordField(), //Confirm password
		};
		
		Button addUser = new Button("Add User");
		
		
		
		/*
		 * Styles are set here
		 */
		for(Label label: desc){
			label.setFont(Font.font("", FontWeight.BOLD, 12));
			label.setTextFill(Color.WHITE);
		}
		
		for(TextField tf : newUserInput){
			tf.setFont(Font.font(12));
			CommonElements.setStandardTextFieldStyle(tf);
		}
		
		/*
		 * Styles end here
		 * ------------------
		 * Actions and events are set here
		 */
		
		addUser.setOnAction(e -> {
			String type = ((RadioButton)userType.getSelectedToggle()).getText();
			String username = newUserInput[0].getText();
			String pword = newUserInput[1].getText(), pword2 = newUserInput[2].getText();
			boolean emptyUsername = username.equals(null) || username.equals(""),
					emptyPassword1 = pword.equals(null) || pword.equals(""),
					emptyPassword2 = pword2.equals(null) || pword2.equals(""),
					pw1ispw2 = pword.equals(pword2);
			if(emptyUsername && (emptyPassword1 || emptyPassword2)){
				JOptionPane.showMessageDialog(null, 
						"Multiple fields are empty. Fill these fields in.", 
						"Multiple Empty Fields", 
						JOptionPane.ERROR_MESSAGE);
				System.err.println("Multiple fields are empty. Fill these in.");
			}
			else if(emptyUsername){
				JOptionPane.showMessageDialog(null, 
						"'Username' field is empty.", 
						"Empty 'Username' Field", 
						JOptionPane.ERROR_MESSAGE);
				System.err.println("Username is empty. Fill this in.");
			}
			else if(emptyPassword1){
				JOptionPane.showMessageDialog(null, 
						"'Password' field is empty.", 
						"Empty 'Password' Field", 
						JOptionPane.ERROR_MESSAGE);
				System.err.println("Password is empty. Fill this in.");
			}
			else if(emptyPassword2){
				JOptionPane.showMessageDialog(null, 
						"'Comfirm Password' field is empty.", 
						"Empty 'Confirm Password' Field", 
						JOptionPane.ERROR_MESSAGE);
				System.err.println("Confirm password is empty. Fill this in.");
			}
			else if(pw1ispw2 == false){
				JOptionPane.showMessageDialog(null, 
						"'Password' and 'Confirm Password' are not the same. Correct this.", 
						"'Password' and 'Confirm Password' Not Equal", 
						JOptionPane.ERROR_MESSAGE);
				System.err.println("Password is not the same as Confirm Password. Correct this.");
			}
			else{
				ArrayList<User> temp = AdminPage.getListOfUsers();
				temp.add(
						new User(User.generateUniqueID(type.equals("Admin")), username, pword)
						);
				AdminPage.setListOfUsers(temp);
				User.saveUsersToUserFile(temp);
			}
		});
		
		/*
		 * Actions and events end here
		 */
		
		result.addRow(0, title);
		result.addRow(1, desc[0], userTypeRadioButtons[0], userTypeRadioButtons[1]);
		result.add(desc[1], 0, 2);
		result.add(newUserInput[0], 1, 2, 2, 1);
		result.add(desc[2], 0, 3);
		result.add(newUserInput[1], 1, 3, 2, 1);
		result.add(desc[3], 0, 4);
		result.add(newUserInput[2], 1, 4, 2, 1);
		result.add(addUser, 2, 5);
		
		
		return result;
	}
	
	private static void resetInputs(){
		
	}
	
}
