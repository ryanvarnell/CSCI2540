package assg6_varnellr18;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Application for keeping track of and providing info on Students in a roster.
 * @author Ryan Varnell
 */
public class RosterApplication {
    static Roster roster = new Roster();
    static Roster tempRoster = new Roster();

    public static void main(String[] args) {
        String fileName = "assg6_roster.txt";
        roster.loadData(fileName);

        // Load the file into tempRoster to compare for changes later
        tempRoster.loadData(fileName);

        Scanner kbd = new Scanner(System.in);
        int choice = 0;
        boolean loop = true;

        // Menu options loop until the user decides to exit.
        while (loop) {
            displayMenu();
            choice = getChoice(kbd);
            switch (choice) {
                // Display roster
                case 1 -> roster.displayRoster();

                // Search for a student by ID.
                case 2 -> {
                    System.out.print("Enter the student's ID: ");
                    Student student = roster.searchForStudent(kbd.nextLine());

                    // If the student is found, prints the info to the screen.
                    if (student == null)
                        System.out.println("No such student.");
                    else
                        System.out.println(student);
                }

                // Add a new student.
                case 3 -> {
                    System.out.print("ID: ");
                    String id = kbd.nextLine();

                    System.out.print("Name: ");
                    String name = kbd.nextLine();

                    System.out.print("Standing: ");
                    String standing = kbd.nextLine();

                    System.out.print("Major: ");
                    String major = kbd.nextLine();

                    roster.addStudent(id, name, standing, major);
                }

                // Remove a student.
                case 4 -> {
                    System.out.print("ID of student to be removed: ");
                    String id = kbd.nextLine();
                    roster.removeStudent(id);
                }

                // Search for students by major.
                case 5 -> {
                    System.out.print("Major: ");
                    String major = kbd.nextLine();
                    ArrayList<Student> studentsByMajor = roster.getStudentsByMajor(major);
                    for (Student s : studentsByMajor) {
                        System.out.print(s);
                    }
                }

                // Sort and save to file.
                case 6 -> {
                    roster.sort();
                    saveFile(fileName);
                }

                // Save to file.
                case 7 -> {
                    saveFile(fileName);
                }

                // Exit.
                case 8 -> {
                    loop = false;
                    saveFile(fileName);
                }

                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
            System.out.println();
        }
    }

    /**
     * Displays the menu
     */
    public static void displayMenu() {
        System.out.println("""
                1. Display the roster
                2. Search for a student by ID
                3. Add a new student
                4. Remove a student
                5. Search for students by major
                6. Sort and save to file
                7. Save to file
                8. Exit""");
    }

    /**
     * Gets the user's menu choice.
     * @param kbd Scanner from the main method to get user's input
     * @return The user's choice
     */
    public static int getChoice(Scanner kbd) {
        int choice = 0;

        // Loops while the user's input isn't between 1 and 8 inclusive.
        while (!(choice >= 1 && choice <= 8)) {

            // If the user's input isn't able to be parsed by the Integer class, it's considered invalid
            try {
                choice = Integer.parseInt(kbd.nextLine());
                if (choice < 1 || choice > 8) {
                    System.out.println("Invalid menu entry. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Unable to parse input. Try again.");
            }
        }
        return choice;
    }

    /**
     * Method to save contents of roster to file.
     * @param fileName The name of the file to be saved to.
     */
    public static void saveFile(String fileName) {
        try {
            // Overwrites the file with the current contents of the roster.
            FileWriter out = new FileWriter(fileName, false);

            // New line for every student in the roster.
            for (Student s : roster.roster) {
                out.write(s.toString() + "\n");
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
