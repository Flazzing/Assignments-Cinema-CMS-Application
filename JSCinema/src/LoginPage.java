import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
		
		Label loginTitle = new Label("Login to Proceed");
		loginTitle.setFont(Font.font("", FontWeight.BOLD, 45));
		loginTitle.setTextFill(Color.WHITE);
		
		HBox loginTitleHBox = new HBox(loginTitle);
		loginTitleHBox.setAlignment(Pos.CENTER);
		
		Label[] loginIdentifiers = {
				new Label("Username  "),
				new Label("Password  ")
		};
		
		TextField[] loginInputs = {
				new TextField(),
				new PasswordField()
		};
		
		for(int i = 0; i < 2; i++){
			loginIdentifiers[i].setFont(Font.font("", FontWeight.BOLD, 25));
			loginIdentifiers[i].setTextFill(Color.WHITE);
			loginInputs[i].setFont(Font.font(25));
			loginInputs[i].setStyle("-fx-text-fill: white; -fx-padding: 3 3 3 3; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: #00B0F0; -fx-border-width: 5px; "
    			+ "-fx-background-color: transparent;");
		}
		
		Button loginButton = new Button("Login");
		loginButton.setStyle("-fx-text-fill: white; -fx-font-size: 35px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-border-color: #00B0F0; -fx-border-width: 5px; "
    			+ "-fx-background-color: transparent;");
		
		HBox loginButtonHBox = new HBox(loginButton);
		loginButtonHBox.setPrefHeight(100);
		loginButtonHBox.setAlignment(Pos.BOTTOM_CENTER);		
		
		DropShadow buttonGlow = new DropShadow();
		buttonGlow.setOffsetX(0.0);
		buttonGlow.setOffsetY(0.0);
		buttonGlow.setColor(Color.rgb(0, 176, 240));
		buttonGlow.setWidth(70);
		buttonGlow.setHeight(70);
		loginButton.setEffect(buttonGlow);
		
		Label loginError = new Label("Incorrect username/password. Try again.");
		loginError.setFont(Font.font(25));
		loginError.setTextFill(Color.RED);
		
		DropShadow loginErrorGlow = new DropShadow();
		loginErrorGlow.setOffsetX(0.0);
		loginErrorGlow.setOffsetY(0.0);
		loginErrorGlow.setColor(Color.rgb(255, 0, 0));
		loginErrorGlow.setWidth(35);
		loginErrorGlow.setHeight(35);
		loginError.setEffect(loginErrorGlow);
		
		HBox loginErrorHBox = new HBox(loginError);
		loginErrorHBox.setAlignment(Pos.CENTER);
		
		loginButton.setOnAction(e -> {
			System.out.println("Login Button Pushed");
			ArrayList<User> users = new ArrayList<User>();
			try {
				 users.addAll(User.getUsersFromUserFile());
			} catch (SecurityException | ClassNotFoundException | IOException e1) {
				System.err.println("Something happened when logging in. Printing stack trace.");
				e1.printStackTrace();
			}
			boolean foundUser = false; //false by default
			for(User user : users){
				if(user.verifyUser(loginIdentifiers[0].getText(), loginIdentifiers[1].getText()) == true){
					foundUser = true;
					AdminPage.setUserLoggedIn(user);
					break;
				}
			}
			if(foundUser == false){
				System.out.println("Incorrect username/password");
				loginError.setVisible(true);
			}
		});
		
		loginContent.add(loginTitleHBox, 0, 0, 3, 1);
		loginContent.add(loginErrorHBox, 0, 1, 3, 1);
		loginContent.addRow(2, loginIdentifiers[0], loginInputs[0]);
		loginContent.addRow(3, loginIdentifiers[1], loginInputs[1]);
		loginContent.add(loginButtonHBox, 0, 4, 3, 1);
		
		loginContent.setAlignment(Pos.CENTER);
		
		result.getChildren().add(loginContent);
		
		return new Scene(result);
	}
	
}
