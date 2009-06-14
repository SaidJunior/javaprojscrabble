package com.rcp.scrabble;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.handlers.HandlerUtil;
import Gui.Images;

import resources.resConfig;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.
	private IWorkbenchAction exitAction;
	private Action newGame, multi;
	private Action open, save, exit;
	private Action home, space, beach, forest;
	private Action basic, adv;
	private Action help, about;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(final IWorkbenchWindow window) {
		// Creates the actions and registers them.
		// Registering is needed to ensure that key bindings work.
		// The corresponding commands keybindings are defined in the plugin.xml
		// file.
		// Registering also provides automatic disposal of the actions when
		// the window is closed.

		//exitAction = ActionFactory.QUIT.create(window);
		//register(exitAction);
		newGame = new Action(){
			public void run(){
				View.w.initNewGame();
			}
		};
		newGame.setText("New Game");
		open = new Action(){
			public void run(){
				View.w.openSelected();
			}
		};
		
		
		open.setText("Open");
		
		multi = new Action(){
			public void run(){
				View.w.initMultiGame();
			}
		};
		
		multi.setText("Multiplay");

		save = new Action(){
			public void run(){
				View.w.saveAction();
			}
		};
		save.setText("Save");
		exit = new Action(){
			public void run(){
				View.w.exitProcedure();
			}
		};
		exit.setText("Exit");
		home = new Action(){
			public void run(){
				View.w.setBackgroundImage(Images.getImage("wooden_table.jpg"));
			}
		};
		home.setText("Home Sweet Home");
		space = new Action(){
			public void run(){
				View.w.setBackgroundImage(Images.getImage("space.jpg"));
			}
		};
		space.setText("In Space");
		beach = new Action(){
			public void run(){
				View.w.setBackgroundImage(Images.getImage("beach.jpg"));

			}
		};
		beach.setText("On The Beach");
		newGame.setText("New Game");
		forest = new Action(){
			public void run(){
				View.w.setBackgroundImage(Images.getImage("forest.jpg"));

			}
		};
		forest.setText("In The Forest");
		basic = new Action(){
			public void run(){
				View.w.RecordListBasicSelected();
			}
		};
		basic.setText("Basic");
		adv = new Action(){
			public void run(){
				View.w.RecordListBasicSelected();
			}
		};
		adv.setText("Advanced");
		help = new Action(){
			public void run(){
				View.w.HelpSelected();
			}
		};
		help.setText("Help");
		about = new Action(){
			public void run(){
				View.w.AboutSelected();
			}
		};
		about.setText("About");
		
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager gameMenu = new MenuManager("&Game",
				null);
		menuBar.add(gameMenu);
		gameMenu.add(newGame);
		gameMenu.add(open);
		gameMenu.add(save);
		gameMenu.add(multi);
		gameMenu.add(exit);
		MenuManager viewMenu = new MenuManager("&View",
				null);
		menuBar.add(viewMenu);
		viewMenu.add(home);
		viewMenu.add(beach);
		viewMenu.add(space);
		viewMenu.add(forest);
		MenuManager recordMenu = new MenuManager("&Record List",
				null);
		menuBar.add(recordMenu);
		recordMenu.add(basic);
		recordMenu.add(adv);
		MenuManager helpMenu = new MenuManager("&Help",
				null);
		menuBar.add(helpMenu);
		helpMenu.add(help);
		helpMenu.add(about);
		
	}

}
