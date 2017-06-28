import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.application.Application.launch;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

	public class UserScene {
		
		int no_Movies =0;
		String [] movieNames = new String [10];
		
		public Scene getUserScene(Stage stage) throws Exception{
		
			//SCENE 1 - NOW SHOWING
			Pane rootPane = new Pane();
			
			//background pane
			Pane backgroundPane = new Pane();
				
				FileInputStream imageStream = new FileInputStream("UserPage/Background.png");
				backgroundPane.setPadding(new Insets(0,0,0,0));
				Image image = new Image(imageStream);
				backgroundPane.getChildren().add(new ImageView(image));
			
			//footer pane
			HBox Footer = new HBox();
			
				FileInputStream imageStream2 = new FileInputStream("UserPage/Logo.png");
				Footer.setPadding(new Insets(30,0,0,530));
				Image image2 = new Image(imageStream2);
				Footer.getChildren().add(new ImageView(image2));
				
			//menu bar background pane
			HBox banner = new HBox();
				
				FileInputStream imageStream3 = new FileInputStream("UserPage/banner.png");
				banner.setPadding(new Insets(125,0,0,30));
				Image image3 = new Image(imageStream3);
				ImageView Img = new ImageView(image3);
				Img.setFitHeight(60);
				Img.setFitWidth(1370);
				banner.getChildren().addAll(Img);
					
			//menu bar pane
			HBox MenuBar = new HBox(25);
			
				MenuBar.setPadding(new Insets(135,0,0,50));
				MenuBar.setAlignment(Pos.CENTER);
				Label lblNowShowing = new Label("Now Showing				 	");
				Label lblOption1 = new Label("						 Now Showing ");
				Label lbl = new Label("|");
				Button lblOption2 = new Button("Comming Soon");
				lblNowShowing.setFont(Font.font("Arial Black", FontWeight.BOLD, 30));
				lblNowShowing.setTextFill(Color.LIGHTBLUE);
				lblOption1.setFont(Font.font("Arial Black", 20));
				lblOption1.setTextFill(Color.LIGHTBLUE);
				lbl.setFont(Font.font("Arial Black", 20));
				lbl.setTextFill(Color.LIGHTBLUE);
				lblOption2.setFont(Font.font("Arial Black", 20));
				lblOption2.setTextFill(Color.LIGHTBLUE);
				lblOption2.setStyle("-fx-border-color: transparent;-fx-background-color: transparent");
				MenuBar.getChildren().addAll(lblNowShowing,lblOption1,lbl,lblOption2);
				
			//movies pane
			HBox MoviesImage = new HBox(0);
			
				MoviesImage.setStyle("-fx-background: transparent");
				MoviesImage.setStyle("-fx-background-color: transparent");
				java.io.File file = new java.io.File("UserPage/movies.txt");
				Scanner input = new Scanner(file);
				ImageView [] movieImgView = new ImageView[10];
				int count =0;
				while(input.hasNext()){
				String line = input.nextLine();
				String[] splitter = line.split(",");
				FileInputStream movieStream = new FileInputStream(splitter[12]);
				movieNames[count] = splitter[1];
				Image movieImage = new Image(movieStream);
				movieImgView[count] = new ImageView(movieImage);
				MoviesImage.getChildren().add(movieImgView[count]);
				
				count ++;
			}
			input.close();
			
			//moviesLbl
			HBox MovieTitle = new HBox(0);
			
				MovieTitle.setStyle("-fx-background: transparent");
				MovieTitle.setStyle("-fx-background-color: transparent");
				Scanner inputTitle = new Scanner(file);
				Button [] movieBtn = new Button[10];
				int count2 =0;
				while(inputTitle.hasNext()){
				String line = inputTitle.nextLine();
				String[] splitter = line.split(",");

				movieBtn[count2] = new Button(splitter[1]);
				movieBtn[count2].setPrefSize(470, 50);
				movieBtn[count2].getStyleClass().add("button2");
				MovieTitle.getChildren().add(movieBtn[count2]);
				no_Movies ++;
				
				
				count2 ++;
				}
				inputTitle.close();
			
			//VBox to fit image and button of each movie
			VBox MoviesPane = new VBox(0);
			
				MoviesPane.setStyle("-fx-background: transparent");
				MoviesPane.setStyle("-fx-background-color: transparent");
				MoviesPane.getChildren().addAll(MoviesImage,MovieTitle);
			
			//scroll through movies pane
			ScrollPane sp1 = new ScrollPane();
			
				sp1.setContent(MoviesPane);
				sp1.setStyle("-fx-background: transparent");
				sp1.setStyle("-fx-background-color: transparent");
				sp1.setHbarPolicy(ScrollBarPolicy.ALWAYS);
				sp1.setVbarPolicy(ScrollBarPolicy.NEVER);
				sp1.addEventFilter(ScrollEvent.SCROLL,new EventHandler<ScrollEvent>() {
				@Override
				public void handle(ScrollEvent event) {
					if (event.getDeltaY() != 0)
					{
						event.consume();
					}
				}
				});
				sp1.setMaxSize(1370, 750);
		
		//pane to fit more pane :0(scroll Pane)
		HBox hbox1 = new HBox();
		
			hbox1.setStyle("-fx-background: transparent");
			hbox1.setStyle("-fx-background-color: transparent");
			hbox1.setPadding(new Insets(200,0,0,30));
			hbox1.getChildren().add(sp1);
		
		//
		HBox border = new HBox();
		
			border.setPadding(new Insets(600,0,0,18));
			FileInputStream imageStream7 = new FileInputStream("UserPage/border.png");
			Image blueBorder = new Image(imageStream7);
			ImageView Bord1 = new ImageView(blueBorder);
			Bord1.setFitHeight(220);
			Bord1.setFitWidth(1394);
			border.getChildren().add(Bord1);
			
		//time schedule pane	
		GridPane showingTime = new GridPane();
			showingTime.setPadding(new Insets(650,0,0,50));
			showingTime.setHgap(30);
			showingTime.setVgap(30);	
			
			ToggleGroup group = new ToggleGroup();
			RadioButton time1 = new RadioButton("Not Applicable");
				time1.setFont(Font.font("Times New Roman", 20));
				time1.setTextFill(Color.AQUA);
			
			RadioButton time2 = new RadioButton("Not Applicable");
				time2.setFont(Font.font("Times New Roman", 20));
				time2.setTextFill(Color.AQUA);
			
			RadioButton time3 = new RadioButton("Not Applicable");
				time3.setFont(Font.font("Times New Roman", 20));
				time3.setTextFill(Color.AQUA);
			
			RadioButton time4 = new RadioButton("Not Applicable");
				time4.setFont(Font.font("Times New Roman", 20));
				time4.setTextFill(Color.AQUA);
			
			RadioButton time5 = new RadioButton("Not Applicable");
				time5.setFont(Font.font("Times New Roman", 20));
				time5.setTextFill(Color.AQUA);
			
				time1.setToggleGroup(group);
				time2.setToggleGroup(group);
				time3.setToggleGroup(group);
				time4.setToggleGroup(group);
				time5.setToggleGroup(group);
				
				
				Label ShowingTimeAvailable = new Label("Showing Time Available");
				ShowingTimeAvailable.setFont(Font.font("Times New Roman",FontWeight.BOLD, 25));
				ShowingTimeAvailable.setTextFill(Color.AQUA);
			
				Label Movie_Name = new Label("Cinema Name");
				Movie_Name.setFont(Font.font("Times New Roman", 22));
				Movie_Name.setTextFill(Color.AQUA);
				
			showingTime.add(ShowingTimeAvailable, 0, 0);
			showingTime.add(Movie_Name, 0, 1);
			showingTime.add(time1, 1, 1);
			showingTime.add(time2, 2, 1);
			showingTime.add(time3, 3, 1);
			showingTime.add(time4, 4, 1);
			showingTime.add(time5, 5, 1);
			
			//Proceed btn Pane
			HBox BtnPane = new HBox(20);
			
				BtnPane.setPadding(new Insets(830,0,0,980));
				Button Back = new Button("Back");
				Button Proceed = new Button("Proceed");
				Back.setMinWidth(200);
				Back.getStyleClass().add("button2");
				Proceed.setMinWidth(200);
				Proceed.getStyleClass().add("button2");
				BtnPane.getChildren().addAll(Back,Proceed);
			
			if(no_Movies >= 1){
				movieBtn[0].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[0]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[0])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		            			
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			if(no_Movies >= 2){
				movieBtn[1].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[1]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[1])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		            			
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			if(no_Movies >= 3){
				movieBtn[2].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[2]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[2])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		            			
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			if(no_Movies >= 4){
				movieBtn[3].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[3]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[3])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		            			
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			if(no_Movies >= 5){
				movieBtn[4].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[4]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[4])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		            			
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			if(no_Movies >= 6){
				movieBtn[5].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[5]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[5])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		            			
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			if(no_Movies >= 7){
				movieBtn[6].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[6]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[6])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		                    	
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			if(no_Movies >= 8){
				movieBtn[7].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[7]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[7])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		            			
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			if(no_Movies >= 9){
				movieBtn[8].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[8]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[8])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		            			
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			if(no_Movies >= 10){
				movieBtn[9].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		            
		            public void handle(ActionEvent event) {
		            	
		            	time1.setText("Not Applicable");
		            	time2.setText("Not Applicable");
		            	time3.setText("Not Applicable");
		            	time4.setText("Not Applicable");
		            	time5.setText("Not Applicable");
		            	
		            	Movie_Name.setText(movieNames[9]);
		            	try{
		            	java.io.File file = new java.io.File("UserPage/movies.txt");
		            	Scanner input = new Scanner(file);
		            	while(input.hasNext()){
		            		String line = input.nextLine();
		            		String[] splitter = line.split(",");
		            		
		            		if(splitter[1].matches(movieNames[9])){
		            			
		            			time1.setText(splitter[2]);
		                    	time2.setText(splitter[3]);
		                    	time3.setText(splitter[4]);
		                    	time4.setText(splitter[5]);
		                    	time5.setText(splitter[6]);
		            			
		            		}
		            		
		            		}
		            	
		            	}
		            	catch (FileNotFoundException ex){
		            		System.out.println("File Cannot Be Found");
		            	}
		            } 
		            });

			}
			
			lblOption2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			      public void handle(MouseEvent e) {
			        try {
						stage.setScene(getComingSoon(stage));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println("Missing Next Scene >>");
					}
			      }
			    });
			
			rootPane.getChildren().addAll(backgroundPane,Footer,banner,border,BtnPane,showingTime,hbox1,MenuBar);
			Scene scene = new Scene(rootPane, 1440 , 960 );
			scene.getStylesheets().add("style.css");
			stage.setTitle("JSC");
			return scene;
		}
		
		
		public Scene getComingSoon(Stage stage) throws Exception{
			//SCENE 2
			Pane rootPane2 = new Pane();
			
			Pane backgroundPane = new Pane();
			
			FileInputStream imageStream = new FileInputStream("UserPage/Background.png");
			backgroundPane.setPadding(new Insets(0,0,0,0));
			Image image = new Image(imageStream);
			backgroundPane.getChildren().add(new ImageView(image));
	
		//footer pane[scene2]
		HBox Footer = new HBox();
		
			FileInputStream imageStream2 = new FileInputStream("UserPage/Logo.png");
			Footer.setPadding(new Insets(30,0,0,530));
			Image image2 = new Image(imageStream2);
			Footer.getChildren().add(new ImageView(image2));
		
		//menu bar background pane[scene2]
		HBox banner2 = new HBox();
		
			banner2.setPadding(new Insets(125,0,0,30));
			FileInputStream imageStream11 = new FileInputStream("UserPage/banner.png");
			Image image11 = new Image(imageStream11);
			ImageView Img1 = new ImageView(image11);
			Img1.setFitHeight(60);
			Img1.setFitWidth(1370);
			banner2.getChildren().add(Img1);
		
		//menu bar pane[scene2]
		HBox MenuBar2 = new HBox(25);
		
			MenuBar2.setPadding(new Insets(135,0,0,50));
			MenuBar2.setAlignment(Pos.CENTER);
			Label lblNowShowing2 = new Label("Comming Soon			 	    ");
			Label lblOption3 = new Label("					    Comming Soon");
			Button lblOption4 = new Button("Now Showing");
			lblNowShowing2.setFont(Font.font("Arial Black", FontWeight.BOLD, 30));
			lblNowShowing2.setTextFill(Color.LIGHTBLUE);
			lblOption3.setFont(Font.font("Arial Black", 20));
			lblOption3.setTextFill(Color.LIGHTBLUE);
			lblOption4.setFont(Font.font("Arial Black", 20));
			lblOption4.setTextFill(Color.LIGHTBLUE);
			lblOption4.setStyle("-fx-border-color: transparent;-fx-background-color: transparent");
			Label lbl2 = new Label("|");
			lbl2.setFont(Font.font("Arial Black", 20));
			lbl2.setTextFill(Color.LIGHTBLUE);
			MenuBar2.getChildren().addAll(lblNowShowing2,lblOption3,lbl2,lblOption4);
			
		HBox BorderClassPane = new HBox();
			
			BorderClassPane.setPadding(new Insets(200,0,0,50));
			FileInputStream imageStream12 = new FileInputStream("UserPage/SceneBorder2.png");
			Image image12 = new Image(imageStream12);
			ImageView Img12 = new ImageView(image12);
			Img12.setFitHeight(750);
			Img12.setFitWidth(700);
			BorderClassPane.getChildren().add(Img12);
			
		VBox NowShowingMov = new VBox(20);
		
			NowShowingMov.setPadding(new Insets(350,0,0,100));
			java.io.File file = new java.io.File("UserPage/movies.txt");
			Scanner input = new Scanner(file);
			Scanner MovName = new Scanner(file);
			Label movieNames [] = new Label [10];
			int count3 =0;
			while(MovName.hasNext()){
				String line = MovName.nextLine();
				String[] splitter = line.split(",");

				movieNames[count3] = new Label((count3+1)+"."+splitter[1]);
				movieNames[count3].setFont(Font.font("Arial Black", 20));
				movieNames[count3].setTextFill(Color.LIGHTBLUE);
				NowShowingMov.getChildren().add(movieNames[count3]);
				count3 ++;
				
			}
			MovName.close();
	
		VBox CommingSoonMov = new VBox(20);
		
	
			CommingSoonMov.setPadding(new Insets(350,0,0,360));
			FileInputStream file2 = new FileInputStream("UserPage/comingSoon.txt");
			Scanner CmgName = new Scanner(file2);
			Label comingSoonNames [] = new Label [10];
			int count4 =0;
			while(CmgName.hasNext()){
				String line = CmgName.nextLine();
				String[] splitter = line.split(",");

				comingSoonNames[count4] = new Label((count4+1)+"."+splitter[0]+"         released on: "+splitter[1]);
				comingSoonNames[count4].setFont(Font.font("Arial Black", 20));
				comingSoonNames[count4].setTextFill(Color.TOMATO);
				NowShowingMov.getChildren().add(comingSoonNames[count4]);
				count4 ++;
			}
			CmgName.close();
	
				
				rootPane2.getChildren().addAll(backgroundPane,Footer,BorderClassPane,NowShowingMov,CommingSoonMov,banner2,MenuBar2);
				Scene scene = new Scene(rootPane2, 1440 , 960 );
				stage.setTitle("JSC");
				return scene;
		
	}
}
	
