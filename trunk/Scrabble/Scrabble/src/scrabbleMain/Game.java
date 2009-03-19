package scrabbleMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Game {

	private final static int rows      = 15;
	private final static int columns  = 15;
	private static int numberOfPlayers;
	private static List<Player>   playerList    = new ArrayList<Player>();
	private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	private static LettersSet     lettersSet    = new LettersSet();
	private static Dictionary     dictionary    = new Dictionary(rows, columns);
	private static Board          board         = new Board(rows, columns, dictionary.getRandomWord());
	private static final int maxNameLength = 50;
	
	
	public static void main(String[] args) {
		boolean exit = false;
		getNumberOfPlayers();
		
		createPlayersList();
		
		while ((lettersSet.getLetterSetSize() > 0) && (exit == false)) {
			for(int i = 0; i < numberOfPlayers; i++) {
				int currentMove = 0;
				boolean validInput = false;
				
				System.out.println("Now playing: " + playerList.get(i).getName() + "your score is: " + playerList.get(i).getScore());
				System.out.println("\n\n");
				board.printBoard();
				System.out.print("\n\n Your letters are: ");
				System.out.println();
				playerList.get(i).printPlayerLetters();
				do {
					System.out.println("\n\n");
					System.out.println("choose your next move: t for throwing letters, w for adding a word to board, q for exit");
					try {
						String input = null;
						input = consoleReader.readLine();
						if (input.length() != 1) {
							System.out.println("Input not valid");
							continue;
						}
						currentMove = input.charAt(0);
						
					} catch (IOException e) {
						System.out.println("Input is not valid");
					}
					
					switch (currentMove) {
					case 't': throwLetter(playerList.get(i)); 
							  validInput = true; 
							  break;
					case 'w': placeWord(playerList.get(i)); 
					          validInput = true; 
					          break;
					case 'q': exit = true; 
					          validInput = true; 
					          break;
					default: System.out.println("input is not valid, please etry again");
					}
				} while (validInput == false);
				
				if (exit == true) {
					break;
				}
			}
		}
		printExitScreen();
		
	}
	
	

	private static void placeWord(Player player) {
		int row;
		int column;
		int letterIndex;
		int startRow;
		int startCol;
		int endRow;
		int endCol;
		String userWord;
		
		row    = getUsetIntgerInput(0, rows, "enter row number");
		column = getUsetIntgerInput(0, columns, "enter column number");
		letterIndex = getUsetIntgerInput(0, player.getNumberOfLetters(), "enter the index of the wanted letter");
		
		if ((board.hasNeigbours(row, column) == false) || (board.isCellFree(row, column) == false)) {
			System.out.println("The placed letter doesn't have any neigbours, you lost your turn");
			return;
		}
		
		startRow = getUsetIntgerInput(0, rows, "enter word's start row");
		startCol = getUsetIntgerInput(0, columns, "enter word's start column");
		endRow   = getUsetIntgerInput(0, rows, "enter word's end row");
		endCol   = getUsetIntgerInput(0, columns, "enter word's end column");
		
		board.insertLetter(row, column, player.getLetter(letterIndex));
		//board.printBoard();
		userWord = board.getWord(startRow, startCol, endRow, endCol);
		if (userWord == null) {
			System.out.println("given indeces are not valid, you lost your turn");
			board.removeLetter(row, column);
		}
		if(dictionary.contains(userWord)) {
			player.removeLetter(letterIndex);
			player.insertLetter(lettersSet.getLetter());
			player.setScore(userWord.length());
		}
		else {
			board.removeLetter(row, column);
			System.out.println("Word: "+ userWord + " does not exist in the dictionary");
		}
	}



	private static int getUsetIntgerInput(int min, int max, String message) {
		boolean validInput = false;
		int inputInt    = 0;
		System.out.println(message);
		do {
			try {
				inputInt = Integer.parseInt(consoleReader.readLine());
				if ((inputInt >= min) && (inputInt < max)) {
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


	private static void throwLetter(Player player) {
		int wantedLetter = 0;
		boolean validInput = false;
	
		do {
			String input = null;
			System.out.println("Enter the number of letter you what to change(0 to " + player.getNumberOfLetters() + ")");
			try {
				input = consoleReader.readLine();
				wantedLetter = Integer.parseInt(input);
				validInput = true;
			} catch (IOException e) {
				System.out.println("IO error, try again");
			} catch (NumberFormatException e) {
				System.out.println("Input is not a valid number, please enter again");
			}
		} while (validInput == false);
		
		player.removeLetter(wantedLetter);
		player.insertLetter(lettersSet.getLetter());
	}



	private static void createPlayersList() {
		for (int i = 1; i < numberOfPlayers + 1; i++) {
			String playerName = null;
			
			try {
				do {
					System.out.print("Enter NameOf Player(Length less than 50) " + i + ":");
					playerName = consoleReader.readLine();
				} while (playerName.length() > maxNameLength);
				
				Player newPlayer = new Player(playerName);
				
				for (int j = 0; j < 7; j++) {
					newPlayer.insertLetter(lettersSet.getLetter());
				}
				playerList.add(newPlayer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
	}

	private static void getNumberOfPlayers() {
		boolean loopParam = true;
		
		System.out.println("WELLCOM TO SCRABBLE!!!!!");
		System.out.println("\n\n Enter Number Of Players(1 - 4)");
		
		while (loopParam){
			try {
				numberOfPlayers = Integer.parseInt(consoleReader.readLine());
				if ((numberOfPlayers >=1) && (numberOfPlayers <= 4)) {
					break;
				}
				else {
					System.out.println("Number of players should be 1 to 4, please enter again");
				}
			} catch (IOException e) {
				System.out.println("IO Error, try again");
			} catch (NumberFormatException e) {
				System.out.println("Input is not a valid number, please enter again");
			}
		}
	}
	
	private static void printExitScreen() {
		int maxScore = -1;
		int maxScorePlayer = 0;
		for (int i = 0; i < numberOfPlayers; i++) {
			if (maxScore < playerList.get(i).getScore()) {
				maxScore = playerList.get(i).getScore();
				maxScorePlayer = i;
			}
			System.out.println("player: " + playerList.get(i).getName() + " scored: " + playerList.get(i).getScore());
		}
		System.out.println("The winner is: " + playerList.get(maxScorePlayer).getName());
		System.out.println("Thank you for playing Scrabble!!");
	}

}
