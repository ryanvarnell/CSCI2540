// Ryan Varnell

package activities;

import java.util.Scanner;

public class Lines {

    // A class to request and print a number of asterisks.
    public static void main(String[] args) {

        Scanner get = new Scanner(System.in);

        System.out.println("How many asterisks would you like?");
        int numOfAst = get.nextInt();

        printLine(numOfAst);
    }

    // printLine takes the number requested by the user and prints that number of asterisks,
    // then goes to a new line.
    public static void printLine(int numOfAst)  {

        for (int i = 0; i < numOfAst; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
