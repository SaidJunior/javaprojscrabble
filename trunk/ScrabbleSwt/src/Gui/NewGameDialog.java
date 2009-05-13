package Gui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;


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
public class NewGameDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private CLabel selectGameTypeLabel;
	private CLabel name3Label;
	private Text player2Text;
	private Button clearButton;
	private CLabel bottomSpaceLabel;
	private Button cancelButton;
	private Button startButton;
	private Button computerCheck4;
	private Button computerCheck3;
	private Button computerCheck2;
	private CLabel computerLabel;
	private Text player4Text;
	private Text player3Text;
	private Text player1Text;
	private CLabel name4Label;
	private CLabel name2Label;
	private CLabel name1Label;
	private CCombo numberOfPlayersCombo;
	private CLabel numberOfPlayersLabel;
	private Button advancedButton;
	private Button basicButton;
	private boolean isClosed;
//	private int numberOfPlayers;
//	private String[] names;
//	private String name2;
//	private String name3;
//	private String name4;
	
	/**
	 * @return the isClosed
	 */
	public boolean isClosed() {
		return isClosed;
	}

	private PlayerInfo[] playersInfo;
	private char gameMode;
	
    /**
	 * @return the playersInfo
	 */
	public PlayerInfo[] getPlayersInfo() {
		return playersInfo;
	}

	/**
	 * @param playersInfo the playersInfo to set
	 */
	public void setPlayersInfo(PlayerInfo[] playersInfo) {
		this.playersInfo = playersInfo;
	}

	/**
	 * @return the isBasic
	 */
	public char getGameMode() {
		return gameMode;
	}

	/**
	 * @param gameMode the isBasic to set
	 */
	public void setGameMode(char gameMode) {
		this.gameMode = gameMode;
	}

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			shell.setText("New Game Dialog");
			NewGameDialog inst = new NewGameDialog(shell, SWT.NULL);
			inst.setText("New Game Dialog");
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NewGameDialog(Shell parent, int style) {
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
			dialogShell.setSize(500, 600);
			dialogShell.setText("New Game Dialog");
			dialogShell.setFont(SWTResourceManager.getFont("Tahoma", 12, 0, false, false));
			{
				clearButton = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				clearButton.setText("Clear");
				FormData clearButtonLData = new FormData();
				clearButtonLData.width = 60;
				clearButtonLData.height = 39;
				clearButtonLData.left =  new FormAttachment(0, 1000, 340);
				clearButtonLData.top =  new FormAttachment(0, 1000, 339);
				clearButton.setLayoutData(clearButtonLData);
				clearButton.setFont(SWTResourceManager.getFont("Tahoma", 12, 0, false, false));
				clearButton.setToolTipText("Clear new game form");
				clearButton.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						clearButtonWidgetSelected(evt);
					}
				});
			}
			{
				bottomSpaceLabel = new CLabel(dialogShell, SWT.NONE);
				FormData bottomSpaceLabelLData = new FormData();
				bottomSpaceLabelLData.width = 6;
				bottomSpaceLabelLData.height = 24;
				bottomSpaceLabelLData.left =  new FormAttachment(0, 1000, 4);
				bottomSpaceLabelLData.top =  new FormAttachment(0, 1000, 378);
				bottomSpaceLabel.setLayoutData(bottomSpaceLabelLData);
			}
			{
				cancelButton = new Button(dialogShell, SWT.TOGGLE | SWT.CENTER);
				cancelButton.setText("Cancel");
				FormData cancelButtonLData = new FormData();
				cancelButtonLData.width = 60;
				cancelButtonLData.height = 39;
				cancelButtonLData.left =  new FormAttachment(0, 1000, 251);
				cancelButtonLData.top =  new FormAttachment(0, 1000, 339);
				cancelButton.setLayoutData(cancelButtonLData);
				cancelButton.setFont(SWTResourceManager.getFont("Tahoma", 12, 0, false, false));
				cancelButton.setToolTipText("Cancel");
				cancelButton.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
//						System.out.println("cancelButton.widgetSelected, event="+evt);
						isClosed = true;
						dialogShell.dispose();
					}
				});
			}
			{
				startButton = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				startButton.setText("Start Scrabble!");
				FormData startButtonLData = new FormData();
				startButtonLData.width = 175;
				startButtonLData.height = 39;
				startButtonLData.left =  new FormAttachment(0, 1000, 47);
				startButtonLData.top =  new FormAttachment(0, 1000, 339);
				startButton.setLayoutData(startButtonLData);
				startButton.setFont(SWTResourceManager.getFont("Tahoma", 12, 0, false, false));
				startButton.setToolTipText("Start game");
				startButton.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						startButtonWidgetSelected(evt);
					}
				});
			}
			{
				computerCheck4 = new Button(dialogShell, SWT.CHECK | SWT.LEFT);
				FormData computerCheck4LData = new FormData();
				computerCheck4LData.width = 13;
				computerCheck4LData.height = 16;
				computerCheck4LData.left =  new FormAttachment(0, 1000, 400);
				computerCheck4LData.top =  new FormAttachment(0, 1000, 270);
				computerCheck4.setLayoutData(computerCheck4LData);
				computerCheck4.setToolTipText("Make player 4 an auto player");
				computerCheck4.setEnabled(false);
			}
			{
				computerCheck3 = new Button(dialogShell, SWT.CHECK | SWT.LEFT);
				FormData button1LData = new FormData();
				button1LData.width = 13;
				button1LData.height = 16;
				button1LData.left =  new FormAttachment(0, 1000, 400);
				button1LData.top =  new FormAttachment(0, 1000, 234);
				computerCheck3.setLayoutData(button1LData);
				computerCheck3.setToolTipText("Make player 3 an auto player");
				computerCheck3.setEnabled(false);
			}
			{
				computerCheck2 = new Button(dialogShell, SWT.CHECK | SWT.LEFT);
				FormData computerCheck2LData = new FormData();
				computerCheck2LData.width = 18;
				computerCheck2LData.height = 24;
				computerCheck2LData.left =  new FormAttachment(0, 1000, 400);
				computerCheck2LData.top =  new FormAttachment(0, 1000, 190);
				computerCheck2.setLayoutData(computerCheck2LData);
				computerCheck2.setToolTipText("Make player 2 an auto player");
				computerCheck2.setEnabled(false);
			}
			{
				computerLabel = new CLabel(dialogShell, SWT.NONE);
				computerLabel.setText("Computer");
				FormData computerLabelLData = new FormData();
				computerLabelLData.width = 124;
				computerLabelLData.height = 22;
				computerLabelLData.left =  new FormAttachment(0, 1000, 368);
				computerLabelLData.top =  new FormAttachment(0, 1000, 121);
				computerLabel.setLayoutData(computerLabelLData);
				computerLabel.setFont(SWTResourceManager.getFont("Tahoma", 12, 0, false, false));
			}
			{
				player4Text = new Text(dialogShell, SWT.BORDER);
				FormData player4TextLData = new FormData();
				player4TextLData.width = 247;
				player4TextLData.height = 24;
				player4TextLData.left =  new FormAttachment(0, 1000, 106);
				player4TextLData.top =  new FormAttachment(0, 1000, 262);
				player4Text.setLayoutData(player4TextLData);
				player4Text.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
				player4Text.setToolTipText("Enter Player 4's name");
				player4Text.setEnabled(false);
			}
			{
				player3Text = new Text(dialogShell, SWT.BORDER);
				FormData player3TextLData = new FormData();
				player3TextLData.width = 247;
				player3TextLData.height = 24;
				player3TextLData.left =  new FormAttachment(0, 1000, 106);
				player3TextLData.top =  new FormAttachment(0, 1000, 226);
				player3Text.setLayoutData(player3TextLData);
				player3Text.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
				player3Text.setToolTipText("Enter Player 3's name");
				player3Text.setEnabled(false);
			}
			{
				player2Text = new Text(dialogShell, SWT.BORDER);
				FormData player2TextLData = new FormData();
				player2TextLData.width = 247;
				player2TextLData.height = 24;
				player2TextLData.left =  new FormAttachment(0, 1000, 106);
				player2TextLData.top =  new FormAttachment(0, 1000, 190);
				player2Text.setLayoutData(player2TextLData);
				player2Text.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
				player2Text.setToolTipText("Enter Player 2's name");
				player2Text.setEnabled(false);
			}
			{
				player1Text = new Text(dialogShell, SWT.BORDER);
				FormData text1LData = new FormData();
				text1LData.width = 247;
				text1LData.height = 24;
				text1LData.left =  new FormAttachment(0, 1000, 106);
				text1LData.top =  new FormAttachment(0, 1000, 154);
				player1Text.setLayoutData(text1LData);
				player1Text.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
				player1Text.setToolTipText("Enter Player 1's name");
			}
			{
				name4Label = new CLabel(dialogShell, SWT.NONE);
				name4Label.setText("Player 4:");
				FormData name4LabelLData = new FormData();
				name4LabelLData.width = 72;
				name4LabelLData.height = 24;
				name4LabelLData.left =  new FormAttachment(0, 1000, 22);
				name4LabelLData.top =  new FormAttachment(0, 1000, 262);
				name4Label.setLayoutData(name4LabelLData);
				name4Label.setFont(SWTResourceManager.getFont("Tahoma", 12, 2, false, false));
			}
			{
				name3Label = new CLabel(dialogShell, SWT.NONE);
				name3Label.setText("Player 3:");
				FormData player3LabelLData = new FormData();
				player3LabelLData.width = 72;
				player3LabelLData.height = 24;
				player3LabelLData.left =  new FormAttachment(0, 1000, 22);
				player3LabelLData.top =  new FormAttachment(0, 1000, 226);
				name3Label.setLayoutData(player3LabelLData);
				name3Label.setFont(SWTResourceManager.getFont("Tahoma", 12, 2, false, false));
			}
			{
				name2Label = new CLabel(dialogShell, SWT.NONE);
				name2Label.setText("Player 2:");
				FormData player2LabelLData = new FormData();
				player2LabelLData.width = 72;
				player2LabelLData.height = 24;
				player2LabelLData.left =  new FormAttachment(0, 1000, 22);
				player2LabelLData.top =  new FormAttachment(0, 1000, 190);
				name2Label.setLayoutData(player2LabelLData);
				name2Label.setFont(SWTResourceManager.getFont("Tahoma", 12, 2, false, false));
			}
			{
				name1Label = new CLabel(dialogShell, SWT.NONE);
				name1Label.setText("Player 1:");
				FormData name1LabelLData = new FormData();
				name1LabelLData.width = 72;
				name1LabelLData.height = 24;
				name1LabelLData.left =  new FormAttachment(0, 1000, 22);
				name1LabelLData.top =  new FormAttachment(0, 1000, 154);
				name1Label.setLayoutData(name1LabelLData);
				name1Label.setFont(SWTResourceManager.getFont("Tahoma", 12, 2, false, false));
			}
			{
				numberOfPlayersCombo = new CCombo(dialogShell, SWT.BORDER);
				FormData cCombo1LData = new FormData();
				cCombo1LData.width = 84;
				cCombo1LData.height = 22;
				cCombo1LData.left =  new FormAttachment(0, 1000, 237);
				cCombo1LData.top =  new FormAttachment(0, 1000, 74);
				numberOfPlayersCombo.setLayoutData(cCombo1LData);
				numberOfPlayersCombo.setFont(SWTResourceManager.getFont("Tahoma", 12, 0, false, false));
				numberOfPlayersCombo.setToolTipText("Number of players");
				numberOfPlayersCombo.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						numberOfPlayersComboWidgetSelected(evt);
					}
				});
				numberOfPlayersCombo.setText("1");
				numberOfPlayersCombo.add("1");
				numberOfPlayersCombo.add("2");
				numberOfPlayersCombo.add("3");
				numberOfPlayersCombo.add("4");
			}
			{
				numberOfPlayersLabel = new CLabel(dialogShell, SWT.NONE);
				numberOfPlayersLabel.setText("Select Number Of Players:");
				FormData numberOfPlayersLabelLData = new FormData();
				numberOfPlayersLabelLData.width = 213;
				numberOfPlayersLabelLData.height = 24;
				numberOfPlayersLabelLData.left =  new FormAttachment(0, 1000, 12);
				numberOfPlayersLabelLData.top =  new FormAttachment(0, 1000, 72);
				numberOfPlayersLabel.setLayoutData(numberOfPlayersLabelLData);
				numberOfPlayersLabel.setFont(SWTResourceManager.getFont("Tahoma", 12, 2, false, false));
			}
			{
				advancedButton = new Button(dialogShell, SWT.RADIO | SWT.LEFT);
				advancedButton.setText("Advanced");
				FormData advancedButtonLData = new FormData();
				advancedButtonLData.width = 98;
				advancedButtonLData.height = 18;
				advancedButtonLData.left =  new FormAttachment(0, 1000, 238);
				advancedButtonLData.top =  new FormAttachment(0, 1000, 44);
				advancedButton.setLayoutData(advancedButtonLData);
				advancedButton.setFont(SWTResourceManager.getFont("Tahoma", 12, 0, false, false));
				advancedButton.setToolTipText("professional game");
				advancedButton.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						advancedButtonWidgetSelected(evt);
					}
				});
			}
			{
				basicButton = new Button(dialogShell, SWT.RADIO | SWT.LEFT);
				basicButton.setText("Basic");
				FormData basicButtonLData = new FormData();
				basicButtonLData.width = 77;
				basicButtonLData.height = 20;
				basicButtonLData.left =  new FormAttachment(0, 1000, 238);
				basicButtonLData.top =  new FormAttachment(0, 1000, 12);
				basicButton.setLayoutData(basicButtonLData);
				basicButton.setFont(SWTResourceManager.getFont("Tahoma", 12, 0, false, false));
				basicButton.setToolTipText("Beginers game");
				basicButton.setSelection(true);
				basicButton.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						basicButtonWidgetSelected(evt);
					}
				});
			}
			{
				selectGameTypeLabel = new CLabel(dialogShell, SWT.NONE);
				selectGameTypeLabel.setText("Select Game Type:");
				FormData selectGameTypeLabelLData = new FormData();
				selectGameTypeLabelLData.width = 143;
				selectGameTypeLabelLData.height = 26;
				selectGameTypeLabelLData.left =  new FormAttachment(0, 1000, 12);
				selectGameTypeLabelLData.top =  new FormAttachment(0, 1000, 12);
				selectGameTypeLabel.setLayoutData(selectGameTypeLabelLData);
				selectGameTypeLabel.setFont(SWTResourceManager.getFont("Tahoma", 12, 2, false, false));
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
	
	//clears the dialog to default
	private void clearButtonWidgetSelected(SelectionEvent evt) {
//		System.out.println("clearButton.widgetSelected, event="+evt);
		basicButton.setSelection(true);
		advancedButton.setSelection(false);
		numberOfPlayersCombo.setText("1");
		player1Text.setText("");
		player2Text.setText("");
		player2Text.setEnabled(false);
		player3Text.setText("");
		player3Text.setEnabled(false);
		player4Text.setText("");
		player4Text.setEnabled(false);
		computerCheck2.setSelection(false);
		computerCheck2.setEnabled(false);
		computerCheck3.setSelection(false);
		computerCheck3.setEnabled(false);
		computerCheck4.setSelection(false);
		computerCheck4.setEnabled(false);
	}
	
	private void numberOfPlayersComboWidgetSelected(SelectionEvent evt) {
//		System.out.println("numberOfPlayersCombo.widgetSelected, event="+evt);
		//set the players text and check boxes according to selection
		setPlayerTextAndCheckBoxes();
	}

	private void setPlayerTextAndCheckBoxes() {	
		int selection = numberOfPlayersCombo.getSelectionIndex();
//		System.out.println(selection);
		if (selection == 0) {
			player2Text.setEnabled(false);
			player2Text.setText("");
			player3Text.setEnabled(false);
			player3Text.setText("");
			player4Text.setEnabled(false);
			player4Text.setText("");
			//if (basicButton.getSelection() == true) {
				computerCheck2.setSelection(false);
				computerCheck2.setEnabled(false);
				computerCheck3.setSelection(false);
				computerCheck3.setEnabled(false);
				computerCheck4.setSelection(false);
				computerCheck4.setEnabled(false);
			//}
		} else if (selection == 1) {
			player2Text.setEnabled(true);
			player3Text.setEnabled(false);
			player3Text.setText("");
			player4Text.setEnabled(false);
			player4Text.setText("");
			//if (basicButton.getSelection() == true) {
				computerCheck2.setSelection(false);
				computerCheck2.setEnabled(true);
				computerCheck3.setSelection(false);
				computerCheck3.setEnabled(false);
				computerCheck4.setSelection(false);
				computerCheck4.setEnabled(false);
			//}
		} else if (selection == 2) {
			player2Text.setEnabled(true);
			player3Text.setEnabled(true);
			player4Text.setEnabled(false);
			player4Text.setText("");
			//if (basicButton.getSelection() == true) {
				computerCheck2.setSelection(false);
				computerCheck2.setEnabled(true);
				computerCheck3.setSelection(false);
				computerCheck3.setEnabled(true);
				computerCheck4.setSelection(false);
				computerCheck4.setEnabled(false);
			//}
		} else if (selection == 3) {
			player2Text.setEnabled(true);
			player3Text.setEnabled(true);
			player4Text.setEnabled(true);
			//if (basicButton.getSelection() == true) {
				computerCheck2.setSelection(false);
				computerCheck2.setEnabled(true);
				computerCheck3.setSelection(false);
				computerCheck3.setEnabled(true);
				computerCheck4.setSelection(false);
				computerCheck4.setEnabled(true);
			//}
		}
	}
	
	private void advancedButtonWidgetSelected(SelectionEvent evt) {
//		System.out.println("advancedButton.widgetSelected, event="+evt);
	/*	computerCheck2.setSelection(false);
		computerCheck2.setEnabled(false);
		computerCheck3.setSelection(false);
		computerCheck3.setEnabled(false);
		computerCheck4.setSelection(false);
		computerCheck4.setEnabled(false);*/
	}
	
	private void basicButtonWidgetSelected(SelectionEvent evt) {
//		System.out.println("basicButton.widgetSelected, event="+evt);
		setPlayerTextAndCheckBoxes();
	}
	
	private void startButtonWidgetSelected(SelectionEvent evt) {
//		System.out.println("startButton.widgetSelected, event="+evt);
		isClosed = false;
		getNames();
	}

	private void getNames() {
		String sel = numberOfPlayersCombo.getText();
		if (!sel.equals("1") || !sel.equals("2") || !sel.equals("3") || !sel.equals("4")) {
			//TODO: make popup message for the error
		}
		int numberOfPlayers = Integer.parseInt(sel);
		
		String[] names = new String[4];
		names[0] = player1Text.getText();
		names[1] = player2Text.getText();
		names[2] = player3Text.getText();
		names[3] = player4Text.getText();
		//check that names are valid(non empty)
		for (int i = 0; i < numberOfPlayers; i++) {
			String isValid = isValidName(names[i]);
			if (isValid != null) {
				//TODO: popup message with isValid
				return;
			}
			
		}
		
		boolean[] isAuto = new boolean[4];
		isAuto[0] = false;
		isAuto[1] = computerCheck2.getSelection();
		isAuto[2] = computerCheck3.getSelection();
		isAuto[3] = computerCheck4.getSelection();
		
		playersInfo = new PlayerInfo[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++) {
			playersInfo[i] = new PlayerInfo(names[i], isAuto[i]);
		}
		
//		if (basicButton.getSelection()) {System.out.println("bla");}
		gameMode = basicButton.getSelection() ? 'b' : 'a';
		dialogShell.dispose();		
	}

	private String isValidName(String string) {
		if (string.length() > 15) 
			return "Name Length Must Not Be More Than 15"; 
		return ((string == null) || (string.equals(""))) ? "You Can't feed an empty name" : null;
	}
	
	public class PlayerInfo {
		private String playerName;
		private boolean isAuto;
		
		private PlayerInfo(String playerName, boolean isAuto) {
			this.playerName = playerName;
			this.isAuto     = isAuto;
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
	}

}

