package Gui;
import com.cloudgarden.resource.SWTResourceManager;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class NewMultiDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Label label1;
	private Button cancelConnect;
	private Button newUser;
	private Button AutoCheck;
	private Text EmailText;
	private Text text2;
	private Text text1;
	private Label label3;
	private Label label2;
	private boolean isClosed;
	private ClientInfo cInfo;
	private Button Existing;

	public boolean isClosed() {
		return isClosed;
	}


	public NewMultiDialog(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			
			
			dialogShell.setLayout(new FormLayout());
			dialogShell.setText("Multiplayer Dialog");
			{
				Existing = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				Existing.setText("Login User");
				FormData ExistingLData = new FormData();
				ExistingLData.width = 68;
				ExistingLData.height = 31;
				ExistingLData.left =  new FormAttachment(0, 1000, 131);
				ExistingLData.top =  new FormAttachment(0, 1000, 165);
				Existing.setLayoutData(ExistingLData);
				Existing.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						//System.out.println("Existing.widgetSelected, event="+evt);
						isClosed = false;
						if (!text1.getText().equals(""))
							setClientInfo(false);
						else{
							MessageBox m = new MessageBox(dialogShell, SWT.ICON_ERROR);
							m.setText("Error");
							m.setMessage("You must specify the name");
							m.open();
						}
					}
				});
			}
			{
				cancelConnect = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				cancelConnect.setText("Cancel");
				FormData cancelConnectLData = new FormData();
				cancelConnectLData.width = 43;
				cancelConnectLData.height = 32;
				cancelConnectLData.top =  new FormAttachment(0, 1000, 165);
				cancelConnectLData.left =  new FormAttachment(0, 1000, 205);
				cancelConnectLData.right =  new FormAttachment(1000, 1000, -46);
				cancelConnect.setLayoutData(cancelConnectLData);
				cancelConnect.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						isClosed = true;
						dialogShell.dispose();
					}
				});
			}
			{
				newUser = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				newUser.setText("Login New User");
				FormData connectLData = new FormData();
				connectLData.width = 87;
				connectLData.height = 31;
				connectLData.top =  new FormAttachment(0, 1000, 165);
				connectLData.left =  new FormAttachment(0, 1000, 38);
				newUser.setLayoutData(connectLData);
				newUser.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						isClosed = false;
						if (!text1.getText().equals(""))
							setClientInfo(true);
						else{
							MessageBox m = new MessageBox(dialogShell, SWT.ICON_ERROR);
							m.setText("Error");
							m.setMessage("You must specify the name");
							m.open();
						}
					}
					
				});
			}
			{
				AutoCheck = new Button(dialogShell, SWT.CHECK | SWT.LEFT);
				AutoCheck.setText("Automated Player");
				FormData AutoCheckLData = new FormData();
				AutoCheckLData.width = 111;
				AutoCheckLData.height = 16;
				AutoCheckLData.left =  new FormAttachment(0, 1000, 18);
				AutoCheckLData.top =  new FormAttachment(0, 1000, 129);
				AutoCheck.setLayoutData(AutoCheckLData);
			}
			{
				EmailText = new Text(dialogShell, SWT.NONE);
				FormData EmailTextLData = new FormData();
				EmailTextLData.width = 119;
				EmailTextLData.height = 17;
				EmailTextLData.left =  new FormAttachment(0, 1000, 91);
				EmailTextLData.top =  new FormAttachment(0, 1000, 91);
				EmailText.setLayoutData(EmailTextLData);
			}
			{
				text2 = new Text(dialogShell, SWT.NONE);
				FormData text2LData = new FormData();
				text2LData.width = 119;
				text2LData.height = 17;
				text2LData.left =  new FormAttachment(0, 1000, 91);
				text2LData.top =  new FormAttachment(0, 1000, 62);
				text2.setLayoutData(text2LData);
			}
			{
				text1 = new Text(dialogShell, SWT.NONE);
				FormData text1LData = new FormData();
				text1LData.width = 119;
				text1LData.height = 17;
				text1LData.left =  new FormAttachment(0, 1000, 91);
				text1LData.top =  new FormAttachment(0, 1000, 30);
				text1.setLayoutData(text1LData);
			}
			{
				label3 = new Label(dialogShell, SWT.NONE);
				label3.setText("Email:");
				FormData label3LData = new FormData();
				label3LData.width = 43;
				label3LData.height = 17;
				label3LData.left =  new FormAttachment(0, 1000, 18);
				label3LData.top =  new FormAttachment(0, 1000, 91);
				label3.setLayoutData(label3LData);
				label3.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
			}
			{
				label2 = new Label(dialogShell, SWT.NONE);
				label2.setText("password:");
				FormData label2LData = new FormData();
				label2LData.width = 61;
				label2LData.height = 17;
				label2LData.left =  new FormAttachment(0, 1000, 18);
				label2LData.top =  new FormAttachment(0, 1000, 62);
				label2.setLayoutData(label2LData);
				label2.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
			}
			{
				label1 = new Label(dialogShell, SWT.NONE);
				label1.setText("username:");
				FormData label1LData = new FormData();
				label1LData.width = 61;
				label1LData.height = 20;
				label1LData.left =  new FormAttachment(0, 1000, 18);
				label1LData.top =  new FormAttachment(0, 1000, 30);
				label1.setLayoutData(label1LData);
				label1.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
			}
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setLocation(getParent().toDisplay(100, 100));
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void setClientInfo(boolean newUser) {
		setCInfo(new ClientInfo(
				text1.getText(),
				text2.getText(),
				EmailText.getText(),
				AutoCheck.getSelection(),
				newUser));
		dialogShell.dispose();
	}

	public void setCInfo(ClientInfo cInfo) {
		this.cInfo = cInfo;
	}

	public ClientInfo getCInfo() {
		return cInfo;
	}

	public class ClientInfo {
		private String playerName;
		private String password;
		private String email;
		private boolean isAuto;
		private boolean user = true; //if false then guest
		private boolean newUser;
	
		private ClientInfo(String playerName, String password, String email, boolean isAuto, boolean newUser) {
			this.playerName = playerName;
			this.setPassword(password);
			this.setEmail(email);
			this.isAuto     = isAuto;
			if (password == null || password.equals(""))
				setUser(false);
			this.setNewUser(newUser);
		}
	
		public boolean isAuto() {
			return isAuto;
		}

		public void setAuto(boolean isAuto) {
			this.isAuto = isAuto;
		}

		public String getPlayerName() {
			return playerName;
		}
	
		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPassword() {
			return password;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEmail() {
			return email;
		}

		public void setUser(boolean user) {
			this.user = user;
		}

		public boolean isUser() {
			return user;
		}

		public void setNewUser(boolean newUser) {
			this.newUser = newUser;
		}

		public boolean isNewUser() {
			return newUser;
		}
	}

}