import java.io.File;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Testing extends Application{

	public void start(Stage primaryStage)throws Exception{
		Pane graph = new Pane();
    	
    	CategoryAxis xAxis = new CategoryAxis();
    	NumberAxis yAxis = new NumberAxis();
    	
    	bc.setTitle("Booking summary");
    	xAxis.setLabel("Date");
    	yAxis.setLabel("Number of Booking");
    	
    	File file = new File("bookingmade.txt");
    	
    	if(file.exists()){
    		System.out.println("File Opened!");
    		Scanner input = new Scanner(file);
    		String movieTitle ="";
    		String bookingmade = "";
    		while(input.hasNextLine()){
    			movieTitle = input.nextLine();
    			bookingmade = input.nextLine();
    			
    			ObservableList<BarChart.Data> pieChartData = 
    					FXCollections.observableArrayList(
    							BarChart.Data
    							);
    			
    			System.out.println(movieTitle+ bookingmade);
    		}
    		input.close();
    	}else{
    		System.out.println("File not found, No graph to be shown");
    	}
    	
    	graph.getChildren().add(bc);
    	Scene scene = new Scene(graph, 500,500);
		primaryStage.setTitle("Dashboard"); //Set the stage title 
		primaryStage.setScene(scene); //Place the scene in the stage
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}
