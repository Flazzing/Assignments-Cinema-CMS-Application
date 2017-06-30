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
import javafx.scene.effect.DropShadow;
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

public class ComingSoonScene {

	String [] comingSoonMovieNames = new String [10];
	
	//SCENE 2 - ComingSoon Scene
			public Scene getComingSoon(Stage stage) throws Exception{
				//rootPane to add all child panes
				Pane rootPane2 = new Pane();
				
				//pane to fit Background
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
					
						//Setting Styling of button for scene changers
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
			
				//Border pane
				HBox BorderClassPane = new HBox();
				
					BorderClassPane.setPadding(new Insets(200,0,0,50));
					FileInputStream imageStream12 = new FileInputStream("UserPage/SceneBorder2.png");
					Image image12 = new Image(imageStream12);
					ImageView Img12 = new ImageView(image12);
					Img12.setFitHeight(750);
					Img12.setFitWidth(700);
					BorderClassPane.getChildren().add(Img12);
			
				//showcase movies available
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
		
			//showcase movies to be released
			VBox CommingSoonMov = new VBox(20);
			
		
				CommingSoonMov.setPadding(new Insets(350,0,0,360));
				FileInputStream file2 = new FileInputStream("UserPage/comingSoon.txt");
				Scanner CmgName = new Scanner(file2);
				Label comingSoonNames [] = new Label [10];
				int count4 =0;
				while(CmgName.hasNext()){
					String line = CmgName.nextLine();
					String[] splitter = line.split(",");
					
					//Questionable >> The new Label Array sticks with the old Label Array forming a Complex Array ??
					comingSoonNames[count4] = new Label((count4+1)+"."+splitter[0]+"         released on: "+splitter[1]+" "+splitter[2]);
					comingSoonNames[count4].setFont(Font.font("Arial Black", 20));
					comingSoonNames[count4].setTextFill(Color.TOMATO);
					NowShowingMov.getChildren().add(comingSoonNames[count4]);
					count4 ++;
				}
				CmgName.close();
			
				//Creation of button based on lines in the text file
				HBox MoviesCommingSoon = new HBox();
				
					//MoviesCommingSoon.setPadding(new Insets(350,0,0,360));
					java.io.File file3 = new java.io.File("UserPage/comingSoon.txt");
					Scanner MovNames = new Scanner(file3);
					Button MovImages [] = new Button[10];
					int count5 = 0;
					while(MovNames.hasNext()){
						String line = MovNames.nextLine();
						String[] splitter = line.split(",");
					
						MovImages[count5] = new Button();
						FileInputStream ImgCmgSoon = new FileInputStream(splitter[3]);
						MovImages[count5].setGraphic(new ImageView(new Image(ImgCmgSoon)));
						MoviesCommingSoon.getChildren().add(MovImages[count5]);
						comingSoonMovieNames [count5] = splitter[0];
						
						count5++;
					}
					MovNames.close();
				
				//Horizontal ScrollPane for the buttonImages
				ScrollPane Handler = new ScrollPane();
			
					//Handler.setPadding(new Insets(350,0,0,500));
					Handler.setContent(MoviesCommingSoon);
					Handler.setStyle("-fx-background: transparent");
					Handler.setStyle("-fx-background-color: transparent");
					Handler.setHbarPolicy(ScrollBarPolicy.ALWAYS);
					Handler.setVbarPolicy(ScrollBarPolicy.NEVER);
					Handler.addEventFilter(ScrollEvent.SCROLL,new EventHandler<ScrollEvent>() {
					@Override
						public void handle(ScrollEvent event) {
							if (event.getDeltaY() != 0)
							{
								event.consume();
							}
						}
					});
					Handler.setMaxSize(1200, 1200);
			
				//to hold the scrollPane 
				HBox holder = new HBox(20);
					holder.setPadding(new Insets(290,0,0,680));
					holder.setMaxWidth(1400);
					holder.getChildren().add(Handler);
				
				//Title for coming soon display
				HBox Title = new HBox();
					Title.setPadding(new Insets(230,0,0,890));
					Label lbl = new Label("Coming Soon");
					lbl.setFont(Font.font("Arial Black", 35));
					lbl.setTextFill(Color.LIGHTBLUE);
					Title.getChildren().add(lbl);
				
				//Fits the Movie Name followed by the MovieDescription
				VBox Description = new VBox(25);
				
					Description.setPadding(new Insets(600,0,0,680));
					Label movDescTitle = new Label("			   Movie Description");
					movDescTitle.setFont(Font.font("Arial Black", 25));
					movDescTitle.setTextFill(Color.LIGHTBLUE);
					Label movDesc = new Label("Click the list of movies above to view details and the description of the movie !!!");
					movDesc.setMaxWidth(600);
					movDesc.setFont(Font.font("Arial Black", 15));
					movDesc.setTextFill(Color.LIGHTBLUE);
					movDesc.setWrapText(true);
				
				Description.getChildren().addAll(movDescTitle,movDesc);
				
				//Action handler for clicking on the coming soon movie 
				//no.of movies = no.of functional buttons
				if(count5 >= 1){
					MovImages[0].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[0])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 2){
					MovImages[1].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[1])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 3){
					MovImages[2].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[2])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 4){
					MovImages[3].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[3])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 5){
					MovImages[4].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[4])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 6){
					MovImages[5].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[5])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 7){
					MovImages[6].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[6])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 8){
					MovImages[7].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[7])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 9){
					MovImages[8].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[8])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 10){
					MovImages[9].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[9])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				if(count5 >= 11){
					MovImages[10].addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
						
			            
			            public void handle(ActionEvent event) {
			            	
			            	try{
			            	java.io.File file = new java.io.File("UserPage/comingSoon.txt");
			            	Scanner input = new Scanner(file);
			            	while(input.hasNext()){
			            		String line = input.nextLine();
			            		String[] splitter = line.split(",");
			            		
			            		if(splitter[0].matches(comingSoonMovieNames[10])){
			            			
			            			movDescTitle.setText(splitter[0]);
			            			movDesc.setText(splitter[4]);
			            			
			            		}
			            		
			            		}
			            	
			            	}
			            	catch (FileNotFoundException ex){
			            		System.out.println("File Cannot Be Found");
			            	}
			            } 
			            });

				}
				
				DropShadow shadow = new DropShadow();
				  shadow.setColor(Color.LIGHTBLUE);
				  lblOption4.setOnMouseEntered(e -> {
					  lblOption4.setEffect(shadow);
					  lblOption4.setStyle(
				        "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
				       + "-fx-background-color: transparent;");
				     });
				
				 //shadow effect for button >outwards<     
				lblOption4.setOnMouseExited(e -> {
					  lblOption4.setStyle(
				           "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
				           + "-fx-background-color: transparent;");
				      lblOption4.setEffect(null);
				     });
				
				//Action to coming soon page
				lblOption4.setOnMouseClicked(new EventHandler<MouseEvent>() {
				      public void handle(MouseEvent e) {
				        try {
							UserScene userScene = new UserScene();
							stage.setScene(userScene.getUserScene(stage));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							System.out.println(e1);
						}
				      }
				    });
				
					
					rootPane2.getChildren().addAll(backgroundPane,Footer,BorderClassPane,NowShowingMov,Description,CommingSoonMov,Title,holder,banner2,MenuBar2);
					Scene scene = new Scene(rootPane2, 1440 , 960 );
					stage.setTitle("JSC");
					return scene;
			
		}
}
