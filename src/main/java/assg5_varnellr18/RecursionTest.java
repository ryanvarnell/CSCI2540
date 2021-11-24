package assg5_varnellr18;

import java.util.Scanner;

/**
 * Class containing a couple of methods for testing recursion.
 * First method deletes the first instance of a character, second method deletes all occurrences of a character.
 * @author Ryan Varnell
 */
public class RecursionTest {
    private static final Scanner kbd = new Scanner(System.in);
    private static String userString;
    private static char userChar;

    /**
     * Lets the user choose which test to perform and processes accordingly
     */
    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.println("""
                    1. Test deleteFirst method
                    2. Test deleteAll method
                    3. Exit""");
            char choice = kbd.nextLine().charAt(0);
            switch (choice) {
                case '1' -> {
                    System.out.println();
                    getInfo();
                    System.out.println(deleteFirst(userString, userChar) + "\n");
                }
                case '2' -> {
                    System.out.println();
                    getInfo();
                    System.out.println(deleteAll(userString, userChar) + "\n");
                }
                case '3' -> {
                    System.out.println("Exiting");
                    loop = false;
                }
                default -> System.out.println("Something went wrong");
            }
        }

        kbd.close();
    }

    /**
     * Deletes the first occurrence of a given character in a given string.
     * @param str The string to be searched and deleted from.
     * @param ch The character to delete.
     * @return The string with the first instance of the character removed.
     */
    public static String deleteFirst(String str, char ch) {
        // Just returns the string if there's nothing in it.
        if (str.length() == 0) return str;
        else {
            // If the character at index 0 matches the given character, it returns the rest of the string minus that
            // character.
            if (str.charAt(0) == ch)
                return str.substring(1);
            // Otherwise, it returns the character at index 0 along with the result of calling itself again with the
            // string minus the index 0 character.
            else
                return str.charAt(0) + deleteFirst(str.substring(1), ch);
        }
    }

    /**
     * Deletes every occurrence of a given character in a given string
     * Essentially works the same way as deleteFirst, but instead of returning what remains of the string after the
     * character is found, it keeps iterating through.
     * @param str The string to be searched and deleted from.
     * @param ch The character to delete.
     * @return The string with all instances of the character removed.
     */
    public static String deleteAll(String str, char ch) {
        // Just returns the string if there's nothing in it.
        if (str.length() == 0) return str;
        else {
            // If the character at index 0 matches the given character, it returns the result of itself minus that
            // character.
            if (str.charAt(0) == ch)
                return deleteAll(str.substring(1), ch);
            // Otherwise, it returns said character and continues to iterate through the string.
            else
                return str.charAt(0) + deleteAll(str.substring(1), ch);
        }
    }

    /**
     * Method to get a sentence and character from the user.
     */
    public static void getInfo() {
        System.out.println("Enter an string: ");
        userString = kbd.nextLine();
        System.out.println("Enter a character: ");
        userChar = kbd.nextLine().charAt(0);
    }
}
