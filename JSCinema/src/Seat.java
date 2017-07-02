

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Seat extends Application{

	public static void main(String[]args){
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		Stage stage = new Stage();
		BorderPane SeatBorderPane = new BorderPane();
		setBackground(SeatBorderPane);
		setTopMovieBorderPane(SeatBorderPane, stage);
		
		
		SeatBorderPane.setCenter(GenerateRightBox(SeatBorderPane));
		
		
		ScrollPane scrollpane = new ScrollPane();
		scrollpane.setContent(SeatBorderPane);
		Scene scene = new Scene(scrollpane);
		scene.getStylesheets().add("Seat.css");
		stage.setScene(scene);
		stage.setHeight(960);
		stage.setWidth(1440);
		stage.show();
		
	}
	
	public Pane GenerateSeatInterface(){
		Pane pane = new Pane();
		ImageView cinema = new ImageView(new Image("MovieInterfaceResource/Cinema.png"));
		cinema.setLayoutX(120);
		cinema.setLayoutY(120);
		pane.getChildren().add(cinema);
	
		return pane;
	}
		
	public Pane GenerateRightBox(BorderPane borderpane){
		
		Pane root = new Pane();
		Label adult = new Label("Adult: 0");
		Label children = new Label("Children: 0");
		TextField Adult = new TextField();
		GridPane seatGridPane = new GridPane();
		final ToggleGroup[][] group = new ToggleGroup[8][4];
		ToggleButton[][] SeatButton = new ToggleButton[8][4];

		
		for(int i=0; i<4; i++){
			for(int c=0; c<8; c++){
				SeatButton[c][i] = new ToggleButton();
				SeatButton[c][i].setPrefWidth(50);
				SeatButton[c][i].setPrefHeight(50);
				SeatButton[c][i].setGraphic(new ImageView(new Image("MovieInterfaceResource/Seat_Available.png")));			
				SeatButton[c][i].setStyle("-fx-border-color: transparent;-fx-background-color: transparent;");    
				seatGridPane.add(SeatButton[c][i],c,i);
				group[c][i] = new ToggleGroup();
				SeatButton[c][i].setToggleGroup(group[c][i]);
				int temp = c;
				int temp2 = i;
				group[c][i].selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
				    public void changed(ObservableValue<? extends Toggle> ov,
				        Toggle toggle, Toggle new_toggle) {
				    		if(new_toggle == null){
								SeatButton[temp][temp2].setGraphic(new ImageView(new Image("MovieInterfaceResource/Seat_Available.png")));							            	
				            }
				            else{				            	
								SeatButton[temp][temp2].setGraphic(new ImageView(new Image("MovieInterfaceResource/Seat_Choosen.png")));											
								int totalpeople = (Integer.parseInt(adult.getText().replace("Adult: ", ""))) + (Integer.parseInt(children.getText().replace("Children: ", "")));			
								Label seatPosition[] = new Label[totalpeople];
								
								for(int i=0; i<totalpeople; i++){
									seatPosition[i] = new Label("weird");
									VBox vbox = new VBox();
									vbox.getChildren().add(seatPosition[i]);
									vbox.setLayoutX(600);
									vbox.setLayoutY(600);
									root.getChildren().add(vbox);
								}
				            }
				         }				   				    
				});
			}
		}
		
		seatGridPane.setLayoutX(200);
		seatGridPane.setLayoutY(300);
		Pane pane = new Pane();
		pane.getChildren().add(seatGridPane);
		
		
		
		
		Pane BlueLine = new Pane();
		BlueLine.getChildren().add(new ImageView(new Image("MovieInterfaceResource/line.png")));		
		
		VBox vbox1 = new VBox(10);
		HBox hbox1 = new HBox();

		hbox1.setLayoutX(0);
		hbox1.setLayoutY(0);
		
		hbox1.getChildren().add(pane);
		
		hbox1.getChildren().add(BlueLine);
		
		
		String MovieDirectory = "MovieInterfaceResource/MovieIcon.png";
		String MovieName = null;
		String time = null;
		
		
		ImageView imageview = new ImageView(new Image(MovieDirectory));
		imageview.setFitWidth(150);
		imageview.setFitHeight(120);
		vbox1.getChildren().add(imageview);
		vbox1.getChildren().add(new Label(MovieName));
		
		HBox hbox2 = new HBox();
		hbox2.getChildren().add(new ImageView(new Image("MovieInterfaceResource/timeicon.png")));
		hbox2.getChildren().add(new Label(time));
		vbox1.getChildren().add(hbox2);
		
		HBox hbox3 = new HBox(20);
		hbox3.getChildren().add(new ImageView(new Image("MovieInterfaceResource/calendericon.png")));
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		hbox3.getChildren().add( new Label(sdf.format(date)));
		hbox3.setAlignment(Pos.CENTER_LEFT);
		vbox1.getChildren().add(hbox3);
		
		HBox hbox4 = new HBox(20);
		hbox4.getChildren().add(new Label("Enter Adult"));
			hbox4.getChildren().add(Adult);
		vbox1.getChildren().add(hbox4);

		HBox hbox5 = new HBox(20);
		hbox4.getChildren().add(new Label("Enter Children"));
		TextField Children = new TextField();
		hbox4.getChildren().add(Children);
		vbox1.getChildren().add(hbox5);
		
		Button Add = new Button("Add");
		vbox1.getChildren().add(Add);
		
	

	
		
		vbox1.getChildren().add(adult);
		vbox1.getChildren().add(children);
		
		vbox1.getChildren().add(new Label("Selected Seat"));

		
		Add.setOnAction(e->{
			if(Adult.getText().matches("[0-9]")){
				adult.setText("Adult: " +Adult.getText());
				System.out.println(adult.getText().replace("Adult: ", ""));			
				
			}
			if(Children.getText().matches("[0-9]")){
				children.setText("Children: "+ Children.getText());
			}
			
		});

	
		
		Button b1 = new Button("Confirm");
		vbox1.getChildren().add(b1);
		
		b1.setOnAction(e->{
		//generate event	
		});
		hbox1.getChildren().add(vbox1);
		root.getChildren().add(hbox1);
		
		return root;
		
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

	      
	      TopMovieVBox.getChildren().add(TopMovieHBox);      
	      TopMoviePane.getChildren().add(TopMovieVBox);	                 
	      MovieBorderPane.setTop(TopMoviePane);			
	}
	
	public void setBackground(Pane pane){
		Image AddMovieImage = new Image("MovieInterfaceResource/Background.jpg",2000,1500, false,false);
		BackgroundImage AddMovieBackgroundImage= new BackgroundImage(AddMovieImage,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background AddMovieBackground = new Background(AddMovieBackgroundImage);
		pane.setBackground(AddMovieBackground);
	  }
	
	public void setBackground(BorderPane borderpane){
		Image AddMovieImage = new Image("MovieInterfaceResource/Background.jpg",2000,1500, false,false);
		BackgroundImage AddMovieBackgroundImage= new BackgroundImage(AddMovieImage,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background AddMovieBackground = new Background(AddMovieBackgroundImage);
		borderpane.setBackground(AddMovieBackground);
	}
	
}
