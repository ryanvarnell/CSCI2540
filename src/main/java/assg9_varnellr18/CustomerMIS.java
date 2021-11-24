package assg9_varnellr18;

import java.util.Scanner;

/**
 * Basic Customer Management Information System
 * @author Ryan Varnell
 */
public class CustomerMIS {
    private static final Scanner KBD = new Scanner(System.in);
    private static final String FILE_NAME = "assg9_CustomerRoster.txt";
    private static final String MENU = """
                1.) Display the customer roster in sorted order.
                2.) Add a customer.
                3.) Delete a customer.
                4.) Search a customer by ID.
                5.) Update the information of a customer.
                6.) Save and exit.""";

    public static void main(String[] args) {
        CustomerRoster cr = new CustomerRoster(FILE_NAME);

        // Main loop
        boolean loop = true;
        while (loop){
            System.out.println(MENU);
            int choice = Integer.parseInt(KBD.nextLine());

            switch (choice) {
                case 1 -> System.out.println(cr.sortToString(cr.root));
                case 2 -> addCustomer(cr);
                case 3 -> deleteCustomer(cr);
                case 4 -> searchCustomer(cr);
                case 5 -> updateInfo(cr);
                case 6 -> {
                    cr.save(FILE_NAME);
                    loop = false;
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }

    /**
     * A method to let the user add a customer to the system.
     * @param cr The CustomerRoster to add the new Customer to
     */
    public static void addCustomer(CustomerRoster cr) {
        String id = getUniqueIDFromUser(cr);

        // Returns empty-handed if the user enters "quit".
        if (id.equals("QUIT")) {
            System.out.println("Operation abandoned.");
            return;
        }

        // Prompts the user for the remaining info if the ID is syntactically good.
        String name = getFullName();
        String phoneNum = getPhoneNumber();

        // Add the customer if all is well.
        cr.insert(new Customer(id, name, phoneNum));
        System.out.println("Customer successfully added.\n");
    }

    /**
     * Method to let a user delete a customer from the system.
     * @param cr The roster to delete from.
     */
    public static void deleteCustomer(CustomerRoster cr) {
        String id = findExistingCustomerID(cr);

        // Returns empty-handed if the user enters "quit".
        if (id.equals("QUIT")) {
            System.out.println("Operation abandoned.");
            return;
        }

        // Delete the customer if it exists and all is well.
        cr.delete(id);
        System.out.println("Customer successfully deleted.\n");
    }

    /**
     * Method to allow a user to search for a customer
     * @param cr The roster to search in.
     */
    public static void searchCustomer(CustomerRoster cr) {
        String id = getIDFromUser();

        // Returns empty-handed if the user enters "quit".
        if (id.equals("QUIT")) {
            System.out.println("Operation abandoned.");
            return;
        }

        // Prints the Customer to the console if search was successful.
        System.out.println(cr.retrieve(id) + "\n");
    }

    /**
     * Method to allow a user to update the information of a customer within the system.
     * @param cr The roster to update within.
     */
    public static void updateInfo(CustomerRoster cr) {
        String id = findExistingCustomerID(cr);

        // Returns empty-handed if the user enters "quit".
        if (id.equals("QUIT")) {
            System.out.println("Operation abandoned.");
            return;
        }

        // Asks the user if they'd like to update the customer's name.
        System.out.print("Update customer's name? (Y/N): ");
        if (KBD.nextLine().equalsIgnoreCase("Y")) {
            cr.retrieve(id).setName(getFullName());
            System.out.println("Name successfully updated.");
        }

        // Asks the user if they'd like to update the customer's phone number.
        System.out.println("Update customer's phone number? (Y/N): ");
        if (KBD.nextLine().equalsIgnoreCase("Y")) {
            cr.retrieve(id).setPhoneNumber(getPhoneNumber());
            System.out.println("Phone number successfully updated.");
        }

        System.out.println();
    }

    /**
     * This method exists to get an ID from the user with the only requirement being that it be syntactically correct.
     * @return The user-provided ID, or "QUIT" if the user decides to give up.
     */
    public static String getIDFromUser() {
        System.out.print("Enter customer ID: ");
        String id = null;

        // The tryCount variable keeps count of how many times the user has input a syntactically incorrect ID and
        // after 2 tries, lets them know they can cancel the Customer addition by simply entering "quit".
        int tryCount = 0;

        // The while loop continues until the input is valid or the user quits.
        boolean satisfied = false;
        while (!satisfied) {
            id = KBD.nextLine();
            if (id.equalsIgnoreCase("QUIT"))
                return id.toUpperCase();
            else if (tryCount == 2)
                System.out.println("Note: You can type \"quit\" to cancel");
            satisfied = isValidID(id);
            tryCount++;
        }
        return id;
    }

    /**
     * This method extends the getIDFromUser() method by adding the requirement that the user-provided ID also be
     * unique relative to the provided CustomerRoster, as well as syntactically correct.
     * @param cr The CustomerRoster to be searched for matches.
     * @return Unique user-provided ID, or "QUIT" if the user gives up.
     */
    public static String getUniqueIDFromUser(CustomerRoster cr) {
        String id = getIDFromUser();
        if (id.equals("QUIT"))
            return id;
        while (cr.idExists(id)) {
            System.out.println("An account with ID " + id + " already exists. Please try again.");
            id = getIDFromUser();
        }
        return id;
    }

    /**
     * This method extends the getIDFromUser() method by adding the requirement that the user-provided ID also already
     * exist in the provided CustomerRoster, as well as be syntactically correct.
     * @param cr The CustomerRoster to be searched for matches.
     * @return The user-provided ID given that it already exists in the provided CustomerRoster, or "QUIT" if they give
     * up.
     */
    public static String findExistingCustomerID(CustomerRoster cr) {
        String id = getIDFromUser();
        if (id.equals("QUIT"))
            return id;
        while (!cr.idExists(id)) {
            System.out.println("Account with ID " + id + " does not exist. Please try again.");
            id = getIDFromUser();
        }
        return id;
    }

    /**
     * A method to test the syntactical validity of a user-provided ID string.
     * @param id the user-provided ID to be tested.
     * @return True if it's valid, False if it's not.
     */
    public static boolean isValidID(String id) {
        // Has to be a number.
        if (!isNumber(id)) {
            System.out.print("Only numbers are allowed." +
                    "\nTry again: ");
            return false;
        }

        // Has to be 5 characters.
        else if (id.length() != 5) {
            System.out.print("ID must be 5 characters in length." +
                    "\nTry again: ");
            return false;
        }

        else {
            return true;
        }
    }

    /**
     * Simple method to test if a string is a complete number.
     * @param s String that might be an integer(???)
     * @return True if an integer, False if not.
     */
    public static boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isAlphabetic(c))
                return false;
        }
        return true;
    }

    /**
     * A method to get and ensure a phone number is in the right format.
     * @return A customer's phone number.
     */
    public static String getPhoneNumber() {
        String phoneNumber = null;

        // Loops until the user gives 10 numbers.
        boolean satisfactory = false;
        while (!satisfactory) {
            System.out.print("Enter phone number: ");

            // Gets rid of any spaces or hyphens the user may have used for processing purposes.
            phoneNumber = KBD.nextLine();
            phoneNumber = phoneNumber.replace("-", "");
            phoneNumber = phoneNumber.replace(" ", "");
            if (!isNumber(phoneNumber))
                System.out.println("Phone numbers may only contain numbers.");
            else if (phoneNumber.length() != 10)
                System.out.println("Please provide 10 numeric digits.");
            else
                satisfactory = true;
        }

        // This formats it in the XXX-XXX-XXXX format.
        return phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6,10);
    }

    /**
     * A method to get a Customer's name and ensure it's a full name
     * @return Customer's full name.
     */
    public static String getFullName() {
        String name = null;

        // Loops until the user gives a full name.
        boolean satisfactory = false;
        while (!satisfactory) {
            System.out.print("Enter full name: ");

            name = KBD.nextLine();
            if (!name.contains(" "))
                System.out.println("You must include a first and last name.");
            else
                satisfactory = true;
        }

        // Capitalizes first letter of first and last name
        int index = name.indexOf(" ");
        name = name.substring(0,1).toUpperCase() + name.substring(1, index + 1)
                + name.substring(index + 1, index + 2).toUpperCase() + name.substring(index + 2, name.length());

        return name;
    }
}
