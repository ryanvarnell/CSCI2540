package assg7_varnellr18;

import java.util.Stack;

/**
 * A class to take an infix expression and convert it to a postfix expression. Also offers the ability to evaluate the
 * postfix expression.
 * @author Ryan Varnell
 */
public class Calculator {
    String infix;
    StringBuilder postfix = new StringBuilder();

    // "converted" stores whether the expression was successfully converted to postfix.
    boolean converted;

    /**
     * Constructor for the calculator including a user's infix expression.
     *
     * @param exp user's infix expression.
     */
    public Calculator(String exp) {
        infix = exp;
        converted = convertPostfix();
    }

    /**
     * Returns the user's infix expression as a string.
     *
     * @return Infix expression as a string.
     */
    @Override
    public String toString() {
        return infix;
    }

    /**
     * Converts the user's infix expression to postfix.
     * Used the textbook pseudocode, so it's basically structurally identical.
     * @return True if successful.
     */
    private boolean convertPostfix() {
        Stack<Character> stack = new Stack<>();

        // Iterates through each character in the infix expression.
        for (char ch : infix.toCharArray()){

            // Append operand to the end of postfix.
            if (isOperand(ch)) {
                postfix.append(ch);
            }

            // Place '(' on stack.
            else if (ch == '(') {
                stack.push(ch);
            }

            // Pop stack until matching '('.
            else if (ch == ')') {
                postfix.append(" ");    // Makes sure separate entities stay separate in the postfix expression.
                while (stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();    // Remove open parenthesis.
            }

            // Process stack operators of greater precedence.
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && stack.peek() != '(' && precedence(ch) <= precedence(stack.peek())) {
                        postfix.append(" ");
                        postfix.append(stack.pop());
                }

                stack.push(ch); // Save new operator.
                postfix.append(" ");    // Separates individual items in postfix expression.
            }

            // Ignore spaces.
            else if (ch == ' ') {
                assert true;
            }

            // Return false if a character doesn't quite fit the requirements.
            else {
                return false;
            }
        }

        // Append to postfix the operators remaining in the stack
        while (!stack.isEmpty()) {
            postfix.append(" ");
            postfix.append(stack.pop());
        }

        return true;
    }

    /**
     * Returns the postfix expression as a string.
     * @return Postfix expression as a String.
     * @throws IllegalStateException If there is no postfix expression to return.
     */
    public String getPostfix() throws IllegalStateException {
        if (!converted)
            throw new IllegalStateException();
        return postfix.toString();
    }

    /**
     * Evaluates the postfix expression.
     * @return The result of the postfix expression.
     * @throws IllegalStateException If there is no postfix expression to evaluate.
     */
    public double evaluate() throws IllegalStateException {
        if (!converted)
            throw new IllegalStateException();

        Stack<Double> doubleStack = new Stack<>();

        // Iterate through each object in the postfix expression.
        String[] tokens = postfix.toString().split(" ");
        for (String s : tokens) {

            // If the object is an operator, perform the desired mathematical function on the top two items in the
            // stack and push the result back onto the stack.
            // Else, just push the number onto the stack.
            if (isOperator(s)) {
                double op1 = doubleStack.pop();
                double op2 = doubleStack.pop();

                switch (s) {
                    case "+" -> doubleStack.push(op2 + op1);
                    case "-" -> doubleStack.push(op2 - op1);
                    case "*" -> doubleStack.push(op2 * op1);
                    case "/" -> doubleStack.push(op2 / op1);
                }
            } else {
                doubleStack.push(Double.parseDouble(s));
            }
        }

        // The remaining number on the stack should be the evaluated expression, so this returns the result.
        return doubleStack.pop();
    }

    /**
     * Determines the mathematical precedence of an operator.
     * @param ch Operator.
     * @return Precedence as 0, 1, or 2.
     */
    private static int precedence(char ch) {
        // Addition and subtraction are of precedence 1.
        if (ch == '+' || ch == '-')
            return 1;

        // Multiplication and division are of precedence 2
        else if (ch == '*' || ch == '/')
            return 2;

        return 0;
    }

    /**
     * Just determines if the provided character is a number or not.
     * @param ch The character to be inspected.
     * @return True if the character is a number, false if not.
     */
    private static boolean isOperand(char ch) {
        return Character.isDigit(ch);
    }

    /**
     * Just determines if the provided character is a supported operator or not.
     * @param ch The character to be inspected.
     * @return True if the character is an operator, false if not.
     */
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * Determines if the provided String is a supported operator or not.
     * Overloaded version of isOperator that uses a String instead of a character.
     * @param s The string to be inspected.
     * @return True if the String is an operator, false if not.
     */
    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
