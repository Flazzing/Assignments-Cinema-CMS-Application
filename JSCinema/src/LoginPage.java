import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPage {
	
	public static Scene generateLoginScreen(){
		StackPane result = new StackPane();
		
		ImageView background = CommonElements.getBackgroundImage();
		background.setFitHeight(960);
		background.setFitWidth(1440);
		result.getChildren().add(background);
		
		GridPane loginContent = new GridPane();
		loginContent.setVgap(5);
		loginContent.setHgap(5);
		loginContent.setPadding(new Insets(5));
		
		Label loginTitle = new Label("Login");
		loginTitle.setFont(Font.font("", FontWeight.BOLD, 18));
		
		TextField[] loginInputs = {
				new TextField(),
				new PasswordField()
		};
		
		Button loginButton = new Button("Login");
		HBox loginHBox = new HBox(loginButton);
		loginHBox.setAlignment(Pos.CENTER);
		
		Button goToRegisterButton = new Button("Register");
		HBox goToRegisterHBox = new HBox(new Label("Not a member? "), goToRegisterButton);
		goToRegisterHBox.setAlignment(Pos.CENTER);
		
		goToRegisterButton.setOnAction(e -> {
			for(TextField tf : loginInputs){
				tf.setText("");
			}
		});
		
		
		loginContent.addRow(0, loginTitle);
		loginContent.addRow(1, new Label("Username"), loginInputs[0]);
		loginContent.addRow(2, new Label("Password"), loginInputs[1]);
		loginContent.add(loginHBox, 0, 3, 2, 1);
		loginContent.addRow(4, new Label("")); //For spacing purposes
		loginContent.add(goToRegisterHBox, 0, 5, 2, 1);
		
		return new Scene(loginContent);
	}
	
}
