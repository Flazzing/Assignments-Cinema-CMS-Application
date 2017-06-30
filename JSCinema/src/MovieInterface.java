
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MovieInterface{

	public Scene generateLoginScreen(Stage MovieStage) throws FileNotFoundException{
		BorderPane MovieBorderPane = new BorderPane();
		setBorderPaneBackground(MovieBorderPane, "MovieInterfaceResource/Background.jpg");
		setTopMovieBorderPane(MovieBorderPane, MovieStage);
		setLeftMovieBorderPane(MovieBorderPane);
		setRightMovieBorderPane(MovieBorderPane);
		setCenterBorderPane(MovieBorderPane, MovieStage);		
		
		ScrollPane MovieScrollPane = new ScrollPane();
	    MovieScrollPane.setFitToWidth(true);
	    MovieScrollPane.setContent(MovieBorderPane);
		
		Scene MovieScene = new Scene(MovieScrollPane);
		return MovieScene;
	}
	
// The method below only set Pane background
	public void setPaneBackground(Pane pane, String ImageDirectory){
		String img1_url = ImageDirectory;
		Image img1 = new Image(img1_url,2000,1500, false,false);
        BackgroundImage bgImg= new BackgroundImage(img1,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bgImg);
        pane.setBackground(background);
	}

// The method below only set BorderPane background
	public void setBorderPaneBackground(BorderPane borderpane, String ImageDirectory){
		String img1_url = ImageDirectory;
		Image img1 = new Image(img1_url,2000,1500, false,false);
        BackgroundImage bgImg= new BackgroundImage(img1,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bgImg);
        borderpane.setBackground(background);
	}

	//The method below set the first row of the interface
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
	      MovieBackButton.setLayoutX(1700);
	      MovieBackButton.setLayoutY(120); 
	      
	      MovieBackButton.setOnAction(e -> {
	    	  try {
	    			Dashboard dashboard = new Dashboard(); // Create a dashboard object from dashboard class
					stage.setScene(dashboard.getDashboard(stage)); // change to dashboard scene
				} catch (Exception e1) {
					System.out.println("Scene not found");
				}
	      });
	        
	      TopMoviePane.getChildren().add(MovieBackButton);
	                
	      MovieBorderPane.setTop(TopMoviePane);			
	}
	
	public void setTopAddMovieBorderPane(BorderPane MovieBorderPane){
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
	      Text MovieName = new Text("Add Movies");
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
	        
	                   
	      MovieBorderPane.setTop(TopMoviePane);			
	}

	public void setTopDeleteMovieBorderPane(BorderPane MovieBorderPane){
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
	      Text MovieName = new Text("Delete Movies");
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
	        
	                   
	      MovieBorderPane.setTop(TopMoviePane);			
	}
	
	public void setTopEditMovieBorderPane(BorderPane MovieBorderPane){
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
	      Text MovieName = new Text("Edit Movies");
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
	        
	                   
	      MovieBorderPane.setTop(TopMoviePane);			
	}

	
	public void setLeftMovieBorderPane(BorderPane MovieBorderPane){
		 Pane LeftsidePane = new Pane();
		 LeftsidePane.setPadding(new Insets(100,100,125,90));
	     MovieBorderPane.setLeft(LeftsidePane);
	}
	
	
	public void setRightMovieBorderPane(BorderPane MovieBorderPane){
        Pane RightSidePane = new Pane();
        RightSidePane.setPadding(new Insets(100,100,125,90));
        MovieBorderPane.setRight(RightSidePane);
	}
	
	public static void AddMovie( String MovieTextFileDirectory, String MovieID, String MovieName, String Time1,String Time2, String Time3,String Time4, String Time5, String Time6, String Hall1, String Hall2, String Hall3, String Hall4, String Hall5, String Hall6,String MovieImageFileDirectory) throws IOException{
		PrintWriter pw = new PrintWriter(new FileOutputStream( new File(MovieTextFileDirectory),  true /* append = true */));
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
		
		pw.println("[" + MovieID + "]" + "," + MovieName + ","+ Time1 +"," + Time2 + "," + Time3 + "," + Time4 + "," + Time5 + "," + Time6 + "," + Hall1 + "," + Hall2 + "," + Hall3 + "," + Hall4 + "," + Hall5 + "," + Hall6 + "," + MovieImageFileDirectory );	
		pw.close();
	}
	
	
	//The method below set the centre of the borderpane
	public void setCenterBorderPane(BorderPane MovieBorderPane, Stage stage){
    	Stage EditMovieStage = new Stage();

		VBox MovieCenterVBox = new VBox();		
		HBox MovieTypeButtonHBox = new HBox();
		Pane MovieTypeButtonPane = new Pane();
	      

		String BlueBoxImageDirectory = "MovieInterfaceResource/BlueBox.png";
		Image BlueBoxImage = new Image(BlueBoxImageDirectory,1528,864, false, false);
		BackgroundImage BlueBoxBackgroundImage = new BackgroundImage(BlueBoxImage,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background BlueBoxBackground = new Background(BlueBoxBackgroundImage);
		MovieCenterVBox.setBackground(BlueBoxBackground);
	        
	        
		Button AiringMovieInterfaceButton = new Button("Airing Movie");
		AiringMovieInterfaceButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
		AiringMovieInterfaceButton.setPrefHeight(150);
		AiringMovieInterfaceButton.setPrefWidth(300);
	      
		AiringMovieInterfaceButton.setOnAction(e->{
			MovieTableView(MovieTypeButtonPane, "MovieDataSource/Movie.txt");	
		});
		
		Button ComingSoonMovieInterfaceButton = new Button("Coming Soon");
		ComingSoonMovieInterfaceButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
		ComingSoonMovieInterfaceButton.setPrefHeight(150);
		ComingSoonMovieInterfaceButton.setPrefWidth(300);	

		ComingSoonMovieInterfaceButton.setOnAction(e->{
			ComingSoonMovieTableView(MovieTypeButtonPane, "MovieDataSource/ComingSoonMovie.txt");
		});
		

		MovieTypeButtonHBox.getChildren().add(AiringMovieInterfaceButton);
		MovieTypeButtonHBox.getChildren().add(ComingSoonMovieInterfaceButton);
		MovieTypeButtonPane.getChildren().add(MovieTypeButtonHBox);
	        
	     
	
			MovieTableView(MovieTypeButtonPane, "MovieDataSource/Movie.txt");
		
		   Button AddMovieButton = new Button("Add Movie");
	        Button EditMovieButton = new Button("Edit Movie");
	        Button DeleteMovieButton = new Button("DeleteMovieButton");
	        AddMovieButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
	        EditMovieButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
	        DeleteMovieButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
	        
	        HBox MovieFunctionHBox = new HBox();
	        MovieFunctionHBox.setSpacing(300);
	        MovieFunctionHBox.getChildren().add(AddMovieButton);
	        MovieFunctionHBox.getChildren().add(EditMovieButton);
	        MovieFunctionHBox.getChildren().add(DeleteMovieButton);
	        MovieFunctionHBox.setLayoutX(200);
	        MovieFunctionHBox.setLayoutY(700);
	        MovieTypeButtonPane.getChildren().add(MovieFunctionHBox);
	        AddMovieButton.setOnAction(e->{
	        	
	        
	        BorderPane AddMovieBorderPane = new BorderPane();	
	    	Image AddMovieImage = new Image("MovieInterfaceResource/Background.jpg",2000,1500, false,false);
	        BackgroundImage AddMovieBackgroundImage= new BackgroundImage(AddMovieImage,
	                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        Background AddMovieBackground = new Background(AddMovieBackgroundImage);
	        GridPane AddMovieGridPane = new GridPane();
	        Scene AddMovieScene = new Scene(AddMovieBorderPane);
	        Stage AddMovieStage = new Stage();
	        AddMovieBorderPane.setBackground(AddMovieBackground);
	        AddMovieGridPane.setVgap(10);
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
	        AddMovieConfirmButton.setPrefSize(100, 50);
	        AddMovieGridPane.add(AddMovieConfirmButton, 8, 8);
	        Button MovieImageDirectoryButton = new Button("Movie Image Directory");
	        MovieImageDirectoryButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
          			FileChooser fileChooser = new FileChooser();
	            			File selectedFile = fileChooser.showOpenDialog(null);
	            			if (selectedFile != null) {
	            				MovieImageDirectoryButton.setText(selectedFile.getName());
	            			}
	            			else {
	            				MovieImageDirectoryButton.setText("File selection cancelled.");
	            			}
	            }});

	    	ComboBox <String>MovieFileComboBox = new ComboBox<String>();
			MovieFileComboBox.getItems().add("MovieDataSource/Movie.txt");
			MovieFileComboBox.getItems().add("MovieDataSource/ComingSoonMovie.txt");

			MovieFileComboBox.setPromptText("Please select the type of movie to delete");
			
	        Label Movie = new Label("Type of Text Movie");
	       	Movie.setStyle(" -fx-font-size: 20; -fx-text-fill: #ffffff;");
	   	 	AddMovieGridPane.add(MovieFileComboBox, 7, 8);
	        AddMovieGridPane.add(Movie, 6, 8);
	        AddMovieConfirmButton.setOnAction(d->{
	        	try {
	        		AddMovie(MovieFileComboBox.getValue(), AddMovieTextField[0].getText(), AddMovieTextField[1].getText(), AddMovieTextField[2].getText(), AddMovieTextField[3].getText(), AddMovieTextField[4].getText(), AddMovieTextField[5].getText(), AddMovieTextField[6].getText(), AddMovieTextField[7].getText(), AddMovieTextField[8].getText(), AddMovieTextField[9].getText(), AddMovieTextField[10].getText(), AddMovieTextField[11].getText(), AddMovieTextField[12].getText(),AddMovieTextField[13].getText(), MovieImageDirectoryButton.getText());
	        	}catch(IOException g){
	        		g.printStackTrace();
	        	}
	        	AddMovieStage.close();
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

	        AddMovieGridPane.setPadding(new Insets(50,50,50,150));
	        AddMovieGridPane.setLayoutX(400);
	        AddMovieGridPane.setLayoutY(200);
			AddMovieBorderPane.setCenter(AddMovieGridPane);
			setTopAddMovieBorderPane(AddMovieBorderPane);
	        AddMovieStage.setWidth(990);
	        AddMovieStage.setHeight(540);
	        AddMovieStage.setScene(AddMovieScene);
	        AddMovieStage.setTitle("Add Movie");
	        AddMovieStage.show();
	        });
	        	
	
	        MovieCenterVBox.getChildren().add(MovieTypeButtonPane);   
	        MovieBorderPane.setCenter(MovieCenterVBox);		        
		
	        DeleteMovieButton.setOnAction(e->{
			BorderPane DeleteMovieBorderPane = new BorderPane();
			setTopDeleteMovieBorderPane(DeleteMovieBorderPane);
		
			Image DeleteMovieImage = new Image("MovieInterfaceResource/Background.jpg",2000,1500, false,false);
			BackgroundImage DeleteMovieBackgroundImage= new BackgroundImage(DeleteMovieImage,
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background DeleteMovieBackground = new Background(DeleteMovieBackgroundImage);
			    
			DeleteMovieBorderPane.setBackground(DeleteMovieBackground);
			Label DeleteIDLabel = new Label("Delete ID");
			DeleteIDLabel.setStyle(" -fx-font-size: 20; -fx-text-fill: #ffffff;");
			GridPane DeleteMovieGridPane = new GridPane();
			DeleteMovieGridPane.add(DeleteIDLabel, 0, 0);
			TextField DeleteIDTextField = new TextField();
			DeleteMovieGridPane.add(DeleteIDTextField, 1, 0);

			Label MovieTextLabel = new Label("Choose section to edit:");
			MovieTextLabel.setStyle(" -fx-font-size: 20; -fx-text-fill: #ffffff;");
			DeleteMovieGridPane.add(MovieTextLabel, 0, 1);
			        
			ComboBox <String>MovieFileComboBox = new ComboBox<String>();
			MovieFileComboBox.getItems().add("MovieDataSource/Movie.txt");
			MovieFileComboBox.getItems().add("MovieDataSource/ComingSoonMovie.txt");

			MovieFileComboBox.setPromptText("Please select the type of movie to delete");
			
			DeleteMovieGridPane.add(MovieFileComboBox,1, 1);
       
			Label Notice = new Label();
			DeleteMovieGridPane.add(Notice, 3, 0);
			Notice.setStyle(" -fx-font-size: 20; -fx-text-fill: #ffffff;");
			Button DeleteConfirm = new Button("Confirm");
			DeleteMovieGridPane.add(DeleteConfirm, 4, 4);
			        
			DeleteMovieBorderPane.setCenter(DeleteMovieGridPane);
			        
			Scene DeleteMovieScene = new Scene(DeleteMovieBorderPane);
			Stage DeleteMovieStage = new Stage();

			DeleteConfirm.setOnAction(l->{
				if(DeleteIDTextField.getText().equals("")){
					Notice.setText("The value is empty delete fail");
				}
				else {
					try{
						DeleteMovie(MovieFileComboBox.getValue(), DeleteIDTextField.getText());
						Notice.setText("Delete Success");
						DeleteMovieStage.close();
					}
					catch(IOException e2){
						e2.printStackTrace();
					}
				}
			});
			DeleteMovieStage.setScene(DeleteMovieScene);
			DeleteMovieStage.show();
	        });	
		
	        EditMovieButton.setOnAction(c->{
	        	BorderPane EditMovieBorderPane = new BorderPane();
	        	setTopEditMovieBorderPane(EditMovieBorderPane);
	        	
	        	Image EditMovieImage = new Image("MovieInterfaceResource/Background.jpg",2000,1500, false,false);
	        	BackgroundImage EditMovieBackgroundImage= new BackgroundImage(EditMovieImage,
	        			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        	Background EditMovieBackground = new Background(EditMovieBackgroundImage);
		    
	        	GridPane EditMovieGridPane = new GridPane();
	        	EditMovieGridPane.setPadding(new Insets(50,0,0,0));
	        	Label EditMovieLabel[] = new Label[15];
	        	TextField EditMovieTextField[] = new TextField[15];
	        	EditMovieGridPane.setHgap(30);
	        	EditMovieGridPane.setVgap(20);

	        	for(int i=0; i< EditMovieLabel.length; i++){
	        		EditMovieLabel[i] = new Label();
	        		EditMovieLabel[i].setStyle(" -fx-font-size: 20; -fx-text-fill: #ffffff;");
	        		EditMovieTextField[i] = new TextField();
	        		if(i<7){
	        			EditMovieGridPane.add(EditMovieLabel[i], 1, i);
	        			EditMovieGridPane.add(EditMovieTextField[i], 2, i);
	        		}
	        		else {
	        			EditMovieGridPane.add(EditMovieLabel[i], 3, i-7);
	        			EditMovieGridPane.add(EditMovieTextField[i], 4, i-7);
	        		}
	        	}
	        	EditMovieLabel[0].setText("Movie ID");
	        	EditMovieLabel[1].setText("Movie Name");
	        	EditMovieLabel[2].setText("Movie Time 1");
	        	EditMovieLabel[3].setText("Movie Time 2");
	        	EditMovieLabel[4].setText("Movie Time 3");
	        	EditMovieLabel[5].setText("Movie Time 4");
	        	EditMovieLabel[6].setText("Movie Time 5");
	        	EditMovieLabel[7].setText("Movie Time 6");
	        	EditMovieLabel[8].setText("Movie Hall 1");
	        	EditMovieLabel[9].setText("Movie Time 2");
	        	EditMovieLabel[10].setText("Movie Time 3");
	        	EditMovieLabel[11].setText("Movie Time 4");
	        	EditMovieLabel[12].setText("Movie Time 5");
	        	EditMovieLabel[13].setText("Movie Time 6");
	        	EditMovieLabel[14].setText("Movie Image File Directory");
			
	    
	        	Button EditMovieConfirmButton = new Button("Confirm");
	        	Button EditMovieExitButton = new Button("Exit");
	        	EditMovieGridPane.add(EditMovieConfirmButton, 1, 10);
	        	EditMovieGridPane.add(EditMovieExitButton, 2, 10);
	     
	
    	
	        	
	        	EditMovieExitButton.setOnAction(p->{
	        		EditMovieStage.close();
	        	});
	        	
	        	
	        	VBox EditMovieVBox = new VBox();
	        	HBox EditMovieHBox = new HBox(10);
			
			
	        	ComboBox <String>EditMovieFileComboBox = new ComboBox<String>();
	        	EditMovieFileComboBox.getItems().add("MovieDataSource/Movie.txt");
	        	EditMovieFileComboBox.getItems().add("MovieDataSource/ComingSoonMovie.txt");
	        	EditMovieFileComboBox.setPromptText("Please select the type of movie to Edit");
	        
	        	Label TextFileLabel = new Label("Movies to edit");
	        	TextFileLabel.setStyle(" -fx-font-size: 20; -fx-text-fill: #ffffff;");

	        	Button MovieSearch = new Button("Search");
	        	EditMovieHBox.getChildren().add(TextFileLabel);
	        	EditMovieHBox.getChildren().add(EditMovieFileComboBox);
	        	EditMovieHBox.getChildren().add(MovieSearch);
	        
	        	EditMovieVBox.getChildren().add(EditMovieHBox);
	        	EditMovieVBox.getChildren().add(EditMovieGridPane);
	        
	        	Label StatusLabel = new Label();
	        	StatusLabel.setStyle(" -fx-font-size: 20; -fx-text-fill: #ffffff;");
	        	EditMovieHBox.getChildren().add(StatusLabel);
	        	
	        	EditMovieConfirmButton.setOnAction(p->{
	        		try {
						DeleteMovie(EditMovieFileComboBox.getValue(), EditMovieTextField[0].getText());
						AddMovie(EditMovieFileComboBox.getValue(), EditMovieTextField[0].getText(),EditMovieTextField[1].getText(), EditMovieTextField[2].getText(),EditMovieTextField[3].getText(), EditMovieTextField[4].getText(),EditMovieTextField[5].getText(),EditMovieTextField[6].getText(), EditMovieTextField[7].getText(), EditMovieTextField[8].getText(), EditMovieTextField[9].getText(), EditMovieTextField[10].getText(),EditMovieTextField[11].getText(), EditMovieTextField[12].getText(), EditMovieTextField[13].getText(),EditMovieTextField[14].getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		EditMovieStage.close();
	        	});
	    	        	
	        	
	        	
	        	MovieSearch.setOnAction(b->{
	        		List <String> MovieData = new ArrayList<String>();
	        		List<List<String>> lists = null;
	    		
	        		try{
	        			MovieData = ReadFunction(EditMovieFileComboBox.getValue());
	        			lists = split(MovieData, 21);
	        		}
	        		catch(FileNotFoundException e){
	        			e.printStackTrace();
	        		}
	        		catch(Exception e){
	        			e.printStackTrace();			
	        		}	        	
	        		
	        		for(int i=0;i<lists.size();i++){
	        			for(int x=0; x<lists.get(i).size()/21; x++){
	        				if(EditMovieTextField[0].getText().equals(lists.get(i).get(x))){
	        					System.out.println(EditMovieTextField[0].getText().equals(lists.get(i).get(x)));
		    	        		EditMovieTextField[0].setText(lists.get(i).get(x));
		    	        		EditMovieTextField[1].setText(lists.get(i).get(x+1));
		    	        		EditMovieTextField[2].setText(lists.get(i).get(x+2) + "-" +lists.get(i).get(x+3));
		    	        		EditMovieTextField[3].setText(lists.get(i).get(x+4) + "-" + lists.get(i).get(x+5));
		    	        		EditMovieTextField[4].setText(lists.get(i).get(x+6) + "-" + lists.get(i).get(x+7));
		    	        		EditMovieTextField[5].setText(lists.get(i).get(x+8) + "-" + lists.get(i).get(x+9));
		    	        		EditMovieTextField[6].setText(lists.get(i).get(x+10) + "-" + lists.get(i).get(x+11));
		    	        		EditMovieTextField[7].setText(lists.get(i).get(x+12) + "-" + lists.get(i).get(x+13));
		    	        		EditMovieTextField[8].setText(lists.get(i).get(x+14));
		    	        		EditMovieTextField[9].setText(lists.get(i).get(x+15));
		    	        		EditMovieTextField[10].setText(lists.get(i).get(x+16));
		    	        		EditMovieTextField[11].setText(lists.get(i).get(x+17));
		    	        		EditMovieTextField[12].setText(lists.get(i).get(x+18));
		    	        		EditMovieTextField[13].setText(lists.get(i).get(x+19));
		    	        		EditMovieTextField[14].setText(lists.get(i).get(x+20));	        					
		        				StatusLabel.setText("The ID is found");
		    	        		break;
	        				}
	        				if(EditMovieTextField[0].getText().equals("")){
	        					System.out.println(EditMovieTextField[0].getText().equals(lists.get(i).get(x)));
		    	        		EditMovieTextField[0].setText(lists.get(i).get(x));
		    	        		EditMovieTextField[1].setText(lists.get(i).get(x+1));
		    	        		EditMovieTextField[2].setText(lists.get(i).get(x+2) + "-" +lists.get(i).get(x+3));
		    	        		EditMovieTextField[3].setText(lists.get(i).get(x+4) + "-" + lists.get(i).get(x+5));
		    	        		EditMovieTextField[4].setText(lists.get(i).get(x+6) + "-" + lists.get(i).get(x+7));
		    	        		EditMovieTextField[5].setText(lists.get(i).get(x+8) + "-" + lists.get(i).get(x+9));
		    	        		EditMovieTextField[6].setText(lists.get(i).get(x+10) + "-" + lists.get(i).get(x+11));
		    	        		EditMovieTextField[7].setText(lists.get(i).get(x+12) + "-" + lists.get(i).get(x+13));
		    	        		EditMovieTextField[8].setText(lists.get(i).get(x+14));
		    	        		EditMovieTextField[9].setText(lists.get(i).get(x+15));
		    	        		EditMovieTextField[10].setText(lists.get(i).get(x+16));
		    	        		EditMovieTextField[11].setText(lists.get(i).get(x+17));
		    	        		EditMovieTextField[12].setText(lists.get(i).get(x+18));
		    	        		EditMovieTextField[13].setText(lists.get(i).get(x+19));
		    	        		EditMovieTextField[14].setText(lists.get(i).get(x+20));
		        				StatusLabel.setText("The ID doesn't exist. Therefore will Display the final");
		        				break;
	        				}
	        			}
	        		}
	        		
	        		
	        	});
					
		
	        	EditMovieBorderPane.setCenter(EditMovieVBox);

	        	Pane pane1 = new Pane();
	        	pane1.setPadding(new Insets(0,50,0,0));
	        	EditMovieBorderPane.setLeft(pane1);
		    
		    
	        	EditMovieBorderPane.setBackground(EditMovieBackground);
	        	Scene EditMovieScene = new Scene(EditMovieBorderPane);
	        	EditMovieStage.setScene(EditMovieScene);
	        	EditMovieStage.show();		        
	        });
	}
	
	public static <T extends Object> List<List<T>> split(List<T> list, int targetSize) {
		List<List<T>> lists = new ArrayList<List<T>>();
	    for (int i = 0; i < list.size(); i += targetSize) {
	        lists.add(list.subList(i, Math.min(i + targetSize, list.size())));
	    }
	    return lists;
	}
	
	// The mehtod below read the file and return the entire data in list
	public List<String> ReadFunction(String FileDirectory) throws FileNotFoundException{
		File MovieFile = new File(FileDirectory);
		Scanner readMovieFile = new Scanner(MovieFile);
		String Linedata =null;
		String[] MovieDataTemp = null;
		List <String> MovieIDTemp = new ArrayList<String>();
		
		while(readMovieFile.hasNext()){
			Linedata = readMovieFile.nextLine();
			MovieDataTemp = Linedata.split("-|\\,");

			for(int i=0; i<MovieDataTemp.length;i++){
				for(int  b=0; b<MovieDataTemp[i].length(); b++){
					if(MovieDataTemp[i].charAt(b) == '['|| MovieDataTemp[i].charAt(b) == '['){
						MovieDataTemp[i]=MovieDataTemp[i].replace("[", "");
						MovieDataTemp[i]=MovieDataTemp[i].replace("]", "");
					}
				}
				MovieIDTemp.add(MovieDataTemp[i]);
			}
		}
		readMovieFile.close();
		return MovieIDTemp;
	}
	

	
	public void DeleteMovie(String MovieFileDirectory, String MovieID) throws IOException{
		List <String> MovieData = new ArrayList<String>();
		List<List<String>> lists = null;
		
		try{
			MovieData = ReadFunction(MovieFileDirectory);
			lists = split(MovieData, 21);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		System.out.println(lists.size());
		PrintWriter pw = new PrintWriter(new File(MovieFileDirectory));		
		for(int i=0; i<lists.size(); i++){
			for(int b=0; b<lists.get(i).size()/21; b++){
				System.out.println(MovieID);
				System.out.println(lists.get(i));
				System.out.println(lists.get(i).get(b).equals(MovieID));
				if(lists.get(i).get(b).equals(MovieID)){
					if(MovieID.equals("")){
						pw.write("");
					}
					break;
				}
				else{
					System.out.println("s");
					String time = new String(lists.get(i).get(b+2) + "-" + lists.get(i).get(b+3) + "," + lists.get(i).get(b+4) + "-" + lists.get(i).get(b+5) + "," + lists.get(i).get(b+6) + "-" + lists.get(i).get(b+7)+"," + lists.get(i).get(b+8) + "-" + lists.get(i).get(b+9) + "," +lists.get(i).get(b+10) + "-" + lists.get(i).get(b+11) + "," + lists.get(i).get(b+12) + "-" + lists.get(i).get(b+13) + ",");
					String hall = new String(lists.get(i).get(b+14) + "," + lists.get(i).get(b+15) + "," + lists.get(i).get(b+16) + "," + lists.get(i).get(b+17) + "," + lists.get(i).get(b+18) + "," + lists.get(i).get(b+19) );
//	        		WriteMovie(MovieFileDirectory, ,lists.get(i).get(b+1), time, hall, lists.get(i).get(b+20));										
					pw.write("[" + lists.get(i).get(b) + "]" + "," + lists.get(i).get(b+1) + ","+ time + hall+ "," + lists.get(i).get(b+20) + "\n");	
				}
			}
		}
		pw.close();

	}

	//The method below create table view by reading the resoruce txt file
	public void MovieTableView(Pane MovieTypePane, String Directory){
		List <String> MovieData = new ArrayList<String>();
		List<List<String>> lists = null;
		
		try{
			MovieData = ReadFunction(Directory);
			lists = split(MovieData, 21);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		List<Movie> MovieCollection = new ArrayList<Movie>();
		for(int i=0; i<lists.size(); i++){
			for(int b=0; b<lists.get(i).size()/17; b++){
				String[] MovieStartTime = new String[6];
				MovieStartTime[0] = lists.get(i).get(b+2);
				MovieStartTime[1] = lists.get(i).get(b+4);
				MovieStartTime[2] = lists.get(i).get(b+6);
				MovieStartTime[3] = lists.get(i).get(b+8);
				MovieStartTime[4] = lists.get(i).get(b+10);
				MovieStartTime[5] = lists.get(i).get(b+12);
				
				String[] MovieEndTime = new String[6];
				MovieEndTime[0] = lists.get(i).get(b+3);
				MovieEndTime[1] = lists.get(i).get(b+5);
				MovieEndTime[2] = lists.get(i).get(b+7);
				MovieEndTime[3] = lists.get(i).get(b+9);
				MovieEndTime[4] = lists.get(i).get(b+11);
				MovieEndTime[5] = lists.get(i).get(b+13);
				
				String[] MovieHall = new String[6];
				MovieHall[0] = lists.get(i).get(b+14);
				MovieHall[1] = lists.get(i).get(b+15);
				MovieHall[2] = lists.get(i).get(b+16);
				MovieHall[3] = lists.get(i).get(b+17);
				MovieHall[4] = lists.get(i).get(b+18);
				MovieHall[5] = lists.get(i).get(b+19);
				
				for (int k=0; k<MovieEndTime.length; k++){
					MovieCollection.add(new Movie(lists.get(i).get(b), lists.get(i).get(b+1), MovieStartTime[k], MovieEndTime[k], MovieHall[k],lists.get(i).get(b+20)));
				}
			}
		}
	
		TableView <Movie>MovieTableView = new TableView<Movie>();
		MovieTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		MovieTableView.setEditable(true);
		TableColumn<Movie, String> MovieID = new TableColumn<Movie, String>("Movie ID");
		TableColumn<Movie, String> MovieName = new TableColumn<Movie, String>("Movie Name");
		TableColumn<Movie, String> MovieTimeStart = new TableColumn<Movie, String>("Time Start");
		TableColumn<Movie, String> MovieTimeEnd = new TableColumn<Movie, String>("Time End");
		TableColumn<Movie, String> MovieHallTableColumn = new TableColumn<Movie, String>("Hall");
		TableColumn<Movie, String> MovieImageDirectory = new TableColumn<Movie, String>("Movie Image Directory");
		MovieTableView.getColumns().addAll(MovieID,MovieName, MovieTimeStart, MovieTimeEnd, MovieHallTableColumn, MovieImageDirectory);

		MovieID.setCellValueFactory(new PropertyValueFactory<>("MovieID"));
		MovieName.setCellValueFactory(new PropertyValueFactory<>("MovieName"));
		MovieTimeStart.setCellValueFactory(new PropertyValueFactory<>("MovieStartTime"));
		MovieTimeEnd.setCellValueFactory(new PropertyValueFactory<>("MovieEndTime"));
		MovieHallTableColumn.setCellValueFactory(new PropertyValueFactory<>("MovieHall"));
		MovieImageDirectory.setCellValueFactory(new PropertyValueFactory<>("MovieDirectory"));
		 
	
		 ObservableList<Movie> data = FXCollections.observableArrayList();
		 for(int i=0;i<MovieCollection.size(); i++){			 
		 data.add(MovieCollection.get(i));
		}	    
		 
		 MovieTableView.setItems(data);		 
		MovieTableView.setLayoutX(400);
		MovieTableView.setLayoutY(250);
		MovieTableView.setPrefHeight(400);
		MovieTableView.setPrefWidth(800);
		MovieTypePane.getChildren().add(MovieTableView);
	}
	
	public void ComingSoonMovieTableView(Pane MovieTypePane, String Directory){
	
		File ComingSoonMovieDataFile = new File(Directory);
		Scanner read = null;
		try {
			read = new Scanner(ComingSoonMovieDataFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String Dataline = null;
		String[] ComingSoonData = null;
		ArrayList <String>RawMovieData = new ArrayList<String>();
		
		
		while (read.hasNextLine()){
			Dataline = read.nextLine();
			ComingSoonData = Dataline.split(",");
			for (int i=0; i<ComingSoonData.length;i++){
				RawMovieData.add(ComingSoonData[i]);				
			}
		}
		
		
		
		TableView <ComingSoonMovie>MovieTableView = new TableView<ComingSoonMovie>();
		MovieTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		MovieTableView.setEditable(true);
		TableColumn<ComingSoonMovie, String> MovieName = new TableColumn<ComingSoonMovie, String>("Movie Name");
		TableColumn<ComingSoonMovie, String> MovieReleaseDay = new TableColumn<ComingSoonMovie, String>("Release Day");
		TableColumn<ComingSoonMovie, String> MovieReleaseMonth = new TableColumn<ComingSoonMovie, String>("Release Month");
		
		MovieTableView.getColumns().addAll(MovieName, MovieReleaseDay, MovieReleaseMonth);

		MovieName.setCellValueFactory(new PropertyValueFactory<>("MovieName"));
		MovieReleaseDay.setCellValueFactory(new PropertyValueFactory<>("ReleaseDay"));
		MovieReleaseMonth.setCellValueFactory(new PropertyValueFactory<>("ReleaseMonth"));
		 
		 ObservableList<ComingSoonMovie> data = FXCollections.observableArrayList();
		 
		 System.out.println(RawMovieData.size());
		 for(int i=0;i<(RawMovieData.size()-1)/3; i++){
			data.add(new ComingSoonMovie(RawMovieData.get(i), RawMovieData.get(i+1), RawMovieData.get(i+2)));
			
		 }
		
		MovieTableView.setItems(data);		 
		MovieTableView.setLayoutX(400);
		MovieTableView.setLayoutY(250);
		MovieTableView.setPrefHeight(400);
		MovieTableView.setPrefWidth(800);
		MovieTypePane.getChildren().add(MovieTableView);
	}
	
	
}
