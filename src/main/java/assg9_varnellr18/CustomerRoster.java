package assg9_varnellr18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * A Binary-Search-Tree-Based roster of Customers for a basic customer management information system. Side-note: I
 * thought it would be a cleaner implementation to directly extend the BinarySearchTree than to just include it as a
 * data field, but I'd love to hear feedback on that.
 * @author Ryan Varnell
 */
public class CustomerRoster extends BinarySearchTree<Customer, String>{
    /**
     * Single-parameter constructor.
     * @param fileName Name of a tree file to be loaded from.
     */
    CustomerRoster(String fileName) {
        loadCustomersFromFile(fileName);
    }

    /**
     * Loads a binary search tree from a provided file.
     * @param fileName The name of the file to be loaded from.
     */
    public void loadCustomersFromFile(String fileName) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.exit(1);
            e.printStackTrace();
        }

        // Splits each line of the file into a String array, and since the formatting is standardized, the indexing
        // of the array should be [0] = ID/Key, [1] = First name, [2] = Last name, and [3] = Phone number.
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            String[] splitLine = line.split("\\s+");
            Customer newCustomer = new Customer(splitLine[0], splitLine[1] + " " + splitLine[2], splitLine[3]);
            this.insert(newCustomer);
        }
        inputStream.close();
    }

    /**
     * Recursive function that ultimately builds the search tree into one big sorted String. The explanation would be
     * lackluster because I can't wrap my head around putting recursion into words.
     * @param node The current node of the binary tree being processed.
     * @return Sorted String consisting of the entire binary tree.
     */
    public String sortToString(TreeNode<Customer> node) {
        StringBuilder sortedString = new StringBuilder();
        if (node != null) {
            sortedString.append(sortToString(node.leftChild));
            sortedString.append(node.item).append("\n");
            sortedString.append(sortToString(node.rightChild));
        } else {
            return "";
        }
        return sortedString.toString();
    }

    /**
     * Simple method that just discerns whether an ID exists in the roster.
     * @param id Customer ID
     * @return True if the ID is in the roster, False if not.
     */
    public boolean idExists(String id) {
        return this.retrieve(id) != null;
    }

    /**
     * Method to save the roster to the file.
     * @param fileName Name of the file to be saved to.
     */
    public void save(String fileName) {
        String newRoster = sortToString(root);
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(newRoster);
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong :(");
            e.printStackTrace();
        }
    }
}
