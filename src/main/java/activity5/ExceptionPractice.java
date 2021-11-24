package activity5;

import java.util.Scanner;

/**
 * A class to practice throwing and catching exceptions. Gets a user's number and calculates the square root.
 * @author Ryan Varnell
 */
public class ExceptionPractice {
    public static void main(String[] args) throws NegativeNumberException {
        int userNum = getNum();
        System.out.println("The square root of " + userNum + " is " + Math.sqrt(userNum));
    }

    /**
     * Gets the user's number and throws an exception if the number is negative.
     * @return The user's number
     * @throws NegativeNumberException If the user's number is less than zero.
     */
    public static int getNum() throws NegativeNumberException {
        // Creates a scanner and gets the user's number.
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int userNum = kbd.nextInt();

        // Throws an exception if the input is negative.
        if (userNum < 0) {
            throw new NegativeNumberException("Number cannot be negative.");
        }
        return userNum;
    }
}
