import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class houses the different elements that are commonly used on all of the application's scenes
 * 
 * Rant:
 * PLEASE USE THIS CLASS TO LOAD ALL IMAGES. PLEASE. I BEG OF YOU.
 * Setting up the FileInputStreams, Images, and ImageViews will make the files too long.
 * Too long for anyone to read the code without spending several hours on it already.
 * 
 */

/**
 * @author Steve
 *
 */
public class CommonElements {
	
	/*
	 * This function returns an ImageView of the background image
	 */
	public static ImageView getElementView(String url){
		Image image = null;
		try {
			FileInputStream imageStream1 = new FileInputStream(url);
			image = new Image(imageStream1);
		} catch (NullPointerException npe) {
			System.err.println("Image could not be opened from " + url + " . Closing application.");
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("getBackgroundImage is having problems reading " + url + ".");;
		}
		return new ImageView(image);
	}
	
	/*
	 *  This function sets Buttons to their standard style
	 */
	public static void setStandardButtonStyle(Button btn){
		btn.setStyle("-fx-text-fill: white; -fx-font-size: 35px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
	}
	
	/*
	 *  This function sets TextFields to their standard style
	 */
	public static void setStandardTextFieldStyle(TextField tf){
		tf.setStyle("-fx-text-fill: white; -fx-padding: 3 3 3 3; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: #00B0F0; -fx-border-width: 5px; "
    			+ "-fx-background-color: transparent;");
	}
	
	/*
	 * This function just directly gets 1.png (background) from PageLayout
	 */
	public static ImageView getBackgroundImage(){
		return getElementView("PageLayout/1.png");
	}
	
	/*
	 * This function just directly gets 2.png (header) from PageLayout
	 */
	public static ImageView getHeaderImage(){
		return getElementView("PageLayout/2.png");
	}

	/*
	 * This function just directly gets 3.png (title) from PageLayout
	 */
	public static ImageView getTitleImage(){
		return getElementView("PageLayout/3.png");
	}
	
	/*
	 * This function calculate number movies that is airing
	 */
	public static int getNowShowingNo() throws Exception{
		int num = 0;
		File file = new File("MovieDataSource/Movie.txt");
		
		if(file.exists()){
    		System.out.println("File Opened! Calculating number of movies.");
    		Scanner input = new Scanner(file);
    		
    		while(input.hasNextLine()){
    			num++;
    			input.nextLine();
    		}// end of while ( calculate lines in text file, 1 line = 1 movie showing)
    		
    		input.close();// close input 
    	}else{
    		System.out.println("File not found!");
    	}
		System.out.println("Movies Available: " +num);
		return num;// return number of movie showing
	}
	
	/*
	 * This function changes the style of buttons 
	 */
	public static void changeButtonProperty(Button btn) throws Exception{
    	btn.setStyle("-fx-text-fill: white;-fx-font-size: 35px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    	
    	
    	// Mouse Hover Effect
		DropShadow buttonGlow = new DropShadow();
		buttonGlow.setOffsetX(0.0);
		buttonGlow.setOffsetY(0.0);
		buttonGlow.setColor(Color.rgb(0, 176, 240));
		buttonGlow.setWidth(70);
		buttonGlow.setHeight(70);
		
		btn.setOnMouseEntered(e -> {
    		btn.setStyle("-fx-background-color: white;-fx-font-size: 35px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    		btn.setEffect(buttonGlow);
    	});
    		
    	btn.setOnMouseExited(e -> {
    		btn.setStyle("-fx-text-fill: white;-fx-font-size: 35px; -fx-padding: 3 20 3 30; "
        			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
        			+ "-fx-background-color: transparent;");
    		btn.setEffect(null);
    	});
	}
	
	/*
	 * This function sets the left menubar for admin pages
	 */
	
	public static Pane getMenuBar(Stage stage) throws Exception{
		
		Pane left = new Pane();
		StackPane leftContainer = new StackPane();
		leftContainer.setPadding(new Insets(180,50,50,40));	
		
		ImageView imgview4 = getElementView("LeftDashboard/sidebar.png");
		imgview4.setFitHeight(650);
		imgview4.setFitWidth(350);
	    
	    leftContainer.getChildren().add(imgview4);
	    left.getChildren().add(leftContainer);
	    
	    VBox leftOutline = new VBox(45);
	    leftOutline.setPadding(new Insets(240,50,50,85));
	    
	    HBox hb1 = new HBox();
	    ImageView imageView5 = getElementView("LeftDashboard/1.png");
    	imageView5.setFitHeight(62);
    	imageView5.setFitWidth(62);
    	Button btn1 = new Button("DashBoard");
    	btn1.setGraphic(imageView5);
    	 
    	changeButtonProperty(btn1);
    	
    	btn1.setOnAction(e -> {
    		try {
    			Dashboard dashboard = new Dashboard(); // Create a dashboard object from dashboard class
				stage.setScene(dashboard.getDashboard(stage)); // change to dashboard scene
			} catch (Exception e1) {
				System.out.println("Scene not found");
			}
    	});
    	
    	HBox hb2 = new HBox();
    	ImageView imageView6 = getElementView("LeftDashboard/3.png");
    	imageView6.setFitHeight(62);
    	imageView6.setFitWidth(62);
    	Button btn2 = new Button("Movies");
    	btn2.setGraphic(imageView6);
    	
    	changeButtonProperty(btn2);
    	
    	btn2.setOnAction(e -> {
    		try {
    			MovieInterface movieInterface = new MovieInterface();// Create a report object from report class
				stage.setScene(movieInterface.generateMovieScreen(stage)); // back to report scene
			} catch (Exception e1) {
				System.out.println("Scene not found");
			}
    	});
        	
    	HBox hb3 = new HBox();
    	ImageView imageView7 =getElementView("LeftDashboard/4.png");
    	imageView7.setFitHeight(62);
    	imageView7.setFitWidth(62);
    	Button btn3 = new Button("Report");
    	btn3.setGraphic(imageView7);
    	
    	changeButtonProperty(btn3);
    	
    	btn3.setOnAction(e -> {
    		try {
    			Report report = new Report();// Create a report object from report class
				stage.setScene(report.getReport(stage)); // back to report scene
			} catch (Exception e1) {
				System.out.println("Scene not found");
			}
    	});
    	
    	HBox hb4 = new HBox();
    	ImageView imageView8 = getElementView("LeftDashboard/6.png");
    	imageView8.setFitHeight(62);
    	imageView8.setFitWidth(62);
    	Button btn4 = new Button("Users");
    	btn4.setGraphic(imageView8);
    	
    	changeButtonProperty(btn4);
    	
    	btn4.setOnAction(e -> {
    		try {
    			// Create the scene needed to add/remove/modify users
    			stage.setTitle("User Interface");
				stage.setScene(UserPaneInterface.getUserAddRemoveModifyScene(stage));
			} catch (Exception e1) {
				System.out.println("User add/remove/modify scene not found");
			}
    	});
    	
    	HBox hb5 = new HBox();
    	ImageView imageView9 = getElementView("LeftDashboard/8.png");
    	imageView9.setFitHeight(62);
    	imageView9.setFitWidth(62);
    	Button btn5 = new Button("Logout");
    	btn5.setGraphic(imageView9);
    	
    	changeButtonProperty(btn5);
    	
    	btn5.setOnAction(e -> {
    		int dialogButton = JOptionPane.NO_OPTION;
    		dialogButton = JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning", dialogButton);
    		if(dialogButton == JOptionPane.YES_OPTION){
    			System.out.println("You have logged out!");
    			//Go back to login screen
    			stage.setScene(MainApplication.getLoginScene());
    		}
    	});
    	
    	hb1.getChildren().add(btn1);
    	hb2.getChildren().add(btn2);
    	hb3.getChildren().add(btn3);
    	hb4.getChildren().add(btn4);
    	hb5.getChildren().add(btn5);

    	leftOutline.getChildren().add(hb1);
    	leftOutline.getChildren().add(hb2);
    	leftOutline.getChildren().add(hb3);
    	leftOutline.getChildren().add(hb4);
    	leftOutline.getChildren().add(hb5);
    	
    	left.getChildren().add(leftOutline);
		
		return left;
	}
	
}
