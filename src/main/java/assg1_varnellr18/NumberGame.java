// Ryan Varnell

package assg1_varnellr18;

import java.util.Random;
import java.util.Scanner;

// Game where a random number is selected and the user tries to guess what number it is
public class NumberGame {

    public static void main(String[] args) {
        int secret;
        int guesses = 0;
        boolean correct = false;
        Scanner get = new Scanner(System.in);

        // Generates the secret number
        Random generator = new Random();
        secret = generator.nextInt(100);

        System.out.println("I'm thinking of a number between 0 and 99...\nWhat is it? ");

        // Loops until the user guesses the correct number. Increment guesses with each guess.
        while (!correct) {
            int guess = get.nextInt();
            if (guess < secret) {
                guesses++;
                System.out.println("Too low! Try again!");
            } else if (guess > secret) {
                guesses++;
                System.out.println("Too high! Try again!");
            } else {
                guesses++;
                if (guesses < 10) {
                    System.out.println(
                            "You got it! It only took you " + guesses + " guesses!"
                    );
                } else {
                    System.out.println(
                            "Wow, I can't believe it took you " + guesses + " guesses..."
                    );
                }
                correct = true;
            }
        }
    }
}
