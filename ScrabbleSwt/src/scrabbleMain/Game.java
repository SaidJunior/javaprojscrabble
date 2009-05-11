package scrabbleMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Gui.MainWindow;

public class Game{
	public static void main(String[] args) { 
		
		gameDirectories.initDirectories();
		
		char input = 0;
		boolean validInput = false;
		BufferedReader reader   = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("WELLCOME TO SCRABBLE!!!!");
		do {
			input = GetUserInput.getUserCharInput("Press 'c' for console application, 'g' for gui application or 'q' to quit.", reader);
			switch(input) {
			case 'c':	GameConsole.consoleMain();
				        validInput = true;
				        break;
			case 'g':   MainWindow.startGuiGame();
						validInput = true;
						break;
			case 'q':   System.out.println("Thank  you!!!");
						validInput = true;
						break;
			default:    System.out.println("Not a valit input, try again.");
				
			}
		} while (validInput == false);
	}
}
