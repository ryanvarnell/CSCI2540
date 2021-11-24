package activity5;

import java.io.*;
import java.util.Scanner;

/**
 * A class to read from a file and print the contents to another file, including line numbers
 * @author Ryan Varnell
 */
public class FileInputOutputPractice {
    public static void main(String[] args) throws IOException {
        // Create a new Scanner with the input file
        Scanner input = new Scanner(new FileReader("input.txt"));

        // Create a new FileWriter with the output file.
        FileWriter output = new FileWriter("output.txt");

        // Prints line number + lines in input to output
        int lineNum = 0;
        while (input.hasNextLine()) {
            lineNum++;
            output.write(lineNum + ": " + input.nextLine());
        }
    }
}
