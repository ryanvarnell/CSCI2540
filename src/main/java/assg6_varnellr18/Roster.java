package assg6_varnellr18;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Class for a roster of students.
 * @author Ryan Varnell
 */
public class Roster implements RosterInterface{
    ArrayList<Student> roster = new ArrayList<>();

    /**
     * Loads the data containing all the students from a given file.
     *
     * @param fileName The name of the file to be loaded from.
     */
    @Override
    public void loadData(String fileName) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        String[] lineSplit;
        while (inputStream.hasNextLine()) {
            lineSplit = inputStream.nextLine().split(",");
            roster.add(new Student(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3]));
        }
    }

    /**
     * Displays the complete information of all the students on the roster.
     */
    @Override
    public void displayRoster() {
        for (Student student : roster) {
            System.out.println(student);
        }
    }

    /**
     * Looks for a student in a roster.
     *
     * @param id The student's ID
     * @return The Student object if found, Null if not
     */
    @Override
    public Student searchForStudent(String id) {
        Iterator<Student> studentIterator = roster.iterator();
        for (Student s : roster) {
            if (s.getId().equals(id))
                return s;
        }
        return null;
    }

    /**
     * Adds a new student.
     *
     * @param id       ID of the student to be added
     * @param name     Name of the student
     * @param standing Standing of the student (Freshman, Sophomore, Junior, Senior, etc.)
     * @param major    Student's Major
     * @return True if the student is successfully added, false if not.
     */
    @Override
    public boolean addStudent(String id, String name, String standing, String major) {
        if (searchForStudent(id) != null) {
            System.out.println("Student ID already exists.");
            return false;
        }
        roster.add(new Student(id, name, standing, major));
        return true;
    }

    /**
     * Removes a student.
     *
     * @param id ID of the student to be removed.
     * @return True if successfully removed, false if not.
     */
    @Override
    public boolean removeStudent(String id) {
        if (searchForStudent(id) != null) {
            roster.remove(searchForStudent(id));
            return true;
        }
        System.out.println("No such student found.");
        return false;
    }

    /**
     * Return an ArrayList with all students of a given major.
     *
     * @param major The major with which the list of students is to be compiled with.
     * @return Arraylist with the students of a given major.
     */
    @Override
    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> arrayList = new ArrayList<>();
        for (Student s : roster) {
            if (s.getMajor().equalsIgnoreCase(major))
                arrayList.add(s);
        }
        return arrayList;
    }

    /**
     * Sorts all students by ID.
     */
    @Override
    public void sort() {
        roster.sort(Comparator.comparing(Student::getId));
    }
}
