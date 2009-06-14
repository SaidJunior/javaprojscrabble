package Gui;
import java.io.File; 
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.internal.graphics.ImageData;
import org.eclipse.swt.internal.graphics.ResourceFactory;
import org.eclipse.ui.plugin.AbstractUIPlugin;  

public class Images {
 public static Image getImage(String imageName){
	 ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin("com.rcp.Scrabble", "src/resources/" + imageName);
	 return desc.createImage();
 }
 
 public static ImageData getImageData(Image image){
	 return ResourceFactory.getImageData(image);
 }
 
 public static Image getImageFromData(ImageData data){ 
	 return ResourceFactory.findImage(data);
 }
}
