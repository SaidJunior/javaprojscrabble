package com.plugin.scrabbleswt.views;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import resources.resConfig;



/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class ScrabbleSwt extends ViewPart {

	private Action action1;
	private Action doubleClickAction;
	Gui.MainWindow_ver2 w;

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	

	/**
	 * The constructor.
	 */
	public ScrabbleSwt() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		
		Gui.MainWindow_ver2.showMenu = false;
		
		ScrolledComposite sc = new ScrolledComposite(parent, SWT.H_SCROLL |   
				  SWT.V_SCROLL | SWT.BORDER);
		w = new Gui.MainWindow_ver2(sc, SWT.NONE);
		//w.setLayout(new FillLayout());
		sc.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		sc.setContent(w);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setMinSize(w.computeSize(1000, 1000));
		w.setBackgroundImage(new Image(parent.getDisplay(), resConfig.getImageStream("wooden_table.jpg")));
		makeActions();
		
		contributeToActionBars();
	}

	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);

	}

	
	

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				//showMessage("Action 1 executed");
				w.initNewGame();
			}
		};
		action1.setText("New Game");
		action1.setToolTipText("New Game");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		
		
	}

	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}