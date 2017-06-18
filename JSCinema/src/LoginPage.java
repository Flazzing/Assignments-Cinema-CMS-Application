import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPage {
	
	public static Scene generateLoginScreen() throws FileNotFoundException{
		StackPane result = new StackPane();
		
		ImageView imgview = CommonElements.getBackgroundImage();
		imgview.setFitWidth(1440);
		imgview.setFitHeight(960);
		result.getChildren().add(imgview);
		
		//Create Header
		Pane header = new Pane();
		FileInputStream imageStream2 = new FileInputStream("2.png");
		Image image2 = new Image(imageStream2);
		ImageView imgview2 = new ImageView(image2);
		imgview2.setLayoutY(0);
		header.getChildren().add(imgview2);
		header.setLayoutY(0);
		result.getChildren().add(header);
		
		// Title on header
		Pane title = new Pane();
		FileInputStream imageStream3 = new FileInputStream("3.png");
		Image image3 = new Image(imageStream3);
		ImageView imgview3 = new ImageView(image3);
		imgview3.setLayoutX(542);
		imgview3.setLayoutY(26);
		title.getChildren().add(imgview3);
		result.getChildren().add(title);
		
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
		
		loginContent.addRow(0, loginTitle);
		loginContent.addRow(1, new Label("Username"), loginInputs[0]);
		loginContent.addRow(2, new Label("Password"), loginInputs[1]);
		loginContent.add(loginHBox, 0, 3, 2, 1);
		loginContent.addRow(4, new Label(""));
		
		result.getChildren().add(loginContent);
		
		return new Scene(result);
	}
	
}
