import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dashboard{
	
	public Scene getDashboard(Stage stage) throws Exception{
		stage.setTitle("Dashboard");
		System.out.println("Entered Admin's Dashboard!");
		Pane root = new Pane();// root pane 
		
		//Setting Background Image
		ImageView imgview = CommonElements.getBackgroundImage();
		imgview.setFitHeight(960);
		imgview.setFitWidth(1440);
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
		
		//Sidebar
		Pane left = new Pane();
		StackPane leftContainer = new StackPane();
		leftContainer.setPadding(new Insets(180,50,50,40));	
		
		ImageView imgview4 = CommonElements.getElementView("LeftDashboard/sidebar.png");
		imgview4.setFitHeight(650);
		imgview4.setFitWidth(350);
	    
	    leftContainer.getChildren().add(imgview4);
	    left.getChildren().add(leftContainer);
	    
	    VBox leftOutline = new VBox(45);
	    leftOutline.setPadding(new Insets(240,50,50,85));
	    
	    HBox hb1 = new HBox();
	    ImageView imageView5 = CommonElements.getElementView("LeftDashboard/1.png");
    	imageView5.setFitHeight(62);
    	imageView5.setFitWidth(62);
    	Button btn1 = new Button("DashBoard");
    	btn1.setGraphic(imageView5);
    	 
    	changeButtonProperty(btn1);
		
    	btn1.setOnAction(e -> {
    		try {
				stage.setScene(getDashboard(stage)); // back to dashboard
			} catch (Exception e1) {
				System.out.println("Scene not found");
			}
    	});
    	
    	HBox hb2 = new HBox();
    	ImageView imageView6 = CommonElements.getElementView("LeftDashboard/3.png");
    	imageView6.setFitHeight(62);
    	imageView6.setFitWidth(62);
    	Button btn2 = new Button("Movies");
    	btn2.setGraphic(imageView6);
    	
    	changeButtonProperty(btn2);
        	
    	HBox hb3 = new HBox();
    	ImageView imageView7 = CommonElements.getElementView("LeftDashboard/4.png");
    	imageView7.setFitHeight(62);
    	imageView7.setFitWidth(62);
    	Button btn3 = new Button("Report");
    	btn3.setGraphic(imageView7);
    	
    	changeButtonProperty(btn3);
    	
    	btn3.setOnAction(e -> {
    		Report report = new Report(); // Create report object from report class
    		try {
				stage.setScene(report.getReport(stage));// Change to report scene
			} catch (Exception ex) {
				System.out.println("Scene not found");
			}
    	});
    	
    	HBox hb4 = new HBox();
    	ImageView imageView8 = CommonElements.getElementView("LeftDashboard/6.png");
    	imageView8.setFitHeight(62);
    	imageView8.setFitWidth(62);
    	Button btn4 = new Button("Users");
    	btn4.setGraphic(imageView8);
    	
    	changeButtonProperty(btn4);
    	
    	HBox hb5 = new HBox();
    	ImageView imageView9 = CommonElements.getElementView("LeftDashboard/8.png");;
    	imageView9.setFitHeight(62);
    	imageView9.setFitWidth(62);
    	Button btn5 = new Button("Logout");
    	btn5.setGraphic(imageView9);
    	
    	changeButtonProperty(btn5);
    	
    	btn5.setOnAction(e -> {
    		int dialogButton = JOptionPane.NO_OPTION;
    		dialogButton = JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning", dialogButton);
    		/*
    		 * If the user wants to log out, we should not immediately quit the program.
    		 * Just redirect the program back to login and set the userLoggedIn to null (empty)
    		 *	-Steve
    		 */
    		if(dialogButton == JOptionPane.YES_OPTION){
    			System.out.println("You have logged out!");
    			AdminPage.setUserLoggedIn(null);
    			AdminPage.getMainStage().setScene(AdminPage.getLoginScene());
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

		// Center content
		Pane centTop = new Pane();
    	StackPane centerTop = new StackPane();
    	centerTop.setPadding(new Insets(185,50,50,400));	
		GridPane ctop1 = new GridPane();
		ctop1.setPadding(new Insets(70, 50,50,15));
		ctop1.setHgap(40);
		
		ImageView imgview10 = CommonElements.getElementView("TopDashboard/4.png");
		imgview10.setFitHeight(100);
		imgview10.setFitWidth(100);
		GridPane.setRowSpan(imgview10, 5);
		ctop1.add(imgview10, 0, 0);
		
		ImageView imgview11 = CommonElements.getElementView("LeftDashboard/4.png");
		imgview11.setFitHeight(80);
		imgview11.setFitWidth(80);
		GridPane.setRowSpan(imgview11, 5);
		ctop1.add(imgview11, 4, 0);
		
		ImageView imgview12 = CommonElements.getElementView("LeftDashboard/5.png");
		imgview12.setFitHeight(90);
		imgview12.setFitWidth(90);
		GridPane.setRowSpan(imgview12, 5);
		ctop1.add(imgview12, 8, 0);
		
		centerTop.getChildren().add(ctop1);
		
		ImageView imgview13 = CommonElements.getElementView("TopDashboard/5.png");
		imgview13.setFitWidth(960);
		imgview13.setFitHeight(180);
		
		centerTop.getChildren().add(imgview13);
		
		centTop.getChildren().add(centerTop);
		
		Text ctText1 = new Text(Integer.toString(getNowShowingNo())); // get number of movie showing then change to String type
		Text ctText2 = new Text("movie showing today");
		ctText1.setFont(Font.font(28));
		ctText2.setFont(Font.font(14));
		ctText1.setFill(Color.WHITE);
		ctText2.setFill(Color.WHITE);
		ctop1.add(ctText1, 1, 3);
		ctop1.add(ctText2, 1, 4);
		Text ctText3 = new Text(Integer.toString(getTotalBookingMade())); // get number of booking made then change to String type
		Text ctText4 = new Text("booking made today");
		ctText3.setFont(Font.font(28));
		ctText4.setFont(Font.font(14));
		ctText3.setFill(Color.WHITE);
		ctText4.setFill(Color.WHITE);
		ctop1.add(ctText3, 5, 3);
		ctop1.add(ctText4, 5, 4);
		Text ctText5 = new Text("6");
		Text ctText6 = new Text("halls");
		ctText5.setFont(Font.font(28));
		ctText6.setFont(Font.font(14));
		ctText5.setFill(Color.WHITE);
		ctText6.setFill(Color.WHITE);
		ctop1.add(ctText5, 9, 3);
		ctop1.add(ctText6, 9, 4);
		
		root.getChildren().add(centTop); 
		
		// 2nd heading
		HBox headingContainer = new HBox();
		headingContainer.setPadding(new Insets(400,50,50,430));
		Text heading1 = new Text("Now Showing:");
		heading1.setFont(Font.font(45));
		heading1.setStyle("-fx-font-weight: bold;");
		heading1.setFill(Color.WHITE);
		
		headingContainer.getChildren().add(heading1);
		root.getChildren().add(headingContainer);
		
		// Now Showing (Bottom)
		ScrollPane container = new ScrollPane();
		container.setPrefHeight(330);
		container.setPrefWidth(905);
		container.setPadding(new Insets(50,50,50,50));
		container.setStyle("-fx-background-color : transparent; -fx-background: transparent; ");
		container.setHbarPolicy(ScrollBarPolicy.NEVER);
		container.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		StackPane content = new StackPane();
		content.setPadding(new Insets(506,50,50,450));
		
		StackPane nowShowing = new StackPane();
		nowShowing.setPadding(new Insets(450,50,50,395));
		
		FileInputStream imageStream14 = new FileInputStream("LeftDashboard/container.png");
		Image image14 = new Image(imageStream14);
		ImageView imgview14 = new ImageView(image14);
		imgview14.setFitWidth(1000);
		imgview14.setFitHeight(440);
		nowShowing.getChildren().add(imgview14);
		
		
		//container.setContent(displayNowShowing());
		content.getChildren().add(container);// Content containing the scrollpane
		root.getChildren().add(nowShowing);
		root.getChildren().add(content);
		
		root.getChildren().add(left);
		Scene scene = new Scene(root, 1440, 960);
		return scene;
	}
	
	public VBox displayNowShowing() throws Exception{
		System.out.println("Getting Movies Information...");
		
		VBox moviesInfo = new VBox(0);
		moviesInfo.setStyle("-fx-background: transparent; -fx-background-color: transparent");
		java.io.File file = new java.io.File("MovieData/movies.txt");
		Scanner input = new Scanner(file);
		
		ArrayList<String> info = new ArrayList<String>();
		
		while(input.hasNext()){
			String line = input.nextLine();
			String[] section = line.split(",");
			
			for(String movies: section){
				System.out.println(movies);
				info.add(movies);
			}
			System.out.println();
		}
		
		final HBox[] movieBox = null;
		
		for(int i = 0; i < getNowShowingNo(); i++){
			 movieBox[i] = new HBox();
			 
			 
			 moviesInfo.getChildren().add(movieBox[i]);
		}
		
		System.out.println(info);
		return moviesInfo;
	}
	
	public int getNowShowingNo() throws Exception{
		int num = 0;
		File file = new File("MovieData/movies.txt");
		
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
	
	public int getTotalBookingMade() throws Exception{
		String num = "";
		int tot = 0;
		File file = new File("MovieData/TotalBookingMade.txt");
		
		if(file.exists()){
    		System.out.println("File Opened! Calculating number of booking made.");
    		Scanner input = new Scanner(file);
    		
    		while(input.hasNextLine()){
    			input.nextLine();
    			num = input.nextLine();// line in text file of even number store the number of booking made 
    			tot += Integer.parseInt(num);// Change num as string to int to enable calculation
    		}// end of while 
    		
    		input.close();// close input 
    	}else{
    		System.out.println("File not found!");
    	}
		System.out.println("Booking made: " +tot);
		return tot; // Return total number of booking made 
	}
	
	public void changeButtonProperty(Button btn) throws Exception{
		CommonElements.setStandardButtonStyle(btn);

    	// Mouse Hover Effect
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.LIGHTBLUE);
		btn.setOnMouseEntered(e -> {
    		btn.setEffect(shadow);
    		btn.setTextFill(Color.BLACK);
    		btn.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY , Insets.EMPTY)));
    		
    	});
    		
    	btn.setOnMouseExited(e -> {
    		btn.setTextFill(Color.WHITE);
    		btn.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY , Insets.EMPTY)));
    		btn.setEffect(null);
    	});
	}
}