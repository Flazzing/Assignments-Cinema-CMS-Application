import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class houses the different elements that are commonly used on all of the application's scenes
 */

/**
 * @author Steve
 *
 */
public class CommonElements {
	
	/*
	 * This function returns an ImageView of the background image at 900x600
	 */
	public static ImageView getBackgroundImage(){
		Image image = null;
		try {
			FileInputStream imageStream1 = new FileInputStream("1.png");
			image = new Image(imageStream1);
		} catch (NullPointerException npe) {
			System.err.println("Image could not be opened from 1.png. Closing application.");
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("getBackgroundImage is having problems reading 1.png.");;
		}
		return new ImageView(image);
	}

}
