package Gui;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import resources.resConfig;

import scrabbleMain.GameGui;
import scrabbleMain.GameLogic;
import scrabbleMain.Player;

import Gui.NewGameDialog.PlayerInfo;

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
/**
 * @author eviatar
 *
 */
public class MainWindow extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	
	private Menu menuMain;
	private Button changeLetterBut;
	private CLabel cLabeCell0104;
	private Text textStatus;
	@SuppressWarnings("unused")
	private MenuItem menuItemHelpSep1;
	private CLabel lettersLeftLabel;
	private CLabel playerLetter7;
	private MenuItem menuItemHelpAbout;
	private MenuItem menuItemHelpScreen;
	private Menu menu4;
	private MenuItem menuItemHelp;
	private Menu menu3;
	private MenuItem menuItemRecordList;
	private Menu menu2;
	private MenuItem menuItemView;
	private MenuItem menuItemGameExit;
	@SuppressWarnings("unused")
	private MenuItem menuItemGameSep2;
	private MenuItem menuItemGameSave;
	private MenuItem menuItemGameOpen;
	@SuppressWarnings("unused")
	private MenuItem menuItemGameSep;
	private MenuItem menuItemGameNew;
	private Menu menu1;
	private MenuItem menuItemGame;
	private Group groupStatus;
	private Text textScores;
	private Group groupScore;
	private CLabel cLabelCell1413;
	private CLabel cLabelCell1412;
	private CLabel cLabelCell1410;
	private CLabel cLabelCell1409;
	private CLabel cLabelCell1408;
	private CLabel cLabelCell1406;
	private CLabel cLabelCell1405;
	private CLabel cLabelCell1404;
	private CLabel cLabelCell1402;
	private CLabel cLabelCell1401;
	private CLabel cLabelCell1314;
	private CLabel cLabelCell1312;
	private CLabel cLabelCell1311;
	private CLabel cLabelCell1310;
	private CLabel cLabelCell1308;
	private CLabel cLabelCell1307;
	private CLabel cLabelCell1306;
	private CLabel cLabelCell1304;
	private CLabel cLabelCell1303;
	private CLabel cLabelCell1302;
	private CLabel cLabelCell1300;
	private CLabel cLabelCell1214;
	private CLabel cLabelCell1213;
	private CLabel cLabelCell1211;
	private CLabel cLabelCell1210;
	private CLabel cLabelCell1209;
	private CLabel cLabelCell1207;
	private CLabel cLabelCell1205;
	private CLabel cLabelCell1204;
	private CLabel cLabelCell1203;
	private CLabel cLabelCell1201;
	private CLabel cLabelCell1200;
	private CLabel cLabelCell1212;
	private CLabel cLabelCell1202;
	private CLabel cLabelCell1313;
	private CLabel cLabelCell1301;
	private CLabel cLabelCell1305;
	private CLabel cLabelCell1309;
	private CLabel cLabelCell1414;
	private CLabel cLabelCell1407;
	private CLabel cLabelCell1400;
	private CLabel cLabelCell1411;
	private CLabel cLabelCell1403;
	private CLabel cLabelCell1208;
	private CLabel cLabelCell1206;
	private CLabel cLabelCell1114;
	private CLabel cLabelCell1113;
	private CLabel cLabelCell1112;
	private CLabel cLabelCell1111;
	private CLabel cLabelCell1110;
	private CLabel cLabelCell1109;
	private CLabel cLabelCell1108;
	private CLabel cLabelCell1107;
	private CLabel cLabelCell1106;
	private CLabel cLabelCell1105;
	private CLabel cLabelCell1104;
	private CLabel cLabelCell1103;
	private CLabel cLabelCell1102;
	private CLabel cLabelCell1101;
	private CLabel cLabelCell1100;
	private CLabel cLabelCell1014;
	private CLabel cLabelCell1013;
	private CLabel cLabelCell1012;
	private CLabel cLabelCell1011;
	private CLabel cLabelCell1010;
	private CLabel cLabelCell1009;
	private CLabel cLabelCell1008;
	private CLabel cLabelCell1007;
	private CLabel cLabelCell1006;
	private CLabel cLabelCell1005;
	private CLabel cLabelCell1004;
	private CLabel cLabelCell1003;
	private CLabel cLabelCell1002;
	private CLabel cLabelCell1001;
	private CLabel cLabelCell1000;
	private CLabel cLabelCell0914;
	private CLabel cLabelCell0913;
	private CLabel cLabelCell0912;
	private CLabel cLabelCell0911;
	private CLabel cLabelCell0910;
	private CLabel cLabelCell0909;
	private CLabel cLabelCell0908;
	private CLabel cLabelCell0907;
	private CLabel cLabelCell0906;
	private CLabel cLabelCell0905;
	private CLabel cLabelCell0904;
	private CLabel cLabelCell0903;
	private CLabel cLabelCell0902;
	private CLabel cLabelCell0901;
	private CLabel cLabelCell0900;
	private CLabel cLabelCell0814;
	private CLabel cLabelCell0813;
	private CLabel cLabelCell0812;
	private CLabel cLabelCell0811;
	private CLabel cLabelCell0810;
	private CLabel cLabelCell0809;
	private CLabel cLabelCell0808;
	private CLabel cLabelCell0807;
	private CLabel cLabelCell0806;
	private CLabel cLabelCell0805;
	private CLabel cLabelCell0804;
	private CLabel cLabelCell0803;
	private CLabel cLabelCell0802;
	private CLabel cLabelCell0801;
	private CLabel cLabelCell0800;
	private CLabel cLabelCell0714;
	private CLabel cLabelCell0713;
	private CLabel cLabelCell0712;
	private CLabel cLabelCell0711;
	private CLabel cLabelCell0710;
	private CLabel cLabelCell0709;
	private CLabel cLabelCell0708;
	private CLabel cLabelCell0707;
	private CLabel cLabelCell0706;
	private CLabel cLabelCell0705;
	private CLabel cLabelCell0704;
	private CLabel cLabelCell0703;
	private CLabel cLabelCell0702;
	private CLabel cLabelCell0701;
	private CLabel cLabelCell0700;
	private CLabel cLabelCell0614;
	private CLabel cLabelCell0613;
	private CLabel cLabelCell0612;
	private CLabel cLabelCell0611;
	private CLabel cLabelCell0610;
	private CLabel cLabelCell0609;
	private CLabel cLabelCell0608;
	private CLabel cLabelCell0607;
	private CLabel cLabelCell0606;
	private CLabel cLabelCell0605;
	private CLabel cLabelCell0604;
	private CLabel cLabelCell0603;
	private CLabel cLabelCell0602;
	private CLabel cLabelCell0601;
	private CLabel cLabelCell0600;
	private CLabel cLabelCell0514;
	private CLabel cLabelCell0513;
	private CLabel cLabelCell0512;
	private CLabel cLabelCell0511;
	private CLabel cLabelCell0510;
	private CLabel cLabelCell0509;
	private CLabel cLabelCell0508;
	private CLabel cLabelCell0507;
	private CLabel cLabelCell0506;
	private CLabel cLabelCell0505;
	private CLabel cLabelCell0504;
	private CLabel cLabelCell0503;
	private CLabel cLabelCell0502;
	private CLabel cLabelCell0501;
	private CLabel cLabelCell0500;
	private CLabel cLabelCell0414;
	private CLabel cLabelCell0413;
	private CLabel cLabelCell0412;
	private CLabel cLabelCell0411;
	private CLabel cLabelCell0410;
	private CLabel cLabelCell0409;
	private CLabel cLabelCell0408;
	private CLabel cLabelCell0407;
	private CLabel cLabelCell0406;
	private CLabel cLabelCell0405;
	private CLabel cLabelCell0404;
	private CLabel cLabelCell0403;
	private CLabel cLabelCell0402;
	private CLabel cLabelCell0401;
	private CLabel cLabelCell0400;
	private CLabel cLabelCell0314;
	private CLabel cLabelCell0313;
	private CLabel cLabelCell0312;
	private CLabel cLabelCell0311;
	private CLabel cLabelCell0310;
	private CLabel cLabelCell0309;
	private CLabel cLabelCell0308;
	private CLabel cLabelCell0307;
	private CLabel cLabelCell0306;
	private CLabel cLabelCell0305;
	private CLabel cLabelCell0304;
	private CLabel cLabelCell0303;
	private CLabel cLabelCell0302;
	private CLabel cLabelCell0301;
	private CLabel cLabelCell0300;
	private CLabel cLabelCell0214;
	private CLabel cLabelCell0213;
	private CLabel cLabelCell0212;
	private CLabel cLabelCell0211;
	private CLabel cLabelCell0210;
	private CLabel cLabelCell0209;
	private CLabel cLabelCell0208;
	private CLabel cLabelCell0207;
	private CLabel cLabelCell0206;
	private CLabel cLabelCell0205;
	private CLabel cLabelCell0204;
	private CLabel cLabelCell0203;
	private CLabel cLabelCell0202;
	private CLabel cLabelCell0201;
	private CLabel cLabelCell0200;
	private CLabel cLabelCell0114;
	private CLabel cLabelCell0113;
	private CLabel cLabelCell0112;
	private CLabel cLabelCell0111;
	private CLabel cLabelCell0110;
	private CLabel cLabelCell0109;
	private CLabel cLabelCell0108;
	private CLabel cLabelCell0107;
	private CLabel cLabelCell0106;
	private CLabel cLabelCell0105;
	private CLabel cLabelCell0103;
	private CLabel cLabelCell0102;
	private CLabel cLabelCell0101;
	private CLabel cLabelCell0100;
	private CLabel cLabelCell0014;
	private CLabel cLabelCell0013;
	private CLabel cLabelCell0012;
	private CLabel cLabelCell0011;
	private CLabel cLabelCell0010;
	private CLabel cLabeCell0009;
	private CLabel cLabelCell0008;
	private CLabel cLabelCell0007;
	private CLabel cLabelCell0006;
	private CLabel cLabelCell0005;
	private CLabel cLabelCell0004;
	private CLabel cLabelCell0003;
	private CLabel cLabelCell0002;
	private CLabel cLabelCell0001;
	private CLabel cLabelCell0000;
	private CLabel cLabelBoard;
	private Button addWordBut;
	private Button doneBut;
	private CLabel letterSetImageLabel;
	private CLabel lettersLeftBut;
	private Text textNowPlaying;
	private Group groupNowPlaying;
	private CLabel playerLetter6;
	private CLabel playerLetter5;
	private CLabel playerLetter4;
	private CLabel playerLetter3;
	private CLabel playerLetter2;
	private CLabel playerLetter1;
	private CLabel letterStandLabel;
	private static Display display;
	private GameLogic G;
	private boolean isSaved = true;
	private boolean changeLetterFlag;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		startGuiGame();
	}
	
	/**
	 * This is the method that is called to start the game gui
	 */ 
	public static void startGuiGame() {
		showGUI();
		
	}
	
	//inits the status text when the window is opened
	private void initTextStatus() {
		textStatus.setText("Welcome to Scrabble!!\n\nTo start a new game go to Game->New\nTo Load an exsiting game go to Game->Load\nTo learn to play go to Help");
	}
	
	/**
	* Overriding checkSubclass allows this class to extend org.eclipse.swt.widgets.Composite
	*/	
	protected void checkSubclass() {
	}
	
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		display = Display.getDefault();
		display.setWarnings(false);
		Shell shell = new Shell(display);
		MainWindow inst = new MainWindow(shell, SWT.NULL);
		inst.setLocation(new org.eclipse.swt.graphics.Point(10, 10));
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
			shell.setSize(1200, 730);
			shell.setLocation(new org.eclipse.swt.graphics.Point(20, 20));
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public MainWindow(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		GameGui.UploadrecordList('b');
		GameGui.UploadrecordList('a');
		GameGui.getG().mainWindow = this;
		initGUI();
		initTextStatus();
		initWindow();
	}

	private void initWindow() {
		textNowPlaying.setVisible(false);
		textScores.setVisible(false);
		lettersLeftBut.setVisible(false);
		lettersLeftLabel.setVisible(false);
	}

	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	private void initGUI() {
		try {
			this.setLayout(new FormLayout());
			this.setLocation(new org.eclipse.swt.graphics.Point(10, 10));
			{
				menuMain = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menuMain);
				{
					menuItemGame = new MenuItem(menuMain, SWT.CASCADE);
					menuItemGame.setText("Game");
					{
						menu1 = new Menu(menuItemGame);
						menuItemGame.setMenu(menu1);
						{
							menuItemGameNew = new MenuItem(menu1, SWT.PUSH);
							menuItemGameNew.setText("New");
							menuItemGameNew.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									menuItemGameNewWidgetSelected(evt);
								}
							});
						}
						{
							menuItemGameSep = new MenuItem(menu1, SWT.SEPARATOR);
						}
						{
							menuItemGameOpen = new MenuItem(menu1, SWT.PUSH);
							menuItemGameOpen.setText("Open");
						}
						{
							menuItemGameSave = new MenuItem(menu1, SWT.PUSH);
							menuItemGameSave.setText("Save");
						}
						{
							menuItemGameSep2 = new MenuItem(menu1, SWT.SEPARATOR);
						}
						{
							menuItemGameExit = new MenuItem(menu1, SWT.PUSH);
							menuItemGameExit.setText("Exit");
							menuItemGameExit.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									//									System.out.println("menuItemGameExit.widgetSelected, event="+evt);
									
									display.close();
								}
							});
						}
					}
				}
				{
					menuItemView = new MenuItem(menuMain, SWT.CASCADE);
					menuItemView.setText("View");
					{
						menu2 = new Menu(menuItemView);
						menuItemView.setMenu(menu2);
					}
				}
				{
					menuItemRecordList = new MenuItem(menuMain, SWT.CASCADE);
					menuItemRecordList.setText("Record List");
					{
						menu3 = new Menu(menuItemRecordList);
						menuItemRecordList.setMenu(menu3);
					}
				}
				{
					menuItemHelp = new MenuItem(menuMain, SWT.CASCADE);
					menuItemHelp.setText("Help");
					{
						menu4 = new Menu(menuItemHelp);
						menuItemHelp.setMenu(menu4);
						{
							menuItemHelpScreen = new MenuItem(menu4, SWT.PUSH);
							menuItemHelpScreen.setText("Help Screen");
						}
						{
							menuItemHelpSep1 = new MenuItem(menu4, SWT.SEPARATOR);
						}
						{
							menuItemHelpAbout = new MenuItem(menu4, SWT.PUSH);
							menuItemHelpAbout.setText("About");
						}
					}
				}
			}
			this.layout();
			pack();
			this.setSize(1200, 700);
			{
				lettersLeftLabel = new CLabel(this, SWT.NONE);
				FormData lettersLeftLabelLData = new FormData();
				lettersLeftLabelLData.width = 25;
				lettersLeftLabelLData.height = 33;
				lettersLeftLabelLData.left =  new FormAttachment(0, 1000, 1175);
				lettersLeftLabelLData.top =  new FormAttachment(0, 1000, 388);
				lettersLeftLabel.setLayoutData(lettersLeftLabelLData);
				lettersLeftLabel.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
			}
			{
				letterStandLabel = new CLabel(this, SWT.NONE);
//				letterStandLabel.setImage(SWTResourceManager.getImage("lettersStand.PNG"));
				FormData letterStandLabelLData = new FormData();
				letterStandLabelLData.width = 668;
				letterStandLabelLData.height = 73;
				letterStandLabelLData.left =  new FormAttachment(0, 1000, 294);
				letterStandLabelLData.top =  new FormAttachment(0, 1000, 612);
				letterStandLabel.setLayoutData(letterStandLabelLData);
				{
					playerLetter1 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter1.setBounds(12, -8, 73, 74);
					playerLetter1.setVisible(false);
					playerLetter1.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter1.mouseDown, event="+evt);
							letterClickAction(0);
						}
					});
				}
				{
					playerLetter2 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter2.setBounds(106, -8, 73, 74);
					playerLetter2.setVisible(false);
					playerLetter2.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter2.mouseDown, event="+evt);
							letterClickAction(1);
						}
					});
				}
				{
					playerLetter3 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter3.setBounds(191, -8, 73, 74);
					playerLetter3.setVisible(false);
					playerLetter3.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter3.mouseDown, event="+evt);
							letterClickAction(2);
						}
					});
				}
				{
					playerLetter4 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter4.setBounds(285, -8, 73, 74);
					playerLetter4.setVisible(false);
					playerLetter4.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter4.mouseDown, event="+evt);
							letterClickAction(3);
						}
					});
				}
				{
					playerLetter5 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter5.setBounds(383, -8, 73, 74);
					playerLetter5.setVisible(false);
					playerLetter5.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter5.mouseDown, event="+evt);
							letterClickAction(4);
						}
					});
				}
				{
					playerLetter6 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter6.setBounds(481, -8, 73, 74);
					playerLetter6.setVisible(false);
					playerLetter6.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter6.mouseDown, event="+evt);
							letterClickAction(5);
						}
					});
				}
				{
					playerLetter7 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter7.setBounds(575, -8, 73, 74);
					playerLetter7.setVisible(false);
					playerLetter7.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter7.mouseDown, event="+evt);
							letterClickAction(6);
						}
					});
				}
			}
			{
				groupNowPlaying = new Group(this, SWT.NONE);
				GridLayout groupNowPlayingLayout = new GridLayout();
				groupNowPlayingLayout.makeColumnsEqualWidth = true;
				groupNowPlaying.setLayout(groupNowPlayingLayout);
				groupNowPlaying.setText("Now Playing");
				FormData groupNowPlayingLData = new FormData();
				groupNowPlayingLData.width = 168;
				groupNowPlayingLData.height = 63;
				groupNowPlayingLData.left =  new FormAttachment(0, 1000, 19);
				groupNowPlayingLData.top =  new FormAttachment(0, 1000, 18);
				groupNowPlaying.setLayoutData(groupNowPlayingLData);
				groupNowPlaying.setFont(SWTResourceManager.getFont("Tahoma",12,0,false,false));
				{
					textNowPlaying = new Text(groupNowPlaying, SWT.MULTI | SWT.WRAP);
					GridData textNowPlatingLData = new GridData();
					textNowPlatingLData.widthHint = 137;
					textNowPlatingLData.heightHint = 36;
					textNowPlaying.setLayoutData(textNowPlatingLData);
					textNowPlaying.setBackground(SWTResourceManager.getColor(236,233,216));
					textNowPlaying.setFont(SWTResourceManager.getFont("Tahoma",14,0,false,false));
				}
			}
			{
				lettersLeftBut = new CLabel(this, SWT.NONE);
				lettersLeftBut.setText("Number Of Letters Left:");
				FormData lettersLeftButLData = new FormData();
				lettersLeftButLData.width = 146;
				lettersLeftButLData.height = 33;
				lettersLeftButLData.left =  new FormAttachment(0, 1000, 1034);
				lettersLeftButLData.top =  new FormAttachment(0, 1000, 388);
				lettersLeftBut.setLayoutData(lettersLeftButLData);
				lettersLeftBut.setFont(SWTResourceManager.getFont("Tahoma",10,0,false,false));
			}
			{
				letterSetImageLabel = new CLabel(this, SWT.NONE);
				FormData letterSetImageLabelLData = new FormData();
				letterSetImageLabelLData.width = 146;
				letterSetImageLabelLData.height = 181;
				letterSetImageLabelLData.left =  new FormAttachment(0, 1000, 1034);
				letterSetImageLabelLData.top =  new FormAttachment(0, 1000, 201);
				letterSetImageLabel.setLayoutData(letterSetImageLabelLData);
			}
			{
				doneBut = new Button(this, SWT.PUSH | SWT.CENTER);
				doneBut.setText("Done");
				FormData doneButLData = new FormData();
				doneButLData.width = 146;
				doneButLData.height = 96;
				doneButLData.left =  new FormAttachment(0, 1000, 1032);
				doneButLData.top =  new FormAttachment(0, 1000, 526);
				doneBut.setLayoutData(doneButLData);
				doneBut.setEnabled(false);
			}
			{
				changeLetterBut = new Button(this, SWT.PUSH | SWT.CENTER);
				changeLetterBut.setText("Change Letter");
				FormData changeLetterButLData = new FormData();
				changeLetterButLData.width = 146;
				changeLetterButLData.height = 64;
				changeLetterButLData.left =  new FormAttachment(0, 1000, 1034);
				changeLetterButLData.top =  new FormAttachment(0, 1000, 103);
				changeLetterBut.setLayoutData(changeLetterButLData);
				changeLetterBut.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						changeLetterButWidgetSelected(evt);
					}
				});
				changeLetterBut.setEnabled(false);
			}
			{
				addWordBut = new Button(this, SWT.PUSH | SWT.CENTER);
				addWordBut.setText("Add Word");
				FormData addWordButLData = new FormData();
				addWordButLData.width = 146;
				addWordButLData.height = 64;
				addWordButLData.left =  new FormAttachment(0, 1000, 1034);
				addWordButLData.top =  new FormAttachment(0, 1000, 12);
				addWordBut.setLayoutData(addWordButLData);
				addWordBut.setEnabled(false);
			}
			{
				cLabelBoard = new CLabel(this, SWT.NONE);
				FormData cLabelBoardLData = new FormData();
				cLabelBoardLData.width = 794;
				cLabelBoardLData.height = 593;
				cLabelBoardLData.left =  new FormAttachment(0, 1000, 205);
				cLabelBoardLData.top =  new FormAttachment(0, 1000, 4);
				cLabelBoard.setLayoutData(cLabelBoardLData);
				{
					cLabelCell0000 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0000.setBounds(164, 26, 32, 31);
					cLabelCell0000.setBackground(SWTResourceManager.getColor(255,0,0));
				}
				{
					cLabelCell0001 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0001.setBounds(202, 26, 32, 31);
					cLabelCell0001.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0002 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0002.setBounds(240, 26, 29, 31);
					cLabelCell0002.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0003 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0003.setBounds(275, 26, 32, 31);
					cLabelCell0003.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0004 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0004.setBounds(314, 26, 32, 31);
					cLabelCell0004.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0005 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0005.setBounds(351, 26, 30, 31);
					cLabelCell0005.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0006 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0006.setBounds(387, 26, 31, 31);
					cLabelCell0006.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0007 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0007.setBounds(424, 26, 31, 31);
					cLabelCell0007.setBackground(SWTResourceManager.getColor(255,0,0));
				}
				{
					cLabelCell0008 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0008.setBounds(461, 26, 31, 30);
					cLabelCell0008.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabeCell0009 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabeCell0009.setBounds(498, 26, 31, 30);
					cLabeCell0009.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0010 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0010.setBounds(535, 26, 30, 30);
					cLabelCell0010.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0011 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0011.setBounds(571, 26, 29, 30);
					cLabelCell0011.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0012 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0012.setBounds(606, 26, 30, 30);
					cLabelCell0012.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0013 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0013.setBounds(642, 26, 29, 30);
					cLabelCell0013.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0014 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0014.setBounds(677, 26, 29, 30);
					cLabelCell0014.setBackground(SWTResourceManager.getColor(255,0,0));
				}
				{
					cLabelCell0100 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0100.setBounds(164, 63, 32, 30);
					cLabelCell0100.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0101 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0101.setBounds(202, 63, 32, 30);
					cLabelCell0101.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell0102 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0102.setBounds(240, 63, 29, 30);
					cLabelCell0102.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0103 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0103.setBounds(275, 63, 32, 30);
					cLabelCell0103.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabeCell0104 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabeCell0104.setBounds(313, 63, 32, 30);
					cLabeCell0104.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0105 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0105.setBounds(351, 63, 30, 30);
					cLabelCell0105.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0106 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0106.setBounds(387, 63, 31, 30);
					cLabelCell0106.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0107 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0107.setBounds(424, 63, 31, 30);
					cLabelCell0107.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0108 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0108.setBounds(461, 63, 31, 30);
					cLabelCell0108.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0109 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0109.setBounds(498, 63, 31, 30);
					cLabelCell0109.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0110 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0110.setBounds(535, 63, 30, 30);
					cLabelCell0110.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0111 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0111.setBounds(571, 63, 29, 30);
					cLabelCell0111.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0112 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0112.setBounds(606, 63, 30, 30);
					cLabelCell0112.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0113 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0113.setBounds(642, 63, 29, 30);
					cLabelCell0113.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell0114 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0114.setBounds(677, 63, 29, 30);
					cLabelCell0114.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0200 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0200.setBounds(164, 99, 32, 30);
					cLabelCell0200.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0201 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0201.setBounds(202, 99, 32, 30);
					cLabelCell0201.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0202 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0202.setBounds(240, 99, 29, 30);
					cLabelCell0202.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell0203 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0203.setBounds(275, 99, 32, 30);
					cLabelCell0203.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0204 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0204.setBounds(313, 99, 32, 30);
					cLabelCell0204.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0205 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0205.setBounds(351, 99, 30, 30);
					cLabelCell0205.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0206 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0206.setBounds(387, 99, 31, 30);
					cLabelCell0206.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0207 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0207.setBounds(424, 99, 31, 30);
					cLabelCell0207.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0208 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0208.setBounds(461, 99, 31, 30);
					cLabelCell0208.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0209 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0209.setBounds(498, 99, 31, 30);
					cLabelCell0209.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0210 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0210.setBounds(535, 99, 30, 30);
					cLabelCell0210.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0211 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0211.setBounds(571, 99, 29, 30);
					cLabelCell0211.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0212 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0212.setBounds(606, 99, 30, 30);
					cLabelCell0212.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell0213 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0213.setBounds(642, 99, 29, 30);
					cLabelCell0213.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0214 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0214.setBounds(677, 99, 29, 30);
					cLabelCell0214.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0300 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0300.setBounds(164, 135, 32, 30);
					cLabelCell0300.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0301 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0301.setBounds(202, 135, 32, 30);
					cLabelCell0301.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0302 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0302.setBounds(240, 135, 29, 30);
					cLabelCell0302.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0303 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0303.setBounds(275, 135, 32, 30);
					cLabelCell0303.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell0304 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0304.setBounds(313, 135, 32, 30);
					cLabelCell0304.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0305 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0305.setBounds(351, 135, 30, 30);
					cLabelCell0305.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0306 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0306.setBounds(387, 135, 31, 30);
					cLabelCell0306.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0307 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0307.setBounds(424, 135, 31, 30);
					cLabelCell0307.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0308 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0308.setBounds(461, 135, 31, 30);
					cLabelCell0308.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0309 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0309.setBounds(498, 135, 31, 30);
					cLabelCell0309.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0310 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0310.setBounds(535, 135, 30, 30);
					cLabelCell0310.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0311 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0311.setBounds(571, 135, 29, 30);
					cLabelCell0311.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell0312 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0312.setBounds(606, 135, 30, 30);
					cLabelCell0312.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0313 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0313.setBounds(642, 135, 29, 30);
					cLabelCell0313.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0314 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0314.setBounds(677, 135, 29, 30);
					cLabelCell0314.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0400 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0400.setBounds(164, 171, 32, 33);
					cLabelCell0400.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0401 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0401.setBounds(202, 171, 32, 33);
					cLabelCell0401.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0402 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0402.setBounds(240, 171, 29, 33);
					cLabelCell0402.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0403 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0403.setBounds(275, 171, 32, 33);
					cLabelCell0403.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0404 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0404.setBounds(313, 171, 32, 33);
					cLabelCell0404.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell0405 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0405.setBounds(351, 171, 30, 33);
					cLabelCell0405.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0406 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0406.setBounds(387, 171, 31, 33);
					cLabelCell0406.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0407 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0407.setBounds(424, 171, 31, 33);
					cLabelCell0407.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0408 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0408.setBounds(461, 171, 31, 33);
					cLabelCell0408.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0409 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0409.setBounds(498, 171, 31, 33);
					cLabelCell0409.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0410 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0410.setBounds(535, 171, 30, 33);
					cLabelCell0410.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell0411 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0411.setBounds(571, 171, 29, 33);
					cLabelCell0411.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0412 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0412.setBounds(606, 171, 30, 33);
					cLabelCell0412.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0413 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0413.setBounds(642, 171, 29, 33);
					cLabelCell0413.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0414 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0414.setBounds(677, 171, 29, 33);
					cLabelCell0414.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0500 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0500.setBounds(164, 210, 32, 32);
					cLabelCell0500.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0501 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0501.setBounds(202, 210, 32, 32);
					cLabelCell0501.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0502 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0502.setBounds(240, 210, 29, 32);
					cLabelCell0502.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0503 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0503.setBounds(275, 210, 32, 32);
					cLabelCell0503.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0504 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0504.setBounds(313, 210, 32, 32);
					cLabelCell0504.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0505 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0505.setBounds(351, 210, 30, 32);
					cLabelCell0505.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0506 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0506.setBounds(387, 210, 31, 32);
					cLabelCell0506.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0507 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0507.setBounds(424, 210, 31, 32);
					cLabelCell0507.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0508 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0508.setBounds(461, 210, 31, 32);
					cLabelCell0508.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0509 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0509.setBounds(498, 210, 31, 32);
					cLabelCell0509.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0510 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0510.setBounds(535, 210, 30, 32);
					cLabelCell0510.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0511 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0511.setBounds(571, 210, 29, 32);
					cLabelCell0511.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0512 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0512.setBounds(605, 210, 30, 32);
					cLabelCell0512.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0513 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0513.setBounds(642, 210, 29, 32);
					cLabelCell0513.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0514 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0514.setBounds(677, 210, 29, 32);
					cLabelCell0514.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0600 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0600.setBounds(164, 248, 32, 30);
					cLabelCell0600.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0601 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0601.setBounds(202, 248, 32, 30);
					cLabelCell0601.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0602 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0602.setBounds(240, 248, 29, 30);
					cLabelCell0602.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0603 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0603.setBounds(275, 248, 32, 30);
					cLabelCell0603.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0604 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0604.setBounds(313, 248, 32, 30);
					cLabelCell0604.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0605 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0605.setBounds(351, 248, 30, 30);
					cLabelCell0605.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0606 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0606.setBounds(387, 248, 31, 30);
					cLabelCell0606.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0607 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0607.setBounds(424, 248, 31, 30);
					cLabelCell0607.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0608 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0608.setBounds(461, 248, 31, 30);
					cLabelCell0608.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0609 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0609.setBounds(498, 248, 31, 30);
					cLabelCell0609.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0610 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0610.setBounds(535, 248, 30, 30);
					cLabelCell0610.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0611 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0611.setBounds(571, 248, 29, 30);
					cLabelCell0611.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0612 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0612.setBounds(606, 248, 29, 30);
					cLabelCell0612.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0613 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0613.setBounds(641, 248, 30, 30);
					cLabelCell0613.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0614 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0614.setBounds(677, 248, 29, 30);
					cLabelCell0614.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0700 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0700.setBounds(164, 284, 32, 33);
					cLabelCell0700.setBackground(SWTResourceManager.getColor(255,0,0));
				}
				{
					cLabelCell0701 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0701.setBounds(202, 284, 32, 33);
					cLabelCell0701.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0702 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0702.setBounds(240, 284, 29, 33);
					cLabelCell0702.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0703 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0703.setBounds(275, 284, 32, 33);
					cLabelCell0703.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0704 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0704.setBounds(313, 284, 32, 33);
					cLabelCell0704.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0705 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0705.setBounds(351, 284, 30, 33);
					cLabelCell0705.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0706 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0706.setBounds(387, 284, 31, 33);
					cLabelCell0706.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0707 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0707.setBounds(424, 284, 31, 33);
				}
				{
					cLabelCell0708 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0708.setBounds(461, 284, 31, 33);
					cLabelCell0708.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0709 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0709.setBounds(498, 284, 31, 33);
					cLabelCell0709.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0710 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0710.setBounds(535, 284, 30, 33);
					cLabelCell0710.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0711 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0711.setBounds(571, 284, 29, 33);
					cLabelCell0711.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0712 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0712.setBounds(606, 284, 29, 33);
					cLabelCell0712.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0713 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0713.setBounds(641, 284, 30, 33);
					cLabelCell0713.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0714 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0714.setBounds(677, 284, 29, 33);
					cLabelCell0714.setBackground(SWTResourceManager.getColor(255,0,0));
				}
				{
					cLabelCell0800 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0800.setBounds(164, 323, 32, 30);
					cLabelCell0800.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0801 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0801.setBounds(202, 323, 32, 30);
					cLabelCell0801.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0802 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0802.setBounds(240, 323, 29, 30);
					cLabelCell0802.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0803 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0803.setBounds(275, 323, 32, 30);
					cLabelCell0803.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0804 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0804.setBounds(313, 323, 32, 30);
					cLabelCell0804.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0805 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0805.setBounds(351, 323, 30, 30);
					cLabelCell0805.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0806 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0806.setBounds(387, 323, 31, 30);
					cLabelCell0806.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0807 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0807.setBounds(424, 323, 31, 30);
					cLabelCell0807.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0808 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0808.setBounds(461, 323, 31, 30);
					cLabelCell0808.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0809 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0809.setBounds(498, 323, 31, 30);
					cLabelCell0809.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0810 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0810.setBounds(535, 323, 30, 30);
					cLabelCell0810.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0811 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0811.setBounds(571, 323, 29, 30);
					cLabelCell0811.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0812 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0812.setBounds(606, 323, 29, 30);
					cLabelCell0812.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell0813 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0813.setBounds(641, 323, 30, 30);
					cLabelCell0813.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0814 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0814.setBounds(677, 323, 29, 30);
					cLabelCell0814.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0900 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0900.setBounds(164, 359, 32, 30);
					cLabelCell0900.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0901 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0901.setBounds(202, 359, 32, 30);
					cLabelCell0901.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0902 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0902.setBounds(240, 359, 29, 30);
					cLabelCell0902.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0903 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0903.setBounds(275, 359, 32, 30);
					cLabelCell0903.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0904 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0904.setBounds(313, 359, 32, 30);
					cLabelCell0904.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0905 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0905.setBounds(351, 359, 30, 30);
					cLabelCell0905.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0906 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0906.setBounds(387, 359, 31, 30);
					cLabelCell0906.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0907 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0907.setBounds(424, 359, 31, 30);
					cLabelCell0907.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0908 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0908.setBounds(461, 359, 31, 30);
					cLabelCell0908.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0909 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0909.setBounds(498, 359, 31, 30);
					cLabelCell0909.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0910 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0910.setBounds(535, 359, 30, 30);
					cLabelCell0910.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0911 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0911.setBounds(571, 359, 29, 30);
					cLabelCell0911.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0912 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0912.setBounds(606, 359, 29, 30);
					cLabelCell0912.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell0913 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0913.setBounds(641, 359, 30, 30);
					cLabelCell0913.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell0914 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0914.setBounds(677, 359, 29, 30);
					cLabelCell0914.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1000 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1000.setBounds(164, 395, 32, 32);
					cLabelCell1000.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1001 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1001.setBounds(202, 395, 32, 30);
					cLabelCell1001.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1002 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1002.setBounds(240, 395, 29, 30);
					cLabelCell1002.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1003 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1003.setBounds(275, 395, 32, 30);
					cLabelCell1003.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1004 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1004.setBounds(313, 395, 32, 30);
					cLabelCell1004.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell1005 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1005.setBounds(351, 395, 30, 30);
					cLabelCell1005.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1006 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1006.setBounds(387, 395, 31, 30);
					cLabelCell1006.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1007 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1007.setBounds(424, 395, 31, 30);
					cLabelCell1007.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1008 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1008.setBounds(461, 395, 31, 30);
					cLabelCell1008.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1009 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1009.setBounds(498, 395, 31, 30);
					cLabelCell1009.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1010 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1010.setBounds(535, 395, 30, 30);
					cLabelCell1010.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell1011 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1011.setBounds(571, 395, 29, 30);
					cLabelCell1011.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1012 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1012.setBounds(606, 395, 29, 30);
					cLabelCell1012.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1013 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1013.setBounds(641, 395, 30, 30);
					cLabelCell1013.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1014 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1014.setBounds(677, 395, 29, 30);
					cLabelCell1014.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1100 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1100.setBounds(164, 431, 32, 33);
					cLabelCell1100.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell1101 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1101.setBounds(202, 431, 32, 33);
					cLabelCell1101.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1102 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1102.setBounds(240, 431, 29, 33);
					cLabelCell1102.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1103 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1103.setBounds(275, 431, 32, 33);
					cLabelCell1103.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell1104 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1104.setBounds(313, 431, 32, 33);
					cLabelCell1104.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1105 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1105.setBounds(351, 431, 30, 33);
					cLabelCell1105.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1106 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1106.setBounds(387, 431, 31, 33);
					cLabelCell1106.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1107 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1107.setBounds(424, 431, 31, 33);
					cLabelCell1107.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell1108 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1108.setBounds(461, 431, 31, 33);
					cLabelCell1108.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1109 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1109.setBounds(498, 431, 31, 33);
					cLabelCell1109.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1110 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1110.setBounds(535, 431, 30, 33);
					cLabelCell1110.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1111 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1111.setBounds(571, 431, 29, 33);
					cLabelCell1111.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell1112 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1112.setBounds(606, 431, 29, 33);
					cLabelCell1112.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1113 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1113.setBounds(641, 431, 30, 33);
					cLabelCell1113.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1114 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1114.setBounds(677, 431, 29, 33);
					cLabelCell1114.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell1206 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1206.setBounds(387, 470, 31, 30);
					cLabelCell1206.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell1208 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1208.setBounds(461, 470, 31, 30);
					cLabelCell1208.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell1403 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1403.setBounds(275, 540, 32, 28);
					cLabelCell1403.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell1411 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1411.setBounds(571, 540, 29, 28);
					cLabelCell1411.setBackground(SWTResourceManager.getColor(13,162,242));
				}
				{
					cLabelCell1400 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1400.setBounds(164, 540, 32, 28);
					cLabelCell1400.setBackground(SWTResourceManager.getColor(255,0,0));
				}
				{
					cLabelCell1407 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1407.setBounds(424, 540, 31, 28);
					cLabelCell1407.setBackground(SWTResourceManager.getColor(255,0,0));
				}
				{
					cLabelCell1414 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1414.setBounds(677, 540, 29, 28);
					cLabelCell1414.setBackground(SWTResourceManager.getColor(255,0,0));
				}
				{
					cLabelCell1309 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1309.setBounds(498, 506, 31, 29);
					cLabelCell1309.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell1305 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1305.setBounds(351, 506, 30, 30);
					cLabelCell1305.setBackground(SWTResourceManager.getColor(0,0,255));
				}
				{
					cLabelCell1301 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1301.setBounds(202, 506, 32, 30);
					cLabelCell1301.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell1313 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1313.setBounds(641, 506, 30, 30);
					cLabelCell1313.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell1202 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1202.setBounds(240, 470, 29, 30);
					cLabelCell1202.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell1212 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1212.setBounds(606, 470, 29, 30);
					cLabelCell1212.setBackground(SWTResourceManager.getColor(255,128,128));
				}
				{
					cLabelCell1200 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1200.setBounds(164, 470, 32, 30);
					cLabelCell1200.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1201 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1201.setBounds(202, 470, 32, 30);
					cLabelCell1201.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1203 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1203.setBounds(275, 470, 32, 30);
					cLabelCell1203.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1204 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1204.setBounds(313, 470, 32, 30);
					cLabelCell1204.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1205 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1205.setBounds(351, 470, 30, 30);
					cLabelCell1205.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1207 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1207.setBounds(424, 470, 31, 30);
					cLabelCell1207.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1209 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1209.setBounds(498, 470, 31, 30);
					cLabelCell1209.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1210 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1210.setBounds(535, 470, 30, 30);
					cLabelCell1210.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1211 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1211.setBounds(572, 470, 28, 30);
					cLabelCell1211.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1213 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1213.setBounds(641, 470, 30, 30);
					cLabelCell1213.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1214 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1214.setBounds(677, 470, 29, 30);
					cLabelCell1214.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1300 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1300.setBounds(163, 506, 33, 30);
					cLabelCell1300.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1302 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1302.setBounds(240, 506, 29, 30);
					cLabelCell1302.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1303 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1303.setBounds(275, 506, 32, 30);
					cLabelCell1303.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1304 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1304.setBounds(313, 506, 32, 30);
					cLabelCell1304.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1306 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1306.setBounds(387, 506, 31, 30);
					cLabelCell1306.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1307 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1307.setBounds(424, 506, 31, 30);
					cLabelCell1307.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1308 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1308.setBounds(461, 506, 31, 30);
					cLabelCell1308.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1310 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1310.setBounds(535, 506, 30, 30);
					cLabelCell1310.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1311 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1311.setBounds(571, 506, 29, 30);
					cLabelCell1311.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1312 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1312.setBounds(606, 506, 29, 30);
					cLabelCell1312.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1314 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1314.setBounds(677, 506, 29, 30);
					cLabelCell1314.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1401 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1401.setBounds(202, 540, 32, 28);
					cLabelCell1401.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1402 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1402.setBounds(240, 540, 29, 30);
					cLabelCell1402.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1404 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1404.setBounds(313, 540, 32, 28);
					cLabelCell1404.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1405 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1405.setBounds(351, 540, 30, 30);
					cLabelCell1405.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1406 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1406.setBounds(387, 540, 31, 30);
					cLabelCell1406.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1408 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1408.setBounds(461, 540, 31, 30);
					cLabelCell1408.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1409 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1409.setBounds(498, 540, 31, 30);
					cLabelCell1409.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1410 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1410.setBounds(535, 540, 30, 28);
					cLabelCell1410.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1412 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1412.setBounds(605, 540, 30, 30);
					cLabelCell1412.setBackground(SWTResourceManager.getColor(239,208,143));
				}
				{
					cLabelCell1413 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1413.setBounds(641, 540, 30, 30);
					cLabelCell1413.setBackground(SWTResourceManager.getColor(239,208,143));
				}
			}
			{
				groupScore = new Group(this, SWT.NONE);
				GridLayout groupScoreLayout = new GridLayout();
				groupScoreLayout.makeColumnsEqualWidth = true;
				groupScore.setLayout(groupScoreLayout);
				groupScore.setText("Scores");
				FormData groupScoreLData = new FormData();
				groupScoreLData.width = 168;
				groupScoreLData.height = 253;
				groupScoreLData.left =  new FormAttachment(0, 1000, 19);
				groupScoreLData.top =  new FormAttachment(0, 1000, 416);
				groupScore.setLayoutData(groupScoreLData);
				groupScore.setFont(SWTResourceManager.getFont("Tahoma",10,0,false,false));
				{
					textScores = new Text(groupScore, SWT.MULTI | SWT.WRAP);
					textScores.setText("scores text");
					GridData textScoresLData = new GridData();
					textScoresLData.widthHint = 151;
					textScoresLData.heightHint = 245;
					textScores.setLayoutData(textScoresLData);
					textScores.setBackground(SWTResourceManager.getColor(236,233,216));
					textScores.setFont(SWTResourceManager.getFont("Tahoma", 12, 0, false, false));
				}
			}
			{
				groupStatus = new Group(this, SWT.NONE);
				GridLayout groupStatusLayout = new GridLayout();
				groupStatusLayout.makeColumnsEqualWidth = true;
				groupStatus.setLayout(groupStatusLayout);
				groupStatus.setText("Status Messages");
				FormData groupStatusLData = new FormData();
				groupStatusLData.width = 168;
				groupStatusLData.height = 267;
				groupStatusLData.left =  new FormAttachment(0, 1000, 19);
				groupStatusLData.top =  new FormAttachment(0, 1000, 115);
				groupStatus.setLayoutData(groupStatusLData);
				groupStatus.setFont(SWTResourceManager.getFont("Tahoma",10,0,false,false));
				{
					textStatus = new Text(groupStatus, SWT.MULTI | SWT.WRAP);
					textStatus.setText("status text label");
					GridData textStatusLData = new GridData();
					textStatusLData.widthHint = 147;
					textStatusLData.heightHint = 259;
					textStatus.setLayoutData(textStatusLData);
					textStatus.setBackground(SWTResourceManager.getColor(236,233,216));
					textStatus.setFont(SWTResourceManager.getFont("Tahoma",14,0,false,false));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadImages();
	}



	public boolean showMessageDialog(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void setPlayStatusText(String string) {
		// TODO Auto-generated method stub
	}
	
	private void menuItemGameNewWidgetSelected(SelectionEvent evt) {
//		System.out.println("menuItemGameNew.widgetSelected, event="+evt);
		if (!isSaved) {
//			SaveBeforeExitDialog saveBeforeExitDialog = new SaveBeforeExitDialog(getShell(), SWT.DIALOG_TRIM);
			//TODO: add this class
		}
		NewGameDialog newGameDialog = new NewGameDialog(getShell(), SWT.DIALOG_TRIM);
		newGameDialog.open();
		GameGui.initGameLogic();
		PlayerInfo[] playerInfo = newGameDialog.getPlayersInfo();
		GameGui.setNumberOfPlayers(playerInfo.length);
		GameGui.setGameMode(newGameDialog.getGameMode());
		GameGui.createPlayerList(playerInfo);
		G = GameGui.getG();
		this.updateWindow();
	}

	private void updateWindow() {
		this.updateNowPlayingText();
		this.updateStatusText("Press 'Add Word' or 'Change Letter' and make your move. When finished press 'Done'");
		this.updateScoresText();
		this.updateLetterSetText();
		this.updatePlayerLetters();
		addWordBut.setEnabled(true);
		changeLetterBut.setEnabled(true);
	}

	private void updatePlayerLetters() {
		CLabel[] playerLetters = new CLabel[7];
		playerLetters[0] = playerLetter1;
		playerLetters[1] = playerLetter2;
		playerLetters[2] = playerLetter3;
		playerLetters[3] = playerLetter4;
		playerLetters[4] = playerLetter5;
		playerLetters[5] = playerLetter6;
		playerLetters[6] = playerLetter7;
		
		Player currentPlayer = G.getCurrentPlayer();
		int numberOfPlayerLetters = currentPlayer.getNumberOfLetters();
		for (int i = 0; i < numberOfPlayerLetters; i++) {
			playerLetters[i].setBackgroundImage(getLetterImage(currentPlayer.getLetter(i)));
			playerLetters[i].setVisible(true);
		}
		for (int i = numberOfPlayerLetters; i < 7; i++) {
			playerLetters[i].setVisible(false);
		}
	}

	private Image getLetterImage(char letter) {
		return SWTResourceManager.getImage(String.valueOf(letter).toUpperCase() + ".PNG");
	}

	private void updateLetterSetText() {
		lettersLeftBut.setVisible(true);
		lettersLeftLabel.setVisible(true);
		lettersLeftLabel.setText(Integer.valueOf(G.getLettersSet().getLetterSetSize()).toString());	
	}

	private void updateScoresText() {
		textScores.setVisible(true);
		String allPlayers = "";
		String finish = (G.getLettersSet().getLetterSetSize() > 0) ? "Current" : "";
		int winner = 0;
		int winningScore = 0;
		List<Player> playerList = G.getPlayerList();
		for (int i = 0; i < playerList.size(); i++) {
			Player currentPlayer = playerList.get(i);
			int temp_score = currentPlayer.getScore();
			if (temp_score > winningScore)
			{
				winningScore = temp_score;
				winner = i;
			}
			allPlayers += currentPlayer.getName() + "\n"; 
			allPlayers += temp_score + " pts\n\n";
		}	
		String winMessage = finish + "Winner is:\n " + playerList.get(winner).getName() +
		"\n With a score of:\n " + winningScore + " pts";
		allPlayers = winMessage + "\n\n" + allPlayers;
		textScores.setText(allPlayers);
	}

	private void updateStatusText(String text) {
		textStatus.setText(text);
	}

	private void updateNowPlayingText() {
		textNowPlaying.setVisible(true);
		textNowPlaying.setText(G.getCurrentPlayerName());
	}
	
	private void changeLetterButWidgetSelected(SelectionEvent evt) {
//		System.out.println("changeLetterBut.widgetSelected, event="+evt);
		changeLetterFlag = true;
		addWordBut.setEnabled(false);
		changeLetterBut.setEnabled(false);
		this.updateStatusText("You are allowed to change no more than 3 letters");
		GameGui.initNumberOfChanges();
		doneBut.setEnabled(true);
	}
	
	private void letterClickAction(int index) {
		if (changeLetterFlag == true) {
			GameGui.changeOneLetter(index);
			this.updatePlayerLetters();
		}
	}
	
	public void loadImages(){
		cLabelBoard.setBackgroundImage(new Image(Display.getDefault(),resConfig.getImageStream("board.PNG")));
		letterStandLabel.setBackgroundImage(new Image(Display.getDefault(),resConfig.getImageStream("lettersStand.PNG")));
		letterSetImageLabel.setBackground(new Image(Display.getDefault(),resConfig.getImageStream("LetterSet.jpg")));
	}
	
	
}
