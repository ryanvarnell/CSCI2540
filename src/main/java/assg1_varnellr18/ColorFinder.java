// Ryan Varnell

package assg1_varnellr18;

import java.util.*;

// This class takes input from a user and outputs whether it finds a specific color and what kind it is
public class ColorFinder {

    public static void main(String[] args) {
        // Takes the user's sentence
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("This program will detect any primary colors within a sentence. Just need a sentence: ");
        String input = scannerObject.nextLine();

        // Tests for an additive primary color or subtractive primary color, with precedence given to additive
        if (
            input.toLowerCase().contains("RED".toLowerCase()) ||
            input.toLowerCase().contains("BLUE".toLowerCase()) ||
            input.toLowerCase().contains("GREEN".toLowerCase())
        ) {
            System.out.println("Additive primary color found.");
        } else if (
            input.toLowerCase().contains("MAGENTA".toLowerCase()) ||
            input.toLowerCase().contains("YELLOW".toLowerCase()) ||
            input.toLowerCase().contains("CYAN".toLowerCase())
        ) {
            System.out.println("Subtractive primary color found.");
        } else {
            System.out.println("No primary colors found.");
        }
    }
}
