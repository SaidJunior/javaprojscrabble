package resources.Letters;

import java.io.InputStream;


public class lettersConfig {
	

	public static final Class<lettersConfig> resourcesClass = resources.Letters.lettersConfig.class;
	        
		public static InputStream getImageStream(String fileName){
	    	return resourcesClass.getResourceAsStream(fileName);
		}
}
