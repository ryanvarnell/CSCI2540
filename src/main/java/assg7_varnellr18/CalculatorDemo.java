package assg7_varnellr18;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Demo program for the Calculator class
 * @author Ryan Varnell
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.println("""
                Enter an infix expression. I will provide and calculate the postfix expression.
                Enter "quit" to exit.
                """);

        // Main loop
        boolean loop = true;
        while (loop) {
            String input = kbd.nextLine();

            if (input.equalsIgnoreCase("quit"))
                loop = false;
            else {
                Calculator calc = new Calculator(input);
                DecimalFormat format = new DecimalFormat("0.####");  // Drops trailing zeros for whole numbers.

                try {
                    System.out.println("Expression in postfix format: " + calc.getPostfix() +
                            "\nResult of the postfix expression: " + format.format(calc.evaluate()));
                } catch (IllegalStateException e) {
                    System.out.println("Expression invalid!");
                }

                System.out.println("\nEnter another expression, or \"quit\" to exit:\n");
            }
        }
    }
}