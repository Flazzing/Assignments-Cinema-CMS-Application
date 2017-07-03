
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PurchaseConfirmation extends Application {
	
	public Scene generatePurchaseConfirmation(Stage stage, String MovieName ,String MovieDirectory , String ShowTime , String BookedHall ,String BookedSeats, int TotalAdult , int TotalChildren, double TotalPrice)throws FileNotFoundException{
		
		BorderPane pane2 = new BorderPane();
		
		GridPane ctop1 = new GridPane();
		ctop1.setPadding(new Insets(70, 50,50,15));
		ctop1.setHgap(40);
		GridPane ctop2 = new GridPane();
		ctop2.setPadding(new Insets(70, 50,50,15));
		ctop2.setHgap(40);
			StackPane pane = new StackPane();
			StackPane pane3 = new StackPane();
			pane2.setTop(pane);
			pane2.setBottom(pane3);
			
			//background pane
			Pane backgroundPane = new Pane();
				
				FileInputStream imageStream = new FileInputStream("pictures/Background.png");
				backgroundPane.setPadding(new Insets(0,0,0,0));
				Image image = new Image(imageStream);
				backgroundPane.getChildren().add(new ImageView(image));
				
				Pane Footer = new Pane();
				
				FileInputStream imageStream2 = new FileInputStream("pictures/Logo.png");
				Footer.setPadding(new Insets(30,0,0,530));
				Image image2 = new Image(imageStream2);
				Footer.getChildren().add(new ImageView(image2));
				Footer.setTranslateX(500);
				Footer.setTranslateY(40);
				
				FileInputStream imageStream12 = new FileInputStream("pictures/Container.png");
				Image image12 = new Image(imageStream12);
				ImageView imgview12 = new ImageView(image12);
				imgview12.setFitWidth(400);
				imgview12.setFitHeight(90);
				imgview12.setTranslateX(50);
				imgview12.setTranslateY(200);
					
				FileInputStream imageStream13 = new FileInputStream("pictures/Container.png");
				Image image13 = new Image(imageStream13);
				ImageView imgview13 = new ImageView(image13);
				imgview13.setFitWidth(400);
				imgview13.setFitHeight(90);
				imgview13.setTranslateX(500);
				imgview13.setTranslateY(200);
				
				FileInputStream imageStream14 = new FileInputStream("pictures/Container.png");
				Image image14 = new Image(imageStream14);
				ImageView imgview14 = new ImageView(image14);
				imgview14.setFitWidth(400);
				imgview14.setFitHeight(500);
				imgview14.setTranslateX(50);
				imgview14.setTranslateY(300);
				
				FileInputStream imageStream15 = new FileInputStream("pictures/Container.png");
				Image image15 = new Image(imageStream14);
				ImageView imgview15 = new ImageView(image14);
				imgview15.setFitWidth(400);
				imgview15.setFitHeight(300);
				imgview15.setTranslateX(900);
				imgview15.setTranslateY(300);
				
				ImageView moviepicture =  new ImageView(new Image("file:" + MovieDirectory));
				moviepicture.setFitWidth(400);
				moviepicture.setFitHeight(90);
				moviepicture.setTranslateX(500);
				moviepicture.setTranslateY(250);
				
				Text Text1 = new Text("Purchase Summary");
				Text1.setFont(Font.font(35));
				Text1.setFill(Color.CYAN);
				ctop1.add(Text1, 2, 2);
				Text1.setTranslateX(20);
				Text1.setTranslateY(150);
				
				Text Text2 = new Text("Movie Selected");
				Text2.setFont(Font.font(35));
				Text2.setFill(Color.CYAN);
				ctop2.add(Text2, 2, 2);
				Text2.setTranslateX(500);
				Text2.setTranslateY(150);
				
				Text Text3 = new Text("Ticket Summary");
				Text3.setFont(Font.font(30));
				Text3.setFill(Color.CYAN);
				Text3.setTranslateX(60);
				Text3.setTranslateY(400);
				
				Text Text4 = new Text("Adult     : " + TotalAdult );
				Text4.setFont(Font.font(25));
				Text4.setFill(Color.CYAN);
				Text4.setTranslateX(60);
				Text4.setTranslateY(500);
				
				
				Text Text5 = new Text("Children     :" + TotalChildren);
				Text5.setFont(Font.font(25));
				Text5.setFill(Color.CYAN);
				Text5.setTranslateX(60);
				Text5.setTranslateY(550);
				
				Text Text6 = new Text("Booking Fee     :       RM 3.00");
				Text6.setFont(Font.font(25));
				Text6.setFill(Color.CYAN);
				Text6.setTranslateX(60);
				Text6.setTranslateY(600);
				
				Text Text7 = new Text("Seats      :" + BookedSeats);
				Text7.setFont(Font.font(25));
				Text7.setFill(Color.CYAN);
				Text7.setTranslateX(60);
				Text7.setTranslateY(650);
				
				Text Text8= new Text("Total Price      :" + TotalPrice);
				Text8.setFont(Font.font(25));
				Text8.setFill(Color.CYAN);
				Text8.setTranslateX(60);
				Text8.setTranslateY(700);
				
				Text Text9= new Text("Movie Name      :" + MovieName);
				Text9.setFont(Font.font(25));
				Text9.setFill(Color.CYAN);
				Text9.setTranslateX(920);
				Text9.setTranslateY(370);
				
				Text Text10= new Text("Date      :");
				Text10.setFont(Font.font(25));
				Text10.setFill(Color.CYAN);
				Text10.setTranslateX(920);
				Text10.setTranslateY(420);
				
				Text Text11= new Text("Showtime      :" + ShowTime );
				Text11.setFont(Font.font(25));
				Text11.setFill(Color.CYAN);
				Text11.setTranslateX(920);
				Text11.setTranslateY(480);
				
				Text Text12= new Text("Hall Booked      :" + BookedHall );
				Text12.setFont(Font.font(25));
				Text12.setFill(Color.CYAN);
				Text12.setTranslateX(920);
				Text12.setTranslateY(530);
				
				
			Label label1 = new Label();
			pane3.getChildren().add(label1);
			
			Button button1 = new Button("Confirm Purchase");
			pane.getChildren().add(button1);
			button1.setTranslateX(1000);
			button1.setTranslateY(800);
			
			button1.setOnAction(e -> 
			{
				File file = new File("myfile.txt");
				if(file.exists())
				{
					System.out.println("File already exists");
					System.exit(0);
				}
				try(
				PrintWriter output = new PrintWriter(file);
				){
				output.println(MovieName +","+MovieDirectory +","+ ShowTime +","+ BookedHall +","+BookedSeats+ ","+Integer.toString(TotalAdult) + ","+Integer.toString(TotalChildren)+","+ Double.toString(TotalPrice));
				try {
					updateBookingMade(MovieName, 3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "System error: Please Contact developer for help!");

				}

				}
				catch(FileNotFoundException ex)
				{
					System.out.println("Error");
					JOptionPane.showMessageDialog(null, "System error: Please Contact developer for help!");

				}
				label1.setText("Receipt Generated");
				label1.setTextFill(Color.CYAN);
				label1.setTranslateX(1100);
				label1.setTranslateY(850);
				
			}
					);
			backgroundPane.getChildren().addAll(pane2,pane,Footer,imgview12, imgview13, imgview14 ,imgview15, ctop1, ctop2,Text3,Text4, Text5, Text6, Text7, Text8,Text9,Text10, Text11, Text12);
			Scene scene = new Scene(backgroundPane, 1440, 960);
		
			return scene;
			
	}
	
	public static void updateBookingMade(String movieName, int bookingmade) throws Exception{
		
		try{
			File file = new File("MovieDataSource/bookingmade.txt");
			Scanner input = new Scanner(file);
			List<String> movieNameList = new ArrayList<String>();
			List<String> ytdList = new ArrayList<String>();
			List<String> todayList = new ArrayList<String>();
			
			while(input.hasNextLine()){
				String line = input.nextLine();	// Store a line from txt file
    			String[] section = line.split(";");	// Split each line with regex ";" to each section store in an element of array
				movieNameList.add(section[0]);	// Storing movieName into arrayList
				ytdList.add(section[1]);	//Storing yesterday booking into arrayList
				todayList.add(section[2]);	//Storing today booking into arrayList
			}
			
			PrintWriter updater = new PrintWriter(new FileOutputStream(file, false));// Open file to overwrite
			int i = 0;
			/*
			 * For each movie in a movieNameList,
			 * If the movie in movieNameList is same as the movieName is being booked
			 * Print the movie name, yesterday's booking, and also today booking add with current bookingmade.
			 * Else print out other movie along with yesterday's booking and today's booing made
			 */
			for(String movie : movieNameList){
				if(movie.equals(movieName)){
					updater.println(movie +";" +ytdList.get(i) +";" +(bookingmade + Integer.parseInt(todayList.get(i))));
				}
				else{
					updater.println(movie +";" +ytdList.get(i) +";" +todayList.get(i));
				}
				i++;// this is to increment through the arraylist
			}
			/*
			 * If there is new movie that doesnt have data stored in MovieNameList,
			 * it will then append to the end of the textfile
			 * according to the format: MovieName;ytdbooking;todaybooking
			 */
			if(!movieNameList.contains(movieName)){
				updater.println(movieName +";" +0 +";" +bookingmade);
			}
			updater.close();
    	}catch(IndexOutOfBoundsException ex){
    		System.out.println("Error please check the array/arrayList usage");
			JOptionPane.showMessageDialog(null, "System error: Please Contact developer for help!");

    	}
		catch(FileNotFoundException ex){
    		System.out.println("Error please check File existence.");
			JOptionPane.showMessageDialog(null, "System error: Please Contact developer for help!");

    	}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "System error: Please Contact developer for help!");
    		
    	}
	}
	
	
	@Override
   public void start(Stage primaryStage) throws FileNotFoundException
	{
		BorderPane pane2 = new BorderPane();		
		GridPane ctop1 = new GridPane();
		ctop1.setPadding(new Insets(70, 50,50,15));
		ctop1.setHgap(40);
		GridPane ctop2 = new GridPane();
		ctop2.setPadding(new Insets(70, 50,50,15));
		ctop2.setHgap(40);
			StackPane pane = new StackPane();
			StackPane pane3 = new StackPane();
			pane2.setTop(pane);
			pane2.setBottom(pane3);
			
			//background pane
			Pane backgroundPane = new Pane();
				
				FileInputStream imageStream = new FileInputStream("MovieInterfaceResource/Background.png");
				backgroundPane.setPadding(new Insets(0,0,0,0));
				Image image = new Image(imageStream);
				backgroundPane.getChildren().add(new ImageView(image));
				
				Pane Footer = new Pane();
				
				FileInputStream imageStream2 = new FileInputStream("MovieInterfaceResource/Logo.png");
				Footer.setPadding(new Insets(30,0,0,530));
				Image image2 = new Image(imageStream2);
				Footer.getChildren().add(new ImageView(image2));
				Footer.setTranslateX(500);
				Footer.setTranslateY(40);
				
				FileInputStream imageStream12 = new FileInputStream("MovieInterfaceResource/Container.png");
				Image image12 = new Image(imageStream12);
				ImageView imgview12 = new ImageView(image12);
				imgview12.setFitWidth(400);
				imgview12.setFitHeight(90);
				imgview12.setTranslateX(50);
				imgview12.setTranslateY(200);
					
				FileInputStream imageStream13 = new FileInputStream("MovieInterfaceResource/Container.png");
				Image image13 = new Image(imageStream13);
				ImageView imgview13 = new ImageView(image13);
				imgview13.setFitWidth(400);
				imgview13.setFitHeight(90);
				imgview13.setTranslateX(500);
				imgview13.setTranslateY(200);
				
				FileInputStream imageStream14 = new FileInputStream("MovieInterfaceResource/Container.png");
				Image image14 = new Image(imageStream14);
				ImageView imgview14 = new ImageView(image14);
				imgview14.setFitWidth(400);
				imgview14.setFitHeight(500);
				imgview14.setTranslateX(50);
				imgview14.setTranslateY(300);
				
				FileInputStream imageStream15 = new FileInputStream("MovieInterfaceResource/Container.png");
				Image image15 = new Image(imageStream15);
				ImageView imgview15 = new ImageView(image15);
				imgview15.setFitWidth(400);
				imgview15.setFitHeight(300);
				imgview15.setTranslateX(900);
				imgview15.setTranslateY(300);
				
				
				FileInputStream picture = new FileInputStream("MovieInterfaceResource/AOT.png");
				Image moviepic = new Image(picture);
				ImageView moviepicture = new ImageView(moviepic);
				moviepicture.setFitWidth(400);
				moviepicture.setFitHeight(400);
				moviepicture.setTranslateX(500);
				moviepicture.setTranslateY(350);
				
				Text Text1 = new Text("Purchase Summary");
				Text1.setFont(Font.font(35));
				Text1.setFill(Color.CYAN);
				ctop1.add(Text1, 2, 2);
				Text1.setTranslateX(20);
				Text1.setTranslateY(150);
				
				Text Text2 = new Text("Movie Selected");
				Text2.setFont(Font.font(35));
				Text2.setFill(Color.CYAN);
				ctop2.add(Text2, 2, 2);
				Text2.setTranslateX(500);
				Text2.setTranslateY(150);
				
				Text Text3 = new Text("Ticket Summary");
				Text3.setFont(Font.font(30));
				Text3.setFill(Color.CYAN);
				Text3.setTranslateX(60);
				Text3.setTranslateY(400);
				
				Text Text4 = new Text("Adult     : " );
				Text4.setFont(Font.font(25));
				Text4.setFill(Color.CYAN);
				Text4.setTranslateX(60);
				Text4.setTranslateY(500);
				
				
				Text Text5 = new Text("Children     :" );
				Text5.setFont(Font.font(25));
				Text5.setFill(Color.CYAN);
				Text5.setTranslateX(60);
				Text5.setTranslateY(550);
				
				Text Text6 = new Text("Booking Fee     :       RM 3.00");
				Text6.setFont(Font.font(25));
				Text6.setFill(Color.CYAN);
				Text6.setTranslateX(60);
				Text6.setTranslateY(600);
				
				Text Text7 = new Text("Seats      :" );
				Text7.setFont(Font.font(25));
				Text7.setFill(Color.CYAN);
				Text7.setTranslateX(60);
				Text7.setTranslateY(650);
				
				Text Text8= new Text("Total Price      :" );
				Text8.setFont(Font.font(25));
				Text8.setFill(Color.CYAN);
				Text8.setTranslateX(60);
				Text8.setTranslateY(700);
				
				Text Text9= new Text("Movie Name      :" );
				Text9.setFont(Font.font(25));
				Text9.setFill(Color.CYAN);
				Text9.setTranslateX(920);
				Text9.setTranslateY(370);
				
				Text Text10= new Text("Date      :");
				Text10.setFont(Font.font(25));
				Text10.setFill(Color.CYAN);
				Text10.setTranslateX(920);
				Text10.setTranslateY(420);
				
				Text Text11= new Text("Showtime      :"  );
				Text11.setFont(Font.font(25));
				Text11.setFill(Color.CYAN);
				Text11.setTranslateX(920);
				Text11.setTranslateY(480);
				
				Text Text12= new Text("Hall Booked      :"  );
				Text12.setFont(Font.font(25));
				Text12.setFill(Color.CYAN);
				Text12.setTranslateX(920);
				Text12.setTranslateY(530);
				
				
			Label label1 = new Label();
			pane3.getChildren().add(label1);
			
			Button button1 = new Button("Confirm Purchase");
			pane.getChildren().add(button1);
			button1.setTranslateX(1000);
			button1.setTranslateY(800);
			button1.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; -fx-font-size: 30; /* 30 */ -fx-text-fill: #ffffff;");
			
			button1.setOnAction(e -> 
			{
				File file = new File("myfile.txt");
				if(file.exists())
				{
					System.out.println("File already exists");
					System.exit(0);
				}
				try(
				PrintWriter output = new PrintWriter(file);
				){
				output.println("Power Rangers,9.30am-13.30am,3children/rm15.00,2adult/RM20.00,3,RM35.00,A3,A4,B3,B4,C5");
				
				}
				catch(FileNotFoundException ex)
				{
					System.out.println("Error");
					JOptionPane.showMessageDialog(null, "System error: Please Contact developer for help!");

				}
				label1.setText("Receipt Generated");
				label1.setTextFill(Color.CYAN);
				label1.setTranslateX(1100);
				label1.setTranslateY(850);
				
			}
					);
			backgroundPane.getChildren().addAll(pane2,pane,Footer,imgview12, imgview13, imgview14 ,imgview15, ctop1, ctop2,Text3,Text4, Text5, Text6, Text7, Text8,Text9,Text10, Text11, Text12, moviepicture);
			Scene scene = new Scene(backgroundPane, 1440, 960);
		primaryStage.setTitle("JSCinema");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}

}

