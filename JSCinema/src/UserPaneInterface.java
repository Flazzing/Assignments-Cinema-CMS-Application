import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.prism.impl.Disposer.Record;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * This class is used to generate the panes needed to perform the following tasks:
 * 		- Add user
 * 		- Remove user
 * 		- Edit username
 * 		- Edit user type (admin/user)
 * 		- Reset password of a user, using admin's password as confirmation
 * 
 * Credit goes to the following for help on implementing the needed things:
 * 		- GitHub user abhinayagarwal for the implementation of buttons in a TableView 
 * 			- Link : https://gist.github.com/abhinayagarwal/9735744
 */

/**
 * @author Steve
 *
 */
public class UserPaneInterface {

	private static boolean selectedAddUser = true; //True by default

	private static ObservableList<User> userData = FXCollections.observableArrayList(MainApplication.getListOfUsers());

	/*
	 * This function is used to get the boolean value of whether or not 'Add User' was selected
	 */
	private static boolean isSelectedAddUser() {
		return selectedAddUser;
	}

	/*
	 * This function is used to set the boolean value of whether or not 'Add User' was selected
	 */
	private static void setSelectedAddUser(boolean selectedAddUser) {
		UserPaneInterface.selectedAddUser = selectedAddUser;
	}

	/*
	 * This function creates the interface to add, remove, and modify users
	 */
	public static Scene getUserAddRemoveModifyScene(Stage stage) throws Exception{
		Pane root = new Pane();//root pane 

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

		//Title on header
		Pane title = new Pane();
		ImageView imgview3 = CommonElements.getTitleImage();
		imgview3.setLayoutX(542);
		imgview3.setLayoutY(26);
		title.getChildren().add(imgview3);
		root.getChildren().add(title);

		Pane content = new Pane();
		content.getChildren().add(getAddUserContent()); //Show 'Add User' by default 
		content.setLayoutX(400);
		content.setLayoutY(220);


		final Button[] userOptions = {
				new Button("Add New User"),
				new Button("Modify / Remove Users")
		};

		DropShadow buttonGlow = new DropShadow();
		buttonGlow.setOffsetX(0.0);
		buttonGlow.setOffsetY(0.0);
		buttonGlow.setColor(Color.rgb(0, 176, 240));
		buttonGlow.setWidth(55);
		buttonGlow.setHeight(55);

		//Setting the styles of the buttons
		for(int i = 0; i < 2; i++){
			userOptions[i].setStyle("-fx-padding: 3 20 3 20; -fx-border-color: #00B0F0; -fx-border-width: 5px; "
					+ "-fx-background-color: rgba(0,0,0,0.5);");
			userOptions[i].setFont(Font.font("", FontWeight.BOLD, 25));
			userOptions[i].setTextFill(Color.WHITE);
			userOptions[i].setLayoutX(400 + i * 210);
			userOptions[i].setLayoutY(170);

			final int j = i; //Workaround to pass i into the event handler
			//The option will glow if hovered upon
			userOptions[i].setOnMouseEntered(e -> {
				userOptions[j].setEffect(buttonGlow);
			});

			/*
			 * Upon leaving the button:
			 * 	- If the 'Add User' section was selected, the 'Add User' Button will still glow
			 *  - If the 'Remove User' section was selected, the 'Remove User' Button will still glow
			 *  - In both scenarios, the other button will not glow
			 */	
			userOptions[i].setOnMouseExited(e -> {
				if(isSelectedAddUser()){
					userOptions[j].setEffect((j == 0) ? buttonGlow : null);
				}
				else{
					userOptions[j].setEffect((j == 0) ? null : buttonGlow);
				}
			});
		}

		userOptions[0].setEffect(buttonGlow);

		//Setting the actions of the buttons
		userOptions[0].setOnAction(e -> {
			content.getChildren().removeAll(content.getChildren());
			content.getChildren().add(getAddUserContent());
			setSelectedAddUser(true);
			userOptions[1].setEffect(null);
		});

		userOptions[1].setOnAction(e -> {
			content.getChildren().removeAll(content.getChildren());
			content.getChildren().add(getModifyRemoveUserContent());
			setSelectedAddUser(false);
			userOptions[0].setEffect(null);
		});


		root.getChildren().addAll(userOptions);

		root.getChildren().add(content);

		root.getChildren().add(CommonElements.getMenuBar(stage));

		return new Scene(root, 1440, 960);
	}

	public static GridPane getAddUserContent(){
		GridPane result = new GridPane();
		result.setStyle("-fx-text-fill: white; -fx-font-size: 20px;  "
				+ "-fx-border-color: #00B0F0; -fx-border-width: 5px; -fx-background-color: rgba(0,0,0,0.2);");
		result.setHgap(5);
		result.setVgap(5);
		result.setPadding(new Insets(5));
		result.setMinSize(900, 700);

		Label title = new Label("Add New User");

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

		Button addUser = new Button("Add New User");		

		HBox addUserButtonHBox = new HBox(addUser);


		/*
		 * Styles are set here
		 */
		title.setFont(Font.font("", FontWeight.BOLD, 35));
		title.setUnderline(true);
		title.setTextFill(Color.WHITE);

		for(Label label: desc){
			label.setTextFill(Color.WHITE);
			label.setFont(Font.font(null, FontWeight.BOLD, 25));
		}

		for(RadioButton rb : userTypeRadioButtons){
			rb.setFont(Font.font(null, FontWeight.BOLD, 25));
			rb.setTextFill(Color.WHITE);
		}

		for(TextField tf : newUserInput){
			//tf.setFont(Font.font(12));
			CommonElements.setStandardTextFieldStyle(tf);
		}

		addUser.setStyle("-fx-text-fill: white; -fx-font-size: 25px;  -fx-padding: 3 20 3 20; "
				+ "-fx-border-color: #00B0F0; -fx-border-width: 5px; "
				+ "-fx-background-color: transparent;");

		//'Add User' button Hover Effect
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
				ArrayList<User> temp = MainApplication.getListOfUsers();
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
					String uniqueID = User.generateUniqueID(type.equals("Admin"));
					temp.add(
							new User(uniqueID, username, pword)
							);
					MainApplication.setListOfUsers(temp);
					User.saveUsersToUserFile(temp);
					JOptionPane.showMessageDialog(null, 
							"A new user was created. Details: \n\n" 
									+ "Unique ID : " + uniqueID + "\n"
									+ "Username : " + username + "\n"
									+ "Password : " + pword + "\n", 
									"New User Created", 
									JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, 
							"An identical username already exists. Please try another username.", 
							"Duplicate Username Found", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
			//Reset text fields
			newUserInput[0].setText("");
			newUserInput[1].setText("");
			newUserInput[2].setText("");
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

	@SuppressWarnings("unchecked")
	public static GridPane getModifyRemoveUserContent(){
		GridPane result = new GridPane();
		result.setStyle("-fx-text-fill: white; -fx-font-size: 20px;  "
				+ "-fx-border-color: #00B0F0; -fx-border-width: 5px; -fx-background-color: rgba(0,0,0,0.2);");
		result.setHgap(5);
		result.setVgap(5);
		result.setPadding(new Insets(5));
		result.setMinSize(900, 700);


		Label title = new Label("Modify / Remove Users");

		TableView<User> table = new TableView<User>();
		table.setEditable(false);
		table.setColumnResizePolicy((param) -> true );

		//Setting up the columns needed
		TableColumn<User, String> uniqueID = new TableColumn<User, String>("Unique User ID");
		uniqueID.setCellValueFactory(new PropertyValueFactory<User, String>("uniqueID"));

		TableColumn<User, String> username = new TableColumn<User, String>("Username");
		username.setCellValueFactory(new PropertyValueFactory<User, String>("username"));

		TableColumn<User, String> password = new TableColumn<User, String>("Password");
		password.setCellValueFactory(new PropertyValueFactory<User, String>("password"));

		//This column generates the 'Edit Username' and 'Reset Password' buttons
		TableColumn editOptions = new TableColumn<>("Edit Options");

		//Boilerplate needed to generate the values needed
		editOptions.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Record, Boolean>, ObservableValue<Boolean>>() {

					@Override
					public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
						return new SimpleBooleanProperty(p.getValue() != null);
					}
				});

		//Adding the buttons to the cell for 'Edit Options' column
		editOptions.setCellFactory(
				new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

					@Override
					public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
						return new EditButtonCell();
					}

				});

		//This column generates the 'Delete User' button
		TableColumn removeUser = new TableColumn<>("Delete User");

		//Boilerplate needed to generate the values needed
		removeUser.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
				ObservableValue<Boolean>>() {

					@Override
					public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
						return new SimpleBooleanProperty(p.getValue() != null);
					}
				});

		//Adding the Button to the cell for the 'Delete User' column
		removeUser.setCellFactory(
				new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

					@Override
					public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
						return new DeleteButtonCell();
					}

				});

		table.getColumns().addAll(uniqueID, username, password, editOptions, removeUser);

		userData = FXCollections.observableArrayList(MainApplication.getListOfUsers());
		table.setItems(userData);

		table.setMinSize(1000, 700);
		table.setMaxSize(1100, 720);
		uniqueID.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		username.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		password.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		editOptions.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		removeUser.prefWidthProperty().bind(table.widthProperty().multiply(0.2));

		editOptions.setMaxWidth(180);
		removeUser.setMaxWidth(140);

		/*
		 * Styles are set here
		 */
		title.setFont(Font.font("", FontWeight.BOLD, 35));
		title.setUnderline(true);
		title.setTextFill(Color.WHITE);

		/*
		 * Styles end here
		 */

		result.add(title, 0, 0);
		result.add(table, 0, 1);


		return result;
	}

	/*
	 * This inner private class defines the 'Edit Options' row's button cells
	 */
	private static class EditButtonCell extends TableCell<Record, Boolean> {
		final Button editUsername = new Button("Edit Username");
		final Button resetPassword = new Button("Reset Password");

		EditButtonCell(){
			/*
			 * Invoke a username edit action whenever the 'Edit Username' button is pressed.
			 */
			editUsername.setOnAction(e -> {
				//Get the selected user
				User currentUser = (User) EditButtonCell.this.getTableView().getItems().get(EditButtonCell.this.getIndex());

				String newUsername = "";

				//Repeat until we have something
				while(newUsername.equals(null) || newUsername.equals("")){
					newUsername = JOptionPane.showInputDialog(null, "Enter a new username: ", "Edit Username", JOptionPane.QUESTION_MESSAGE);

					//Check for identical usernames
					boolean usernameIsDuplicate = false; //True by default (we didn't find any yet)
					for(User user : MainApplication.getListOfUsers()){
						if(user.getUsername().equals(newUsername)){
							//We found a match, so we can't accept this
							usernameIsDuplicate = true;
							//Found one, just end the thing now.
							break;
						}
					}

					if(usernameIsDuplicate){
						JOptionPane.showMessageDialog(null, 
								"An identical username already exists. Please try another username.", 
								"Duplicate Username Found", 
								JOptionPane.ERROR_MESSAGE);
						//Purge the received username
						newUsername = "";
					}
				}

				//Create new User with edit
				User newUser = new User(currentUser.getUniqueID(), newUsername, currentUser.getPassword());

				//Replace the selected item from the table list
				userData.set(userData.indexOf(currentUser), newUser);

				//Update the ArrayList in Application as well
				ArrayList<User> temp = MainApplication.getListOfUsers();
				temp.set(temp.indexOf(currentUser), newUser);

				//Update and save
				MainApplication.updateUserArrayListAndSaveToFile(temp);

				//Also, update the profile of the user that's logged in, if that has been edited
				if(currentUser.getUsername().equals(MainApplication.getUserLoggedIn().getUsername())){
					MainApplication.setUserLoggedIn(newUser);
				}
			});

			/*
			 * Invoke a password edit action whenever the 'Reset Password' button is pressed.
			 */
			resetPassword.setOnAction(e -> {
				//Get the selected user
				User currentUser = (User) EditButtonCell.this.getTableView().getItems().get(EditButtonCell.this.getIndex());

				String newPassword = "", confirmPassword = "";
				boolean newPasswordConfirmed = false;

				while(newPassword.equals(null) || confirmPassword.equals(null) 
						|| newPassword.equals("") || confirmPassword.equals("")){
					 JPasswordField password = new JPasswordField();
			        
			        int result = JOptionPane.showConfirmDialog(null, 
			        		new Object[]{"New Password: ", password}, 
			        		"Reset Password", 
			        		JOptionPane.OK_CANCEL_OPTION);
			        
			        if(result == JOptionPane.OK_OPTION){
			        	newPassword = new String(password.getPassword());
				        
				        if(newPassword.equals(null) || newPassword.equals("")){
							JOptionPane.showMessageDialog(null, 
									"'Password' field is empty. Try again.", 
									"Empty 'Password' Field", 
									JOptionPane.ERROR_MESSAGE);
							newPassword = "";
						}
						else{
							JPasswordField password2 = new JPasswordField();
					        
					        int result2 = JOptionPane.showConfirmDialog(null, 
					        		new Object[]{"Confirm Password: ", password2}, 
					        		"Reset Password", 
					        		JOptionPane.OK_CANCEL_OPTION);
					        
					        if(result2 == JOptionPane.OK_OPTION){
					        	confirmPassword = new String(password2.getPassword());
						        System.out.println(newPassword + " " + confirmPassword + newPassword.equals(confirmPassword)); 
						        
						        if(confirmPassword.equals("") || confirmPassword.equals(null)){
									JOptionPane.showMessageDialog(null, 
											"'Comfirm Password' field is empty. Try again.", 
											"Empty 'Confirm Password' Field", 
											JOptionPane.ERROR_MESSAGE);
									newPassword = "";
									confirmPassword = "";
								}
								else if(newPassword.equals(confirmPassword) == false){
									JOptionPane.showMessageDialog(null, 
											"'Password' and 'Confirm Password' are not the same. Correct this.", 
											"'Password' and 'Confirm Password' Not Equal", 
											JOptionPane.ERROR_MESSAGE);
									//Purge the received passwords
									newPassword = "";
									confirmPassword = "";
								}
								else{
									newPasswordConfirmed = true;
								}
					        }
						}
			        }
			        else{
			        	break;
			        }
				}

				if(newPasswordConfirmed){
					//Create new User with edit
					User newUser = new User(currentUser.getUniqueID(), currentUser.getUsername(), newPassword);

					//Replace the selected item from the table list
					userData.set(userData.indexOf(currentUser), newUser);

					//Update the ArrayList in Application as well
					ArrayList<User> temp = MainApplication.getListOfUsers();
					temp.set(temp.indexOf(currentUser), newUser);

					//Update and save
					MainApplication.updateUserArrayListAndSaveToFile(temp);

					//Also, update the profile of the user that's logged in, if that has been edited
					if(currentUser.getUsername().equals(MainApplication.getUserLoggedIn().getUsername())){
						MainApplication.setUserLoggedIn(newUser);
					}
				}
			});
		}

		/*
		 * This function displays a delete button for the row if the row is not empty.
		 */
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if(empty){
				setGraphic(null);
			} else {
				VBox vbox = new VBox(5, editUsername, resetPassword);
				setGraphic(vbox);
			}
		}
	}

	/*
	 * This inner private class defines the 'Delete' button cell
	 */
	private static class DeleteButtonCell extends TableCell<Record, Boolean> {
		final Button btn = new Button("Delete");

		DeleteButtonCell(){
			/*
			 * Invoke a delete action whenever a button is pressed.
			 */
			btn.setOnAction(e -> {
				//Get the selected item
				User currentUser = (User) DeleteButtonCell.this.getTableView().getItems().get(DeleteButtonCell.this.getIndex());

				//Do not allow the user to delete their own profile
				if(currentUser.getUsername().equals(MainApplication.getUserLoggedIn().getUsername())){
					JOptionPane.showMessageDialog(null, 
							"You cannot delete your own user profile. \n"
									+ "Your profile can only be deleted using another user's profile.", 
									"Deletion of Own Profile Forbidden", 
									JOptionPane.ERROR_MESSAGE);
				}
				else{
					//Remove the selected item from the table list
					userData.remove(currentUser);
					//Remove the user from the main ArrayList as well 
					ArrayList<User> temp = MainApplication.getListOfUsers();
					temp.remove(currentUser);
					//Update and save
					MainApplication.updateUserArrayListAndSaveToFile(temp);
				}
			});
		}

		/*
		 * This function displays a delete button for the row if the row is not empty.
		 */
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if(empty){
				setGraphic(null);
			} else {
				setGraphic(btn);
			}
		}
	}
}
