package testClasses;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

public class TestDialogWindow {

	/**
	 * @param args
	 */
	
	private static boolean showMessageDialog(String string, String string2,Shell shell) {
		String message = (string);
		String title=(string2);
		String []options= new String [2];
		options[0]="YES";
		options[1]="NO";
		MessageDialog messageBox = new MessageDialog(shell, title,null,message,MessageDialog.QUESTION,options,2);
		
		int response = messageBox.open();
		if (response == 0) {
			return true;
		} else  {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//	display.setWarnings(false);
	//	 Shell shell = new Shell(display);
		Shell  shell = new Shell(display, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);              
		  shell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE)); 
		showMessageDialog("Title","Message",shell);

	}

}
