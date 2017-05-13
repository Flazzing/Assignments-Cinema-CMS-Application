import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dashboard extends Application{
	public void start(Stage primaryStage) throws Exception{
		BorderPane mainPane = new BorderPane();
		StackPane top = new StackPane();
		GridPane cp1 = new GridPane();
		GridPane cp2 = new GridPane();
		GridPane cp3 = new GridPane();
		GridPane cp4 = new GridPane();
		
		//Background
		FileInputStream imageStream1 = new FileInputStream("1.png");
		Image image = new Image(imageStream1);
		ImageView imgview = new ImageView(image);
		imgview.setFitHeight(960);
		imgview.setFitWidth(1440);
		mainPane.getChildren().add(imgview);
		
		//Header
		Pane header = new Pane();
		FileInputStream imageStream2 = new FileInputStream("2.png");
		Image image2 = new Image(imageStream2);
		ImageView imgview2 = new ImageView(image2);
		header.getChildren().add(imgview2);
		top.getChildren().add(header);
		
		FileInputStream imageStream3 = new FileInputStream("3.png");
		Image image3 = new Image(imageStream3);
		ImageView imgview3 = new ImageView(image3);
		top.getChildren().add(imgview3);
		top.setAlignment(Pos.CENTER);
		
		//Left
		Pane left = new Pane();
		StackPane leftContainer = new StackPane();
		leftContainer.setPadding(new Insets(80,50,50,60));	
		
		String img1_url = "LeftDashboard/9.png";
		
	    FileInputStream imageStream4 = new FileInputStream(img1_url);
		Image image4 = new Image(imageStream4);
		ImageView imgview4 = new ImageView(image4);
		imgview4.setFitHeight(650);
		imgview4.setFitWidth(350);
	    
	    leftContainer.getChildren().add(imgview4);
	    left.getChildren().add(leftContainer);
	    
	    Pane leftOutline = new VBox(10);
	    leftOutline.setPadding(new Insets(101,50,50,85));
	    
	    HBox hb1 = new HBox(25);
	    FileInputStream imageStream5 = new FileInputStream("LeftDashboard/1.png"); 
		Image image5 = new Image(imageStream5);
    	ImageView imageView5 = new ImageView(image5);
    	imageView5.setFitHeight(59);
    	imageView5.setFitWidth(59);
    	Button btn1 = new Button("DashBoard");
    	btn1.setGraphic(imageView5);
    	 
    	btn1.setStyle("-fx-text-fill: white;-fx-font-size: 30px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    	hb1.getChildren().add(btn1);
    	leftOutline.getChildren().add(hb1);
		
    	HBox hb2 = new HBox();
    	FileInputStream imageStream6 = new FileInputStream("LeftDashboard/2.png"); 
		Image image6 = new Image(imageStream6);
    	ImageView imageView6 = new ImageView(image6);
    	imageView6.setFitHeight(59);
    	imageView6.setFitWidth(59);
    	Button btn2 = new Button("Now Showing");
    	btn2.setGraphic(imageView6);
    	
    	btn2.setStyle("-fx-text-fill: white;-fx-font-size: 30px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    	
	    hb2.getChildren().addAll(btn2);
    	leftOutline.getChildren().add(hb2);
		
    	HBox hb3 = new HBox();
    	FileInputStream imageStream7 = new FileInputStream("LeftDashboard/3.png"); 
		Image image7 = new Image(imageStream7);
    	ImageView imageView7 = new ImageView(image7);
    	imageView7.setFitHeight(59);
    	imageView7.setFitWidth(59);
    	Button btn3 = new Button("Movies");
    	btn3.setGraphic(imageView7);
    	
    	btn3.setStyle("-fx-text-fill: white;-fx-font-size: 30px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    	
	    hb3.getChildren().addAll(btn3);
    	leftOutline.getChildren().add(hb3);
    	
    	HBox hb4 = new HBox();
    	FileInputStream imageStream8 = new FileInputStream("LeftDashboard/4.png"); 
		Image image8 = new Image(imageStream8);
    	ImageView imageView8 = new ImageView(image8);
    	imageView8.setFitHeight(59);
    	imageView8.setFitWidth(59);
    	Button btn4 = new Button("Bookings");
    	btn4.setGraphic(imageView8);
    	
    	btn4.setStyle("-fx-text-fill: white;-fx-font-size: 30px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    	
	    hb4.getChildren().addAll(btn4);
    	leftOutline.getChildren().add(hb4);
		
    	HBox hb5 = new HBox();
    	FileInputStream imageStream9 = new FileInputStream("LeftDashboard/5.png"); 
		Image image9 = new Image(imageStream9);
    	ImageView imageView9 = new ImageView(image9);
    	imageView9.setFitHeight(59);
    	imageView9.setFitWidth(59);
    	Button btn5 = new Button("Cinema Hall");
    	btn5.setGraphic(imageView9);
    	
    	btn5.setStyle("-fx-text-fill: white;-fx-font-size: 30px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    	
	    hb5.getChildren().addAll(btn5);
    	leftOutline.getChildren().add(hb5);
		
    	HBox hb6 = new HBox();
    	FileInputStream imageStream10 = new FileInputStream("LeftDashboard/6.png"); 
		Image image10 = new Image(imageStream10);
    	ImageView imageView10 = new ImageView(image10);
    	imageView10.setFitHeight(59);
    	imageView10.setFitWidth(59);
    	Button btn6 = new Button("Users");
    	btn6.setGraphic(imageView10);
    	
    	btn6.setStyle("-fx-text-fill: white;-fx-font-size: 30px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    	
	    hb6.getChildren().addAll(btn6);
    	leftOutline.getChildren().add(hb6);
		
    	HBox hb7 = new HBox();
    	FileInputStream imageStream11 = new FileInputStream("LeftDashboard/7.png"); 
		Image image11 = new Image(imageStream11);
    	ImageView imageView11 = new ImageView(image11);
    	imageView11.setFitHeight(59);
    	imageView11.setFitWidth(59);
    	Button btn7 = new Button("Option");
    	btn7.setGraphic(imageView11);
    	
    	btn7.setStyle("-fx-text-fill: white;-fx-font-size: 30px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    	
	    hb7.getChildren().addAll(btn7);
    	leftOutline.getChildren().add(hb7);
    	
    	HBox hb8 = new HBox();
    	FileInputStream imageStream12 = new FileInputStream("LeftDashboard/8.png"); 
		Image image12 = new Image(imageStream12);
    	ImageView imageView12 = new ImageView(image12);
    	imageView12.setFitHeight(59);
    	imageView12.setFitWidth(59);
    	Button btn8 = new Button("Logout");
    	btn8.setGraphic(imageView12);
    	
    	btn8.setStyle("-fx-text-fill: white;-fx-font-size: 30px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
    	
	    hb8.getChildren().addAll(btn8);
    	leftOutline.getChildren().add(hb8);
		
    	left.getChildren().add(leftOutline);
    	
		//Center 1
    	Pane centTop = new Pane();
    	StackPane centerTop = new StackPane();
    	centerTop.setPadding(new Insets(63, 50,50,1));
		GridPane ctop1 = new GridPane();
		//ctop1.setGridLinesVisible(true);
		ctop1.setPadding(new Insets(70, 50,50,15));
		ctop1.setHgap(40);
		
		FileInputStream imageStream13 = new FileInputStream("4.png");
		Image image13 = new Image(imageStream13);
		ImageView imgview13 = new ImageView(image13);
		imgview13.setFitHeight(100);
		imgview13.setFitWidth(100);
		GridPane.setRowSpan(imgview13, 5);
		ctop1.add(imgview13, 0, 0);
		
		FileInputStream imageStream14 = new FileInputStream("LeftDashboard/4.png");
		Image image14 = new Image(imageStream14);
		ImageView imgview14 = new ImageView(image14);
		imgview14.setFitHeight(80);
		imgview14.setFitWidth(80);
		GridPane.setRowSpan(imgview14, 5);
		ctop1.add(imgview14, 4, 0);
		
		FileInputStream imageStream15 = new FileInputStream("LeftDashboard/5.png");
		Image image15 = new Image(imageStream15);
		ImageView imgview15 = new ImageView(image15);
		imgview15.setFitHeight(90);
		imgview15.setFitWidth(90);
		GridPane.setRowSpan(imgview15, 5);
		ctop1.add(imgview15, 8, 0);
		
		centerTop.getChildren().add(ctop1);
		
		FileInputStream imageStream16 = new FileInputStream("5.png");
		Image image16 = new Image(imageStream16);
		ImageView imgview16 = new ImageView(image16);
		imgview16.setFitWidth(960);
		imgview16.setFitHeight(180);
		
		centerTop.getChildren().add(imgview16);
		
		centTop.getChildren().add(centerTop);
		
		Text ctText1 = new Text("7");
		Text ctText2 = new Text("movie showing today");
		ctText1.setFont(Font.font(28));
		ctText2.setFont(Font.font(14));
		ctText1.setFill(Color.WHITE);
		ctText2.setFill(Color.WHITE);
		ctop1.add(ctText1, 1, 3);
		ctop1.add(ctText2, 1, 4);
		Text ctText3 = new Text("0");
		Text ctText4 = new Text("booking made today");
		ctText3.setFont(Font.font(28));
		ctText4.setFont(Font.font(14));
		ctText3.setFill(Color.WHITE);
		ctText4.setFill(Color.WHITE);
		ctop1.add(ctText3, 5, 3);
		ctop1.add(ctText4, 5, 4);
		Text ctText5 = new Text("2");
		Text ctText6 = new Text("halls");
		ctText5.setFont(Font.font(28));
		ctText6.setFont(Font.font(14));
		ctText5.setFill(Color.WHITE);
		ctText6.setFill(Color.WHITE);
		ctop1.add(ctText5, 9, 3);
		ctop1.add(ctText6, 9, 4);
		
		//Center 2
		StackPane centerBot1 = new StackPane();
    	centerBot1.setPadding(new Insets(327, 50,50, 14));
		VBox bot1 = new VBox(40);
		bot1.setStyle("-fx-background-color: green;");
		bot1.setPadding(new Insets(25, 50,50, 50));
		bot1.setBorder()
		HBox lbotTitle = new HBox();
		lbotTitle.setStyle("-fx-background-color: green;");
		Pane container = new Pane();
		container.setPadding(new Insets(0,0,0,0));
		container.
		container.setStyle("-fx-background-color: orange;");
		VBox content = new VBox();
		content.setStyle("-fx-background-color: yellow;");
		ScrollPane scroll1 = new ScrollPane();
		scroll1.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll1.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		scroll1.setPrefHeight(200);
		scroll1.setPrefWidth(250);
		scroll1.setStyle("-fx-background-color: red;");
    	
    	FileInputStream imageStream17 = new FileInputStream("6.png");
		Image image17 = new Image(imageStream17);
		ImageView imgview17 = new ImageView(image17);
		imgview17.setFitWidth(300);
		imgview17.setFitHeight(400);
		
		Text nextMovies = new Text("Next Movies");
		nextMovies.setFont(Font.font(30));
		nextMovies.setFill(Color.WHITE);
		
		
		bot1.getChildren().add(nextMovies);
		
		centerBot1.getChildren().add(imgview17);
		scroll1.setContent(content);
		container.getChildren().add(scroll1);
		bot1.getChildren().add(lbotTitle);
		bot1.getChildren().add(container);
		centerBot1.getChildren().add(bot1);
		centTop.getChildren().add(centerBot1);
		
		
		//Center 3
		StackPane centerBot2 = new StackPane();
    	centerBot2.setPadding(new Insets(327, 50,50, 340));
    	VBox bot2 = new VBox();
		bot2.setPadding(new Insets(25, 50,50, 60));
		
    	FileInputStream imageStream18 = new FileInputStream("6.png");
		Image image18 = new Image(imageStream18);
		ImageView imgview18 = new ImageView(image18);
		imgview18.setFitWidth(300);
		imgview18.setFitHeight(400);
		
		Text latestBooking = new Text("Latest Booking");
		latestBooking.setFont(Font.font(30));
		latestBooking.setFill(Color.WHITE);
		
		bot2.getChildren().add(latestBooking);
		
		centerBot2.getChildren().add(imgview18);
		centerBot2.getChildren().add(bot2);
		centTop.getChildren().add(centerBot2);
		
		//Center 4
		StackPane centerBot3 = new StackPane();
    	centerBot3.setPadding(new Insets(327, 50,50, 670));
    	VBox bot3 = new VBox();
		bot3.setPadding(new Insets(25, 50,50, 60));
    	
    	FileInputStream imageStream19 = new FileInputStream("6.png");
		Image image19 = new Image(imageStream19);
		ImageView imgview19 = new ImageView(image19);
		imgview19.setFitWidth(300);
		imgview19.setFitHeight(400);
		
		Text nowShowing = new Text("Now Showing");
		nowShowing.setFont(Font.font(30));
		nowShowing.setFill(Color.WHITE);
		
		bot3.getChildren().add(nowShowing);
		
		centerBot3.getChildren().add(imgview19);
		centerBot3.getChildren().add(bot3);
		centTop.getChildren().add(centerBot3);
		
		mainPane.setTop(top);
		mainPane.setLeft(left);
		mainPane.setCenter(centTop);
		Scene scene = new Scene(mainPane, 1440, 960);
		primaryStage.setTitle("JS Cinema"); //Set the stage title 
		primaryStage.setScene(scene); //Place the scene in the stage
		primaryStage.show();
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}
