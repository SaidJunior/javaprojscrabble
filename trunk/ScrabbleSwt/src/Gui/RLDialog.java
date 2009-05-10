package Gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import scrabbleMain.GameGui;

public class RLDialog extends Dialog {
	private boolean isBasic;
	public RLDialog(Shell parent, boolean isBasic) {
		super(parent);
		this.isBasic = isBasic;
	}

	public void open() {
		final Shell shell = new Shell(getParent(), SWT.DIALOG_TRIM |
		SWT.APPLICATION_MODAL);
		shell.setText("Help");
		shell.setSize(400,500);
		
		Button btnOkay = new Button (shell, SWT.PUSH);
		btnOkay.setText ("OK");
		btnOkay.setLocation(170,420);
		btnOkay.setSize(55,25);
		btnOkay.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				shell.close();
			}
		});
		
		Text txtResponse = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		txtResponse.setLocation(10,10);
		txtResponse.setSize(380, 400);
		txtResponse.setEditable(false);
		txtResponse.setText(GameGui.printRecordListToLabel((isBasic == true) ? 'b' : 'a'));
		
		shell.open();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
	}
}
