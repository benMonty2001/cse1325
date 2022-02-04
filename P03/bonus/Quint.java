import java.util.Scanner;

class Quint {
	public static void main(String[] args) { 
		Puzzle puzzle = new Puzzle(WordList.getWord());

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
			}

			counter++;
	
			if(puzzle.isSolved()){
				System.out.printf("Guessed in %d tries\n", counter);
				break;
			}
		}
	}
}