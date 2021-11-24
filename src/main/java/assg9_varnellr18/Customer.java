package assg9_varnellr18;

/**
 * Class to represent a Customer
 * @author Ryan Varnell
 */
public class Customer extends KeyedItem<String> {
    private String name, phoneNumber;

    /**
     * Three-parameter constructor.
     * @param key searchKey from KeyedItem
     * @param name Customer's name
     * @param phoneNumber Customer's Phone Number
     */
    public Customer(String key, String name, String phoneNumber) {
        super(key);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Setter for name.
     * @param name Customer's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for name.
     * @return Customer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for phoneNumber.
     * @param phoneNumber Customer's phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for phoneNumber.
     * @return Customer's Phone Number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Prints the Customer's information in ID, Name, PhoneNumber format.
     * @return
     */
    @Override
    public String toString() {
        return getKey() + "\t" + getName() + "\t" + getPhoneNumber();
    }
}
