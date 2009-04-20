package resources.Letter2;

import java.io.InputStream;


public class letter2Config {
	

	public static final Class<letter2Config> resourcesClass = resources.Letter2.letter2Config.class;
	        
		public static InputStream getImageStream(String fileName){
	    	return resourcesClass.getResourceAsStream(fileName);
		}
}