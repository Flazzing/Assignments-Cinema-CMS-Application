

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
/**
 * A Seat class to generate seat interface
 * 
 * after confirm ur booking will make n interface transition from here to purchase confirmation interface
 * 
 * 
 * @sa EditableLabelSkin, EditableLabelBehavior
 */
public class Seat extends Application{

	 /************************************************************************
     *                                                                      *
     *                                                                      *
     * \defgroup Method                                           *
     *
     *The method below is responsible to facilitate the reading function
     *
     *
     *
                                                                      *
     * @{                                                                   *
     ***********************************************************************/
	
	
	public ArrayList<String> read(String fileDirectory){
		ArrayList <String> data = new ArrayList<String>();
		Scanner read = null;
		try {
			read = new Scanner(new File(fileDirectory));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String linedata = null;
		String[] alldata = null;
		
		while(read.hasNext()){
			linedata = read.nextLine();
			alldata = linedata.split(",");
			for(int i=0; i<alldata.length; i++){
				data.add(alldata[i]);
			}
		}		
		return data;
	}

	 /************************************************************************
     *                                                                      *
     *                                                                      *
     * \defgroup Method                                           *
     *
     *The method below is responsible to fgenerate the seat available and unavailable to u 
     *
     *
     *
                                                                      *
     * @{                                                                   *
     ***********************************************************************/
	
	public Scene GenerateSeat(Stage stage, String MovieName, String time, String hall, String Directory){
		
		BorderPane SeatBorderPane = new BorderPane();
		setBackground(SeatBorderPane);
		setTopMovieBorderPane(SeatBorderPane, stage);
		
		
		SeatBorderPane.setCenter(GenerateCenter(stage, MovieName, time, hall, Directory));		
		
		ScrollPane scrollpane = new ScrollPane();
		scrollpane.setContent(SeatBorderPane);
		Scene scene = new Scene(scrollpane);
		scene.getStylesheets().add("Seat.css");
		stage.setScene(scene);
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
		
		SeatBorderPane.setCenter(GenerateCenter(arg0, MovieName, time, hall, Directory));		
		
		ScrollPane scrollpane = new ScrollPane();
		scrollpane.setContent(SeatBorderPane);
		Scene scene = new Scene(scrollpane);
		scene.getStylesheets().add("Seat.css");
		arg0.setScene(scene);
		arg0.setHeight(960);
		arg0.setWidth(1440);

	}
	
	
	 /************************************************************************
     *                                                                      *
     *                                                                      *
     * \defgroup Method                                           *
     *
     *The method below is responsible generate the center of the borderpane
     *
     *Note: this is needed to be within a method to simplify the transition of variable
     *
                                                                      *
     * @{                                                                   *
     ***********************************************************************/
	

		public Pane GenerateCenter(Stage stage, String MovieName,String time,String hall, String Directory){
		
		Ticket ticket = new Ticket();
			
		
		Pane root = new Pane();
		Label adult = new Label("Adult: 0");
		Label children = new Label("Children: 0");
		TextField Adult = new TextField();
	
		Pane pane = new Pane();

		GridPane seatGridPane = new GridPane();

		Button[][] SeatButton = new Button[8][4];
	
		ArrayList <String>seatinfo = new ArrayList<String>();
		seatinfo = read("MovieDataSource/Purchase.txt");
		
		int reserve =0;
		int available =0;
		
		if(seatinfo.get(0).equals(MovieName)){
			int p=7;
			for(int i=0; i<4; i++){
				for(int c=0; c<8; c++){
					SeatButton[c][i] = new Button();
					SeatButton[c][i].setText(Integer.toString(c) + Integer.toString(i));
					SeatButton[c][i].setPrefWidth(50);
					SeatButton[c][i].setPrefHeight(50);
					SeatButton[c][i].setDisable(true);
					SeatButton[c][i].setStyle("-fx-border-color: transparent;-fx-background-color: transparent;");    				
					SeatButton[c][i].setGraphic(new ImageView(new Image("MovieInterfaceResource/Seat_Available.png")));	
					for(int x=0; x<seatinfo.size()/39;x++){
						for( ; p< 39;){
							if(seatinfo.get(p).equals("0")){
								SeatButton[c][i].setGraphic(new ImageView(new Image("MovieInterfaceResource/Seat_Available.png")));	
								seatGridPane.add(SeatButton[c][i],c,i);
								available++;
								p++;
								break;
							}
							else {
								SeatButton[c][i].setGraphic(new ImageView(new Image("MovieInterfaceResource/Seat_Reserve.png")));										
								p++;
								seatGridPane.add(SeatButton[c][i],c,i);
								reserve++;
								break;
							}
						}
						break;				
					}
					}
			}
			}
		else{
			for(int i=0; i<4; i++){
				for(int c=0; c<8; c++){
					SeatButton[c][i] = new Button();
					SeatButton[c][i].setText(Integer.toString(c) + Integer.toString(i));
					SeatButton[c][i].setPrefWidth(50);
					SeatButton[c][i].setPrefHeight(50);
					SeatButton[c][i].setStyle("-fx-border-color: transparent;-fx-background-color: transparent;");    				
					SeatButton[c][i].setGraphic(new ImageView(new Image("MovieInterfaceResource/Seat_Available.png")));	
					seatGridPane.add(SeatButton[c][i],c,i);
					available++;
				}
			}
					
					
		}
		seatGridPane.setLayoutX(200);
		seatGridPane.setLayoutY(300);
		pane.getChildren().add(seatGridPane);

		/**
	     * The iamgeview for the blue line
	     * 
	     * 
	     * 
	      */
		
		
		
		Pane BlueLine = new Pane();
		BlueLine.getChildren().add(new ImageView(new Image("MovieInterfaceResource/line.png")));		
		
		VBox vbox1 = new VBox(10);
		HBox hbox1 = new HBox(10);

		hbox1.setLayoutX(0);
		hbox1.setLayoutY(0);
		
		hbox1.getChildren().add(pane);
		
		hbox1.getChildren().add(BlueLine);
	
		System.out.println(Directory);
		//"file:" + new String(Directory)
		ImageView imageview = new ImageView(new Image("file:" + Directory));
		imageview.setFitWidth(250);
		imageview.setFitHeight(180);
		imageview.setLayoutX(450);
		vbox1.getChildren().add(imageview);
		vbox1.getChildren().add(new Label("Movie Name:" + MovieName));
		
		HBox hbox2 = new HBox(20);
		hbox2.getChildren().add(new ImageView(new Image("MovieInterfaceResource/timeicon.png")));
		Label Movietime = new Label(time);
		Movietime.setPadding(new Insets(20,0,0,0));
		hbox2.getChildren().add(Movietime);
		vbox1.getChildren().add(hbox2);
		
		HBox hbox3 = new HBox(20);
		hbox3.getChildren().add(new ImageView(new Image("MovieInterfaceResource/calendericon.png")));
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		hbox3.getChildren().add( new Label(sdf.format(date)));
		hbox3.setAlignment(Pos.CENTER_LEFT);
		vbox1.getChildren().add(hbox3);
		
		HBox hbox7 = new HBox();
		hbox7.getChildren().add(new ImageView(new Image("MovieInterfaceResource/hallicon.png")));
		Label halllabel = new Label(hall);
		halllabel.setPadding(new Insets(15,0,0,0));
		hbox7.getChildren().add(halllabel);
		vbox1.getChildren().add(hbox7);
		
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
		
		/**
	     *Refresh button 
	     *
	     *Function: To refresh the interface after wreitting the number of adult and children
	     *
	     *Note; button will be disable after writting once 
	     *
	      */
		
		Button b2 = new Button("Refresh");
		vbox1.getChildren().add(b2);
		TextField[] seatPosition = new TextField[18];
		
		
		
		int totalAdult = (Integer.parseInt(adult.getText().replace("Adult: ", "")));
		int totalChild = (Integer.parseInt(children.getText().replace("Children: ", "")));
		
		
		b2.setOnAction(e->{
			int totalpeople = (Integer.parseInt(adult.getText().replace("Adult: ", ""))) + (Integer.parseInt(children.getText().replace("Children: ", "")));			
			Label ticketdetail[] = new Label[totalpeople];	
			
			ticket.setValidTotalpeople(totalpeople);
		
			HBox hbox[] = new HBox[totalpeople];
			VBox vbox = new VBox(10);
			
			
			/**
		     * 
		     * This section generate the detail about the booking being made
		     * 
		     * Ticket Number	Ticket Type		Price		SeatPosition (TextField)
		     * 
		     */
			
			
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
			double total =  10 * (Integer.parseInt(children.getText().replace("Children: ", "")));
			total += 15*(Integer.parseInt(adult.getText().replace("Adult: ", "")));
			vbox.getChildren().add(new Label("Total: " + Double.toString(total) ));
			root.getChildren().add(vbox);
			vbox.setLayoutX(1030);
			vbox.setLayoutY(780);
		});
			
		
		
		double total =  10 * (Integer.parseInt(children.getText().replace("Children: ", "")));
		total += 15*(Integer.parseInt(adult.getText().replace("Adult: ", "")));
		
		HBox hbox6 = new HBox(50);
		Button back = new Button("Back");
		
		
		/**
		 * 
		 * The back button is function to allows the transition of the previous page
		 * 
		 * 
		 * The button goes to userscene interface
		 * 
		 */
		
		back.setOnAction(e->{
			UserScene userscene = new UserScene();
			try {
				stage.setScene(userscene.getUserScene(stage));
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "System error: Please Contact developer for help!");
			}
		});
		
		
		/**
		 * The Confirm button confirm the detail of the booking being made
		 * 
		 * Will maje tge transition from here to purchase confirmation page
	      */
	
		Button b1 = new Button("Confirm");

		hbox6.getChildren().add(back);
		hbox6.getChildren().add(b1);
		vbox1.getChildren().add(hbox6);
		
		
		
		b1.setOnAction(e->{
			PurchaseConfirmation purchaseConfirmation = new PurchaseConfirmation();
			char[] seat = new char[32];
			int totalpeople = Integer.parseInt(adult.getText().replace("Adult: ", "")) + Integer.parseInt(children.getText().replace("Children: ", ""));
			for(int i=0; i>totalpeople; i++){
				System.out.println("ss");
				seat[i] = seatPosition[i].getText().charAt(0);
			}
			
			
			
			double total24 =  10 * (Integer.parseInt(children.getText().replace("Children: ", "")));
			total24 += 15*(Integer.parseInt(adult.getText().replace("Adult: ", "")));
			System.out.println(new String(seat)+ ","+total24+ ","+Integer.toString(totalAdult)+ ","+ Double.toString(totalChild));
			/**
			 * set the scene to abother scebe
			 * 
			 * The method below will change the stage to purchase confirmation page
		     */
			
		try {
						
			stage.setScene(purchaseConfirmation.generatePurchaseConfirmation(stage, MovieName, Directory, time, hall, new String(seat), adult.getText().replace("Adult: ", ""), children.getText().replace("Children: ", ""), total24));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "System error: Please Contact developer for help!");

		}
		});
		
		/**
		 * The add button confirm the number of adult and children 
		 * 
		 * 
	     */
		
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
	
		
		/**
		 * 
		 * Generate the number within the seat box
		 * 
	     */
		int total2 =1;
		GridPane gp = new GridPane();
		for(int i=0; i<4;i++){
			for(int b=0; b<8; b++){
				gp.add(new Label(Integer.toString(total2)), b, i);
				total2++;
			}			
		}
		gp.setLayoutX(230);
		gp.setLayoutY(320);
		gp.setHgap(70);
		gp.setVgap(43);
		root.getChildren().add(gp);	

	
		HBox hbox9 = new HBox(200);
		
		VBox vbox2 = new VBox();
		VBox vbox3 = new VBox();

		
		ImageView noticeview = new ImageView(new Image("MovieInterfaceResource/Seat_Reserve.png"));
		noticeview.setFitWidth(100);
		noticeview.setFitHeight(100);
		vbox2.getChildren().add(noticeview);
		vbox2.getChildren().add(new Label("Reserve Seat"));
		hbox9.getChildren().add(vbox2);
		
		ImageView noticeview2 = new ImageView(new Image("MovieInterfaceResource/Seat_Available.png"));
		noticeview2.setFitWidth(100);
		noticeview2.setFitHeight(100);
	
		vbox3.getChildren().add(noticeview2);
		hbox9.setLayoutX(300);
		hbox9.setLayoutY(700);
		vbox3.getChildren().add(new Label ("Available seat"));
		hbox9.getChildren().add(vbox3);
				
		VBox seatdetail = new VBox();
		seatdetail.getChildren().add(new Label("Available seat: " + available));
		seatdetail.getChildren().add(new Label("Reserve seat: " + reserve));
		seatdetail.setLayoutX(100);
		seatdetail.setLayoutY(100);
		root.getChildren().add(seatdetail);
		
		root.getChildren().add(hbox9);
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
