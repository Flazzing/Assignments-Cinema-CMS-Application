

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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


	public Scene GenerateSeat(Stage stage, String MovieName, String time, String hall, String Directory){
		BorderPane SeatBorderPane = new BorderPane();
		setBackground(SeatBorderPane);
		setTopMovieBorderPane(SeatBorderPane, stage);
		
		
		SeatBorderPane.setCenter(GenerateCenter(MovieName, time, hall, Directory));		
		
		ScrollPane scrollpane = new ScrollPane();
		scrollpane.setContent(SeatBorderPane);
		Scene scene = new Scene(scrollpane);
		scene.getStylesheets().add("Seat.css");
		return scene;
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

		BorderPane SeatBorderPane = new BorderPane();
		setBackground(SeatBorderPane);
		setTopMovieBorderPane(SeatBorderPane, arg0);
		
		String MovieName = null;
		String time = null;
		String hall = null; 
		String Directory = "MovieInterfaceResource/MovieIcon.png";
		
		SeatBorderPane.setCenter(GenerateCenter(MovieName, time, hall, Directory));		
		
		ScrollPane scrollpane = new ScrollPane();
		scrollpane.setContent(SeatBorderPane);
		Scene scene = new Scene(scrollpane);
		scene.getStylesheets().add("Seat.css");
		arg0.setScene(scene);
		arg0.setHeight(960);
		arg0.setWidth(1440);

	}
	
	
		public Pane GenerateCenter(String MovieName,String time,String hall, String Directory){
		
		Ticket ticket = new Ticket();
		
		
		
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
				SeatButton[c][i].setText(Integer.toString(c) + Integer.toString(i));
				SeatButton[c][i].setPrefWidth(50);
				SeatButton[c][i].setPrefHeight(50);
				SeatButton[c][i].setDisable(true);
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
		HBox hbox1 = new HBox(10);

		hbox1.setLayoutX(0);
		hbox1.setLayoutY(0);
		
		hbox1.getChildren().add(pane);
		
		hbox1.getChildren().add(BlueLine);
	
		
		ImageView imageview = new ImageView(new Image(Directory));
		imageview.setFitWidth(150);
		imageview.setFitHeight(120);
		imageview.setLayoutX(400);
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
		
		
		
		Button b2 = new Button("Refresh");
		vbox1.getChildren().add(b2);
		
		
		TextField[] seatPosition = new TextField[18];
		
		
		b2.setOnAction(e->{
			int totalpeople = (Integer.parseInt(adult.getText().replace("Adult: ", ""))) + (Integer.parseInt(children.getText().replace("Children: ", "")));			
			Label ticketdetail[] = new Label[totalpeople];	
			
			ticket.setValidTotalpeople(totalpeople);
		
			HBox hbox[] = new HBox[totalpeople];
			VBox vbox = new VBox(10);
			
			
			
			int i=0;
			for( ; i< totalpeople-(Integer.parseInt(children.getText().replace("Children: ", ""))); i++){
				ticketdetail[i] = new Label(Integer.toString(Integer.parseInt(adult.getText().replace("Adult: ", "")) -i) + "\t\t\t\tAdult: " + "\t\t  "+ ticket.getTicketAdultPrice());
				hbox[i] = new HBox(50);
				seatPosition[i] = new TextField();
				hbox[i].getChildren().addAll(ticketdetail[i],seatPosition[i]);
				vbox.getChildren().add(hbox[i]);
			}
			int b =+ i;
			for( ; b<totalpeople; b++){
				ticketdetail[b] = new Label(b+1 + "\t\t\t\tChildren: " + "\t\t  "+ ticket.getTicketChildPrice());
				hbox[b] = new HBox(50);
				seatPosition[b] = new TextField();
				hbox[b].getChildren().addAll(ticketdetail[b], seatPosition[b]);
				vbox.getChildren().add(hbox[b]);
			}
			
			root.getChildren().add(vbox);
			vbox.setLayoutX(1480);
			vbox.setLayoutY(580);
		});
			
	
	
		Button b1 = new Button("Confirm");
		vbox1.getChildren().add(b1);
		
		b1.setOnAction(e->{
		//generate event	
		});
		
		Add.setOnAction(e->{
			if(Adult.getText().matches("[0-9]")){
				adult.setText("Adult: " +Adult.getText());
				Adult.setEditable(false);
				
			}
			if(Children.getText().matches("[0-9]")){
				children.setText("Children: "+ Children.getText());
				Children.setEditable(false);
			}
			
		});

	
		vbox1.getChildren().add(new Label("Ticket detail (Click on seat position to choose sit	)"));		
		vbox1.getChildren().add(new Label("Ticket number \t Ticket type \t\tPrice\t\t Seat Positon"));

		
		hbox1.getChildren().add(vbox1);
		root.getChildren().add(hbox1);
	
		
		
		VBox SeatHorizontalPosition = new VBox(110);
		SeatHorizontalPosition.getChildren().add(new Label("A"));
		SeatHorizontalPosition.getChildren().add(new Label("B"));
		SeatHorizontalPosition.getChildren().add(new Label("C"));
		SeatHorizontalPosition.getChildren().add(new Label("D"));
	
		
		root.getChildren().add(SeatHorizontalPosition);
		SeatHorizontalPosition.setLayoutX(180);
		SeatHorizontalPosition.setLayoutY(350);
		
		HBox seatVerticlePosition = new HBox(140);
		seatVerticlePosition.getChildren().add(new Label("1"));
		seatVerticlePosition.getChildren().add(new Label("2"));
		seatVerticlePosition.getChildren().add(new Label("3"));
		seatVerticlePosition.getChildren().add(new Label("4"));
		seatVerticlePosition.getChildren().add(new Label("5"));
		seatVerticlePosition.getChildren().add(new Label("6"));
		seatVerticlePosition.getChildren().add(new Label("7"));
		seatVerticlePosition.getChildren().add(new Label("8"));
		seatVerticlePosition.setLayoutX(260);
		seatVerticlePosition.setLayoutY(270);
		root.getChildren().add(seatVerticlePosition);
		

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
