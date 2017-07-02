
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Add extends Application{

	
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		GenerateAddPage(arg0);
	}
	
	public void setTopMovieBorderPane(BorderPane MovieBorderPane, Stage stage){
		  Pane TopMoviePane = new Pane();
	      HBox TopMovieHBox = new HBox();		
	      VBox TopMovieVBox =  new VBox();
			
	      Pane MovieTittlePane = new Pane();
	      ImageView MovieTittleImageView = new ImageView(new Image("MovieInterfaceResource/Logo.png"));
	      MovieTittleImageView.setX(750);
	      MovieTittleImageView.setY(30);
	      MovieTittlePane.getChildren().add(MovieTittleImageView);
	      TopMovieVBox.getChildren().add(MovieTittlePane);

	        
	      Pane MovieIconImageViewPane = new Pane();
	      Image MovieIconImage = new Image("MovieInterfaceResource/MovieIcon.png");
	      ImageView MovieIconImageView = new ImageView(MovieIconImage);
	        
	        
	      String MovieTittleBlackBoxStringDirectory = "MovieInterfaceResource/MovieTittleBlackBox.jpg";
	      Image MovieTittleBlackBoxImage = new Image(MovieTittleBlackBoxStringDirectory,1980,398, false, false);
	      BackgroundImage MovieTittleBlackBoxBackgroundImage = new BackgroundImage(MovieTittleBlackBoxImage,
	            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	      Background MovieTittleBlackBoxBackground = new Background(MovieTittleBlackBoxBackgroundImage);
	      TopMovieHBox.setBackground(MovieTittleBlackBoxBackground);
	      TopMovieHBox.setPrefSize(1980, 200);
	      MovieIconImageView.setFitWidth(150);
	      MovieIconImageView.setFitHeight(100);   
	      MovieIconImageView.setX(150);
	      MovieIconImageView.setY(50);
	      MovieIconImageViewPane.getChildren().add(MovieIconImageView);
	      TopMovieHBox.getChildren().add(MovieIconImageViewPane);
	      Text MovieName = new Text("Movies");
	      MovieName.setFont(Font.font("Verdana", 60));
	      MovieName.setFill(Color.BLUE);
	        
	      MovieName.resize(100, 100);
	      Pane MovieNamePane = new Pane();
	      MovieNamePane.getChildren().add(MovieName);
	      MovieName.setLayoutX(0);
	      MovieName.setLayoutY(110);
	        
	      TopMovieHBox.getChildren().add(MovieNamePane);
	      TopMovieHBox.setSpacing(80);
	                
	      TopMovieVBox.getChildren().add(TopMovieHBox);      
	      TopMoviePane.getChildren().add(TopMovieVBox);
	        
	        
	      Button MovieBackButton = new Button("Back");
	      MovieBackButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
	      MovieBackButton.setPrefHeight(200);
	      MovieBackButton.setPrefWidth(200);
	      MovieBackButton.setLayoutX(1200);
	      MovieBackButton.setLayoutY(120); 
	      
	      MovieBackButton.setOnAction(e -> {
	    	  try {
	    		  MovieInterface movieinterface = new MovieInterface();
	    		  stage.setScene(movieinterface.generateMovieScreen(stage));
				} catch (Exception e1) {
					System.out.println("Scene not found");
				}
	      });
	        
	      TopMoviePane.getChildren().add(MovieBackButton);
	                
	      MovieBorderPane.setTop(TopMoviePane);			
	}
	
	public void AddMovie( String MovieTextFileDirectory, String MovieID, String MovieName, String Time1,String Time2, String Time3,String Time4, String Time5, String Time6, String Hall1, String Hall2, String Hall3, String Hall4, String Hall5, String Hall6,String MovieImageFileDirectory) throws IOException{
		PrintWriter pw = new PrintWriter(new FileOutputStream( new File(MovieTextFileDirectory),  true /* append = true */));
		MovieImageFileDirectory = MovieImageFileDirectory.replace('\\' , '/');
		
		if (MovieTextFileDirectory.equals("Movie Image Directory")){
			MovieTextFileDirectory = "null";
		}
		
		if(MovieID.equals("")){
			MovieID = "null";
		}
		
		if (MovieName.equals("")){
			MovieName = "null";
		}
		if (Time1.equals("")){
			Time1="0.00-0.00";
		}
		if(Time2.equals("")){
			Time2 = "0.00-0.00";
		}
		
		if (Time3.equals("")){
			Time3 = "0.00-0.00";
		}
		if(Time4.equals("")){
			Time4 = "0.00-0.00";
		}
		if(Time5.equals("")){
			Time5 = "0.00-0.00";
		}
		if(Time6.equals("")){
			Time6 = "0.00-0.00";
		}
		if(Hall1.equals("")){
			Hall1 = "null";
		}
		if(Hall2.equals("")){
			Hall2 = "null";
		}
		if(Hall3.equals("")){
			Hall3 = "null";
		}
		if(Hall4.equals("")){
			Hall4 = "null";
		}
		if(Hall5.equals("")){
			Hall5 = "null";
		}
		if(Hall6.equals("")){
			Hall6 = "null";
		}
		
		pw.println("[" + MovieID + "]" + "," + MovieName + ","+ Time1 +"," + Time2 + "," + Time3 + "," + Time4 + "," + Time5 + "," + Time6 + "," + Hall1 + "," + Hall2 + "," + Hall3 + "," + Hall4 + "," + Hall5 + "," + Hall6 + "," + MovieImageFileDirectory);	
		pw.close();
	}
	
	public Pane GenerateAddAiringMoviePage(String filedirectory, Stage stage){
		Pane AiringMoviePane = new Pane();
		
		
		GridPane AddMovieGridPane = new GridPane();
		Label AddMovieLabel[] = new Label[14];
		TextField AddMovieTextField[] = new TextField[14];
		for (int i=0; i<AddMovieLabel.length; i++){
			AddMovieLabel[i] = new Label();
			AddMovieTextField[i] = new TextField();
			AddMovieLabel[i].setStyle(" -fx-font-size: 20; -fx-text-fill: #ffffff;");
			if(i<7){
				AddMovieGridPane.add(AddMovieLabel[i], 0, i);
				AddMovieGridPane.add(AddMovieTextField[i], 1, i);
			}
			else {
				AddMovieGridPane.add(AddMovieLabel[i], 2, i-7);
				AddMovieGridPane.add(AddMovieTextField[i], 3, i-7);
			}
		}
		AddMovieGridPane.setHgap(20);
        AddMovieGridPane.setVgap(20);
        
        Button AddMovieConfirmButton = new Button("Confirm");
        AddMovieConfirmButton.setPrefSize(200, 100);
    	AddMovieConfirmButton.setStyle(" fx-font: bold italic 20pt 'Arial'; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
 
        AddMovieGridPane.add(AddMovieConfirmButton, 8, 7);
        Button MovieImageDirectoryButton = new Button("Movie Image Directory");
        MovieImageDirectoryButton.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		FileChooser fileChooser = new FileChooser();
        		File selectedFile = fileChooser.showOpenDialog(null);
        		if (selectedFile != null) {
        			MovieImageDirectoryButton.setText(selectedFile.getPath());
        		}
        		else {
        			MovieImageDirectoryButton.setText("File selection cancelled.");
        		}
        	}});
        
        
        MovieImageDirectoryButton.setPrefWidth(200);
        MovieImageDirectoryButton.setPrefHeight(50);
        
 
        AddMovieConfirmButton.setOnAction(d->{
        	try {
        		AddMovie(filedirectory, AddMovieTextField[0].getText(), AddMovieTextField[1].getText(), AddMovieTextField[2].getText(), AddMovieTextField[3].getText(), AddMovieTextField[4].getText(), AddMovieTextField[5].getText(), AddMovieTextField[6].getText(), AddMovieTextField[7].getText(), AddMovieTextField[8].getText(), AddMovieTextField[9].getText(), AddMovieTextField[10].getText(), AddMovieTextField[11].getText(), AddMovieTextField[12].getText(),AddMovieTextField[13].getText(), MovieImageDirectoryButton.getText());
        	}catch(IOException g){
        		g.printStackTrace();
        	}
        	MovieInterface movieInterface = new MovieInterface();
        	try {
				stage.setScene(movieInterface.generateMovieScreen(stage));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   		 
               });
        
        
        MovieImageDirectoryButton.setPrefWidth(200);
        MovieImageDirectoryButton.setPrefHeight(50);
        AddMovieGridPane.add(MovieImageDirectoryButton, 3,6);
      
        
        AddMovieLabel[0].setText("Movie ID");
        AddMovieLabel[1].setText("Movie Name");
        AddMovieLabel[2].setText("Movie Time 1");
        AddMovieLabel[3].setText("Movie Time 2");
        AddMovieLabel[4].setText("Movie Time 3");
        AddMovieLabel[5].setText("Movie Time 4");
        AddMovieLabel[6].setText("Movie Time 5");
        AddMovieLabel[7].setText("Movie Time 6");
        AddMovieLabel[8].setText("Movie Hall 1");
        AddMovieLabel[9].setText("Movie Hall 2");
        AddMovieLabel[10].setText("Movie Hall 3");
        AddMovieLabel[11].setText("Movie Hall 4");
        AddMovieLabel[12].setText("Movie Hall 5");
        AddMovieLabel[12].setText("Movie Hall 6");
        AddMovieLabel[13].setText("Movie Image File Directory");

        AddMovieGridPane.setLayoutX(400);
        AddMovieGridPane.setLayoutY(200);
   	
        AddMovieGridPane.setLayoutX(0);
        AddMovieGridPane.setLayoutY(100);
        AiringMoviePane.getChildren().add(AddMovieGridPane);
        
		return AiringMoviePane;
	}
	
	public void AddComingSoonMovie( String MovieTextFileDirectory, String MovieName, String StartDay, String StartMonth, String MovieImageFileDirectory, String MovieDescription) throws IOException{
		PrintWriter pw = new PrintWriter(new FileOutputStream( new File(MovieTextFileDirectory),  true /* append = true */));
		if (MovieTextFileDirectory.equals("Movie Image Directory")){
			MovieTextFileDirectory = "null";
		}
				
		if (MovieName.equals("")){
			MovieName = "null";
		}
		if (StartDay.equals("")){
			StartDay = "null";
		}
		if (StartMonth.equals("")){
			StartMonth = "null";
		}

		if (MovieImageFileDirectory.equals("")){
			MovieImageFileDirectory = "null";
		}

		if (MovieDescription.equals("")){
			MovieDescription = "null";
		}

		
		pw.println( MovieName  + "," + StartDay + "," +  StartMonth + ","  + MovieImageFileDirectory + ","+ MovieDescription);	
		pw.close();
	}
	
	public GridPane GenerateAddComingSoonMoviePage(Stage stage){
		GridPane AddComingSoonMovieGridPane = new GridPane();
		AddComingSoonMovieGridPane.setHgap(50);
		AddComingSoonMovieGridPane.setVgap(10);

		AddComingSoonMovieGridPane.add(new Label("Movie Name"), 0, 0);
		AddComingSoonMovieGridPane.add(new Label("Release Data"), 0, 1);
		AddComingSoonMovieGridPane.add(new Label("Release Month (e.g. January)"), 0, 2);
		AddComingSoonMovieGridPane.add(new Label("Image Directory"), 0, 3);
		AddComingSoonMovieGridPane.add(new Label("Description"), 0, 4);

		TextField[] AddComingSoonMovieData = new TextField[4];
		for(int i=0; i<AddComingSoonMovieData.length; i++){
			AddComingSoonMovieData[i] = new TextField();
		}
		   Button MovieImageDirectoryButton = new Button("Movie Image Directory");
		   MovieImageDirectoryButton.setStyle("-fx-background-color:#090a0c, linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),linear-gradient(#20262b, #191d22), radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0)); -fx-background-radius: 5,4,3,5; -fx-background-insets: 0,1,2,0;    -fx-text-fill: white; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );    -fx-font-family: 'Arial';    -fx-text-fill: linear-gradient(white, #d0d0d0); -fx-font-size: 12px; -fx-padding: 10 20 10 20;");
	        MovieImageDirectoryButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
         			FileChooser fileChooser = new FileChooser();
	            			File selectedFile = fileChooser.showOpenDialog(null);
	            			if (selectedFile != null) {
	            				String directory = null;	
	            				directory = selectedFile.getPath();
	            				directory = directory.replace('\\', '/');
	            				MovieImageDirectoryButton.setText(directory);
	            			}
	            			else {
	            				MovieImageDirectoryButton.setText("File selection cancelled.");
	            			}
	            }});

		
		AddComingSoonMovieGridPane.add(AddComingSoonMovieData[0], 1, 0);
		AddComingSoonMovieGridPane.add(AddComingSoonMovieData[1], 1, 1);
		AddComingSoonMovieGridPane.add(AddComingSoonMovieData[2], 1, 2);		
		AddComingSoonMovieGridPane.add(MovieImageDirectoryButton, 1, 3);		
		AddComingSoonMovieGridPane.add(AddComingSoonMovieData[3], 1, 4);
		
		Button confirm = new Button("Confirm");
		confirm.setStyle(" fx-font: bold italic 20pt 'Arial'; -fx-effect: dropshadow( one-pass-box , black , 8 , 0.0 , 2 , 0 );");
		confirm.setOnAction(e->{
			try {
				AddComingSoonMovie("MovieDataSource/ComingSoonMovie.txt",AddComingSoonMovieData[0].getText(),AddComingSoonMovieData[1].getText(), AddComingSoonMovieData[2].getText(), MovieImageDirectoryButton.getText(), AddComingSoonMovieData[3].getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MovieInterface movieinterface = new MovieInterface();
			try {
				stage.setScene(movieinterface.generateMovieScreen(stage));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
		});
		
		AddComingSoonMovieGridPane.add(confirm, 2, 5);
		return AddComingSoonMovieGridPane;
	}
	
	
	public Scene GenerateAddPage(Stage AddStage){

        BorderPane AddMovieBorderPane = new BorderPane();	
        Image AddMovieImage = new Image("MovieInterfaceResource/Background.jpg",2000,1500, false,false);
        BackgroundImage AddMovieBackgroundImage= new BackgroundImage(AddMovieImage,
        		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background AddMovieBackground = new Background(AddMovieBackgroundImage);
        AddMovieBorderPane.setBackground(AddMovieBackground);        
        setTopMovieBorderPane(AddMovieBorderPane, AddStage);
        
        Pane CenterRootPane = new Pane();        
        HBox FirstRowHBox = new HBox(15);
        
        ComboBox <String>MovieFileComboBox = new ComboBox<String>();
		MovieFileComboBox.getItems().add("MovieDataSource/Movie.txt");
		MovieFileComboBox.getItems().add("MovieDataSource/ComingSoonMovie.txt");
		MovieFileComboBox.setPromptText("Please select the type of movie to Add");
		
		FirstRowHBox.getChildren().add(new Label("Select movie file to add:"));
		FirstRowHBox.getChildren().add(MovieFileComboBox);
		VBox CenterVBox = new VBox(20);
		CenterVBox.getChildren().add(FirstRowHBox);

		Pane temp = GenerateAddAiringMoviePage("MovieDataSource/Movie.txt", AddStage);
		Pane temp2 = new Pane();
		GridPane AddComingSoonMovieGridPane = GenerateAddComingSoonMoviePage(AddStage);
		AddComingSoonMovieGridPane.setLayoutX(0);
		AddComingSoonMovieGridPane.setLayoutY(50);
		temp2.getChildren().add(AddComingSoonMovieGridPane);
		
		MovieFileComboBox.setOnAction(e->{
			if(MovieFileComboBox.getValue().equals("MovieDataSource/Movie.txt")){
				if(CenterVBox.getChildren().contains(temp2)){
					CenterVBox.getChildren().remove(temp2);
				}
				CenterVBox.getChildren().add(temp);
			}
			if(MovieFileComboBox.getValue().equals("MovieDataSource/ComingSoonMovie.txt")){
				if(CenterVBox.getChildren().contains(temp)){
					CenterVBox.getChildren().remove(temp);
				}
				CenterVBox.getChildren().add(temp2);
			}
		});
		
		CenterRootPane.getChildren().add(CenterVBox);		
        AddMovieBorderPane.setCenter(CenterRootPane);
        Pane leftpane = new Pane();
        leftpane.setPadding(new Insets(0,50,0,50));
        AddMovieBorderPane.setLeft(leftpane);
        
        Scene scene = new Scene(AddMovieBorderPane);
        AddStage.setScene(scene);
        AddStage.setHeight(960);
        AddStage.setWidth(1440);
        scene.getStylesheets().add("DeleteCSS.css");		
        return scene;
 	     }
}
