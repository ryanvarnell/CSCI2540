package assg6_varnellr18;

import java.util.Objects;

/**
 * Class to contain a student.
 * @author Ryan Varnell
 */
public class Student implements Comparable<Student>{
    private final String id, name, standing;
    private String major;

    /**
     * Constructor for Student object
     * @param id Student's ID
     * @param name Student's Name
     * @param standing Student's standing i.e. Freshman, Sophomore, etc.
     * @param major Student's Major
     */
    public Student(String id, String name, String standing, String major) {
        this.id = id;
        this.name = name;
        this.standing = standing;
        this.major = major;
    }

    /**
     * Getter for ID
     * @return Student's ID
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for Name
     * @return Student's Name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for Standing
     * @return Student's Standing
     */
    public String getStanding() {
        return standing;
    }

    /**
     * Getter for Major
     * @return Student's Major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Setter for Major
     * @param major Major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Overridden toString method.
     * @return Student's info in id,name,standing,major format.
     */
    @Override
    public String toString() {
        return this.id + "," + this.name + "," + this.standing + "," + this.major;
    }

    /**
     * Overridden equals method
     * @param obj Object to compare this Student to
     * @return True if the same object, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Student && Objects.equals(this.id, ((Student) obj).id);
    }

    /**
     * Compares two Student's IDs
     * @param s2 The Student to compare this Student's ID to
     * @return -1 if lower, 0 if the same, 1 if larger.
     */
    @Override
    public int compareTo(Student s2) {
        return Integer.compare(Integer.parseInt(this.id), Integer.parseInt(s2.id));
    }
}
