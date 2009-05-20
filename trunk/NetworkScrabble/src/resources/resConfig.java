package resources;

import java.io.InputStream;

	public class resConfig {
		

		public static final Class<resConfig> resourcesClass = resources.resConfig.class;
   
			public static InputStream getImageStream(String fileName){
		    	return resourcesClass.getResourceAsStream(fileName);
			}
	}
