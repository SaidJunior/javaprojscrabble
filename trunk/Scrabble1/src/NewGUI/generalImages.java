package NewGUI;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

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
	
	

}
