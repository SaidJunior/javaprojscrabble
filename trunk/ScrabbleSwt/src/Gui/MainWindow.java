package Gui;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import resources.resConfig;
import scrabbleMain.Board;
import scrabbleMain.GameGui;
import scrabbleMain.GameLogic;
import scrabbleMain.Player;
import scrabbleMain.gameDirectories;
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
	private CLabel cLabelCell0104;
	private Text textStatus;
	@SuppressWarnings("unused")
	private MenuItem menuItemHelpSep1;
	private MenuItem menuItemViewForest;
	private MenuItem menuItemViewSpace;
	private MenuItem menuItemViewBeach;
	private MenuItem menuItemViewHome;
	private CLabel lettersLeftLabel;
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
	private CLabel cLabelCell0009;
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
	private CLabel playerLetter0;
	private CLabel letterStandLabel;
	private static Display display;
	private GameLogic G;
	private static boolean isSaved = true;
	private boolean changeLetterFlag;
	private CLabel[][] allCellsGrid = new CLabel[15][15];
	private CLabel[]   allPlayerLetters = new CLabel[7];
	private Color[][]  allCellsColors = new Color[15][15];
	private Color currentColor;
	private boolean addWordFlag = false;
	private static final Color whiteColor = SWTResourceManager.getColor(255,255,255);
	private List<CellIndAndColor> currentTurnInsertedLetters = new ArrayList<CellIndAndColor>();
	private MenuItem menuItemRLBasic;
	private MenuItem menuItemRLAdvanced;
	private static Shell shell;
	private boolean advancedLetterPlaced = false;
	
	private class CellIndAndColor {
		private int i;
		private int j;
		
		private CellIndAndColor(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	
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
		textStatus.setText("Welcome to Scrabble!!\n\nTo start a new game go to Game->New\n\nTo Open an exsiting game go to Game->Open\n\nTo learn how to play go to Help");
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
		shell = new Shell(display);
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		MainWindow inst = new MainWindow(shell, SWT.NULL);
		inst.setLocation(new org.eclipse.swt.graphics.Point(10, 10));
//		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
//		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
			shell.setSize(1200, 750);
			shell.setLocation(new org.eclipse.swt.graphics.Point(10, 10));
			shell.setImage(new Image(Display.getDefault(),resConfig.getImageStream("scrabble_icon.PNG")));
			shell.setText("Scrabble");
			shell.addShellListener(new ShellAdapter() {
				public void shellClosed(ShellEvent evt) {
//					System.out.println("shell.shellClosed, event="+evt);
					if (isSaved == false) {
						saveBeforExitMessage();
					}
					MessageBox m = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
					m.setMessage("Are you sure you want to exit?");
					m.setText("Game Exit");
					if (m.open() == SWT.YES) {
						display.dispose();
//						System.out.println("bla");
					}
					else {
						evt.doit = false;
					}
				}
			});
//		} else {
//			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
//			shell.setSize(shellBounds.width, shellBounds.height);
//		}
		Image img = new Image(Display.getDefault(),resConfig.getImageStream("wooden_table.jpg"));
		shell.open();
		shell.setBackgroundImage(img);
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
//		addMouseListenersToCells();
		addDragListenersToLetters();
		addDropListenersToCells();
		initTextStatus();
		initAllCellsColors();
		initWindow();
		GameGui.initUsedLetters();
	}


	private void initAllCellsColors() {
//		Color def   = SWTResourceManager.getColor(239, 208, 143);
//		Color red   = SWTResourceManager.getColor(255, 0, 0);
//		Color blue  = SWTResourceManager.getColor(0, 0, 255);
//		Color lBlue = SWTResourceManager.getColor(13, 162, 242);
//		Color pink  = SWTResourceManager.getColor(255, 128, 128);
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				allCellsColors[i][j] = allCellsGrid[i][j].getBackground();
			}
		}
	}
	
//	private void addMouseListenersToCells() {
//		for (int i = 0; i < 15; i++) {
//			for (int j = 0; j < 15; j++) {
//				final CLabel currentCell = allCellsGrid[i][j];
//				currentCell.addMouseTrackListener(new MouseTrackAdapter() {
//					public void mouseEnter(MouseEvent evt) {
//						cLabelCellMouseEnter(evt, currentCell);
//					}
//				});
//				currentCell.addMouseTrackListener(new MouseTrackAdapter() {
//					public void mouseExit(MouseEvent evt) {
//						cLabelCellMouseExit(evt, currentCell);
//					}
//				});
//			}
//		}
//	}
	
	private void cLabelCellMouseEnter(MouseEvent evt, CLabel currentCell) {
//		System.out.println("cLabelCell0000.mouseEnter, event="+evt);
		if (addWordFlag == true) {
			currentColor = currentCell.getBackground();
			currentCell.setBackground(whiteColor);
		}
	}
//	
	private void cLabelCellMouseExit(MouseEvent evt, CLabel currentCell) {
//		System.out.println("cLabelCell0000.mouseExit, event="+evt);
		if (addWordFlag == true) {
			currentCell.setBackground(currentColor);
		}
	}

	private void addDragListenersToLetters() {
		int operations = DND.DROP_MOVE;
		for (int i = 0; i < allPlayerLetters.length; i++) {
			final CLabel currentPlayerLetter = allPlayerLetters[i];
			final Integer currentI = new Integer(i);
			DragSource source = new DragSource(currentPlayerLetter, operations);
			Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
			source.setTransfer(types);
			source.addDragListener(new DragSourceListener() {
				   public void dragStart(DragSourceEvent event) {
				      // Only start the drag if addWordFlag == true or advanced letter has not been already placed
				      if ((addWordFlag == false) || (advancedLetterPlaced == true)){
				          event.doit = false;
				      }
				   }
				   public void dragSetData(DragSourceEvent event) {
				     // get the letter's number
				     if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
				    	  StringBuffer data = new StringBuffer();
				    	  data.append(String.valueOf(G.getCurrentPlayer().getLetter(currentI)));
				    	  data.append(currentI);
				          event.data = data.toString();
//				          System.out.println(currentI);
				     }
				   }
				   public void dragFinished(DragSourceEvent event) {
				     // drag finished make the letter unvisable
					  if (event.detail == DND.DROP_MOVE) {
						  currentPlayerLetter.setVisible(false);
					  }
				   }
				});
		}
		
	}
	
	private void addDropListenersToCells() {
		int operations = DND.DROP_MOVE;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				final CLabel currentCell = allCellsGrid[i][j];
				final int currentI = i;
				final int CurrentJ = j;
				DropTarget target = new DropTarget(currentCell, operations);
				Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
				target.setTransfer(types);
				target.addDropListener(new DropTargetListener() {
					public void dragEnter(DropTargetEvent event) {
						if (currentCell.getBackgroundImage() == null) {
							cLabelCellMouseEnter(null, currentCell);
							event.currentDataType = event.dataTypes[0];
						}
						else {
							event.detail = DND.DROP_NONE;
						}
					}
				    public void dragOver(DropTargetEvent event) { }
				    public void dragOperationChanged(DropTargetEvent event) { }
				    public void dragLeave(DropTargetEvent event) {
				    	if (currentCell.getBackgroundImage() == null) {
				    		cLabelCellMouseExit(null, currentCell);
				    	}
				    }
				    public void dropAccept(DropTargetEvent event) { }
				    public void drop(DropTargetEvent event) {
				    	String data = (String)event.data;
				    	String letter = data.substring(0, 1);
				    	int place = Integer.parseInt(data.substring(1));
						currentCell.setBackground(new Image(Display.getDefault(),resConfig.getImageStream(letter + "1.PNG")));
						currentCell.setBackgroundImage(new Image(Display.getDefault(),resConfig.getImageStream(letter + "1.PNG")));
//						System.out.println(place);
				    	GameGui.addLetterToBoardBasic(currentI, CurrentJ, place);
				    	if (GameGui.getG().getMode() == 'a') {
							advancedLetterPlaced = true;
//							System.out.println("bla");
						}
				    	currentTurnInsertedLetters.add(new CellIndAndColor(currentI, CurrentJ));
				    }
			  });
			}
		}
		
	}
	
	private void initWindow() {
		textNowPlaying.setVisible(false);
		textScores.setVisible(false);
		lettersLeftBut.setVisible(false);
		lettersLeftLabel.setVisible(false);
	}

	private void initGUI() {
		try {
			this.setLayout(new FormLayout());
			this.setLocation(new org.eclipse.swt.graphics.Point(10, 10));
			{
				menuMain = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menuMain);
				{
					menuItemGame = new MenuItem(menuMain, SWT.CASCADE);
					menuItemGame.setText("&Game");
					{
						menu1 = new Menu(menuItemGame);
						menuItemGame.setMenu(menu1);
						{
							menuItemGameNew = new MenuItem(menu1, SWT.PUSH);
							menuItemGameNew.setText("&New");
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
							menuItemGameOpen.setText("&Open");
							menuItemGameOpen.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									if (!isSaved) {
										saveBeforExitMessage();
									}
									String[] filterExtensions = {"*.scrabble"};
									FileDialog fileDialog = new FileDialog(shell, SWT.OPEN);
									fileDialog.setText("Scrabble Load Game");
									fileDialog.setFilterPath(gameDirectories.getSavedGamesDirectorty());
									fileDialog.setFilterExtensions(filterExtensions);
									String selectedFile = fileDialog.open();
									if (selectedFile != null) {
										boolean successLoad = GameGui.loadGame(selectedFile);
										if (successLoad == true) {
											advancedLetterPlaced = false;
											isSaved = false;
//											updateWindow(false);
											updateWindow();
										} else {
											MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
											messageBox.setText("Game Load");
											messageBox.setMessage("Loading Game failed");
											messageBox.open();
										}
									}
								}
							});
						}
						{
							menuItemGameSave = new MenuItem(menu1, SWT.PUSH);
							menuItemGameSave.setText("&Save");
							menuItemGameSave.setEnabled(false);
							menuItemGameSave.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
//									System.out.println("menuItemGameSave.widgetSelected, event="+evt);
									saveAction();
								}
							});
						}
						{
							menuItemGameSep2 = new MenuItem(menu1, SWT.SEPARATOR);
						}
						{
							menuItemGameExit = new MenuItem(menu1, SWT.PUSH);
							menuItemGameExit.setText("E&xit");
							menuItemGameExit.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									//System.out.println("menuItemGameExit.widgetSelected, event="+evt);
									exitProcedure();
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
						{
							menuItemViewHome = new MenuItem(menu2, SWT.RADIO);
							menuItemViewHome.setText("Home Sweet Home");
							menuItemViewHome.setSelection(true);
							menuItemViewHome.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
//									System.out.println("menuItemViewHome.widgetSelected, event="+evt);
									Image image = new Image(Display.getDefault(),resConfig.getImageStream("wooden_table.jpg"));
									shell.setBackgroundImage(image);
									
								}
							});
						}
						{
							menuItemViewBeach = new MenuItem(menu2, SWT.RADIO);
							menuItemViewBeach.setText("On the Beach");
							menuItemViewBeach.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
//									System.out.println("menuItemViewBeach.widgetSelected, event="+evt);
									Image image = new Image(Display.getDefault(),resConfig.getImageStream("beach.jpg"));
									shell.setBackgroundImage(image);
								}
							});
						}
						{
							menuItemViewSpace = new MenuItem(menu2, SWT.RADIO);
							menuItemViewSpace.setText("On Space");
							menuItemViewSpace.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									Image image = new Image(Display.getDefault(),resConfig.getImageStream("space.jpg"));
									shell.setBackgroundImage(image);
								}
							});
						}
						{
							menuItemViewForest = new MenuItem(menu2, SWT.RADIO);
							menuItemViewForest.setText("On the Forest");
							menuItemViewForest.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
//									System.out.println("menuItemViewForest.widgetSelected, event="+evt);
									Image image = new Image(Display.getDefault(),resConfig.getImageStream("forest.jpg"));

									shell.setBackgroundImage(image);
								}
							});
						}
					}
				}
				{
					menuItemRecordList = new MenuItem(menuMain, SWT.CASCADE);
					menuItemRecordList.setText("Record List");
					{
						menu3 = new Menu(menuItemRecordList);
						menuItemRecordList.setMenu(menu3);
						{
							menuItemRLBasic = new MenuItem(menu3, SWT.PUSH);
							menuItemRLBasic.setText("Basic");
							menuItemRLBasic.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									RLDialog rlDialog = new RLDialog(shell, true);
									rlDialog.open();
								}
							});
						}
						{
							menuItemRLAdvanced = new MenuItem(menu3, SWT.PUSH);
							menuItemRLAdvanced.setText("Advanced");
							menuItemRLAdvanced.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									RLDialog rlDialog = new RLDialog(shell, false);
									rlDialog.open();
								}
							});
						}
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
							menuItemHelpScreen.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									HelpDialog helpDialog = new HelpDialog(shell);
									helpDialog.open();
								}
							});
						}
						{
							menuItemHelpSep1 = new MenuItem(menu4, SWT.SEPARATOR);
						}
						{
							menuItemHelpAbout = new MenuItem(menu4, SWT.PUSH);
							menuItemHelpAbout.setText("About");
							menuItemHelpAbout.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									AboutDialog aboutDialog = new AboutDialog(shell);
									aboutDialog.open();
								}
							});
						}
					}
				}
			}
			{
				lettersLeftLabel = new CLabel(this, SWT.NONE);
				FormData lettersLeftLabelLData = new FormData();
				lettersLeftLabelLData.width = 25;
				lettersLeftLabelLData.height = 33;
				lettersLeftLabelLData.left =  new FormAttachment(0, 1000, 1175);
				lettersLeftLabelLData.top =  new FormAttachment(0, 1000, 388);
				lettersLeftLabel.setLayoutData(lettersLeftLabelLData);
				lettersLeftLabel.setFont(SWTResourceManager.getFont("Tahoma", 10, 0, false, false));
				lettersLeftLabel.setBackground(SWTResourceManager.getColor(236, 233, 216));
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
					playerLetter0 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter0.setBounds(12, -8, 73, 74);
					playerLetter0.setBackgroundImage(new Image(Display.getDefault(),resConfig.getImageStream("A.PNG")));
					playerLetter0.setVisible(false);
					playerLetter0.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter1.mouseDown, event="+evt);
							letterClickAction(0);
						}
					});
					allPlayerLetters[0] = playerLetter0;
				}
				{
					playerLetter1 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter1.setBounds(106, -8, 73, 74);
//					playerLetter1.setBackgroundImage(SWTResourceManager.getImage("C.PNG"));
					playerLetter1.setVisible(false);
					playerLetter1.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter2.mouseDown, event="+evt);
							letterClickAction(1);
						}
					});
					allPlayerLetters[1] = playerLetter1;
				}
				{
					playerLetter2 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter2.setBounds(191, -8, 73, 74);
//					playerLetter2.setBackgroundImage(SWTResourceManager.getImage("G.PNG"));
					playerLetter2.setVisible(false);
					playerLetter2.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter3.mouseDown, event="+evt);
							letterClickAction(2);
						}
					});
					allPlayerLetters[2] = playerLetter2;
				}
				{
					playerLetter3 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter3.setBounds(285, -8, 73, 74);
//					playerLetter3.setBackgroundImage(SWTResourceManager.getImage("K.PNG"));
					playerLetter3.setVisible(false);
					playerLetter3.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter4.mouseDown, event="+evt);
							letterClickAction(3);
						}
					});
					allPlayerLetters[3] = playerLetter3;
				}
				{
					playerLetter4 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter4.setBounds(383, -8, 73, 74);
//					playerLetter4.setBackgroundImage(SWTResourceManager.getImage("F.PNG"));
					playerLetter4.setVisible(false);
					playerLetter4.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter5.mouseDown, event="+evt);
							letterClickAction(4);
						}
					});
					allPlayerLetters[4] = playerLetter4;
				}
				{
					playerLetter5 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter5.setBounds(481, -8, 73, 74);
//					playerLetter5.setBackgroundImage(SWTResourceManager.getImage("Q.PNG"));
					playerLetter5.setVisible(false);
					playerLetter5.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter6.mouseDown, event="+evt);
							letterClickAction(5);
						}
					});
					allPlayerLetters[5] = playerLetter5;
				}
				{
					playerLetter6 = new CLabel(letterStandLabel, SWT.NONE);
					playerLetter6.setBounds(575, -8, 73, 74);
//					playerLetter6.setBackgroundImage(SWTResourceManager.getImage("X.PNG"));
					playerLetter6.setVisible(false);
					playerLetter6.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
//							System.out.println("playerLetter7.mouseDown, event="+evt);
							letterClickAction(6);
						}
					});
					allPlayerLetters[6] = playerLetter6;
				}
			}
			{
				groupNowPlaying = new Group(this, SWT.BORDER);
				groupNowPlaying.setBackground(SWTResourceManager.getColor(236, 233, 216));
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
					textNowPlatingLData.heightHint = 50;
					textNowPlaying.setLayoutData(textNowPlatingLData);
					textNowPlaying.setBackground(SWTResourceManager.getColor(236, 233, 216));
					textNowPlaying.setFont(SWTResourceManager.getFont("Tahoma",14,0,false,false));
					textNowPlaying.setEditable(false);
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
				lettersLeftBut.setBackground(SWTResourceManager.getColor(236, 233, 216));
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
				doneBut.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						doneButWidgetSelected(evt);
					}
				});
			}
			{
				changeLetterBut = new Button(this, SWT.PUSH | SWT.CENTER);
				changeLetterBut.setText("Change Letter");
				FormData changeLetterButLData = new FormData();
				changeLetterButLData.width = 146;
				changeLetterButLData.height = 64;
				changeLetterButLData.left =  new FormAttachment(0, 1000, 1034);
				changeLetterButLData.top =  new FormAttachment(0, 1000, 59);
				changeLetterBut.setLayoutData(changeLetterButLData);
				changeLetterBut.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						changeLetterButWidgetSelected(evt);
					}
				});
				changeLetterBut.setEnabled(false);
			}
			{
				cLabelBoard = new CLabel(this, SWT.NONE);
				cLabelBoard.setImage(new Image(Display.getDefault(),resConfig.getImageStream("board.PNG")));
				FormData cLabelBoardLData = new FormData();
				cLabelBoardLData.width = 794;
				cLabelBoardLData.height = 593;
				cLabelBoardLData.left =  new FormAttachment(0, 1000, 205);
				cLabelBoardLData.top =  new FormAttachment(0, 1000, 4);
				cLabelBoard.setLayoutData(cLabelBoardLData);
				{
					cLabelCell0000 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0000.setBounds(164, 26, 32, 31);
					cLabelCell0000.setBackground(SWTResourceManager.getColor(255, 0, 0));
					allCellsGrid[0][0] = cLabelCell0000;
				}
				{
					cLabelCell0001 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0001.setBounds(202, 26, 32, 31);
					cLabelCell0001.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][1] = cLabelCell0001;
				}
				{
					cLabelCell0002 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0002.setBounds(240, 26, 30, 31);
					cLabelCell0002.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][2] = cLabelCell0002;
				}
				{
					cLabelCell0003 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0003.setBounds(275, 26, 32, 31);
					cLabelCell0003.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[0][3] = cLabelCell0003;
				}
				{
					cLabelCell0004 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0004.setBounds(314, 26, 32, 31);
					cLabelCell0004.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][4] = cLabelCell0004;
				}
				{
					cLabelCell0005 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0005.setBounds(351, 26, 30, 31);
					cLabelCell0005.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][5] = cLabelCell0005;
				}
				{
					cLabelCell0006 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0006.setBounds(387, 26, 31, 31);
					cLabelCell0006.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][6] = cLabelCell0006;
				}
				{
					cLabelCell0007 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0007.setBounds(424, 26, 31, 31);
					cLabelCell0007.setBackground(SWTResourceManager.getColor(255,0,0));
					allCellsGrid[0][7] = cLabelCell0007;
				}
				{
					cLabelCell0008 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0008.setBounds(461, 26, 31, 31);
					cLabelCell0008.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][8] = cLabelCell0008;
				}
				{
					cLabelCell0009 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0009.setBounds(498, 26, 31, 31);
					cLabelCell0009.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][9] = cLabelCell0009;
				}
				{
					cLabelCell0010 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0010.setBounds(535, 26, 31, 31);
					cLabelCell0010.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][10] = cLabelCell0010;
				}
				{
					cLabelCell0011 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0011.setBounds(571, 26, 29, 31);
					cLabelCell0011.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[0][11] = cLabelCell0011;
				}
				{
					cLabelCell0012 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0012.setBounds(606, 26, 30, 31);
					cLabelCell0012.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][12] = cLabelCell0012;
				}
				{
					cLabelCell0013 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0013.setBounds(642, 26, 29, 31);
					cLabelCell0013.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[0][13] = cLabelCell0013;
				}
				{
					cLabelCell0014 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0014.setBounds(677, 26, 29, 31);
					cLabelCell0014.setBackground(SWTResourceManager.getColor(255,0,0));
					allCellsGrid[0][14] = cLabelCell0014;
				}
				{
					cLabelCell0100 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0100.setBounds(164, 63, 32, 31);
					cLabelCell0100.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][0] = cLabelCell0100;
				}
				{
					cLabelCell0101 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0101.setBounds(202, 63, 32, 31);
					cLabelCell0101.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[1][1] = cLabelCell0101;
				}
				{
					cLabelCell0102 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0102.setBounds(240, 63, 30, 31);
					cLabelCell0102.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][2] = cLabelCell0102;
				}
				{
					cLabelCell0103 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0103.setBounds(275, 63, 32, 31);
					cLabelCell0103.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][3] = cLabelCell0103;
				}
				{
					cLabelCell0104 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0104.setBounds(313, 63, 32, 31);
					cLabelCell0104.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][4] = cLabelCell0104;
				}
				{
					cLabelCell0105 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0105.setBounds(351, 63, 30, 31);
					cLabelCell0105.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[1][5] = cLabelCell0105;
				}
				{
					cLabelCell0106 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0106.setBounds(387, 63, 31, 31);
					cLabelCell0106.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][6] = cLabelCell0106;
				}
				{
					cLabelCell0107 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0107.setBounds(424, 63, 31, 31);
					cLabelCell0107.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][7] = cLabelCell0107;
				}
				{
					cLabelCell0108 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0108.setBounds(461, 63, 31, 31);
					cLabelCell0108.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][8] = cLabelCell0108;
				}
				{
					cLabelCell0109 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0109.setBounds(498, 63, 31, 31);
					cLabelCell0109.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[1][9] = cLabelCell0109;
				}
				{
					cLabelCell0110 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0110.setBounds(535, 63, 31, 31);
					cLabelCell0110.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][10] = cLabelCell0110;
				}
				{
					cLabelCell0111 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0111.setBounds(571, 63, 29, 31);
					cLabelCell0111.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][11] = cLabelCell0111;
				}
				{
					cLabelCell0112 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0112.setBounds(606, 63, 30, 31);
					cLabelCell0112.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][12] = cLabelCell0112;
				}
				{
					cLabelCell0113 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0113.setBounds(642, 63, 29, 31);
					cLabelCell0113.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[1][13] = cLabelCell0113;
				}
				{
					cLabelCell0114 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0114.setBounds(677, 63, 29, 31);
					cLabelCell0114.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[1][14] = cLabelCell0114;
				}
				{
					cLabelCell0200 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0200.setBounds(164, 99, 32, 32);
					cLabelCell0200.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][0] = cLabelCell0200;
				}
				{
					cLabelCell0201 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0201.setBounds(202, 99, 32, 32);
					cLabelCell0201.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][1] = cLabelCell0201;
				}
				{
					cLabelCell0202 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0202.setBounds(240, 99, 30, 32);
					cLabelCell0202.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[2][2] = cLabelCell0202;
				}
				{
					cLabelCell0203 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0203.setBounds(275, 99, 32, 32);
					cLabelCell0203.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][3] = cLabelCell0203;
				}
				{
					cLabelCell0204 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0204.setBounds(313, 99, 32, 32);
					cLabelCell0204.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][4] = cLabelCell0204;
				}
				{
					cLabelCell0205 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0205.setBounds(351, 99, 30, 32);
					cLabelCell0205.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][5] = cLabelCell0205;
				}
				{
					cLabelCell0206 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0206.setBounds(387, 99, 31, 32);
					cLabelCell0206.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[2][6] = cLabelCell0206;
				}
				{
					cLabelCell0207 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0207.setBounds(424, 99, 31, 32);
					cLabelCell0207.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][7] = cLabelCell0207;
				}
				{
					cLabelCell0208 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0208.setBounds(461, 99, 31, 32);
					cLabelCell0208.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[2][8] = cLabelCell0208;
				}
				{
					cLabelCell0209 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0209.setBounds(498, 99, 31, 32);
					cLabelCell0209.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][9] = cLabelCell0209;
				}
				{
					cLabelCell0210 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0210.setBounds(535, 99, 31, 32);
					cLabelCell0210.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][10] = cLabelCell0210;
				}
				{
					cLabelCell0211 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0211.setBounds(571, 99, 29, 32);
					cLabelCell0211.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][11] = cLabelCell0211;
				}
				{
					cLabelCell0212 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0212.setBounds(606, 99, 30, 32);
					cLabelCell0212.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[2][12] = cLabelCell0212;
				}
				{
					cLabelCell0213 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0213.setBounds(642, 99, 29, 32);
					cLabelCell0213.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][13] = cLabelCell0213;
				}
				{
					cLabelCell0214 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0214.setBounds(677, 99, 29, 32);
					cLabelCell0214.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[2][14] = cLabelCell0214;
				}
				{
					cLabelCell0300 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0300.setBounds(164, 135, 32, 33);
					cLabelCell0300.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[3][0] = cLabelCell0300;
				}
				{
					cLabelCell0301 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0301.setBounds(202, 135, 32, 33);
					cLabelCell0301.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][1] = cLabelCell0301;
				}
				{
					cLabelCell0302 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0302.setBounds(240, 135, 30, 33);
					cLabelCell0302.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][2] = cLabelCell0302;
				}
				{
					cLabelCell0303 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0303.setBounds(275, 135, 32, 33);
					cLabelCell0303.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[3][3] = cLabelCell0303;
				}
				{
					cLabelCell0304 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0304.setBounds(313, 135, 32, 33);
					cLabelCell0304.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][4] = cLabelCell0304;
				}
				{
					cLabelCell0305 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0305.setBounds(351, 135, 30, 33);
					cLabelCell0305.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][5] = cLabelCell0305;
				}
				{
					cLabelCell0306 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0306.setBounds(387, 135, 31, 33);
					cLabelCell0306.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][6] = cLabelCell0306;
				}
				{
					cLabelCell0307 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0307.setBounds(424, 135, 31, 33);
					cLabelCell0307.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[3][7] = cLabelCell0307;
				}
				{
					cLabelCell0308 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0308.setBounds(461, 135, 31, 33);
					cLabelCell0308.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][8] = cLabelCell0308;
				}
				{
					cLabelCell0309 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0309.setBounds(498, 135, 31, 33);
					cLabelCell0309.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][9] = cLabelCell0309;
				}
				{
					cLabelCell0310 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0310.setBounds(535, 135, 31, 33);
					cLabelCell0310.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][10] = cLabelCell0310;
				}
				{
					cLabelCell0311 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0311.setBounds(571, 135, 29, 33);
					cLabelCell0311.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[3][11] = cLabelCell0311;
				}
				{
					cLabelCell0312 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0312.setBounds(606, 135, 30, 33);
					cLabelCell0312.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][12] = cLabelCell0312;
				}
				{
					cLabelCell0313 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0313.setBounds(642, 135, 29, 33);
					cLabelCell0313.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[3][13] = cLabelCell0313;
				}
				{
					cLabelCell0314 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0314.setBounds(677, 135, 29, 33);
					cLabelCell0314.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[3][14] = cLabelCell0314;
				}
				{
					cLabelCell0400 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0400.setBounds(164, 171, 32, 34);
					cLabelCell0400.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][0] = cLabelCell0400;
				}
				{
					cLabelCell0401 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0401.setBounds(202, 171, 32, 34);
					cLabelCell0401.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][1] = cLabelCell0401;
				}
				{
					cLabelCell0402 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0402.setBounds(240, 171, 30, 34);
					cLabelCell0402.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][2] = cLabelCell0402;
				}
				{
					cLabelCell0403 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0403.setBounds(275, 171, 32, 34);
					cLabelCell0403.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][3] = cLabelCell0403;
				}
				{
					cLabelCell0404 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0404.setBounds(313, 171, 32, 34);
					cLabelCell0404.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[4][4] = cLabelCell0404;
				}
				{
					cLabelCell0405 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0405.setBounds(351, 171, 30, 34);
					cLabelCell0405.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][5] = cLabelCell0405;
				}
				{
					cLabelCell0406 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0406.setBounds(387, 171, 31, 34);
					cLabelCell0406.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][6] = cLabelCell0406;
				}
				{
					cLabelCell0407 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0407.setBounds(424, 171, 31, 34);
					cLabelCell0407.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][7] = cLabelCell0407;
				}
				{
					cLabelCell0408 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0408.setBounds(461, 171, 31, 34);
					cLabelCell0408.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][8] = cLabelCell0408;
				}
				{
					cLabelCell0409 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0409.setBounds(498, 171, 31, 34);
					cLabelCell0409.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][9] = cLabelCell0409;
				}
				{
					cLabelCell0410 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0410.setBounds(535, 171, 31, 34);
					cLabelCell0410.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[4][10] = cLabelCell0410;
				}
				{
					cLabelCell0411 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0411.setBounds(571, 171, 29, 34);
					cLabelCell0411.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][11] = cLabelCell0411;
				}
				{
					cLabelCell0412 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0412.setBounds(606, 171, 30, 34);
					cLabelCell0412.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][12] = cLabelCell0412;
				}
				{
					cLabelCell0413 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0413.setBounds(642, 171, 29, 34);
					cLabelCell0413.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][13] = cLabelCell0413;
				}
				{
					cLabelCell0414 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0414.setBounds(677, 171, 29, 34);
					cLabelCell0414.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[4][14] = cLabelCell0414;
				}
				{
					cLabelCell0500 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0500.setBounds(164, 210, 32, 32);
					cLabelCell0500.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][0] = cLabelCell0500;
				}
				{
					cLabelCell0501 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0501.setBounds(202, 210, 32, 32);
					cLabelCell0501.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[5][1] = cLabelCell0501;
				}
				{
					cLabelCell0502 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0502.setBounds(240, 210, 30, 32);
					cLabelCell0502.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][2] = cLabelCell0502;
				}
				{
					cLabelCell0503 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0503.setBounds(275, 210, 32, 32);
					cLabelCell0503.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][3] = cLabelCell0503;
				}
				{
					cLabelCell0504 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0504.setBounds(313, 210, 32, 32);
					cLabelCell0504.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][4] = cLabelCell0504;
				}
				{
					cLabelCell0505 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0505.setBounds(351, 210, 30, 32);
					cLabelCell0505.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[5][5] = cLabelCell0505;
				}
				{
					cLabelCell0506 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0506.setBounds(387, 210, 31, 32);
					cLabelCell0506.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][6] = cLabelCell0506;
				}
				{
					cLabelCell0507 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0507.setBounds(424, 210, 31, 32);
					cLabelCell0507.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][7] = cLabelCell0507;
				}
				{
					cLabelCell0508 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0508.setBounds(461, 210, 31, 32);
					cLabelCell0508.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][8] = cLabelCell0508;
				}
				{
					cLabelCell0509 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0509.setBounds(498, 210, 31, 32);
					cLabelCell0509.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[5][9] = cLabelCell0509;
				}
				{
					cLabelCell0510 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0510.setBounds(535, 210, 31, 32);
					cLabelCell0510.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][10] = cLabelCell0510;
				}
				{
					cLabelCell0511 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0511.setBounds(571, 210, 30, 32);
					cLabelCell0511.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][11] = cLabelCell0511;
				}
				{
					cLabelCell0512 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0512.setBounds(605, 210, 31, 32);
					cLabelCell0512.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][12] = cLabelCell0512;
				}
				{
					cLabelCell0513 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0513.setBounds(642, 210, 29, 32);
					cLabelCell0513.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[5][13] = cLabelCell0513;
				}
				{
					cLabelCell0514 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0514.setBounds(677, 210, 29, 32);
					cLabelCell0514.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[5][14] = cLabelCell0514;
				}
				{
					cLabelCell0600 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0600.setBounds(164, 248, 32, 31);
					cLabelCell0600.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][0] = cLabelCell0600;
				}
				{
					cLabelCell0601 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0601.setBounds(202, 248, 32, 31);
					cLabelCell0601.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][1] = cLabelCell0601;
				}
				{
					cLabelCell0602 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0602.setBounds(240, 248, 30, 31);
					cLabelCell0602.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[6][2] = cLabelCell0602;
				}
				{
					cLabelCell0603 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0603.setBounds(275, 248, 32, 31);
					cLabelCell0603.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][3] = cLabelCell0603;
				}
				{
					cLabelCell0604 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0604.setBounds(313, 248, 32, 31);
					cLabelCell0604.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][4] = cLabelCell0604;
				}
				{
					cLabelCell0605 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0605.setBounds(351, 248, 30, 31);
					cLabelCell0605.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][5] = cLabelCell0605;
				}
				{
					cLabelCell0606 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0606.setBounds(387, 248, 31, 31);
					cLabelCell0606.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[6][6] = cLabelCell0606;
				}
				{
					cLabelCell0607 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0607.setBounds(424, 248, 31, 31);
					cLabelCell0607.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][7] = cLabelCell0607;
				}
				{
					cLabelCell0608 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0608.setBounds(461, 248, 31, 31);
					cLabelCell0608.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[6][8] = cLabelCell0608;
				}
				{
					cLabelCell0609 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0609.setBounds(498, 248, 31, 31);
					cLabelCell0609.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][9] = cLabelCell0609;
				}
				{
					cLabelCell0610 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0610.setBounds(535, 248, 31, 31);
					cLabelCell0610.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][10] = cLabelCell0610;
				}
				{
					cLabelCell0611 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0611.setBounds(571, 248, 30, 31);
					cLabelCell0611.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][11] = cLabelCell0611;
				}
				{
					cLabelCell0612 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0612.setBounds(606, 248, 30, 31);
					cLabelCell0612.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[6][12] = cLabelCell0612;
				}
				{
					cLabelCell0613 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0613.setBounds(641, 248, 30, 31);
					cLabelCell0613.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][13] = cLabelCell0613;
				}
				{
					cLabelCell0614 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0614.setBounds(677, 248, 29, 31);
					cLabelCell0614.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[6][14] = cLabelCell0614;
				}
				{
					cLabelCell0700 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0700.setBounds(164, 284, 32, 33);
					cLabelCell0700.setBackground(SWTResourceManager.getColor(255,0,0));
					allCellsGrid[7][0] = cLabelCell0700;
				}
				{
					cLabelCell0701 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0701.setBounds(202, 284, 32, 33);
					cLabelCell0701.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][1] = cLabelCell0701;
				}
				{
					cLabelCell0702 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0702.setBounds(240, 284, 30, 33);
					cLabelCell0702.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][2] = cLabelCell0702;
				}
				{
					cLabelCell0703 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0703.setBounds(275, 284, 32, 33);
					cLabelCell0703.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[7][3] = cLabelCell0703;
				}
				{
					cLabelCell0704 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0704.setBounds(313, 284, 32, 33);
					cLabelCell0704.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][4] = cLabelCell0704;
				}
				{
					cLabelCell0705 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0705.setBounds(351, 284, 30, 33);
					cLabelCell0705.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][5] = cLabelCell0705;
				}
				{
					cLabelCell0706 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0706.setBounds(387, 284, 31, 33);
					cLabelCell0706.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][6] = cLabelCell0706;
				}
				{
					cLabelCell0707 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0707.setBounds(424, 284, 31, 33);
					cLabelCell0707.setBackground(SWTResourceManager.getColor(255, 128, 128));
					allCellsGrid[7][7] = cLabelCell0707;
				}
				{
					cLabelCell0708 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0708.setBounds(461, 284, 31, 33);
					cLabelCell0708.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][8] = cLabelCell0708;
				}
				{
					cLabelCell0709 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0709.setBounds(498, 284, 31, 33);
					cLabelCell0709.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][9] = cLabelCell0709;
				}
				{
					cLabelCell0710 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0710.setBounds(535, 284, 31, 33);
					cLabelCell0710.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][10] = cLabelCell0710;
				}
				{
					cLabelCell0711 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0711.setBounds(571, 284, 30, 33);
					cLabelCell0711.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[7][11] = cLabelCell0711;
				}
				{
					cLabelCell0712 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0712.setBounds(606, 284, 30, 33);
					cLabelCell0712.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][12] = cLabelCell0712;
				}
				{
					cLabelCell0713 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0713.setBounds(641, 284, 30, 33);
					cLabelCell0713.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[7][13] = cLabelCell0713;
				}
				{
					cLabelCell0714 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0714.setBounds(677, 284, 29, 33);
					cLabelCell0714.setBackground(SWTResourceManager.getColor(255,0,0));
					allCellsGrid[7][14] = cLabelCell0714;
				}
				{
					cLabelCell0800 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0800.setBounds(164, 323, 32, 30);
					cLabelCell0800.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][0] = cLabelCell0800;
				}
				{
					cLabelCell0801 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0801.setBounds(202, 323, 32, 30);
					cLabelCell0801.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][1] = cLabelCell0801;
				}
				{
					cLabelCell0802 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0802.setBounds(240, 323, 30, 30);
					cLabelCell0802.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[8][2] = cLabelCell0802;
				}
				{
					cLabelCell0803 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0803.setBounds(275, 323, 32, 30);
					cLabelCell0803.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][3] = cLabelCell0803;
				}
				{
					cLabelCell0804 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0804.setBounds(313, 323, 32, 30);
					cLabelCell0804.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][4] = cLabelCell0804;
				}
				{
					cLabelCell0805 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0805.setBounds(351, 323, 30, 30);
					cLabelCell0805.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][5] = cLabelCell0805;
				}
				{
					cLabelCell0806 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0806.setBounds(387, 323, 31, 30);
					cLabelCell0806.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[8][6] = cLabelCell0806;
				}
				{
					cLabelCell0807 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0807.setBounds(424, 323, 31, 30);
					cLabelCell0807.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][7] = cLabelCell0807;
				}
				{
					cLabelCell0808 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0808.setBounds(461, 323, 31, 30);
					cLabelCell0808.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[8][8] = cLabelCell0808;
				}
				{
					cLabelCell0809 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0809.setBounds(498, 323, 31, 30);
					cLabelCell0809.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][9] = cLabelCell0809;
				}
				{
					cLabelCell0810 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0810.setBounds(535, 323, 31, 30);
					cLabelCell0810.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][10] = cLabelCell0810;
				}
				{
					cLabelCell0811 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0811.setBounds(571, 323, 30, 30);
					cLabelCell0811.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][11] = cLabelCell0811;
				}
				{
					cLabelCell0812 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0812.setBounds(606, 323, 30, 30);
					cLabelCell0812.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[8][12] = cLabelCell0812;
				}
				{
					cLabelCell0813 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0813.setBounds(641, 323, 30, 30);
					cLabelCell0813.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][13] = cLabelCell0813;
				}
				{
					cLabelCell0814 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0814.setBounds(677, 323, 29, 30);
					cLabelCell0814.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[8][14] = cLabelCell0814;
				}
				{
					cLabelCell0900 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0900.setBounds(164, 359, 32, 31);
					cLabelCell0900.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][0] = cLabelCell0900;
				}
				{
					cLabelCell0901 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0901.setBounds(202, 359, 32, 31);
					cLabelCell0901.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[9][1] = cLabelCell0901;
				}
				{
					cLabelCell0902 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0902.setBounds(240, 359, 30, 31);
					cLabelCell0902.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][2] = cLabelCell0902;
				}
				{
					cLabelCell0903 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0903.setBounds(275, 359, 32, 31);
					cLabelCell0903.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][3] = cLabelCell0903;
				}
				{
					cLabelCell0904 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0904.setBounds(313, 359, 32, 31);
					cLabelCell0904.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][4] = cLabelCell0904;
				}
				{
					cLabelCell0905 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0905.setBounds(351, 359, 30, 31);
					cLabelCell0905.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[9][5] = cLabelCell0905;
				}
				{
					cLabelCell0906 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0906.setBounds(387, 359, 31, 31);
					cLabelCell0906.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][6] = cLabelCell0906;
				}
				{
					cLabelCell0907 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0907.setBounds(424, 359, 31, 31);
					cLabelCell0907.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][7] = cLabelCell0907;
				}
				{
					cLabelCell0908 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0908.setBounds(461, 359, 31, 31);
					cLabelCell0908.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][8] = cLabelCell0908;
				}
				{
					cLabelCell0909 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0909.setBounds(498, 359, 31, 31);
					cLabelCell0909.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[9][9] = cLabelCell0909;
				}
				{
					cLabelCell0910 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0910.setBounds(535, 359, 31, 31);
					cLabelCell0910.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][10] = cLabelCell0910;
				}
				{
					cLabelCell0911 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0911.setBounds(571, 359, 30, 31);
					cLabelCell0911.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][11] = cLabelCell0911;
				}
				{
					cLabelCell0912 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0912.setBounds(606, 359, 30, 31);
					cLabelCell0912.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][12] = cLabelCell0912;
				}
				{
					cLabelCell0913 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0913.setBounds(641, 359, 30, 31);
					cLabelCell0913.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[9][13] = cLabelCell0913;
				}
				{
					cLabelCell0914 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell0914.setBounds(677, 359, 29, 31);
					cLabelCell0914.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[9][14] = cLabelCell0914;
				}
				{
					cLabelCell1000 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1000.setBounds(164, 395, 32, 32);
					cLabelCell1000.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][0] = cLabelCell1000;
				}
				{
					cLabelCell1001 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1001.setBounds(202, 395, 32, 32);
					cLabelCell1001.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][1] = cLabelCell1001;
				}
				{
					cLabelCell1002 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1002.setBounds(240, 395, 30, 32);
					cLabelCell1002.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][2] = cLabelCell1002;
				}
				{
					cLabelCell1003 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1003.setBounds(275, 395, 32, 32);
					cLabelCell1003.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][3] = cLabelCell1003;
				}
				{
					cLabelCell1004 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1004.setBounds(313, 395, 32, 32);
					cLabelCell1004.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[10][4] = cLabelCell1004;
				}
				{
					cLabelCell1005 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1005.setBounds(351, 395, 30, 32);
					cLabelCell1005.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][5] = cLabelCell1005;
				}
				{
					cLabelCell1006 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1006.setBounds(387, 395, 31, 32);
					cLabelCell1006.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][6] = cLabelCell1006;
				}
				{
					cLabelCell1007 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1007.setBounds(424, 395, 31, 32);
					cLabelCell1007.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][7] = cLabelCell1007;
				}
				{
					cLabelCell1008 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1008.setBounds(461, 395, 31, 32);
					cLabelCell1008.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][8] = cLabelCell1008;
				}
				{
					cLabelCell1009 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1009.setBounds(498, 395, 31, 32);
					cLabelCell1009.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][9] = cLabelCell1009;
				}
				{
					cLabelCell1010 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1010.setBounds(535, 395, 31, 32);
					cLabelCell1010.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[10][10] = cLabelCell1010;
				}
				{
					cLabelCell1011 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1011.setBounds(571, 395, 30, 32);
					cLabelCell1011.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][11] = cLabelCell1011;
				}
				{
					cLabelCell1012 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1012.setBounds(606, 395, 30, 32);
					cLabelCell1012.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][12] = cLabelCell1012;
				}
				{
					cLabelCell1013 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1013.setBounds(641, 395, 30, 32);
					cLabelCell1013.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][13] = cLabelCell1013;
				}
				{
					cLabelCell1014 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1014.setBounds(677, 395, 29, 32);
					cLabelCell1014.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[10][14] = cLabelCell1014;
				}
				{
					cLabelCell1100 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1100.setBounds(164, 431, 32, 33);
					cLabelCell1100.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[11][0] = cLabelCell1100;
				}
				{
					cLabelCell1101 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1101.setBounds(202, 431, 32, 33);
					cLabelCell1101.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][1] = cLabelCell1101;
				}
				{
					cLabelCell1102 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1102.setBounds(240, 431, 30, 33);
					cLabelCell1102.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][2] = cLabelCell1102;
				}
				{
					cLabelCell1103 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1103.setBounds(275, 431, 32, 33);
					cLabelCell1103.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[11][3] = cLabelCell1103;
				}
				{
					cLabelCell1104 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1104.setBounds(313, 431, 32, 33);
					cLabelCell1104.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][4] = cLabelCell1104;
				}
				{
					cLabelCell1105 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1105.setBounds(351, 431, 30, 33);
					cLabelCell1105.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][5] = cLabelCell1105;
				}
				{
					cLabelCell1106 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1106.setBounds(387, 431, 31, 33);
					cLabelCell1106.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][6] = cLabelCell1106;
				}
				{
					cLabelCell1107 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1107.setBounds(424, 431, 31, 33);
					cLabelCell1107.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[11][7] = cLabelCell1107;
				}
				{
					cLabelCell1108 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1108.setBounds(461, 431, 31, 33);
					cLabelCell1108.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][8] = cLabelCell1108;
				}
				{
					cLabelCell1109 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1109.setBounds(498, 431, 31, 33);
					cLabelCell1109.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][9] = cLabelCell1109;
				}
				{
					cLabelCell1110 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1110.setBounds(535, 431, 31, 33);
					cLabelCell1110.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][10] = cLabelCell1110;
				}
				{
					cLabelCell1111 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1111.setBounds(571, 431, 30, 33);
					cLabelCell1111.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[11][11] = cLabelCell1111;
				}
				{
					cLabelCell1112 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1112.setBounds(606, 431, 30, 33);
					cLabelCell1112.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][12] = cLabelCell1112;
				}
				{
					cLabelCell1113 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1113.setBounds(641, 431, 30, 33);
					cLabelCell1113.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[11][13] = cLabelCell1113;
				}
				{
					cLabelCell1114 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1114.setBounds(677, 431, 29, 33);
					cLabelCell1114.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[11][14] = cLabelCell1114;
				}
				{
					cLabelCell1206 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1206.setBounds(387, 470, 31, 31);
					cLabelCell1206.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[12][6] = cLabelCell1206;
				}
				{
					cLabelCell1208 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1208.setBounds(461, 470, 31, 31);
					cLabelCell1208.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[12][8] = cLabelCell1208;
				}
				{
					cLabelCell1403 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1403.setBounds(275, 540, 32, 29);
					cLabelCell1403.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[14][3] = cLabelCell1403;
				}
				{
					cLabelCell1411 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1411.setBounds(571, 540, 30, 29);
					cLabelCell1411.setBackground(SWTResourceManager.getColor(13,162,242));
					allCellsGrid[14][11] = cLabelCell1411;
				}
				{
					cLabelCell1400 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1400.setBounds(164, 540, 32, 29);
					cLabelCell1400.setBackground(SWTResourceManager.getColor(255,0,0));
					allCellsGrid[14][0] = cLabelCell1400;
				}
				{
					cLabelCell1407 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1407.setBounds(424, 540, 31, 29);
					cLabelCell1407.setBackground(SWTResourceManager.getColor(255,0,0));
					allCellsGrid[14][7] = cLabelCell1407;
				}
				{
					cLabelCell1414 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1414.setBounds(677, 540, 29, 29);
					cLabelCell1414.setBackground(SWTResourceManager.getColor(255,0,0));
					allCellsGrid[14][14] = cLabelCell1414;
				}
				{
					cLabelCell1309 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1309.setBounds(498, 506, 31, 30);
					cLabelCell1309.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[13][9] = cLabelCell1309;
				}
				{
					cLabelCell1305 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1305.setBounds(351, 506, 30, 30);
					cLabelCell1305.setBackground(SWTResourceManager.getColor(0,0,255));
					allCellsGrid[13][5] = cLabelCell1305;
				}
				{
					cLabelCell1301 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1301.setBounds(202, 506, 32, 30);
					cLabelCell1301.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[13][1] = cLabelCell1301;
				}
				{
					cLabelCell1313 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1313.setBounds(641, 506, 30, 30);
					cLabelCell1313.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[13][13] = cLabelCell1313;
				}
				{
					cLabelCell1202 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1202.setBounds(240, 470, 30, 31);
					cLabelCell1202.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[12][2] = cLabelCell1202;
				}
				{
					cLabelCell1212 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1212.setBounds(606, 470, 30, 31);
					cLabelCell1212.setBackground(SWTResourceManager.getColor(255,128,128));
					allCellsGrid[12][12] = cLabelCell1212;
				}
				{
					cLabelCell1200 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1200.setBounds(164, 470, 32, 31);
					cLabelCell1200.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][0] = cLabelCell1200;
				}
				{
					cLabelCell1201 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1201.setBounds(202, 470, 32, 31);
					cLabelCell1201.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][1] = cLabelCell1201;
				}
				{
					cLabelCell1203 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1203.setBounds(275, 470, 32, 31);
					cLabelCell1203.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][3] = cLabelCell1203;
				}
				{
					cLabelCell1204 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1204.setBounds(313, 470, 32, 31);
					cLabelCell1204.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][4] = cLabelCell1204;
				}
				{
					cLabelCell1205 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1205.setBounds(351, 470, 30, 31);
					cLabelCell1205.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][5] = cLabelCell1205;
				}
				{
					cLabelCell1207 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1207.setBounds(424, 470, 31, 31);
					cLabelCell1207.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][7] = cLabelCell1207;
				}
				{
					cLabelCell1209 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1209.setBounds(498, 470, 31, 31);
					cLabelCell1209.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][9] = cLabelCell1209;
				}
				{
					cLabelCell1210 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1210.setBounds(535, 470, 31, 31);
					cLabelCell1210.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][10] = cLabelCell1210;
				}
				{
					cLabelCell1211 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1211.setBounds(572, 470, 30, 31);
					cLabelCell1211.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][11] = cLabelCell1211;
				}
				{
					cLabelCell1213 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1213.setBounds(641, 470, 30, 31);
					cLabelCell1213.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][13] = cLabelCell1213;
				}
				{
					cLabelCell1214 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1214.setBounds(677, 470, 29, 31);
					cLabelCell1214.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[12][14] = cLabelCell1214;
				}
				{
					cLabelCell1300 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1300.setBounds(163, 506, 33, 30);
					cLabelCell1300.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][0] = cLabelCell1300;
				}
				{
					cLabelCell1302 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1302.setBounds(240, 506, 30, 30);
					cLabelCell1302.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][2] = cLabelCell1302;
				}
				{
					cLabelCell1303 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1303.setBounds(275, 506, 32, 30);
					cLabelCell1303.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][3] = cLabelCell1303;
				}
				{
					cLabelCell1304 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1304.setBounds(313, 506, 32, 30);
					cLabelCell1304.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][4] = cLabelCell1304;
				}
				{
					cLabelCell1306 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1306.setBounds(387, 506, 31, 30);
					cLabelCell1306.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][6] = cLabelCell1306;
				}
				{
					cLabelCell1307 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1307.setBounds(424, 506, 31, 30);
					cLabelCell1307.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][7] = cLabelCell1307;
				}
				{
					cLabelCell1308 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1308.setBounds(461, 506, 31, 30);
					cLabelCell1308.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][8] = cLabelCell1308;
				}
				{
					cLabelCell1310 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1310.setBounds(535, 506, 31, 30);
					cLabelCell1310.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][10] = cLabelCell1310;
				}
				{
					cLabelCell1311 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1311.setBounds(571, 506, 30, 30);
					cLabelCell1311.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][11] = cLabelCell1311;
				}
				{
					cLabelCell1312 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1312.setBounds(606, 506, 30, 30);
					cLabelCell1312.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][12] = cLabelCell1312;
				}
				{
					cLabelCell1314 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1314.setBounds(677, 506, 29, 30);
					cLabelCell1314.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[13][14] = cLabelCell1314;
				}
				{
					cLabelCell1401 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1401.setBounds(202, 540, 32, 29);
					cLabelCell1401.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][1] = cLabelCell1401;
				}
				{
					cLabelCell1402 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1402.setBounds(240, 540, 30, 30);
					cLabelCell1402.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][2] = cLabelCell1402;
				}
				{
					cLabelCell1404 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1404.setBounds(313, 540, 32, 29);
					cLabelCell1404.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][4] = cLabelCell1404;
				}
				{
					cLabelCell1405 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1405.setBounds(351, 540, 30, 30);
					cLabelCell1405.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][5] = cLabelCell1405;
				}
				{
					cLabelCell1406 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1406.setBounds(387, 540, 31, 30);
					cLabelCell1406.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][6] = cLabelCell1406;
				}
				{
					cLabelCell1408 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1408.setBounds(461, 540, 31, 30);
					cLabelCell1408.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][8] = cLabelCell1408;
				}
				{
					cLabelCell1409 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1409.setBounds(498, 540, 31, 30);
					cLabelCell1409.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][9] = cLabelCell1409;
				}
				{
					cLabelCell1410 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1410.setBounds(535, 540, 31, 29);
					cLabelCell1410.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][10] = cLabelCell1410;
				}
				{
					cLabelCell1412 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1412.setBounds(605, 540, 31, 30);
					cLabelCell1412.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][12] = cLabelCell1412;
				}
				{
					cLabelCell1413 = new CLabel(cLabelBoard, SWT.BORDER);
					cLabelCell1413.setBounds(641, 540, 30, 30);
					cLabelCell1413.setBackground(SWTResourceManager.getColor(239,208,143));
					allCellsGrid[14][13] = cLabelCell1413;
				}
			}
			{
				groupScore = new Group(this, SWT.BORDER);
				groupScore.setBackground(SWTResourceManager.getColor(236, 233, 216));
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
				groupStatus = new Group(this, SWT.BORDER);
				groupStatus.setBackground(SWTResourceManager.getColor(236, 233, 216));
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
					textStatus.setFont(SWTResourceManager.getFont("Tahoma",10,0,false,false));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        loadImages();
	}
	
	private void exitProcedure() {
		if (isSaved == false) {
			saveBeforExitMessage();
		}
		if (showMessageDialog("Are you sure you want to exit?", "Game Exit") == true) {
			display.dispose();
		}
	}
	
	public boolean showMessageDialog(String string, String string2) {
		MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		messageBox.setMessage(string);
		messageBox.setText(string2);
		int response = messageBox.open();
		if (response == SWT.YES) {
			return true;
		} else  {
			return false;
		}
	}

	public void setPlayStatusText(String string) {
		this.updateStatusText(string);
	}
	
	private static void saveBeforExitMessage() {
		MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
		messageBox.setText("Save before exit");
		messageBox.setMessage("The current game was not saved. Would you like to save it?");
		int response = messageBox.open();
		if (response == SWT.YES) {
			saveAction();
		}
	}
	
	private static void saveAction() {
		String[] filterExtensions = {"*.scrabble", "*.*"};
		FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
		fileDialog.setText("Scrabble Save Game");
		fileDialog.setFilterPath(gameDirectories.getSavedGamesDirectorty());
		fileDialog.setFilterExtensions(filterExtensions);
		String selectedFile = fileDialog.open();
//		System.out.println(selectedFile);
		if (selectedFile != null) {
			boolean succ = scrabbleMain.GameGui.saveCurrentGame(selectedFile);
			MessageBox messageBox;
            if (succ)
            {
            	isSaved = true;
                messageBox = new MessageBox(shell, SWT.ICON_INFORMATION);
                messageBox.setMessage("The Game had been saved successfuly under: " + selectedFile);
            }
            else
            {
            	messageBox = new MessageBox(shell, SWT.ICON_ERROR);
                messageBox.setMessage("The Game has not been saved");
            }
            messageBox.setText("Scrabble Save");
            messageBox.open();
		}
	}
	
	private void menuItemGameNewWidgetSelected(SelectionEvent evt) {
//		System.out.println("menuItemGameNew.widgetSelected, event="+evt);
		if (!isSaved) {
			saveBeforExitMessage();
		}
		NewGameDialog newGameDialog = new NewGameDialog(getShell(), SWT.DIALOG_TRIM);
		newGameDialog.open();
		//user changed his mind and don't want to start a new game
		if (newGameDialog.isClosed() == true) {
			return;
		}
		GameGui.initGameLogic();
		PlayerInfo[] playerInfo = newGameDialog.getPlayersInfo();
		//if window was closed
		if (playerInfo == null) {
			return;
		}
		G = GameGui.getG();
		G.setMode(newGameDialog.getGameMode());
		GameGui.setNumberOfPlayers(playerInfo.length);
//		System.out.println(newGameDialog.getGameMode());
		GameGui.createPlayerList(playerInfo);
		G.mainWindow = this;
//		this.updateWindow(true);
		this.updateWindow();
		this.updateStatusText("Start placing your word or Press 'Change Letter' and make your move. When finished press 'Done'");
		advancedLetterPlaced = false;
		isSaved = false;
	}

//	private void updateWindow(boolean cleanBoard) {
	private void updateWindow() {
		this.updateNowPlayingText();
		this.updateScoresText();
		this.updateLetterSetText();
		this.updatePlayerLetters();
		changeLetterBut.setEnabled(true);
		menuItemGameSave.setEnabled(true);
		updateBoard();
//		if (cleanBoard == true) {
//			this.putRandomWord();
//		} 
	}
	
	private void updateBoard() {
		Board board = G.getBoard();
		for (int i = 0; i < board.getWidth(); i++) {
			for (int j = 0; j < board.getLength(); j++) {
				CLabel currentCell = allCellsGrid[i][j];
				char letter = board.getLetter(i, j);
//				if (currentCell.getBackgroundImage() == null) {
					if (letter == '*') {
						currentCell.setBackground(allCellsColors[i][j]);
						currentCell.setBackgroundImage(null);
					}
					else {
						String l = String.valueOf(letter);
						currentCell.setBackground(new Image(Display.getDefault(),resConfig.getImageStream(l + "1.PNG")));
						currentCell.setBackgroundImage(new Image(Display.getDefault(),resConfig.getImageStream(l + "1.PNG")));
					}
				}
//				else {
//					currentCell.setBackground(allCellsColors[i][j]);
//					currentCell.setBackgroundImage(null);
//				}
//			}
		}
	}
	
//	private void putRandomWord() {
//		Board board = G.getBoard();
//		int middle = board.getLength() / 2;
////		System.out.println(middle);
//		char currentLetter;
//		for (int i = 0; i < board.getWidth(); i++) {
//			if ((currentLetter = board.getLetter(middle, i)) != '*') {
//				CLabel currentCell = allCellsGrid[middle][i];
//				String l = String.valueOf(currentLetter);
//				currentCell.setBackground(new Image(Display.getDefault(),resConfig.getImageStream(l + "1.PNG")));
//				currentCell.setBackgroundImage(new Image(Display.getDefault(),resConfig.getImageStream(l + "1.PNG")));
//			}
//		}
//	}

	private void updatePlayerLetters() {
		Player currentPlayer = G.getCurrentPlayer();
//		int numberOfPlayerLetters = currentPlayer.getNumberOfLetters();
//		for (int i = 0; i < numberOfPlayerLetters; i++) {
//			allPlayerLetters[i].setBackgroundImage(getLetterImage(currentPlayer.getLetter(i)));
//			allPlayerLetters[i].setVisible(true);
//		}
//		for (int i = numberOfPlayerLetters; i < 7; i++) {
//			allPlayerLetters[i].setVisible(false);
//		}
		for (int i = 0; i < 7; i++) {
			char currentLetter = currentPlayer.getLetter(i);
			if (currentLetter != '*') {
				allPlayerLetters[i].setBackgroundImage(getLetterImage(currentLetter));
				allPlayerLetters[i].setVisible(true);
			}
			else {
				allPlayerLetters[i].setBackgroundImage(null);
				allPlayerLetters[i].setVisible(false);
			}
		}
	}

	private Image getLetterImage(char letter) {
		return new Image(Display.getDefault(),resConfig.getImageStream(String.valueOf(letter).toUpperCase() + ".PNG"));
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
		changeLetterBut.setEnabled(false);
		this.updateStatusText("You are allowed to change no more than 3 letters. Press the letter you want to change");
		GameGui.initNumberOfChanges();
		doneBut.setEnabled(true);
	}
	
	private void letterClickAction(int index) {
		isSaved = false;
		if (changeLetterFlag == true) {
			GameGui.changeOneLetter(index);
			this.updatePlayerLetters();
		}
		else { //word adding
			if ((G.getMode() == 'a') && (advancedLetterPlaced == true)) {
				updateStatusText("In advanced mode you may place only one letter. Press Done to continue");
				return;
			}
			addWordFlag = true;
			changeLetterBut.setEnabled(false);
			doneBut.setEnabled(true);
		}	
	}
	

	private void doneButWidgetSelected(SelectionEvent evt) {
		//current player is human
		if (GameGui.getG().getPlayerList().get(GameGui.getG().getTurnInd()).isAuto() == false) {
			//player pressed done before he pressed "change letters" or "add word"
			if ((changeLetterFlag == false) && (addWordFlag == false)){
				setPlayStatusText("Choose add word or change letter");
				return;
			}
			if (changeLetterFlag == true) {
				GameGui.moveToNextPlayer();
				setPlayStatusText("");
			}
			else if (addWordFlag == true) {
				if (GameGui.placeWordBasic() == false) { //word is not valid
					this.updateAfterUnSucInsert();
				}
				GameGui.moveToNextPlayer();
				GameGui.initUsedLetters();
//				setPlayStatusText("");
			}
		}
		//if the current player is automatic
		else {
			GameGui.placeAutoWord();
			GameGui.moveToNextPlayer();
			this.updateBoard();
		}
		
		currentTurnInsertedLetters.clear();
		
		//set the board accordingly if the current player is auto or human
		if (GameGui.getG().getPlayerList().get(GameGui.getG().getTurnInd()).isAuto() == true) {
			changeLetterBut.setEnabled(false);
//			setPlayStatusText("The current turn is an auto player turn, press Done for him to make his move");
			doneBut.setEnabled(true);
			this.enablePlayerLetters(false);
		}
		else {
			changeLetterBut.setEnabled(true);
			doneBut.setEnabled(false);
			this.enablePlayerLetters(true);
		}
		updatePlayerLetters();
		
		changeLetterFlag = false;
		addWordFlag      = false;
		
		//check if game finished
		if (GameGui.getG().getLettersSet().getLetterSetSize() == 0) {
			changeLetterBut.setEnabled(false);
			doneBut.setEnabled(false);
			this.makePlayerLettersUnVisible();
			setPlayStatusText("letters are finished, Game is finished");
			updateScoresText();
			return;
		}
		
		advancedLetterPlaced = false;

		updateNowPlayingText();
		updateLetterSetText();
		updateScoresText();
		
	}

	private void enablePlayerLetters(boolean b) {
		for (int i = 0; i < allPlayerLetters.length; i++) {
			allPlayerLetters[i].setEnabled(b);
		} 
	}

	private void makePlayerLettersUnVisible() {
		for (int i = 0; i < allPlayerLetters.length; i++) {
			allPlayerLetters[i].setVisible(false);
		} 
	}

	private void updateAfterUnSucInsert() {
		for (int i = 0; i < currentTurnInsertedLetters.size(); i++) {
			int x = currentTurnInsertedLetters.get(i).i;
			int y = currentTurnInsertedLetters.get(i).j;
			allCellsGrid[x][y].setBackground(allCellsColors[x][y]);
			allCellsGrid[x][y].setBackgroundImage(null);
		}
		
	}
	
	 public void loadImages(){
         cLabelBoard.setBackgroundImage(new Image(Display.getDefault(),resConfig.getImageStream("board.PNG")));
         letterStandLabel.setBackgroundImage(new Image(Display.getDefault(),resConfig.getImageStream("lettersStand.PNG")));
         letterSetImageLabel.setBackground(new Image(Display.getDefault(),resConfig.getImageStream("LetterSet.jpg")));
 }
}
