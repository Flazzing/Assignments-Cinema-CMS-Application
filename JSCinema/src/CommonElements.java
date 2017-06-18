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
	
	//this function returns an ImageView of the background image
	public static ImageView getBackgroundImage(){
		Image image = null;
		try {
			image = new Image("1.png");
		} catch (NullPointerException npe) {
			System.err.println("Image could not be opened from 1.png. Closing application.");
			System.exit(1);
		}
		return new ImageView(image);
	}

}
