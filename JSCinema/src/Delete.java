import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Delete extends Application{

	public static void main(String[]args){
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		GenerateDeletePage(arg0);
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
	    		stage.setScene(new MovieInterface().generateMovieScreen(stage));
	    		
				} catch (Exception e1) {
					System.out.println("Scene not found");
				}
	      });
	        
	      TopMoviePane.getChildren().add(MovieBackButton);
	                
	      MovieBorderPane.setTop(TopMoviePane);	
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
	
	public static <T extends Object> List<List<T>> split(List<T> list, int targetSize) {
		List<List<T>> lists = new ArrayList<List<T>>();
	    for (int i = 0; i < list.size(); i += targetSize) {
	        lists.add(list.subList(i, Math.min(i + targetSize, list.size())));
	    }
	    return lists;
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
			System.out.println(lists.get(i));
			for(int b=0; b<lists.get(i).size()/5; b++){
				if(lists.get(i).get(b).equals(MovieName)){
					pw.write("");
				}
				else{
					pw.write(lists.get(i).get(b) + "," + lists.get(i).get(b+1) + ","  + lists.get(i).get(b+2) + "," + lists.get(i).get(b+3)  + ","+ lists.get(i).get(b+4) + "\n");	
				}
			}
		}
		read.close();
		pw.close();

	}
	
	public Pane GeneRateDeleteComingSoongMoviePange( Label Deletestatus, Stage DeleteMovieStage){
		Pane DeleteComingSoongMoviePane = new Pane();
		HBox hbox1 = new HBox();
		hbox1.getChildren().add(new Label("Movie Name: "));
		TextField DeleteMovieName = new TextField();
		hbox1.getChildren().add(DeleteMovieName);
		hbox1.setLayoutX(0);
		hbox1.setLayoutY(100);
		Button DeleteConfirm = new Button("Confirm");
		DeleteConfirm.setLayoutX(300);
		DeleteConfirm.setLayoutY(400);
		DeleteComingSoongMoviePane.getChildren().add(hbox1);
		DeleteComingSoongMoviePane.getChildren().add(DeleteConfirm);

		
		DeleteConfirm.setOnAction(e->{
			if (DeleteMovieName.getText().equals("")){
				Deletestatus.setText("The Movie ID text field is empty. Please try again!");
			}
			else{
				try{
					DeleteComingSoonMovie("MovieDataSource/ComingSoonMovie.txt", DeleteMovieName.getText());
					Deletestatus.setText("Delete Success");
					DeleteMovieStage.setScene(new MovieInterface().generateMovieScreen(DeleteMovieStage));
				}
				catch(IOException e2){
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "System error! Please contact technical department.");
				}
			}
		});
		
		return DeleteComingSoongMoviePane;		
	}
	
	
	public Pane GenerateDeleteAiringMoviePage( Label Deletestatus, Stage DeleteMovieStage){
		Pane DeleteAiringMoviePane = new Pane();
		HBox hbox1 = new HBox();
		hbox1.getChildren().add(new Label("Movie ID: "));
		TextField DeleteMovieID = new TextField();
		hbox1.getChildren().add(DeleteMovieID);
		hbox1.setLayoutX(0);
		hbox1.setLayoutY(100);
		Button DeleteConfirm = new Button("Confirm");
		DeleteConfirm.setLayoutX(300);
		DeleteConfirm.setLayoutY(400);
		DeleteAiringMoviePane.getChildren().add(hbox1);
		DeleteAiringMoviePane.getChildren().add(DeleteConfirm);

		
		DeleteConfirm.setOnAction(e->{
			if (DeleteMovieID.getText().equals("")){
				Deletestatus.setText("The Movie ID text field is empty. Please try again!");
			}
			else{
				try{
					DeleteMovie("MovieDataSource/Movie.txt", DeleteMovieID.getText());
					Deletestatus.setText("Delete Success");
					DeleteMovieStage.setScene(new MovieInterface().generateMovieScreen(DeleteMovieStage));
				}
				catch(IOException e2){
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "System error! Please contact technical department.");
				}
			}
		});
		
		return DeleteAiringMoviePane;
	}
	
	

	public Scene GenerateDeletePage(Stage DeleteMovieStage){
		
		BorderPane DeletePageBorderPane = new BorderPane();
		setTopMovieBorderPane(DeletePageBorderPane, DeleteMovieStage);
		
		Image DeleteMovieImage = new Image("MovieInterfaceResource/Background.jpg",2000,1500, false,false);
		BackgroundImage DeleteMovieBackgroundImage= new BackgroundImage(DeleteMovieImage,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background DeleteMovieBackground = new Background(DeleteMovieBackgroundImage);
		    
		DeletePageBorderPane.setBackground(DeleteMovieBackground);

		Pane LeftPane = new Pane();
		LeftPane.setPadding(new Insets(0,150,0,0));
		DeletePageBorderPane.setLeft(LeftPane);

		Pane RightPane = new Pane();
		RightPane.setPadding(new Insets(0,150,0,0));
		DeletePageBorderPane.setRight(RightPane);

		
		
		Pane CenterPaneRoot = new Pane();		
		ComboBox <String>MovieFileComboBox = new ComboBox<String>();
		MovieFileComboBox.getItems().add("MovieDataSource/Movie.txt");
		MovieFileComboBox.getItems().add("MovieDataSource/ComingSoonMovie.txt");
		MovieFileComboBox.setPromptText("Please select the type of movie to delete");

		HBox FirstRowDeleteHBox = new HBox(20);
		Label DeleteNoticeLabel = new Label();
		DeleteNoticeLabel.setStyle(" -fx-font-size: 20; -fx-text-fill: #ff0000;");
		
		FirstRowDeleteHBox.setLayoutX(0);
		FirstRowDeleteHBox.setLayoutY(0);
		FirstRowDeleteHBox.getChildren().add(new Label("Choose section to delete"));
		FirstRowDeleteHBox.getChildren().add(MovieFileComboBox);
		FirstRowDeleteHBox.getChildren().add(DeleteNoticeLabel);
		CenterPaneRoot.getChildren().add(FirstRowDeleteHBox);
			
		Pane temp = GenerateDeleteAiringMoviePage( DeleteNoticeLabel, DeleteMovieStage);						
		Pane temp2 = GeneRateDeleteComingSoongMoviePange( DeleteNoticeLabel, DeleteMovieStage);
		
		MovieFileComboBox.setOnAction(e->{
			if (MovieFileComboBox.getValue().equals("MovieDataSource/Movie.txt")){
				if(CenterPaneRoot.getChildren().contains(temp2)){
					CenterPaneRoot.getChildren().remove(temp2);
				}
				CenterPaneRoot.getChildren().add(temp);
			}
			if (MovieFileComboBox.getValue().equals("MovieDataSource/ComingSoonMovie.txt")){
				if(CenterPaneRoot.getChildren().contains(temp)){
					CenterPaneRoot.getChildren().remove(temp);
				}
				CenterPaneRoot.getChildren().add(temp2);				
			}
		});
		
		

		DeletePageBorderPane.setCenter(CenterPaneRoot);
		
		
		Scene scene = new Scene(DeletePageBorderPane);
		scene.getStylesheets().add("DeleteCSS.css");
		
		DeleteMovieStage.setHeight(960);
		DeleteMovieStage.setWidth(1440);
		return scene;
	}
	
}
