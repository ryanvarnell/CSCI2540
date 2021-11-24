// Ryan Varnell

package activities;

import java.util.*;

// Removes the first and last character for a user-provided string
public class RemoveFirstAndLast {

  public static void main(String[] args) {
    Scanner scannerObject = new Scanner(System.in);

    // Prompts the user for a sentence
    System.out.println(
      "Type a sentence and I'll do my best to remove the first and last character:"
    );
    String input = scannerObject.nextLine();

    // Creates a string using a substring of the user's input, dropping the first and last character
    String shorterString = input.substring(1, input.length() - 1);

    System.out.println(shorterString);
  }
}
