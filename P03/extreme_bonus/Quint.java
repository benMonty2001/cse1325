import java.io.FileNotFoundException;

import java.util.Scanner;

class Quint {
	public static void main(String[] args) { 
		Puzzle puzzle = new Puzzle("ERROR");

		try{
			puzzle = new Puzzle(WordList.getWord());
		} catch(FileNotFoundException e) {
			System.err.println("unable to load words from wordlist.txt");
		}

		System.out.println("=========\n"
		                 + "Q U I N T\n"
		                 + "=========\n");
		System.out.print("Guess a 5-letter word\n" + 
					     "guess ");

		int counter = 0;
		while(true){
			Scanner in = new Scanner(System.in);
			
			String guess = in.nextLine();
			
			try{
				System.out.print(puzzle.compareGuess(guess) + " ");
			} catch(IllegalArgumentException e){
				System.out.print("      Invalid guess: Not 5 letters!\n      ");
				continue;
			} catch(IndexOutOfBoundsException e){
				System.out.print("      Index out of bounds!\n      ");
				continue;
			}

			counter++;
	
			if(puzzle.isSolved()){
				System.out.printf("Guessed in %d tries\n", counter);
				break;
			}
		}
	}
}