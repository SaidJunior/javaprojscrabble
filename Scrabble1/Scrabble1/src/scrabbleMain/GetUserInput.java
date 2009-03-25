package scrabbleMain;

import java.io.BufferedReader;
import java.io.IOException;

public class GetUserInput {
	public static char getUserCharInput(String message, BufferedReader consoleReader) {
		boolean validInput = false;
		char charInput = 0;
		
		System.out.println(message);
		do {
			try {
				String stringInput = null;
				stringInput = consoleReader.readLine();
				if (stringInput.length() != 1) {
					System.out.println("Input not valid, please enter again");
					continue;
				}
				charInput = stringInput.charAt(0);
				validInput = true;
				
			} catch (IOException e) {
				System.out.println("IO Error, please enter again");
			}
		} while (validInput == false);
		
		return charInput;
	}
	
	/* Returns only 'y' or 'n'.
	 * */
	public static char getYesOrNo(BufferedReader consoleReader)
	{
		String message = "Please type only y/n.";
		char answer;
		do {
			answer = GetUserInput.getUserCharInput(message, consoleReader);
	
		} while (!((answer == 'n') || (answer == 'y')));
		return answer;
	}
	
	public static int getUsetIntgerInput(int min, int max, String message, BufferedReader consoleReader) {
		boolean validInput = false;
		int inputInt    = 0;
		System.out.println(message);
		do {
			try {
				inputInt = Integer.parseInt(consoleReader.readLine());
				if ((inputInt >= min) && (inputInt <= max)) {
					break;
				}
				else {
					System.out.println("Number of row should be " + min + " to " + max + " please enter again");
				}
			} catch (IOException e) {
				System.out.println("IO Error, try again");
			} catch (NumberFormatException e) {
				System.out.println("Input is not a valid number, please enter again");
			}
		}  while (validInput == false);
		return inputInt;
	}
	
	public static String getGameName(BufferedReader consoleReader) {
		
		String gameName = null;
		boolean validInput = false;
		do {
			System.out.println("Please enter the name of the game: ");
			try {
				gameName = consoleReader.readLine();
				validInput = true;
			} catch (IOException e) {
				System.out.println("IO ERROR, try again");
			}
		} while (validInput == false);
		return gameName;
	}

}
