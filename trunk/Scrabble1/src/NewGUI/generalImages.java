package NewGUI;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import resources.resConfig;

public class generalImages {

	/** This class will hold general Images that will be in use of all classes.
	 * */
	
	private static Image logo = null;
	private static boolean boolLogo = false;
	
	private static void initLogo()
	{
		if (boolLogo == true)
			return;
		InputStream input = resConfig.getImageStream("logo.jpg");
		try{
			setLogo(ImageIO.read(input));
			setBoolLogo(true);
		}
		catch(IOException e){}
		setBoolLogo(false);
		return;
	}

	public static Image getLogo() throws IOException {
		if (boolLogo == false)
			initLogo();
		return logo;
	}

	private static void setLogo(Image logo) {
		generalImages.logo = logo;
	}

	public static boolean isBoolLogo() {
		return boolLogo;
	}

	private static void setBoolLogo(boolean boolLogo) {
		generalImages.boolLogo = boolLogo;
	}

	
	public static ImageIcon getStartImage()
	{
		ImageIcon image = new javax.swing.ImageIcon(resConfig.getURL("scrabble.jpg"));
		
		return image;
	}

	public static ImageIcon getlettersSackImage()
	{
		ImageIcon image = new javax.swing.ImageIcon(resConfig.getURL("letters.jpg"));
		
		return image;
	}
}
