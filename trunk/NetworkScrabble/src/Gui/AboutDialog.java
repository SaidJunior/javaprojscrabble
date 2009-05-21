package Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;

import scrabbleMain.GameGui;

public class AboutDialog extends Dialog {

	public AboutDialog(Shell parent) {
		super(parent);
	}
	
	public void open() {
		final Shell shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setText("About");
		shell.setSize(400,320);
		
		Button btnOkay = new Button (shell, SWT.PUSH);
		btnOkay.setText ("OK");
		btnOkay.setLocation(150 ,260);
		btnOkay.setSize(55,25);
		btnOkay.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				shell.close();
			}
		});
		
		Text txtResponse = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		txtResponse.setLocation(10,10);
		txtResponse.setSize(280, 240);
		txtResponse.setEditable(false);
		txtResponse.setText(GameGui.parseFileToString("AboutUs.txt"));
		
		CLabel tauPicture = new CLabel(shell, SWT.NONE);
		tauPicture.setLocation(300, 10);
		tauPicture.setSize(80, 80);
		tauPicture.setBackground(SWTResourceManager.getImage("resources/tau.jpg"));
		
		shell.open();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		
	}

}
