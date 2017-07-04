import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.application.Application.launch;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class HomePage {
	
	public Scene getUserScene(Stage stage) throws Exception{
		
		//SCENE 1 - NOW SHOWING
		Pane rootPane = new Pane();
		
		//background pane
		Pane backgroundPane = new Pane();
			
			FileInputStream imageStream = new FileInputStream("Background.png");
			backgroundPane.setPadding(new Insets(0,0,0,0));
			Image image = new Image(imageStream);
			backgroundPane.getChildren().add(new ImageView(image));
		
		VBox lam = new VBox();
		
			Button imdb = new Button();
			imdb.setMaxSize(300, 300);
			imdb.setGraphic(new ImageView(image));
			lam.getChildren().add(imdb);
			
			HBox MoviesCommingSoon = new HBox();
			
			MoviesCommingSoon.setPadding(new Insets(350,0,0,360));
			FileInputStream file2 = new FileInputStream("UserPage/comingSoon.txt");
			Scanner MovNames = new Scanner(file2);
			Button MovImages [] = new Button[15];
			int count5 = 0;
			while(MovNames.hasNext()){
				String line = MovNames.nextLine();
				String[] splitter = line.split(",");
				
				MovImages[count5] = new Button();
				Image ComingSoonMovieImages = new Image(getClass().getResourceAsStream(splitter[3]));
				MovImages[count5].setGraphic(new ImageView(ComingSoonMovieImages));
				MoviesCommingSoon.getChildren().add(MovImages[count5]);
				count5++;
			}
			MovNames.close();
			
		rootPane.getChildren().addAll(backgroundPane,lam,MoviesCommingSoon);
		Scene scene = new Scene(rootPane, 1440 , 960 );
		stage.setTitle("JSC");
		return scene;
}
}


