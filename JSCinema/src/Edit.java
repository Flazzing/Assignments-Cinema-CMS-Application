
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
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
import javafx.stage.Stage;

public class Edit extends Application{

	public static void main(String[]args){
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		GenerateEditPage(arg0);
	}
	
	public void setTopEditMovieBorderPane(BorderPane MovieBorderPane, Stage stage ){
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
	    		stage.setScene(new MovieInterface().generateMovieScreen(stage));
				} catch (Exception e1) {
					System.out.println("Scene not found");
				}
	      });
	        
	      TopMoviePane.getChildren().add(MovieBackButton);
	                
	      MovieBorderPane.setTop(TopMoviePane);	
	}
	
	public Scene GenerateEditPage(Stage EditMovieStage){
	     	
		Image DeleteMovieImage = new Image("MovieInterfaceResource/Background.jpg",2000,1500, false,false);
		BackgroundImage DeleteMovieBackgroundImage= new BackgroundImage(DeleteMovieImage,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background DeleteMovieBackground = new Background(DeleteMovieBackgroundImage);
		
		BorderPane EditMovieBorderPane = new BorderPane();
		setTopEditMovieBorderPane(EditMovieBorderPane, EditMovieStage);
    	Pane EditPane = new Pane();   
    	VBox EditVBox = new VBox(10);
    	
    	Pane LeftPane = new Pane();
    	LeftPane.setPadding(new Insets(0,50,0,50));
    	EditMovieBorderPane.setLeft(LeftPane);
    	
    	
    	ComboBox <String>EditMovieFileComboBox = new ComboBox<String>();
    	EditMovieFileComboBox.getItems().add("MovieDataSource/Movie.txt");
    	EditMovieFileComboBox.getItems().add("MovieDataSource/ComingSoonMovie.txt");
    	EditMovieFileComboBox.setPromptText("Please select the type of movie to Edit");
    	EditPane.getChildren().add(new Label("Movie text file: "));
    	EditPane.getChildren().add(EditMovieFileComboBox);
    	EditMovieFileComboBox.setLayoutX(150);
    	EditMovieFileComboBox.setLayoutY(0);
    	
    
    	    	
    	GridPane temp = GenerateAiringMovieEditPage(EditMovieStage, EditPane);
    	GridPane temp2 = GenerateComingSoonMoviePage(EditMovieStage,EditPane);
    	EditMovieFileComboBox.setOnAction(e->{  		
    		if(EditMovieFileComboBox.getValue().equals("MovieDataSource/Movie.txt")){
    			if(EditVBox.getChildren().contains(temp2)){
    				EditVBox.getChildren().remove(temp2);
    			}
    			if(EditVBox.getChildren().contains(temp)){
    				EditVBox.getChildren().remove(temp);
    			}
    			EditVBox.getChildren().add(temp);
    		}
    		
    		if(EditMovieFileComboBox.getValue().equals("MovieDataSource/ComingSoonMovie.txt")){
    			if(EditVBox.getChildren().contains(temp)){
    				EditVBox.getChildren().remove(temp);
    			}
    			if(EditVBox.getChildren().contains(temp2)){
    				EditVBox.getChildren().remove(temp2);
    			}
    			EditVBox.getChildren().add(temp2);
    		}
    		
    	});
    	EditVBox.setLayoutX(100);
    	EditVBox.setLayoutY(50);
    	EditPane.getChildren().add(EditVBox);
		       	
    	//
 
		EditMovieBorderPane.setCenter(EditPane);
    
    	EditMovieBorderPane.setBackground(DeleteMovieBackground);
    	Scene scene = new Scene(EditMovieBorderPane);
    	EditMovieStage.setScene(scene);
    	scene.getStylesheets().add("DeleteCSS.css");
    	EditMovieStage.setWidth(1440);
    	EditMovieStage.setHeight(960);
    	return scene;

	}
	
	public static <T extends Object> List<List<T>> split(List<T> list, int targetSize) {
		List<List<T>> lists = new ArrayList<List<T>>();
	    for (int i = 0; i < list.size(); i += targetSize) {
	        lists.add(list.subList(i, Math.min(i + targetSize, list.size())));
	    }
	    return lists;
	}
	
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
		PrintWriter pw = new PrintWriter(new File(MovieFileDirectory));		
		for(int i=0; i<lists.size(); i++){
			for(int b=0; b<lists.get(i).size()/21; b++){
				if(lists.get(i).get(b).equals(MovieID)){
					if(MovieID.equals("")){
						pw.write("");
					}
					break;
				}
				else{
					String time = new String(lists.get(i).get(b+2) + "-" + lists.get(i).get(b+3) + "," + lists.get(i).get(b+4) + "-" + lists.get(i).get(b+5) + "," + lists.get(i).get(b+6) + "-" + lists.get(i).get(b+7)+"," + lists.get(i).get(b+8) + "-" + lists.get(i).get(b+9) + "," +lists.get(i).get(b+10) + "-" + lists.get(i).get(b+11) + "," + lists.get(i).get(b+12) + "-" + lists.get(i).get(b+13) + ",");
					String hall = new String(lists.get(i).get(b+14) + "," + lists.get(i).get(b+15) + "," + lists.get(i).get(b+16) + "," + lists.get(i).get(b+17) + "," + lists.get(i).get(b+18) + "," + lists.get(i).get(b+19) );
//	        		WriteMovie(MovieFileDirectory, ,lists.get(i).get(b+1), time, hall, lists.get(i).get(b+20));										
					pw.write("[" + lists.get(i).get(b) + "]" + "," + lists.get(i).get(b+1) + ","+ time + hall+ "," + lists.get(i).get(b+20) + "\n");	
				}
			}
		}
		pw.close();

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
	
	public void DeleteComingSoonMovie(String MovieFileDirectory, String MovieName) throws IOException{
		List <String> MovieData = new ArrayList<String>();
		List<List<String>> lists = null;
		
		Scanner read = new Scanner(new File(MovieFileDirectory));
		String line = null;
		String[] data = null;
		
		while(read.hasNext()){
			line = read.nextLine();
			data = line.split(",");
			for(int i=0; i<data.length; i++){
				MovieData.add(data[i]);
			}
		}
		lists = split(MovieData, 5);

		PrintWriter pw = new PrintWriter(new File(MovieFileDirectory));		
		for(int i=0; i<lists.size(); i++){
			for(int b=0; b<lists.get(i).size()/5; b++){
				if(lists.get(i).get(b).equals(MovieName)){
						pw.write("");
				}
				else{
					pw.write(lists.get(i).get(b) + "," + lists.get(i).get(b+1) + ","  + lists.get(i).get(b+2)+ ","  + lists.get(i).get(b+3)+ ","  + lists.get(i).get(b+4) + "\n");	
				}
			}
		}
		pw.close();

	}
	
	public static void AddMovie( String MovieTextFileDirectory, String MovieID, String MovieName, String Time1,String Time2, String Time3,String Time4, String Time5, String Time6, String Hall1, String Hall2, String Hall3, String Hall4, String Hall5, String Hall6,String MovieImageFileDirectory) throws IOException{
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
				
	
	
	public GridPane GenerateAiringMovieEditPage(Stage EditMovieStage, Pane EditPane){	
		Button Search = new Button("Search for Airing Movie");
		EditPane.getChildren().add(Search);
    	Search.setStyle("-fx-background-color:  #707070,    linear-gradient(#fcfcfc, #f3f3f3),   linear-gradient(#f2f2f2 0%, #ebebeb 49%, #dddddd 50%, #cfcfcf 100%);   -fx-background-insets: 0,1,2;  -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
    	Search.setLayoutX(450);
    	Search.setLayoutY(0);
    	
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
	
    	Label StatusLabel = new Label();
    	Search.setOnAction(g->{
    		List <String> MovieData = new ArrayList<String>();
    		List<List<String>> lists = null;
			try{
    			MovieData = ReadFunction("MovieDataSource/Movie.txt");
    			lists = split(MovieData, 21);
    		}
    		catch(FileNotFoundException e){
    			e.printStackTrace();
    		}
    		catch(Exception e){
    			e.printStackTrace();			
    		}	        	
    	
    		for(int i=0;i<lists.size(); i++){
    				System.out.println(lists.get(i));
    		}
    		
    		for(int i=0;i<lists.size(); i++){
    			for(int x=0; x<lists.get(i).size()/21; x++){
    				if(EditMovieTextField[0].getText().equals(lists.get(i).get(x))){
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
    	            	StatusLabel.setStyle("-fx-text-fill: #ffffff;");
        				StatusLabel.setText("The ID is found");
    	        		break;
    				}
    				if(EditMovieTextField[0].getText().equals("")){
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
    	        	   	StatusLabel.setStyle("-fx-text-fill: #ff0000;");
        				StatusLabel.setText("The ID doesn't exist. Therefore will Display the final");
        				break;
    				}
    			}
    		}
  	    		
    	});
	
    	
    	
    	Button EditMovieConfirmButton = new Button("Confirm");
    	Button EditMovieExitButton = new Button("Exit");
    	EditMovieGridPane.add(EditMovieConfirmButton, 1, 10);
    	EditMovieGridPane.add(EditMovieExitButton, 2, 10);
    	EditMovieConfirmButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
    	EditMovieExitButton.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");    
    	EditMovieGridPane.add(StatusLabel, 5, 10);
    	EditMovieExitButton.setOnAction(p->{
    		try {
				EditMovieStage.setScene(new MovieInterface().generateMovieScreen(EditMovieStage));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
    	});
	
    	EditMovieConfirmButton.setOnAction(p->{
    		try {
				DeleteMovie("MovieDataSource/Movie.txt", EditMovieTextField[0].getText());
				AddMovie("MovieDataSource/Movie.txt", EditMovieTextField[0].getText(),EditMovieTextField[1].getText(), EditMovieTextField[2].getText(),EditMovieTextField[3].getText(), EditMovieTextField[4].getText(),EditMovieTextField[5].getText(),EditMovieTextField[6].getText(), EditMovieTextField[7].getText(), EditMovieTextField[8].getText(), EditMovieTextField[9].getText(), EditMovieTextField[10].getText(),EditMovieTextField[11].getText(), EditMovieTextField[12].getText(), EditMovieTextField[13].getText(),EditMovieTextField[14].getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		try {
				EditMovieStage.setScene(new MovieInterface().generateMovieScreen(EditMovieStage));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	});
    	
    	return EditMovieGridPane;
	}
	
	public GridPane GenerateComingSoonMoviePage(Stage stage, Pane EditPane){

		Button Search = new Button("Search for Coming Soon Movie");
		EditPane.getChildren().add(Search);
    	Search.setStyle("-fx-background-color:  #707070,    linear-gradient(#fcfcfc, #f3f3f3),   linear-gradient(#f2f2f2 0%, #ebebeb 49%, #dddddd 50%, #cfcfcf 100%);   -fx-background-insets: 0,1,2;  -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
    	Search.setLayoutX(700);
    	Search.setLayoutY(0);
		
		GridPane ComingSoonGridPane = new GridPane();
		ComingSoonGridPane.add(new Label("MovieName"), 0, 0);
		ComingSoonGridPane.add(new Label("Release Day"), 0, 1);
		ComingSoonGridPane.add(new Label("Release Month"), 0, 2);
		ComingSoonGridPane.add(new Label("Image Directory"), 0, 3);
		ComingSoonGridPane.add(new Label("Description"), 0, 4);
		ComingSoonGridPane.setHgap(50);
		ComingSoonGridPane.setVgap(10);
		
		TextField[] ComingSoonMovieData = new TextField[5];
		for(int i=0; i< ComingSoonMovieData.length; i++){
			ComingSoonMovieData[i] = new TextField();
			ComingSoonGridPane.add(ComingSoonMovieData[i], 1, i);			
		}
		
		Label StatusLabel = new Label();
		ComingSoonGridPane.add(StatusLabel, 2, 6);
		
		Button Confirm = new Button("Confirm");
		ComingSoonGridPane.add(Confirm, 1, 6);		
		
		Confirm.setOnAction(e->{
			try {
				DeleteComingSoonMovie("MovieDataSource/ComingSoonMovie.txt", ComingSoonMovieData[0].getText());
				AddComingSoonMovie("MovieDataSource/ComingSoonMovie.txt", ComingSoonMovieData[0].getText(), ComingSoonMovieData[1].getText(), ComingSoonMovieData[2].getText(),ComingSoonMovieData[3].getText(),ComingSoonMovieData[4].getText());
				stage.setScene(new MovieInterface().generateMovieScreen(stage));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Search.setOnAction(x->{
			List <String> MovieData = new ArrayList<String>();
    		List<List<String>> lists = null;
			try{
				
				Scanner read = new Scanner(new File("MovieDataSource/ComingSoonMovie.txt"));
				String line = null;
				String[] data = null;				
				while(read.hasNext()){
					line = read.nextLine();
					data = line.split(",");
					for(int i=0; i<data.length; i++){
						MovieData.add(data[i]);
					}
				}
				lists = split(MovieData, 5);

    		}
    		catch(FileNotFoundException e){
    			e.printStackTrace();
    		}
    		catch(Exception e){
    			e.printStackTrace();			
    		}	        	


			
    		for(int i=0;i<lists.size(); i++){
    			for(int c=0; c<lists.get(i).size()/5; c++){
        			if (ComingSoonMovieData[0].getText().equals(lists.get(i).get(c))){
        				ComingSoonMovieData[0].setText(lists.get(i).get(c));
        				ComingSoonMovieData[1].setText(lists.get(i).get(c+1));
        				ComingSoonMovieData[2].setText(lists.get(i).get(c+2));
        				ComingSoonMovieData[3].setText(lists.get(i).get(c+3));
        				ComingSoonMovieData[4].setText(lists.get(i).get(c+4));
       	            	StatusLabel.setStyle("-fx-text-fill: #ffffff;");
       	            	StatusLabel.setText("The ID is found");
        				break;
        			}
        			if (ComingSoonMovieData[0].getText().equals("")){
        		 	   	StatusLabel.setStyle("-fx-text-fill: #ff0000;");    	
          				StatusLabel.setText("The ID doesn't exist");          			 
          				break;
        			}

    			}
    		}
    
		});
		
		return ComingSoonGridPane;		
	}	
	
}
