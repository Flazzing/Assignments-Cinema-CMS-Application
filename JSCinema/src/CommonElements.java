import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class houses the different elements that are commonly used on all of the application's scenes
 * 
 * Rant:
 * PLEASE USE THIS CLASS TO LOAD ALL IMAGES. PLEASE. I BEG OF YOU.
 * Setting up the FileInputStreams, Images, and ImageViews will make the files too long.
 * Too long for anyone to read the code without spending several hours on it already.
 * 
 */

/**
 * @author Steve
 *
 */
public class CommonElements {
	
	/*
	 * This function returns an ImageView of the background image
	 */
	public static ImageView getElementView(String url){
		Image image = null;
		try {
			FileInputStream imageStream1 = new FileInputStream(url);
			image = new Image(imageStream1);
		} catch (NullPointerException npe) {
			System.err.println("Image could not be opened from " + url + " . Closing application.");
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("getBackgroundImage is having problems reading " + url + ".");;
		}
		return new ImageView(image);
	}
	
	/*
	 *  This function sets Buttons to their standard style
	 */
	public static void setStandardButtonStyle(Button btn){
		btn.setStyle("-fx-text-fill: white; -fx-font-size: 35px;  -fx-padding: 3 20 3 30; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: transparent; "
    			+ "-fx-background-color: transparent;");
	}
	
	/*
	 *  This function sets TextFields to their standard style
	 */
	public static void setStandardTextFieldStyle(TextField tf){
		tf.setStyle("-fx-text-fill: white; -fx-padding: 3 3 3 3; "
    			+ "-fx-background-radius: 7,2,1; -fx-border-color: #00B0F0; -fx-border-width: 5px; "
    			+ "-fx-background-color: transparent;");
	}
	
	/*
	 * This function just directly gets 1.png (background) from PageLayout
	 */
	public static ImageView getBackgroundImage(){
		return getElementView("PageLayout/1.png");
	}
	
	/*
	 * This function just directly gets 2.png (header) from PageLayout
	 */
	public static ImageView getHeaderImage(){
		return getElementView("PageLayout/2.png");
	}

	/*
	 * This function just directly gets 3.png (title) from PageLayout
	 */
	public static ImageView getTitleImage(){
		return getElementView("PageLayout/3.png");
	}
	
}
