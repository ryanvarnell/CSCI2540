package activity9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Class for testing if a user's input is a palindrome.
 * @author Ryan Varnell
 */
public class IsPalindrome {
    public static void main(String[] args) {
        Scanner kbd = new Scanner (System.in);
        String userInput = kbd.nextLine();
        System.out.println(isPalindromeUsingStack(userInput));
        System.out.println(isPalindromeRecursion(userInput));
        System.out.println(isPalindromeUsingStackQueue(userInput));
    }

    /**
     * Testing the user's input to see if it's a palindrome using a stack.
     * @param input The user's string
     * @return True if the user's input is a palindrome, False if not.
     */
    public static boolean isPalindromeUsingStack(String input) {
        Stack<Character> stack = new Stack<>();

        // Pushes each character of the user's string into a stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Compares the top of the stack to the bottom of the string and pops if equal, then moves onto top of the
        // stack and next-to-bottom of the string and so on.
        // Returns false if there's any mismatch.
        for (int i = 0; i < input.length(); i++) {
            if (stack.peek() == input.charAt(i))
                stack.pop();
            else
                return false;
        }

        // Returns true if everything runs fine.
        return true;
    }

    /**
     * Method to test if the user's string is a palindrome using recursion
     * @param input The user's string
     * @return True if the user's string is a palindrome, false if not.
     */
    public static boolean isPalindromeRecursion(String input) {
        // Base case: If the input string is less than 2 characters, it returns true.
        if (input.length() < 2)
            return true;

        // If the first and last character match, then it calls itself again with a new string consisting of the
        // previous string with the first and last characters removed
        if (input.charAt(0) == input.charAt(input.length() - 1))
            return isPalindromeRecursion(input.substring(1, input.length() - 1));

        // Returns false if there is a mismatch above.
        return false;
    }

    public static boolean isPalindromeUsingStackQueue(String input) {
        Stack<Character> s = new Stack<>();
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            s.push(input.charAt(i));
            q.add(input.charAt(i));
        }

        while (!s.isEmpty()) {
            if (s.peek() == q.peek()) {
                s.pop();
                q.poll();
            } else {
                return false;
            }
        }

        return true;
    }

}
