import javafx.beans.value.ChangeListener;
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
	 * This function creates the interface to add users
	 */
	public static GridPane getAddUserInterface(){
		GridPane result = new GridPane();
		
		RadioButton[] userTypeRadioButtons = {
				new RadioButton("Admin"), new RadioButton("User")
		};
		
		final ToggleGroup userType = new ToggleGroup();
		
		userTypeRadioButtons[0].setToggleGroup(userType);
		userTypeRadioButtons[1].setToggleGroup(userType);
		
		userType.selectedToggleProperty().addListener(new ChangeListener<T>() {

			@Override
			public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//'User' type is selected by default
		userTypeRadioButtons[1].setSelected(true);
		
		TextField[] newUserInput = {
				new TextField(), //Username
				new PasswordField(), //Password
				new PasswordField(), //Confirm password
		};
		
		Button addUser = new Button("Add User");
		
		Label title = new Label("Add User");
		
		Label[] desc = {
				new Label("Type of user: "),
				new Label("Username: "),
				new Label("Password: "),
				new Label("Confirm Password: ")
		};
		
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
	
}
