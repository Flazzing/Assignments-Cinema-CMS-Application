import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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
	 * This function creates the interface to add, remove, and modify users
	 */
	public static Scene getUserAddRemoveModifyScene(Stage stage) throws Exception{
		Pane root = new Pane();// root pane 
		
		//Setting Background Image
		ImageView imgview = CommonElements.getBackgroundImage();
		imgview.setFitWidth(1440);
		imgview.setFitHeight(960);
		root.getChildren().add(imgview);
				
		//Create Header
		Pane header = new Pane();
		ImageView imgview2 = CommonElements.getHeaderImage();
		imgview2.setLayoutY(0);
		header.getChildren().add(imgview2);
		header.setLayoutY(0);
		root.getChildren().add(header);
				
		// Title on header
		Pane title = new Pane();
		ImageView imgview3 = CommonElements.getTitleImage();
		imgview3.setLayoutX(542);
		imgview3.setLayoutY(26);
		title.getChildren().add(imgview3);
		root.getChildren().add(title);
		
		GridPane content = getMainContent();
		content.setLayoutX(400);
		content.setLayoutY(200);
		root.getChildren().add(content);
		
		root.getChildren().add(CommonElements.getMenuBar(stage));
		
		return new Scene(root);
	}
	
	public static GridPane getMainContent(){
		GridPane result = new GridPane();
		result.setStyle("-fx-text-fill: white; -fx-font-size: 20px;  "
    		+ "-fx-border-color: #00B0F0; -fx-background-color: rgba(0,0,0,0.2);");
		result.setHgap(5);
		result.setVgap(5);
		result.setMinSize(600, 600);
		
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
		
		HBox addUserButtonHBox = new HBox(addUser);
		
		
		/*
		 * Styles are set here
		 */
		title.setFont(Font.font("", FontWeight.BOLD, 35));
		title.setTextFill(Color.WHITE);
		
		for(Label label: desc){
			label.setTextFill(Color.WHITE);
			label.setFont(Font.font(null, FontWeight.BOLD, 25));
		}
		
		for(TextField tf : newUserInput){
			//tf.setFont(Font.font(12));
			CommonElements.setStandardTextFieldStyle(tf);
		}
		
		addUser.setStyle("-fx-text-fill: white; -fx-font-size: 25px;  -fx-padding: 3 20 3 20; "
    			+ "-fx-border-color: #00B0F0; -fx-border-width: 5px; "
    			+ "-fx-background-color: transparent;");
    	
    	// 'Add User' button Hover Effect
		DropShadow buttonGlow = new DropShadow();
		buttonGlow.setOffsetX(0.0);
		buttonGlow.setOffsetY(0.0);
		buttonGlow.setColor(Color.rgb(0, 176, 240));
		buttonGlow.setWidth(55);
		buttonGlow.setHeight(55);
		
		addUser.setOnMouseEntered(e -> {
    		addUser.setEffect(buttonGlow);
    	});
    		
    	addUser.setOnMouseExited(e -> {
    		addUser.setEffect(null);
    	});
    	
    	
    	addUserButtonHBox.setPrefHeight(60);
    	addUserButtonHBox.setAlignment(Pos.BOTTOM_CENTER);
		
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
					emptyPassword2 = pword2.equals(null) || pword2.equals("");
			//If multiple fields are empty, prompt this error to user
			if(emptyUsername && (emptyPassword1 || emptyPassword2)){
				JOptionPane.showMessageDialog(null, 
						"Multiple fields are empty. Fill these fields in.", 
						"Multiple Empty Fields", 
						JOptionPane.ERROR_MESSAGE);
			}
			//If username field is empty, prompt this error to user
			else if(emptyUsername){
				JOptionPane.showMessageDialog(null, 
						"'Username' field is empty.", 
						"Empty 'Username' Field", 
						JOptionPane.ERROR_MESSAGE);
			}
			//If password field is empty, prompt this error to user
			else if(emptyPassword1){
				JOptionPane.showMessageDialog(null, 
						"'Password' field is empty.", 
						"Empty 'Password' Field", 
						JOptionPane.ERROR_MESSAGE);
			}
			//If confirm password field is empty, prompt this error to user
			else if(emptyPassword2){
				JOptionPane.showMessageDialog(null, 
						"'Comfirm Password' field is empty.", 
						"Empty 'Confirm Password' Field", 
						JOptionPane.ERROR_MESSAGE);
			}
			//If password and confirm password are not the same, prompt this error
			else if(pword.equals(pword2) == false){
				JOptionPane.showMessageDialog(null, 
						"'Password' and 'Confirm Password' are not the same. Correct this.", 
						"'Password' and 'Confirm Password' Not Equal", 
						JOptionPane.ERROR_MESSAGE);
			}
			else{
				ArrayList<User> temp = AdminPage.getListOfUsers();
				//One last check: The check for identical usernames!
				boolean usernameIsNotDuplicate = true; //True by default (we didn't find any yet)
				for(User user : temp){
					if(user.getUsername().equals(username)){
						//We found a match, so we can't accept this
						usernameIsNotDuplicate = false;
						//Found one, just end the thing now.
						break;
					}
				}
				//If there was no duplicate, add it into the file. Else, throw an error prompt at the user
				if(usernameIsNotDuplicate){
					temp.add(
							new User(User.generateUniqueID(type.equals("Admin")), username, pword)
							);
					AdminPage.setListOfUsers(temp);
					User.saveUsersToUserFile(temp);
				}
				else{
					JOptionPane.showMessageDialog(null, 
							"An identical username already exists. Please try another username.", 
							"Duplicate Username Found", 
							JOptionPane.ERROR_MESSAGE);
				}
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
		result.add(addUserButtonHBox, 2, 5);
		
		
		return result;
	}
	
	private static void resetInputs(){
		
	}
	
}
