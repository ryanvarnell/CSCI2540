package assg6_varnellr18;

import java.util.ArrayList;

/**
 * Student roster interface.
 * @author Ryan Varnell
 */
public interface RosterInterface {
    /**
     * Loads the data containing all the students from a given file.
     * @param fileName The name of the file to be loaded from.
     */
    void loadData(String fileName);

    /**
     * Displays the complete information of all the students on the roster.
     */
    void displayRoster();

    /**
     * Looks for a student in a roster.
     * @param id The student's ID
     * @return The Student object if found, Null if not.
     */
    Student searchForStudent(String id);

    /**
     * Adds a new student.
     * @param id ID of the student to be added
     * @param name Name of the student
     * @param standing Standing of the student (Freshman, Sophomore, Junior, Senior, etc.)
     * @param major Student's Major
     * @return True if the student is successfully added, false if not.
     */
    boolean addStudent(String id, String name, String standing, String major);

    /**
     * Removes a student.
     * @param id ID of the student to be removed.
     * @return True if successfully removed, false if not.
     */
    boolean removeStudent(String id);

    /**
     * Return an ArrayList with all students of a given major.
     * @param major The major with which the list of students is to be compiled with.
     * @return Arraylist with the students of a given major.
     */
    ArrayList<Student> getStudentsByMajor(String major);

    /**
     * Sorts all students by ID.
     */
    void sort();
}
