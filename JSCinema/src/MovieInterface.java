
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
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
		setBackground(MovieBorderPane);	
		setTopMovieBorderPane(MovieBorderPane, MovieStage);
		setCenterBorderPane(MovieBorderPane, MovieStage);		
		
		
		ScrollPane MovieScrollPane = new ScrollPane();
	    MovieScrollPane.setFitToWidth(true);
	//    MovieScrollPane.setFitToHeight(true);
	    MovieScrollPane.setContent(MovieBorderPane);
		
		Scene MovieScene = new Scene(MovieScrollPane);
		MovieScene.getStylesheets().add("DeleteCSS.css");
		return MovieScene;
	}
	

	public void setBackground(BorderPane borderpane){
		Image MovieImage = new Image("MovieInterfaceResource/Background.jpg",1440,960, false,false);
        BackgroundImage MovieBackgroundImage= new BackgroundImage(MovieImage,
        		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background MovieBackground = new Background(MovieBackgroundImage);
        borderpane.setBackground(MovieBackground);
	}
	
	public void setBackground(Pane pane){
		Image MovieImage = new Image("MovieInterfaceResource/Background.jpg",1440,960, false,false);
        BackgroundImage MovieBackgroundImage= new BackgroundImage(MovieImage,
        		BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background MovieBackground = new Background(MovieBackgroundImage);
        pane.setBackground(MovieBackground);
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
		Image MovieTittleBlackBoxImage = new Image(MovieTittleBlackBoxStringDirectory,1440,398, false, false);
		BackgroundImage MovieTittleBlackBoxBackgroundImage = new BackgroundImage(MovieTittleBlackBoxImage,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background MovieTittleBlackBoxBackground = new Background(MovieTittleBlackBoxBackgroundImage);
		TopMovieHBox.setBackground(MovieTittleBlackBoxBackground);
		TopMovieHBox.setPrefSize(1440, 200);
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
		MovieBackButton.setPrefHeight(200);
		MovieBackButton.setPrefWidth(200);
		MovieBackButton.setLayoutX(1200);
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
	

	


	//The method below set the centre of the borderpane
	public void setCenterBorderPane(BorderPane MovieBorderPane, Stage stage){

		VBox MovieCenterVBox = new VBox();		
		HBox MovieTypeButtonHBox = new HBox();
		Pane MovieTypeButtonPane = new Pane();
	      

		String BlueBoxImageDirectory = "MovieInterfaceResource/BlueBox.png";
		Image BlueBoxImage = new Image(BlueBoxImageDirectory,1100,700, false, false);
		BackgroundImage BlueBoxBackgroundImage = new BackgroundImage(BlueBoxImage,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background BlueBoxBackground = new Background(BlueBoxBackgroundImage);
		MovieCenterVBox.setBackground(BlueBoxBackground);
	        
	        
		Button AiringMovieInterfaceButton = new Button("Airing Movie");
		AiringMovieInterfaceButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
		AiringMovieInterfaceButton.setPrefHeight(100);
		AiringMovieInterfaceButton.setPrefWidth(300);     
		AiringMovieInterfaceButton.setOnAction(e->{
			MovieTableView(MovieTypeButtonPane, "MovieDataSource/Movie.txt");	
		});
		
		Button ComingSoonMovieInterfaceButton = new Button("Coming Soon");
		ComingSoonMovieInterfaceButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
		ComingSoonMovieInterfaceButton.setPrefHeight(100);
		ComingSoonMovieInterfaceButton.setPrefWidth(300);	
		ComingSoonMovieInterfaceButton.setOnAction(e->{
			ComingSoonMovieTableView(MovieTypeButtonPane, "MovieDataSource/ComingSoonMovie.txt");
		});
		

		MovieTypeButtonHBox.getChildren().add(AiringMovieInterfaceButton);
		MovieTypeButtonHBox.getChildren().add(ComingSoonMovieInterfaceButton);
		MovieTypeButtonPane.getChildren().add(MovieCenterVBox);
	    MovieTypeButtonPane.getChildren().add(MovieTypeButtonHBox);    	     
		MovieTableView(MovieTypeButtonPane, "MovieDataSource/Movie.txt");
		setBackground(MovieTypeButtonPane);
	
		Button AddMovie = new Button("Add Movie");
		Button EditMovie = new Button("Edit Movie");
		Button DeleteMovie = new Button("Delete Movie");
		
		AddMovie.setOnAction(e->{			
			Add add = new Add();
			stage.setScene(add.GenerateAddPage(stage));
		});
		MovieTypeButtonPane.getChildren().add(AddMovie);
		AddMovie.setLayoutX(200);
		AddMovie.setLayoutY(600);

		EditMovie.setOnAction(e->{
			Edit edit = new Edit();
			stage.setScene(edit.GenerateEditPage(stage));
		});
		
		MovieTypeButtonPane.getChildren().add(EditMovie);
		EditMovie.setLayoutX(600);
		EditMovie.setLayoutY(600);
		
		DeleteMovie.setOnAction(e->{
			Delete delete = new Delete();
			stage.setScene(delete.GenerateDeletePage(stage));
		});
		
		MovieTypeButtonPane.getChildren().add(DeleteMovie);
		DeleteMovie.setLayoutX(900);
		DeleteMovie.setLayoutY(600);
		
		MovieBorderPane.setCenter(MovieTypeButtonPane);
	        
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
		MovieTableView.setLayoutY(150);
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
		List <String>RawMovieData = new ArrayList<String>();
		
		List<List<String>> lists = null;
		
		
		while (read.hasNextLine()){
			Dataline = read.nextLine();
			ComingSoonData = Dataline.split(",");
			for (int i=0; i<ComingSoonData.length;i++){
				RawMovieData.add(ComingSoonData[i]);				
			}
		}
		
		lists = split(RawMovieData, 5);
	
		
		TableView <ComingSoonMovie>MovieTableView = new TableView<ComingSoonMovie>();

		MovieTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		MovieTableView.setEditable(true);
		
		TableColumn<ComingSoonMovie, String> MovieName = new TableColumn<ComingSoonMovie, String>("Movie Name");
		MovieName.setCellValueFactory(new PropertyValueFactory<ComingSoonMovie, String>("MovieName"));
		
		TableColumn<ComingSoonMovie, String> MovieReleaseDay = new TableColumn<ComingSoonMovie, String>("Release Day");
		MovieReleaseDay.setCellValueFactory(new PropertyValueFactory<ComingSoonMovie, String>("ReleaseDay"));
		
		TableColumn<ComingSoonMovie, String> MovieReleaseMonth = new TableColumn<ComingSoonMovie, String>("Release Month");
		MovieReleaseMonth.setCellValueFactory(new PropertyValueFactory<ComingSoonMovie, String>("ReleaseMonth"));

		
		TableColumn <ComingSoonMovie, String> MovieDescription = new TableColumn <ComingSoonMovie, String>("Movie Description");
		MovieDescription.setCellValueFactory(new PropertyValueFactory<ComingSoonMovie, String>("MovieDescription"));

		
		TableColumn<ComingSoonMovie, String> MovieImageDirectory = new TableColumn<ComingSoonMovie, String>("Movie Image Directory");
		MovieImageDirectory.setCellValueFactory(new PropertyValueFactory<ComingSoonMovie, String>("MovieImageDirectory"));

		
		MovieTableView.getColumns().addAll(MovieName, MovieReleaseDay, MovieReleaseMonth, MovieDescription, MovieImageDirectory);		
		 ObservableList<ComingSoonMovie> data = FXCollections.observableArrayList();
		 
			
		 for(int i=0;i<lists.size(); i++){
			 for (int b=0; b<lists.get(i).size()/5; b++){
				 data.add(new ComingSoonMovie(lists.get(i).get(b), lists.get(i).get(b+1), lists.get(i).get(b+2),lists.get(i).get(b+4), lists.get(i).get(b+3)));
			 }
		 }
		 
		
				 
		MovieTableView.setItems(data);		 
		MovieTableView.setLayoutX(400);
		MovieTableView.setLayoutY(150);
		MovieTableView.setPrefHeight(400);
		MovieTableView.setPrefWidth(800);
		MovieTypePane.getChildren().add(MovieTableView);
	}
	
	
}
