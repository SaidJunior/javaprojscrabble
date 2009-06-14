package com.rcp.scrabble;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import Gui.Images;
import resources.resConfig;


import scrabbleMain.gameDirectories;

public class View extends ViewPart {
	public static final String ID = "com.rcp.Scrabble.view";

	public static Gui.MainWindow_ver2 w;
	public View(){
		gameDirectories.initGame();

	}
	/**
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */


	

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	
	
	
	public void createPartControl(Composite parent) {
		Gui.MainWindow_ver2.showMenu = false;
		Gui.MainWindow_ver2.shell = parent.getShell();
		Gui.MainWindow_ver2.display = parent.getDisplay();
		w = new Gui.MainWindow_ver2(parent, SWT.NONE);
		w.setBackgroundImage(Images.getImage("wooden_table.jpg"));


	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}