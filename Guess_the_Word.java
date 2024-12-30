package game;

import java.util.Scanner;

public class Guess_the_Word {

	private boolean play = true;
	private Words randomWord = new Words();
	private Scanner sc = new Scanner(System.in);
	private int rounds = 10;
	private char lastRound;

	public void start() {
		do {
			showWord();
			getInput();
			checkInput();

		} while (play);
	}

	void showWord() {

		System.out.println("You have " + rounds + " tries left.");
		System.out.println(randomWord);
	}

	void getInput() {

		System.out.println("Enter a letter to guess the word");
		String userGuess = sc.nextLine();
		lastRound = userGuess.charAt(0);
	}

	void checkInput() {

		boolean isGuessedRight = randomWord.guess(lastRound);

		if (isGuessedRight) {

			if (randomWord.isGuessedRight()) {
				System.out.println("Congrats, you won!");
				System.out.println("The word is: " + randomWord);
				play = false;
			}
		} else {
			rounds--;

			if (rounds == 0) {
				System.out.println("Game over!");
				play = false;
			}
		}
	}

	public void end() {
		sc.close();
	}

}
